package com.coding.practices.codewars;

import org.junit.jupiter.api.Test;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an array (which will have a length of at least 3, but could be very large)
 * containing integers. The array is either entirely comprised of odd integers or entirely comprised
 * of even integers except for a single integer N. Write a method that takes the array as an
 * argument and returns this "outlier" N.
 *
 * <p>Examples: [2, 4, 0, 100, 4, 11, 2602, 36] Should return: 11 (the only odd number)
 *
 * <p>[160, 3, 1719, 19, 11, 13, -21] Should return: 160 (the only even number)
 */
public class FindOutlier {

  static int find(int[] integers) {
    for (int i = 0; i < integers.length - 2; i++) {
      int a = abs(integers[i]) % 2;
      int b = abs(integers[i+1]) % 2;
      int c = abs(integers[i+2]) % 2;

      if (a == b && b != c) {
        return integers[i+2];
      } else if (a == c && b != c) {
        return integers[i+1];
      } else if (a != b && b == c) {
        return integers[i];
      }
    }
    return -1;
  }

  @Test
  public void test() {
    int[] exampleTest1 = { 2, 6, 8, -10, 3 };
    assertEquals(3, find(exampleTest1));

    int[] exampleTest2 = { 206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781 };
    assertEquals(206847684, find(exampleTest2));

    int[] exampleTest3 = { Integer.MAX_VALUE, 0, 1 };
    assertEquals(0, find(exampleTest3));
  }

}
