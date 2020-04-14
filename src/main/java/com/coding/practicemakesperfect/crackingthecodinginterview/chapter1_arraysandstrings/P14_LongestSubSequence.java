package com.coding.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Find the longest subSequence of a given string X, which is also a subString of Y.
 *
 * SubSequence :
 *  X = ABCD => A, B, C, D, AB, AC, AD, BC, BD, ABC, BCD, ABCD
 *
 * SubString :
 *  Y = BACDBDCD => B, A, BA, BAC, ACD, etc...
 *
 */
public class P14_LongestSubSequence {

    public static int findLongestSubsequence(String X, String Y) {
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();

        int map[][] = new int[y.length+1][x.length+1];

        for (int i = 1; i <= y.length; i++) {
            char value1 = y[i-1];
            for (int j = 1; j <= x.length; j++) {
                char value2 = x[j-1];
                map[i][j] = value1 == value2 ? map[i-1][j-1] + 1: map[i][j-1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= y.length; i++) {
            for (int j = 1; j <= x.length; j++) {
                int value = map[i][j];
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    @Test
    public void test() {
        String X = "ABCD";
        String Y = "BACDBDCD";

        int result = findLongestSubsequence(X, Y);
        assertEquals(3, result);
    }
}
