package org.example.utils.comparators;

import org.example.models.data.LinguisticSignature;

public interface Comparable {

  double calculateSimilarity(LinguisticSignature unknown, LinguisticSignature known);
}
