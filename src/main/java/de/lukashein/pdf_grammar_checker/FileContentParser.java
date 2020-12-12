package de.lukashein.pdf_grammar_checker;

import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public abstract class FileContentParser {
    private final static Tika tika = new Tika();

    /**
     *
     * @param content the raw file content
     * @return the optimized file content
     */
    protected abstract String format(@NonNull String content);

    /**
     *
     * @param file The file to be parsed
     * @return The formatted file content
     * @throws IOException if the document can not be read
     * @throws TikaException if the document can not be parsed
     */
    public String parse(@NonNull File file) throws IOException, TikaException {
        String fileContent;

        switch (FilenameUtils.getExtension(file.getName())) {
            case "pdf":
                final Metadata metadata = new Metadata();
                final InputStream stream = TikaInputStream.get(file.toPath(), metadata);
                fileContent = tika.parseToString(stream, metadata, 250_000);
                break;

            case "txt":
                fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                break;

            default:
                throw new IOException("Unsupported file extension");
        }

        return format(fileContent);
    }
}
