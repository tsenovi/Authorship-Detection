package org.example.utils.comparators;

import static org.example.expressions.FeatureType.TYPE_TOKEN_RATIO;

import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;

public class TypeTokenRatio implements Comparable {

  private static TypeTokenRatio instance;

  private TypeTokenRatio() {
  }

  public static TypeTokenRatio getInstance() {
    if (instance == null) {
      instance = new TypeTokenRatio();
    }

    return instance;
  }

  @Override
  public double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known) {
    Map<FeatureType, Double> unknownFeatures = unknown.features();
    Double unknownFeatureValue = unknownFeatures.get(TYPE_TOKEN_RATIO);

    Map<FeatureType, Double> knownFeatures = known.features();
    Double knownFeatureValue = knownFeatures.get(TYPE_TOKEN_RATIO);

    return Math.abs(unknownFeatureValue - knownFeatureValue)
        * TYPE_TOKEN_RATIO.getWeight();
  }
}
