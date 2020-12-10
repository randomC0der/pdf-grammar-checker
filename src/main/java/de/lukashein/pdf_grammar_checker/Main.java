package de.lukashein.pdf_grammar_checker;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.exception.TikaException;
import org.languagetool.JLanguageTool;
import org.languagetool.language.GermanyGerman;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.spelling.SpellingCheckRule;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
@Slf4j
public class Main implements Callable<Integer> {

    private File ngramDir;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            if (ngramDir != null) {
            }

            return 0;

        } catch (Exception e) {
            return -1;
        }
    }
}
