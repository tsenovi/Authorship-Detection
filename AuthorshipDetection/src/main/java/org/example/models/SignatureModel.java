package org.example.models;

public class SignatureModel {

  private static SignatureModel instance;
  private final FileReader fileReader;

  private SignatureModel() {
    fileReader = FileReader.getInstance();
  }

  public static SignatureModel getInstance() {
    if(instance == null){
      instance = new SignatureModel();
    }

    return instance;
  }

  //TODO
  //Method for loading the data from knownSignature.txt through the FileReader
}
