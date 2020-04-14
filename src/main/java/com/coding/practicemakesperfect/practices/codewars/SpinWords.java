package com.coding.practicemakesperfect.practices.codewars;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that takes in a string of one or more words, and returns the same string, but with all five or
 * more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and
 * spaces. Spaces will be included only when more than one word is present.
 *
 * Examples:
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 *
 */
public class SpinWords {

  private final int WORD_MAX_LENGTH = 5;
  private final String WORD_DELIMETER = " ";

  public String spinWords(String sentence) {
    requireNonNull(sentence);

    final String[] words = sentence.split(WORD_DELIMETER);
    return stream(words).map(word -> getWord(word)).collect(joining(WORD_DELIMETER)).trim();
  }

  private String getWord(String word) {
    return word.length() >= WORD_MAX_LENGTH ? new StringBuilder(word).reverse().toString() : word;
  }

  @Test
  public void test() {
    assertEquals("emocleW", spinWords("Welcome"));
    assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
  }
}
