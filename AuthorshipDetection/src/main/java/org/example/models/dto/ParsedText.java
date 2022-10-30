package org.example.models.dto;

public record ParsedText(int sentenceCount, int phraseCount, int wordCount, int uniqueWordCount,
                         int nonRecurringWordCount, int characterCount) {

}
