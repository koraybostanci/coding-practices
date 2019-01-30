package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Write a function that takes an array of sorted integers and a sum, and returns true if a pair of any elements
 * in the given array has sum of given sum parameter.
 */
public class P12_ContainsPair {

    /**
     * array = { 1, 2, 4, 4 }, sum = 8 => true
     * array = { 1, 2, 4, 9 }, sum = 8 => false
     */
    public boolean containsPair(int[] array, int sum) {

        if (array == null || array.length == 0) {
            return false;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int total = array[low] + array[high];
            if (total == sum) {
                return true;
            } else if (total > sum) {
                high = high - 1;
            } else if (total < sum) {
                low = low + 1;
            }
        }

        return false;
    }

    @Test
    public void testShouldSuccess() {
        int[] array = { 1, 2, 4, 4 };
        int sum = 8;

        boolean result = containsPair(array, sum);
        Assert.assertTrue(result);
    }

    @Test
    public void testShouldFail() {
        int[] array = { 1, 2, 4, 9 };
        int sum = 8;

        boolean result = containsPair(array, sum);
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyArray() {
        int[] array = {  };
        int sum = 8;

        boolean result = containsPair(array, sum);
        Assert.assertFalse(result);
    }

    @Test
    public void testNull() {
        int[] array = null;
        int sum = 8;

        boolean result = containsPair(array, sum);
        Assert.assertFalse(result);
    }

}
