package com.coding.practicemakesperfect.practices.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Find the total sum of angles in an n sided shape. N will be greater than 2.
 */
public class AngleSum {
  public static int sumOfAngles(int n) {
    return (n - 2) * 180;
  }

  @Test
  public void test() {
    assertEquals(AngleSum.sumOfAngles(3), 180);
    assertEquals(AngleSum.sumOfAngles(4), 360);
  }
}
