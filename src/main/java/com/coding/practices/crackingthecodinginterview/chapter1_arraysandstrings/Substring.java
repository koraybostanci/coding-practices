package com.coding.practices.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Substring {

    public static boolean isSubstring(final String reference, final String sub) {

        if (sub == null) {
            return false;
        }
        if (sub.isEmpty()) {
            return true;
        }

        int subPointer = 0;
        for (int i = 0; i < reference.length(); i++) {
            if (reference.charAt(i) == sub.charAt(subPointer)) {
                subPointer++;
            } else {
                subPointer = 0;
            }

            if (subPointer == sub.length()) {
                return true;
            }
        }

        return false;
    }

    @Test
    void returnsTrue_whenStringsAreSame() {
        final boolean result = isSubstring("abcd", "abcd");
        assertTrue(result);
    }

    @Test
    void returnsTrue_whenSubIsEmpty() {
        final boolean result = isSubstring("abcd", "");
        assertTrue(result);
    }

    @Test
    void returnsFalse_whenSubIsNull() {
        final boolean result = isSubstring("abcd", null);
        assertFalse(result);
    }

    @Test
    void returnsTrue_whenReferenceContainsSub() {
        final boolean result = isSubstring("abcd", "abc");
        assertTrue(result);
    }

    @Test
    void returnsTrue_whenReferenceContainsSub2() {
        final boolean result = isSubstring("abceabcd", "abcd");
        assertTrue(result);
    }
}
