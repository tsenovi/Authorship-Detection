package org.example.expressions;

public enum FeatureType {
  AVERAGE_WORD_LENGTH(11),
  TYPE_TOKEN_RATIO(33),
  HAPAX_LEGOMENA_RATIO(50),
  AVERAGE_SENTENCE_LENGTH(0.4),
  AVERAGE_SENTENCE_COMPLEXITY(4);

  private final double weight;

  FeatureType(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }
}
