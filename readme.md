# pdf-grammar-checker

[![license](https://img.shields.io/github/license/RandomC0der/pdf-grammar-checker.svg)](LICENSE)

Ein Kommandozeilen-Programm, um die Grammatik meiner Hausarbeiten zu prüfen - powered by [Language Tool](https://languagetool.org/).

## Hintergrund

Da ich meinen eigenen Sprachkenntnissen nicht traue, habe ich ein Programm geschrieben,
das meine Hausarbeit kontrollliest.
Es ist nicht perfekt, da es eine relativ hohe Fehlalarm-Quote hat, aber es ist gut genug.

Das Programm ist mit dem von mir erstellten [Zitierstil der HSW](https://github.com/randomC0der/hswstyle) kompatibel.

## Bauen

```bash
mvn clean package
cd target
java -jar pdf-grammar-checker-1.0-with-dependencies.jar Hausarbeit.pdf
```

## Verwendung

### Parameter

Um die Fehlerquote zu reduzieren.

### Output speichern

Der Output kann auch in einer Datei gepeichert werden.
Jedoch verursacht PowerShell 5.1 Probleme. [Weitere Infos sind in der Wiki.](https://github.com/randomC0der/pdf-grammar-checker/wiki/Output-in-Datei-schreiben)
Bash oder cmd:

```bash
cd target
java -jar pdf-grammar-checker-1.0-with-dependencies.jar Hausarbeit.pdf > outfile.txt
```

## Lizenz

GPL-3.0-or-later © Lukas Hein
