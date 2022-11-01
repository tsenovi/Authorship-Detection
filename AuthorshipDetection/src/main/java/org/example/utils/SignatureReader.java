package org.example.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.example.expressions.FeatureType;
import org.example.expressions.RegexPattern;
import org.example.models.data.LinguisticSignature;

public class SignatureReader {

  private static SignatureReader instance;

  private SignatureReader() {
  }

  public static SignatureReader getInstance() {
    if (instance == null) {
      instance = new SignatureReader();
    }

    return instance;
  }

  public List<LinguisticSignature> readyByLine() {
    List<LinguisticSignature> knownSignatures = new ArrayList<>();
    Path filePath = Path.of(RegexPattern.KNOWN_SIGNATURES_PATH.getText());
    try (Scanner scanner = new Scanner(filePath)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        LinguisticSignature linguisticSignature = new LinguisticSignature(createFeatures(line));
        knownSignatures.add(linguisticSignature);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return knownSignatures;
  }

  private Map<FeatureType, Double> createFeatures(String line) {
    Map<FeatureType, Double> features = new HashMap<>();
    String[] lineElements = line.trim().split(RegexPattern.COMMA_AND_WHITESPACE.getText());

    features.put(FeatureType.AVERAGE_WORD_LENGTH, Double.parseDouble(lineElements[1]));
    features.put(FeatureType.TYPE_TOKEN_RATIO, Double.parseDouble(lineElements[2]));
    features.put(FeatureType.HAPAX_LEGOMENA_RATIO, Double.parseDouble(lineElements[3]));
    features.put(FeatureType.AVERAGE_SENTENCE_LENGTH, Double.parseDouble(lineElements[4]));
    features.put(FeatureType.AVERAGE_SENTENCE_COMPLEXITY, Double.parseDouble(lineElements[5]));

    return features;
  }
}
