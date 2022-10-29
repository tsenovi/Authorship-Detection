package org.example.parsers;

public class ParsedText {

  private int sentenceCount;
  private int phraseCount;
  private int wordCount;
  private int uniqueWordCount;
  private int nonRecurringWordCount;
  private int characterCount;

  public int getSentenceCount() {
    return sentenceCount;
  }

  public void setSentenceCount(int sentenceCount) {
    this.sentenceCount = sentenceCount;
  }

  public int getPhraseCount() {
    return phraseCount;
  }

  public void setPhraseCount(int phraseCount) {
    this.phraseCount = phraseCount;
  }

  public int getWordCount() {
    return wordCount;
  }

  public void setWordCount(int wordCount) {
    this.wordCount = wordCount;
  }

  public int getUniqueWordCount() {
    return uniqueWordCount;
  }

  public void setUniqueWordCount(int uniqueWordCount) {
    this.uniqueWordCount = uniqueWordCount;
  }

  public int getNonRecurringWordCount() {
    return nonRecurringWordCount;
  }

  public void setNonRecurringWordCount(int nonRecurringWordCount) {
    this.nonRecurringWordCount = nonRecurringWordCount;
  }

  public int getCharacterCount() {
    return characterCount;
  }

  public void setCharacterCount(int characterCount) {
    this.characterCount = characterCount;
  }
}
