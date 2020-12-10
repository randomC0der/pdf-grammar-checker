package de.lukashein.pdf_grammar_checker;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HSWContentParser extends FileContentParser {
    private final static String LINEBREAK = "\n\n";

    private @Getter @Setter boolean removeTableOfContents;

    @Override
    protected String format(@NonNull String content) {
        String fileContent = content.replace("-" + LINEBREAK, ""); // syllable division

        if (removeTableOfContents) {
        }

        return fileContent;
    }
}
