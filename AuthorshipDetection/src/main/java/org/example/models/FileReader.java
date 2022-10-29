package org.example.models;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileReader {

  private static FileReader instance;

  private FileReader() {
  }

  public static FileReader getInstance() {
    if (instance == null) {
      instance = new FileReader();
    }

    return instance;
  }

  public List<String> readByParagraph(String inputPath) {
    List<String> paragraphs = new ArrayList<>();
    Path filePath = Path.of(inputPath);
    try (Scanner scanner = new Scanner(filePath)
        .useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE))) {
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
