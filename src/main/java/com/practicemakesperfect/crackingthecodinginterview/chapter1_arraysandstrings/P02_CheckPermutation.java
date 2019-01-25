package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class P02_CheckPermutation {

    /**
     * Clarifying questions
     * - Case sensitivity : is "Tales" a permutation of "tesla"?    (No)
     * - Whitespaces      : is "tales   " a permutation of "tesla"? (No)
     * - Alphabet         : is it a ASCII or UNICODE string?
     * This will change the unique character count. (Unicode)
     *
     * Cases
     * Lengths should be same.
     *
     * Test cases
     *  null    null        -> false
     *  tesla   null        -> false
     *  null    tesla       -> false
     *  tesla   tales       -> true
     *  tesla   tares       -> false
     *  tesla   tale        -> false
     *  tesla   "tales  "   -> false
     *
     */
    public boolean isPermutation(String string1, String string2) {

        if (string1 == null || string2 == null) {
            return false;
        }

        if (string1.length() != string2.length()) {
            return false;
        }

        int[] charMap = new int[256];
        for(Character c : string1.toCharArray()) {
            charMap[(int)c]++;
        }

        for(Character c : string2.toCharArray()) {
            charMap[(int)c]--;
        }

        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] > 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testAllNull() {
        boolean result = isPermutation(null, null);
        Assertions.assertEquals(result,false);

        result = isPermutation("tesla", null);
        Assertions.assertEquals(result,false);

        result = isPermutation(null, "tesla");
        Assertions.assertEquals(result,false);
    }

    @Test
    public void testTrue() {
        boolean result = isPermutation("tesla", "tales");
        Assertions.assertEquals(result,true);
    }

    @Test
    public void testFalse() {
        boolean result = isPermutation("tesla", "tares");
        Assertions.assertEquals(result,false);
    }

    @Test
    public void testDifferentLength() {
        boolean result = isPermutation("tesla", "tale");
        Assertions.assertEquals(result,false);
    }

    @Test
    public void testWhitespace() {
        boolean result = isPermutation("tesla", "tales  ");
        Assertions.assertEquals(result,false);
    }

}
