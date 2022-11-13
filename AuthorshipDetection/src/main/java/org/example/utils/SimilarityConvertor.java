package org.example.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import org.example.expressions.RegexPattern;

public class SimilarityConvertor {

  private static SimilarityConvertor instance;
  private static final int PERCENTAGE = 100;

  private SimilarityConvertor() {
  }

  public static SimilarityConvertor getInstance() {
    if (instance == null) {
      instance = new SimilarityConvertor();
    }

    return instance;
  }

  public void parseToPercentage(double[][] similarities) {
    for (int row = 0; row < similarities.length; row++) {
      double rowMaxNumber = findRowMaxNumber(similarities[row]);

      for (int column = 0; column < similarities[row].length; column++) {
        similarities[row][column] = calculatePercentage(similarities[row][column], rowMaxNumber);
      }
    }
  }

  private double calculatePercentage(double valueToConvert, double rowMaxNumber) {
    NumberFormat formatter = new DecimalFormat(
        RegexPattern.DOUBLE_FORMAT.getText());

    return Double.parseDouble(
        formatter.format(PERCENTAGE - ((valueToConvert * PERCENTAGE) / rowMaxNumber)));
  }

  private double findRowMaxNumber(double[] elements) {
    OptionalDouble max = Arrays.stream(elements).max();
    if (max.isPresent()) {
      return max.getAsDouble();
    }

    return 0;
  }
}
