package org.example.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.expressions.FeatureType;
import org.example.models.data.LinguisticSignature;
import org.example.utils.features.AverageSentenceComplexity;
import org.example.utils.features.AverageSentenceLength;
import org.example.utils.features.AverageWordLength;
import org.example.utils.features.Calculable;
import org.example.utils.features.HapaxLegomenaRatio;
import org.example.models.dto.ParsedText;
import org.example.utils.TextParser;
import org.example.utils.features.TypeTokenRatio;
import org.example.models.SignatureModel;

public class SignatureController {

  private static SignatureController instance;
  private final SignatureModel signatureModel;
  private final OutputController outputController;
  private final TextParser textParser;
  private final Calculable averageWordLength;
  private final Calculable typeTokenRatio;
  private final Calculable hapaxLegomenaRatio;
  private final Calculable averageSentenceLength;
  private final Calculable averageSentenceComplexity;

  private SignatureController() {
    signatureModel = SignatureModel.getInstance();
    outputController = OutputController.getInstance();
    textParser = TextParser.getInstance();
    averageWordLength = AverageWordLength.getInstance();
    typeTokenRatio = TypeTokenRatio.getInstance();
    hapaxLegomenaRatio = HapaxLegomenaRatio.getInstance();
    averageSentenceLength = AverageSentenceLength.getInstance();
    averageSentenceComplexity = AverageSentenceComplexity.getInstance();
  }

  public static SignatureController getInstance() {
    if (instance == null) {
      instance = new SignatureController();
    }

    return instance;
  }

  public void onReceivedData(List<String> paragraphs) {
    findSignatures(paragraphs);
    updateOutputController();
  }

  private void updateOutputController() {
    outputController.onReceivedData(signatureModel.getKnownSignatures(),
        signatureModel.getUnknownSignatures());
  }

  private void findSignatures(List<String> paragraphs) {
    for (String paragraph : paragraphs) {
      LinguisticSignature linguisticSignature = calculateSignature(paragraph);
      signatureModel.saveUnknownSignature(linguisticSignature);
    }
  }

  private LinguisticSignature calculateSignature(String paragraph) {
    ParsedText parsedText = textParser.parse(paragraph);
    double averageWordLength = this.averageWordLength.calculateFeature(parsedText);
    double typeTokenRatio = this.typeTokenRatio.calculateFeature(parsedText);
    double hapaxLegomenaRatio = this.hapaxLegomenaRatio.calculateFeature(parsedText);
    double averageSentenceLength = this.averageSentenceLength.calculateFeature(parsedText);
    double averageSentenceComplexity = this.averageSentenceComplexity.calculateFeature(parsedText);

    Map<FeatureType, Double> features = new HashMap<>();
    features.put(FeatureType.AVERAGE_WORD_LENGTH, averageWordLength);
    features.put(FeatureType.TYPE_TOKEN_RATIO, typeTokenRatio);
    features.put(FeatureType.HAPAX_LEGOMENA_RATIO, hapaxLegomenaRatio);
    features.put(FeatureType.AVERAGE_SENTENCE_LENGTH, averageSentenceLength);
    features.put(FeatureType.AVERAGE_SENTENCE_COMPLEXITY, averageSentenceComplexity);

    return new LinguisticSignature(features);
  }
}
