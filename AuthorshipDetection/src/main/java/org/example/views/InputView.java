package org.example.views;

import java.util.ArrayList;
import java.util.Set;
import org.example.controllers.SignatureController;

public class InputView {

  private static InputView instance;

  private InputView() {
  }

  public static InputView getInstance() {
    if (instance == null) {
      instance = new InputView();
    }

    return instance;
  }

  public void show(String text) {
    System.out.print(text);
  }

  public void printInputInstructions() {
    show("File destination path: ");
  }
}
