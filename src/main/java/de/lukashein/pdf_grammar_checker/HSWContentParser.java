package de.lukashein.pdf_grammar_checker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public @Getter @Setter @AllArgsConstructor class HSWContentParser extends FileContentParser {
    private final static String LINEBREAK = "\n\n";

    private Language language;
    private boolean removeTableOfContents;

    @Override
    protected String format(@NonNull String content) {
        String fileContent = StringUtils.replace(content, "-" + LINEBREAK, ""); // syllable division

        if (removeTableOfContents) {
        }

        return fileContent;
    }
}
