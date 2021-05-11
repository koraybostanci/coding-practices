package com.coding.practices.codewars;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this little assignment you are given a string of space separated numbers, and have to return
 * the highest and lowest number.
 *
 * <p>Example: highAndLow("1 2 3 4 5") // return "5 1" highAndLow("1 2 -3 4 5") // return "5 -3"
 * highAndLow("1 9 3 4 -5") // return "9 -5"
 *
 * <p>Notes: All numbers are valid Int32, no need to validate them. There will always be at least
 * one number in the input string. Output string must be two numbers separated by a single space,
 * and highest number is first.
 */
public class HighAndLow {

  private static final String NUMBER_SEPERATOR = " ";

  public static String highAndLow(String numbers) {
    requireNonNull(numbers);

    int HIGH = MIN_VALUE;
    int LOW = MAX_VALUE;

    String[] integers = numbers.split(NUMBER_SEPERATOR);
    for (String integer : integers) {
      int number = Integer.parseInt(integer);
      if (number > HIGH) {
        HIGH = number;
      }
      if (number < LOW) {
        LOW = number;
      }
    }

    return HIGH + NUMBER_SEPERATOR + LOW;
  }

  @Test
  public void test() {
    assertEquals("5 5", highAndLow("5"));
    assertEquals("4 3", highAndLow("3 4"));
    assertEquals("1 0", highAndLow("1 0"));
    assertEquals("1 -1", highAndLow("1 0 -1"));
    assertEquals("4 -3", highAndLow("-3 -1 4"));
    assertEquals("42 -9", highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
  }
}
