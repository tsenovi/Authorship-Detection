package org.example.parsers;

public class AverageWordLength implements Calculable {

  private static AverageWordLength instance;

  private AverageWordLength() {
  }

  public static AverageWordLength getInstance() {
    if (instance == null) {
      instance = new AverageWordLength();
    }

    return instance;
  }

  public double calculateFeature(ParsedText parsedText) {
    return (double) parsedText.getCharacterCount() / parsedText.getWordCount();
  }
}
