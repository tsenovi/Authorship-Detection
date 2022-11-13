package org.example.views;

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
    show("\t\t");
    for (int col = 0; col < results[0].length; col++) {
      show("|| ");
      show("Author." + (col + 1));
    }

    show(RegexPattern.NEW_LINE.getText());
    for (int row = 0; row < results.length; row++) {
      show("Text." + (row + 1));

      for (int col = 0; col < results[row].length; col++) {
        show("||  ");
        show(String.valueOf(results[row][col]));
        show("%  ");
      }
      show(RegexPattern.NEW_LINE.getText());
    }
  }
}
