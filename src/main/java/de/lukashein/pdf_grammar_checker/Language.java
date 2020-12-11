package de.lukashein.pdf_grammar_checker;

import lombok.AllArgsConstructor;
import lombok.Getter;

public @Getter @AllArgsConstructor enum Language {
    DEUTSCH("Inhaltsverzeichnis", "Einleitung", "Quellenverzeichnis", "Anhang"),
    ENGLISH("Table of Contents", "Introduction", "Bibliography", "Appendix");

    private final String tableOfContents;
    private final String introduction;
    private final String bibliography;
    private final String appendix;
}
