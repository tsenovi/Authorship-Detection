package org.example.controllers;

import java.util.List;
import java.util.Scanner;
import org.example.models.InputModel;
import org.example.views.InputView;

public class InputController {

  private static InputController instance;
  private final InputView inputView;
  private final InputModel inputModel;
  private final SignatureController signatureController;
  private final Scanner scanner;

  private InputController() {
    inputView = InputView.getInstance();
    inputModel = InputModel.getInstance();
    signatureController = SignatureController.getInstance();
    scanner = new Scanner(System.in);
    onViewShown();
  }

  public static InputController getInstance() {
    if (instance == null) {
      instance = new InputController();
    }

    return instance;
  }

  public void start() {
    String userFilePath = scanner.nextLine();
    inputModel.loadInputFile(userFilePath);
    onLoadedData();
  }

  private void onLoadedData() {
    List<String> paragraphs = inputModel.getParagraphs();
    signatureController.onReceivedData(paragraphs);
  }

  private void onViewShown() {
    inputView.printInputInstructions();
  }
}
