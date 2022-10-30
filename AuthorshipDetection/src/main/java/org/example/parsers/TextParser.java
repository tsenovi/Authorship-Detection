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
    if (paragraph.isEmpty()) {
      return null;
    }

    String cleanText = cleanUpText(paragraph);
    ParsedText parsedText = new ParsedText();

    parsedText.setWordCount(calculateWordCount(cleanText));
    parsedText.setSentenceCount(calculateSentenceCount(cleanText));

    return parsedText;
  }

  private int calculateWordCount(String text) {
    String textToParse = new String(text);
    final String[] words = cleanAllPunctuation(textToParse);
    return words.length;
  }

  private String[] cleanAllPunctuation(String text) {
    return text.replaceAll("\\p{P}", "")
        .split("\\s+");
  }

  private int calculateSentenceCount(String text) {
    String textToParse = new String(text);
    int abbreviationCount = calculateAbbreviationCount(textToParse);
    final String[] sentences = cleanPunctuationForSentence(textToParse);
    int sentenceCount = sentences.length - 1;
    return sentenceCount - abbreviationCount;
  }

  private String[] cleanPunctuationForSentence(String text) {
    return text.split("[.!?]+");
  }

  private int calculateAbbreviationCount(String text) {
    String[] abbreviations = {"mr.", "mrs.", "miss.", "dr."};
    String[] words = text.split("\\s+");
    int count = 0;
    for (String word : words) {
      for (String abbreviation : abbreviations) {
        if (word.contains(abbreviation)) {
          count++;
        }
      }
    }

    return count;
  }

  private String cleanUpText(String text) {
    return text.toLowerCase()
        .replaceAll("\r", "")
        .replaceAll("\n", "\\s+")
        .replaceAll("\r\n", "\\s+");
  }
}