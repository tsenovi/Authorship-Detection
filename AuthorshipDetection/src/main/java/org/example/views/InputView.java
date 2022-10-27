package org.example.views;

import java.util.ArrayList;
import java.util.Set;

public class InputView {

  public InputView() {
  }

  public void show(String text) {
    System.out.println(text);
  }

  public void printInputInstructions() {
    show("Input text file destination path: ");
  }

  public void printOutputResult(ArrayList<String> strings) {
    for (String string : strings) {
      show(string);
    }
  }
}
