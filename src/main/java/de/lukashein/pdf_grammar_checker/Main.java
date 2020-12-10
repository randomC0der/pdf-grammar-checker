package de.lukashein.pdf_grammar_checker;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.SneakyThrows;
import org.apache.tika.exception.TikaException;
import org.languagetool.JLanguageTool;
import org.languagetool.language.GermanyGerman;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.spelling.SpellingCheckRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
public class Main implements Callable<Integer> {

    public static void main(String[] args) {
    }

    @Override
    public Integer call() {
        try {
        } catch (Exception e) {
        }
    }
}
