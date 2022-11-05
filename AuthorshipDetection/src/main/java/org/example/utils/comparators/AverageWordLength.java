package org.example.utils.comparators;

import static org.example.expressions.FeatureType.AVERAGE_WORD_LENGTH;

import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;

public class AverageWordLength implements Comparable {

  private static AverageWordLength instance;

  private AverageWordLength() {
  }

  public static AverageWordLength getInstance() {
    if (instance == null) {
      instance = new AverageWordLength();
    }

    return instance;
  }

  @Override
  public double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known) {
    Map<FeatureType, Double> unknownFeatures = unknown.features();
    Double unknownFeatureValue = unknownFeatures.get(AVERAGE_WORD_LENGTH);

    Map<FeatureType, Double> knownFeatures = known.features();
    Double knownFeatureValue = knownFeatures.get(AVERAGE_WORD_LENGTH);

    return Math.abs(unknownFeatureValue - knownFeatureValue)
        * AVERAGE_WORD_LENGTH.getWeight();
  }
}
