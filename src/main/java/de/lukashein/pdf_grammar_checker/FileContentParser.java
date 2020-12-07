package de.lukashein.pdf_grammar_checker;

import lombok.NonNull;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
     * @param pdfDoc The file to be parsed
     * @return The formatted file content
     * @throws IOException if the document can not be read
     * @throws TikaException if the document can not be parsed
     */
    public String parse(@NonNull File pdfDoc) throws IOException, TikaException {
        if(!FilenameUtils.getExtension(pdfDoc.getName()).equalsIgnoreCase("pdf")) {
            throw new IOException("Unsupported file extension");
        }

        final Metadata metadata = new Metadata();
        final InputStream stream = TikaInputStream.get(pdfDoc.toPath(), metadata);
        return format(tika.parseToString(stream, metadata, 250_000));
    }
}
