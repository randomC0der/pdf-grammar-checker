package de.lukashein.pdf_grammar_checker;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.GermanyGerman;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.spelling.SpellingCheckRule;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Slf4j
public class Main implements Callable<Integer> {

    @Option(names = "--ngram", description = "Directory to statistical ngram data")
    private File ngramDir;

    private JLanguageTool langTool;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {

            loadLanguage();

            if (ngramDir != null) {
                langTool.activateLanguageModelRules(ngramDir);
            }

            return 0;

        } catch (Exception e) {
            return -1;
        }
    }

    private void loadLanguage() {
        switch (language) {
            case DEUTSCH:
                langTool = new JLanguageTool(new GermanyGerman());
                break;

            case ENGLISH:
                langTool = new JLanguageTool(new AmericanEnglish());
                break;

            default:
                throw new IllegalArgumentException();
        }
    }
}
