package org.example.views;


import java.util.Arrays;
import org.example.expressions.RegexPattern;

public class OutputView {

  private static OutputView instance;

  private OutputView() {
  }

  public static OutputView getInstance() {
    if (instance == null) {
      instance = new OutputView();
    }

    return instance;
  }

  public void show(String text) {
    System.out.print(text);
  }

  public void printResults(double[][] results) {
    for (int col = 0; col < results[0].length; col++) {
      show("\tAuthor." + (col + 1));
    }

    show(RegexPattern.NEW_LINE.getText());

    for (int row = 0; row < results.length; row++) {
      show("Text." + (row + 1) + RegexPattern.SINGLE_WHITESPACE.getText());
      for (int col = 0; col < results[row].length; col++) {
        show(String.valueOf(results[row][col]) + RegexPattern.SINGLE_WHITESPACE.getText());
      }
      show(RegexPattern.NEW_LINE.getText());
    }
  }
}
