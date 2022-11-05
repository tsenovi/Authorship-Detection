package org.example.utils.comparators;

import static org.example.expressions.FeatureType.AVERAGE_SENTENCE_COMPLEXITY;

import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;

public class AverageSentenceComplexity implements Comparable {

  private static AverageSentenceComplexity instance;

  private AverageSentenceComplexity() {
  }

  public static AverageSentenceComplexity getInstance() {
    if (instance == null) {
      instance = new AverageSentenceComplexity();
    }

    return instance;
  }

  @Override
  public double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known) {
    Map<FeatureType, Double> unknownFeatures = unknown.features();
    Double unknownFeatureValue = unknownFeatures.get(AVERAGE_SENTENCE_COMPLEXITY);

    Map<FeatureType, Double> knownFeatures = known.features();
    Double knownFeatureValue = knownFeatures.get(AVERAGE_SENTENCE_COMPLEXITY);

    return Math.abs(unknownFeatureValue - knownFeatureValue)
        * AVERAGE_SENTENCE_COMPLEXITY.getWeight();
  }
}
