package org.example.models;

import java.util.ArrayList;
import java.util.Set;

public class InputModel {

  private final FileReader fileReader;

  private ArrayList<String> paragraphs;

  public InputModel() {
    fileReader = new FileReader();
    paragraphs = new ArrayList<>();
  }

  public void loadInputFile(String filePath) {
    paragraphs = fileReader.readByParagraph(filePath);
  }

  public ArrayList<String> getParagraphs() {
    return paragraphs;
  }
}
