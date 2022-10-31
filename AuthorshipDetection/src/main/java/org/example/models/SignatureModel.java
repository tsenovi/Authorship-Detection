package org.example.models;

import java.util.ArrayList;
import java.util.List;
import org.example.models.data.LinguisticSignature;
import org.example.utils.FileReader;

public class SignatureModel {

  private static SignatureModel instance;
  private final FileReader fileReader;

  private final List<LinguisticSignature> unknownSignatures;

  private SignatureModel() {
    fileReader = FileReader.getInstance();
    unknownSignatures = new ArrayList<>();
  }

  public static SignatureModel getInstance() {
    if (instance == null) {
      instance = new SignatureModel();
    }

    return instance;
  }

  public List<LinguisticSignature> getUnknownSignatures() {
    return unknownSignatures;
  }

  public void saveUnknownSignature(LinguisticSignature linguisticSignature) {
    unknownSignatures.add(linguisticSignature);
  }

  //TODO
  //Method for loading the data from knownSignature.txt through the FileReader
}
