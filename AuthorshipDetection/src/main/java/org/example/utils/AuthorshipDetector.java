package org.example.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import org.example.expressions.RegexPattern;
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

  public double[][] compare(List<LinguisticSignature> unknownSignatures,
      List<LinguisticSignature> knownSignatures) {

    double[][] results = new double[unknownSignatures.size()][knownSignatures.size()];

    for (int elementRow = 0; elementRow < unknownSignatures.size(); elementRow++) {
      LinguisticSignature unknownSignature = unknownSignatures.get(elementRow);

      for (int elementColumn = 0; elementColumn < knownSignatures.size(); elementColumn++) {
        LinguisticSignature knownSignature = knownSignatures.get(elementColumn);
        results[elementRow][elementColumn] = calculateSimilarity(unknownSignature, knownSignature);
      }
    }

    return results;
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

    NumberFormat formatter = new DecimalFormat(
        RegexPattern.DOUBLE_FORMAT.getText());

    return Double.parseDouble(
        formatter.format(averageWordLengthContribution + hapaxLegomenaRatioContribution +
            typeTokenRatioContribution + averageSentenceLengthContribution +
            averageSentenceComplexityContribution));
  }
}
