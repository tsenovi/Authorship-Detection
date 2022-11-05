package org.example.views;



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
    
  }
}
