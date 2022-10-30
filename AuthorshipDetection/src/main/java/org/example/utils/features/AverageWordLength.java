package org.example.utils.features;

import org.example.models.dto.ParsedText;

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
    return (double) parsedText.characterCount() / parsedText.wordCount();
  }
}
