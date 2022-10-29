package org.example.parsers;

public class TextParser {

  private static TextParser instance;

  private TextParser() {
  }

  public static TextParser getInstance() {
    if (instance == null) {
      instance = new TextParser();
    }

    return instance;
  }

  public ParsedText parse(String paragraph) {
    ParsedText parsedText = new ParsedText();

    parsedText.setWordCount(calculateWordCount(paragraph));

    return parsedText;
  }

  private int calculateWordCount(String text) {
    String textToParse = new String(text);
    if (textToParse.isEmpty()) {
      return 0;
    }

    final String[] words = cleanPunctuation(textToParse);
    return words.length;
  }

  private String[] cleanPunctuation(String text) {
    return text.toLowerCase()
        .replaceAll("\\p{P}", "")
        .replaceAll("\n", "")
        .replaceAll("\r\n", "")
        .replaceAll("\r", "")
        .split("\\s+");
  }
}
