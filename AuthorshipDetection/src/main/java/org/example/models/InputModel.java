package org.example.models;

import java.util.ArrayList;
import java.util.List;
import org.example.controllers.InputController;

public class InputModel {

  private static InputModel instance;
  private final FileReader fileReader;
  private List<String> paragraphs;

  private InputModel() {
    fileReader = FileReader.getInstance();
    paragraphs = new ArrayList<>();
  }

  public static InputModel getInstance() {
    if (instance == null) {
      instance = new InputModel();
    }

    return instance;
  }

  public void loadInputFile(String filePath) {
    paragraphs = fileReader.readByParagraph(filePath);
  }

  public List<String> getParagraphs() {
    return List.copyOf(paragraphs);
  }
}
