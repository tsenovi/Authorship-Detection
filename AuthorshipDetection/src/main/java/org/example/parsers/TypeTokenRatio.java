package org.example.parsers;

public class TypeTokenRatio implements Calculable {

  private static TypeTokenRatio instance;

  private TypeTokenRatio() {
  }

  public static TypeTokenRatio getInstance() {
    if (instance == null) {
      instance = new TypeTokenRatio();
    }

    return instance;
  }

  public double calculateFeature(ParsedText parsedText) {
    return (double) parsedText.getUniqueWordCount() / parsedText.getWordCount();
  }
}
