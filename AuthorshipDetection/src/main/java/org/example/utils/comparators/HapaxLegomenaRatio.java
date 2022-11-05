package org.example.utils.comparators;

import static org.example.expressions.FeatureType.HAPAX_LEGOMENA_RATIO;

import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;

public class HapaxLegomenaRatio implements Comparable {

  private static HapaxLegomenaRatio instance;

  private HapaxLegomenaRatio() {
  }

  public static HapaxLegomenaRatio getInstance() {
    if (instance == null) {
      instance = new HapaxLegomenaRatio();
    }

    return instance;
  }

  @Override
  public double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known) {
    Map<FeatureType, Double> unknownFeatures = unknown.features();
    Double unknownFeatureValue = unknownFeatures.get(HAPAX_LEGOMENA_RATIO);

    Map<FeatureType, Double> knownFeatures = known.features();
    Double knownFeatureValue = knownFeatures.get(HAPAX_LEGOMENA_RATIO);

    return Math.abs(unknownFeatureValue - knownFeatureValue)
        * HAPAX_LEGOMENA_RATIO.getWeight();
  }
}
