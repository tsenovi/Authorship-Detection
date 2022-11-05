package org.example.models;


public class OutputModel {

  private static OutputModel instance;

  private double[][] results;

  private OutputModel() {
    results = null;
  }

  public static OutputModel getInstance() {
    if (instance == null) {
      instance = new OutputModel();
    }

    return instance;
  }

  public double[][] getResults() {
    return results;
  }


  public void save(double[][] similarities) {
    results = similarities;
  }
}
