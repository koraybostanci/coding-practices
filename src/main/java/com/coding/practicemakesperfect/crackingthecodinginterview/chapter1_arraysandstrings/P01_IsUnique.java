package com.coding.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class P01_IsUnique {

    /**
     * Clarifying questions
     * - Is it a ASCII or UNICODE string? This will change the unique character count. (Unicode)
     */
    public boolean hasUniqueCharacters(String string) {
        final int UNIQUE_CHAR_COUNT = 256;

        if (string == null || string.length() == 0 || string.length() > UNIQUE_CHAR_COUNT) {
            return false;
        }

        boolean[] charMap = new boolean[UNIQUE_CHAR_COUNT];
        for (Character c : string.toCharArray()) {
            if (charMap[(int)c]) {
                return false;
            }
            charMap[(int)c] = true;
        }

        return true;
    }

    @Test
    public void testNull() {
        boolean result = hasUniqueCharacters(null);
        assertEquals(false, result);
    }

    @Test
    public void testEmpty() {
        boolean result = hasUniqueCharacters("");
        assertEquals(false, result);
    }

    @Test
    public void testWithDuplicatedChars() {
        boolean result = hasUniqueCharacters("aab");
        assertEquals(false, result);
    }

    @Test
    public void testWithUniqueChars() {
        boolean result = hasUniqueCharacters("koray");
        assertEquals(true, result);
    }

}
