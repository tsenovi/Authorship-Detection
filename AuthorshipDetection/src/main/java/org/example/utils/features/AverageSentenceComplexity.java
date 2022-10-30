package org.example.utils.features;

import org.example.models.dto.ParsedText;

public class AverageSentenceComplexity implements Calculable {

  private static AverageSentenceComplexity instance;

  private AverageSentenceComplexity() {
  }

  public static AverageSentenceComplexity getInstance() {
    if (instance == null) {
      instance = new AverageSentenceComplexity();
    }

    return instance;
  }

  public double calculateFeature(ParsedText parsedText) {
    return (double) parsedText.phraseCount() / parsedText.sentenceCount();
  }
}
