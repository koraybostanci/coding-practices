package com.coding.practices.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Anagram : Write a function that takes 2 string parameters and finds if these words are anagram or not
 *
 * Input  : "Steal the pears from tesla and spare the tales"
 * Output : ["steal", "tesla", "tales"], ["pears", "spare"]
 *
 * Steal, tesla => true
 * pears, spare => true
 * tesla, tales => true
 *
 * Case sensitive   => No
 * Ascii or Unicode => Unicode
 */
public class P10_Anagram {


    public boolean areAnagram(String word1, String word2) {

        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }

        final String w1 = word1.toLowerCase();
        final String w2 = word2.toLowerCase();

        final int[] charMap = new int[256];

        for (int i = 0; i < w1.length(); i++) {
            charMap[w1.charAt(i)]++;
            charMap[w2.charAt(i)]--;
        }

        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testTrue() {
        final boolean result = areAnagram("Steal", "tales");
        assertTrue(result);
    }

    @Test
    public void testFalse() {
        final boolean result = areAnagram("Ste.al", "tales");
        assertFalse(result);
    }

}

