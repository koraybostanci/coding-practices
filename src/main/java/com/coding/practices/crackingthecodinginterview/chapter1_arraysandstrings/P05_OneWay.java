package com.coding.practices.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they
 * are one edit (or zero edits) away.
 *
 *  EXAMPLE
 * pale,  ple  -> true
 * pales, pale -> true
 * pale,  bale -> true
 * pale,  bae  -> false
 * pale,  pire -> false
 */
public class P05_OneWay {

    public boolean areMaxOneEdit(String string1, String string2) {
        return string1.length() >= string2.length()
                ? hasMaxOneEdit(string1, string2)
                : hasMaxOneEdit(string2, string1);
    }

    private boolean hasMaxOneEdit(String string1, String string2) {

        int[] charMap = new int[256];
        for (Character c : string1.toCharArray()) {
            charMap[(int)c]++;
        }

        for (Character c : string2.toCharArray()) {
            charMap[(int)c]--;
        }

        int changeCount = 0;
        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] > 0) {
                changeCount++;
            }
        }

        return changeCount <= 1;
    }

    @Test
    public void test1() {
        assertTrue(areMaxOneEdit("pale", "ple"));
    }

    @Test
    public void test2() {
        assertTrue(areMaxOneEdit("pales", "pale"));
    }

    @Test
    public void test3() {
        assertTrue(areMaxOneEdit("pale", "bale"));
    }

    @Test
    public void test4() {
        assertFalse(areMaxOneEdit("pale", "bae"));
    }

    @Test
    public void test5() {
        assertFalse(areMaxOneEdit("pale", "file"));
    }

}
