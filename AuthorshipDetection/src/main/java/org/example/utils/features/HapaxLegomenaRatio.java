package org.example.utils.features;

import org.example.models.dto.ParsedText;

public class HapaxLegomenaRatio implements Calculable {

  private static HapaxLegomenaRatio instance;

  private HapaxLegomenaRatio() {
  }

  public static HapaxLegomenaRatio getInstance() {
    if (instance == null) {
      instance = new HapaxLegomenaRatio();
    }

    return instance;
  }

  public double calculateFeature(ParsedText parsedText) {
    return (double) parsedText.nonRecurringWordCount() / parsedText.wordCount();
  }
}
