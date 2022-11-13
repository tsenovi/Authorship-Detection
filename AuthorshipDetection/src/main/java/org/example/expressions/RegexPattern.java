package org.example.expressions;

public enum RegexPattern {

  KNOWN_SIGNATURES_PATH("src/main/resources/knownSignatures.txt"),
  DOUBLE_FORMAT("#0.00"),
  EMPTY_STRING(""),
  EMPTY_ROW("^\\s*$"),
  SENTENCE_SEPARATOR("[.!?]+"),
  PHRASE_SEPARATOR("[,:;]+"),
  PUNCTUATION("\\p{P}"),
  SINGLE_WHITESPACE(" "),
  COMMA_AND_WHITESPACE(", "),
  CONTIGUOUS_WHITESPACE("\\s+"),
  NEW_LINE("\n"),
  MR("mr."),
  MRS("mrs."),
  MISS("miss."),
  DR("dr.");
  private final String text;

  RegexPattern(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
