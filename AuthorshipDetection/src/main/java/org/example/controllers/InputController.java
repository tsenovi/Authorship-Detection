package org.example.controllers;

import java.util.Scanner;
import org.example.models.InputModel;
import org.example.views.InputView;

public class InputController {

  private final InputView inputView;
  private final InputModel inputModel;
  private final Scanner scanner;

  public InputController() {
    inputView = new InputView();
    inputModel = new InputModel();
    scanner = new Scanner(System.in);
    onViewShown();
  }

  public void start() {
    String userFilePath = scanner.nextLine();
    inputModel.loadInputFile(userFilePath);
    onFileLoaded();
  }

  private void onViewShown() {
    inputView.printInputInstructions();
  }

  private void onFileLoaded() {
    inputView.printOutputResult(inputModel.getParagraphs());
  }
}
