package org.example.controllers;

import java.util.List;
import org.example.parsers.AverageSentenceComplexity;
import org.example.parsers.AverageSentenceLength;
import org.example.parsers.AverageWordLength;
import org.example.parsers.Calculable;
import org.example.parsers.HapaxLegomenaRatio;
import org.example.parsers.ParsedText;
import org.example.parsers.TextParser;
import org.example.parsers.TypeTokenRatio;
import org.example.models.SignatureModel;

public class SignatureController {

  private static SignatureController instance;
  private final SignatureModel signatureModel;
  private final TextParser textParser;
  private final Calculable averageWordLength;
  private final Calculable typeTokenRatio;
  private final Calculable hapaxLegomenaRatio;
  private final Calculable averageSentenceLength;
  private final Calculable averageSentenceComplexity;

  private SignatureController() {
    signatureModel = SignatureModel.getInstance();
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
    //TODO
    //Create collection for signatures for every paragraph and save it
    for (String paragraph : paragraphs) {
      calculateSignature(paragraph);
    }
  }

  private void calculateSignature(String paragraph) {
    ParsedText parsedText = textParser.parse(paragraph);
    double averageWordLength = this.averageWordLength.calculateFeature(parsedText);
    double typeTokenRatio = this.typeTokenRatio.calculateFeature(parsedText);
    double hapaxLegomenaRatio = this.hapaxLegomenaRatio.calculateFeature(parsedText);
    double averageSentenceLength = this.averageSentenceLength.calculateFeature(parsedText);
    double averageSentenceComplexity = this.averageSentenceComplexity.calculateFeature(parsedText);

    //TODO
    //Return Signature object with calculated features and add it to the collection
  }
}
