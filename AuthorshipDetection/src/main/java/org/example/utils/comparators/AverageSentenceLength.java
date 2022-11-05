package org.example.utils.comparators;

import static org.example.expressions.FeatureType.AVERAGE_SENTENCE_LENGTH;

import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;

public class AverageSentenceLength implements Comparable {

  private static AverageSentenceLength instance;

  private AverageSentenceLength() {
  }

  public static AverageSentenceLength getInstance() {
    if (instance == null) {
      instance = new AverageSentenceLength();
    }

    return instance;
  }

  @Override
  public double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known) {
    Map<FeatureType, Double> unknownFeatures = unknown.features();
    Double unknownFeatureValue = unknownFeatures.get(AVERAGE_SENTENCE_LENGTH);

    Map<FeatureType, Double> knownFeatures = known.features();
    Double knownFeatureValue = knownFeatures.get(AVERAGE_SENTENCE_LENGTH);

    return Math.abs(unknownFeatureValue - knownFeatureValue)
        * AVERAGE_SENTENCE_LENGTH.getWeight();
  }
}
