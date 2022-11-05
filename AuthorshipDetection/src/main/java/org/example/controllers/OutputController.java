package org.example.controllers;

import java.util.List;
import org.example.models.OutputModel;
import org.example.models.data.LinguisticSignature;
import org.example.utils.AuthorshipDetector;

public class OutputController {

  private static OutputController instance;
  private final OutputModel outputModel;
  private final AuthorshipDetector authorshipDetector;

  private OutputController() {
    outputModel = OutputModel.getInstance();
    authorshipDetector = AuthorshipDetector.getInstance();
  }

  public static OutputController getInstance() {
    if (instance == null) {
      instance = new OutputController();
    }

    return instance;
  }

  public void onReceivedData(List<LinguisticSignature> knownSignatures,
      List<LinguisticSignature> unknownSignatures) {
    calculateResults(knownSignatures, unknownSignatures);
  }

  private void calculateResults(List<LinguisticSignature> knownSignatures,
      List<LinguisticSignature> unknownSignatures) {
    authorshipDetector.compare(unknownSignatures, knownSignatures);
  }
}
