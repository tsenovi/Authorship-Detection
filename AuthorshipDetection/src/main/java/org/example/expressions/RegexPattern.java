package org.example.expressions;

public enum RegexPattern {

  EMPTY_STRING(""),
  SENTENCE_SEPARATOR("[.!?]+"),
  PHRASE_SEPARATOR("[,:;]+"),
  PUNCTUATION("\\p{P}"),
  SINGLE_WHITE_SPACE(" "),
  CONTIGUOUS_WHITE_SPACE("\\s+"),
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
