package org.example.models;

import java.util.ArrayList;
import java.util.List;
import org.example.models.data.LinguisticSignature;
import org.example.utils.SignatureReader;

public class SignatureModel {

  private static SignatureModel instance;
  private final SignatureReader signatureReader;
  private List<LinguisticSignature> knownSignatures;
  private final List<LinguisticSignature> unknownSignatures;

  private SignatureModel() {
    signatureReader = SignatureReader.getInstance();
    unknownSignatures = new ArrayList<>();
    loadKnownSignatures();
  }

  public static SignatureModel getInstance() {
    if (instance == null) {
      instance = new SignatureModel();
    }

    return instance;
  }

  public List<LinguisticSignature> getKnownSignatures() {
    return knownSignatures;
  }

  public List<LinguisticSignature> getUnknownSignatures() {
    return unknownSignatures;
  }

  public void saveUnknownSignature(LinguisticSignature linguisticSignature) {
    unknownSignatures.add(linguisticSignature);
  }

  private void loadKnownSignatures() {
    knownSignatures = signatureReader.readyByLine();
  }
}
