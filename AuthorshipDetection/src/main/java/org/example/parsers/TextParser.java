package org.example.parsers;

import org.example.expressions.RegexPattern;

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

    String cleanText = cleanNewLines(paragraph);
    ParsedText parsedText = new ParsedText();
    parsedText.setWordCount(calculateWordCount(cleanText));
    parsedText.setSentenceCount(calculateSentenceCount(cleanText));
    parsedText.setPhraseCount(calculatePhraseCount(cleanText));
    parsedText.setCharacterCount(calculateCharacterCount(cleanText));
    return parsedText;
  }

  private int calculateCharacterCount(String text) {
    String textToParse = new String(text);
    String cleanText = subtractCharacters(textToParse);
    String[] characters = cleanText.split(RegexPattern.EMPTY_STRING.getText());
    return characters.length;
  }

  private int calculatePhraseCount(String text) {
    String textToParse = new String(text);
    String[] phrases = textToParse.split(RegexPattern.PHRASE_SEPARATOR.getText());
    return phrases.length;
  }

  private int calculateSentenceCount(String text) {
    String textToParse = new String(text);
    int abbreviationCount = calculateAbbreviationCount(textToParse);
    final String[] sentences = textToParse.split(RegexPattern.SENTENCE_SEPARATOR.getText());
    return sentences.length - abbreviationCount;
  }

  private int calculateAbbreviationCount(String text) {
    String[] abbreviations = {
        RegexPattern.MR.getText(), RegexPattern.MRS.getText(),
        RegexPattern.MISS.getText(), RegexPattern.DR.getText()
    };
    String[] words = text.split(RegexPattern.SINGLE_WHITE_SPACE.getText());
    int abbreviationCount = 0;
    for (String word : words) {
      for (String abbreviation : abbreviations) {
        if (word.contains(abbreviation)) {
          abbreviationCount++;
        }
      }
    }

    return abbreviationCount;
  }

  private int calculateWordCount(String text) {
    String textToParse = new String(text);
    String cleanText = cleanAllPunctuation(textToParse);
    final String[] words = cleanText.split(RegexPattern.SINGLE_WHITE_SPACE.getText());
    return words.length;
  }

  private String subtractCharacters(String text) {
    return text.replaceAll(
            RegexPattern.PUNCTUATION.getText(),
            RegexPattern.EMPTY_STRING.getText())
        .replaceAll(RegexPattern.SINGLE_WHITE_SPACE.getText(),
            RegexPattern.EMPTY_STRING.getText());
  }

  private String cleanAllPunctuation(String text) {
    return text.replaceAll(
        RegexPattern.PUNCTUATION.getText(),
        RegexPattern.EMPTY_STRING.getText());
  }

  private String cleanNewLines(String text) {
    return text.toLowerCase().trim()
        .replaceAll(System.lineSeparator(),
            RegexPattern.SINGLE_WHITE_SPACE.getText())
        .replaceAll(RegexPattern.CONTIGUOUS_WHITE_SPACE.getText(),
            RegexPattern.SINGLE_WHITE_SPACE.getText());
  }
}