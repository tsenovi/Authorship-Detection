package org.example.parsers;

public class AverageSentenceLength implements Calculable {

  private static AverageSentenceLength instance;

  private AverageSentenceLength() {
  }

  public static AverageSentenceLength getInstance() {
    if (instance == null) {
      instance = new AverageSentenceLength();
    }

    return instance;
  }

  public double calculateFeature(ParsedText parsedText) {
    return (double) parsedText.getWordCount() / parsedText.getSentenceCount();
  }
}
