package org.example.utils;

import java.util.List;
import org.example.models.data.LinguisticSignature;
import org.example.utils.comparators.AverageSentenceComplexity;
import org.example.utils.comparators.AverageSentenceLength;
import org.example.utils.comparators.AverageWordLength;
import org.example.utils.comparators.Comparable;
import org.example.utils.comparators.HapaxLegomenaRatio;
import org.example.utils.comparators.TypeTokenRatio;

public class AuthorshipDetector {

  private static AuthorshipDetector instance;
  private final Comparable averageWordLength;
  private final Comparable hapaxLegomenaRatio;
  private final Comparable typeTokenRatio;
  private final Comparable averageSentenceLength;
  private final Comparable averageSentenceComplexity;

  private AuthorshipDetector() {
    averageWordLength = AverageWordLength.getInstance();
    hapaxLegomenaRatio = HapaxLegomenaRatio.getInstance();
    typeTokenRatio = TypeTokenRatio.getInstance();
    averageSentenceLength = AverageSentenceLength.getInstance();
    averageSentenceComplexity = AverageSentenceComplexity.getInstance();
  }

  public static AuthorshipDetector getInstance() {
    if (instance == null) {
      instance = new AuthorshipDetector();
    }

    return instance;
  }

  public void compare(List<LinguisticSignature> unknownSignatures,
      List<LinguisticSignature> knownSignatures) {
    double[][] results = new double[unknownSignatures.size()][knownSignatures.size()];

    for (int unknown = 0; unknown < unknownSignatures.size(); unknown++) {
      LinguisticSignature unknownSignature = unknownSignatures.get(unknown);

      for (int known = 0; known < knownSignatures.size(); known++) {
        LinguisticSignature knownSignature = knownSignatures.get(known);

        double similarity = calculateSimilarity(unknownSignature, knownSignature);
      }
    }
  }

  private double calculateSimilarity(LinguisticSignature unknownSignature,
      LinguisticSignature knownSignature) {

    double averageWordLengthContribution = averageWordLength.calculateSimilarity(unknownSignature,
        knownSignature);
    double hapaxLegomenaRatioContribution = hapaxLegomenaRatio.calculateSimilarity(unknownSignature,
        knownSignature);
    double typeTokenRatioContribution = typeTokenRatio.calculateSimilarity(unknownSignature,
        knownSignature);
    double averageSentenceLengthContribution = averageSentenceLength.calculateSimilarity(
        unknownSignature, knownSignature);
    double averageSentenceComplexityContribution = averageSentenceComplexity.calculateSimilarity(
        unknownSignature, knownSignature);

    return (averageWordLengthContribution + hapaxLegomenaRatioContribution
        + typeTokenRatioContribution + averageSentenceLengthContribution
        + averageSentenceComplexityContribution);
  }
}
