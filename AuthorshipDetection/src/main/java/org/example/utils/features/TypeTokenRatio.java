package org.example.utils.features;

import org.example.models.dto.ParsedText;

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
    return (double) parsedText.uniqueWordCount() / parsedText.wordCount();
  }
}
