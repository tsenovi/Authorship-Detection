package org.example.controllers;

import java.util.List;
import org.example.models.OutputModel;
import org.example.models.data.LinguisticSignature;
import org.example.utils.AuthorshipDetector;
import org.example.utils.SimilarityConvertor;
import org.example.views.OutputView;

public class OutputController {

  private static OutputController instance;
  private final OutputView outputView;
  private final OutputModel outputModel;
  private final AuthorshipDetector authorshipDetector;

  private final SimilarityConvertor similarityConvertor;

  private OutputController() {
    outputView = OutputView.getInstance();
    outputModel = OutputModel.getInstance();
    authorshipDetector = AuthorshipDetector.getInstance();
    similarityConvertor = SimilarityConvertor.getInstance();
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

    double[][] similarities = authorshipDetector.compare(unknownSignatures, knownSignatures);
    similarityConvertor.parseToPercentage(similarities);
    onReceivedResults(similarities);
  }

  private void onReceivedResults(double[][] similarities) {
    updateModel(similarities);
    updateView();
  }

  private void updateView() {
    double[][] results = outputModel.getResults();
    outputView.printResults(results);
  }

  private void updateModel(double[][] similarities) {
    outputModel.save(similarities);
  }
}
