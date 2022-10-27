package org.example.models;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

  public ArrayList<String> readByParagraph(String inputPath) {
    ArrayList<String> paragraphs = new ArrayList<>();
    Path filePath = Path.of(inputPath);
    try (Scanner scanner = new Scanner(filePath).useDelimiter("\n\r\n")) {
      while (scanner.hasNext()) {
        String paragraph = scanner.next();
        paragraphs.add(paragraph);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return paragraphs;
  }
}
