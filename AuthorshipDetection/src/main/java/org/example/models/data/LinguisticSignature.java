package org.example.models.data;

import java.util.Map;
import org.example.expressions.FeatureType;

public record LinguisticSignature(Map<FeatureType, Double> features) {

}
