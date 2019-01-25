package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * For a given string, check whether it's a palindrome or not
 *
 * A palindrome is a word, phrase, number, or other sequences of characters which reads
 * the same backward as forward, such as “madam” or “racecar”.
 */
public class P16_Palindrome {

    /**
     * This solution uses recursive approach.
     */
    public boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    public boolean isPalindromeRecursive(String text, int begin, int end) {
        if (begin == end) {
            return true;
        }

        if (text.charAt(begin) != text.charAt(end)) {
            return false;
        }

        if (begin < end + 1) {
            return isPalindromeRecursive(text, begin + 1, end - 1);
        }

        return true;
    }

    /**
     * This solution uses iterative approach.
     */
    public boolean isPalindromeIterative(String text) {
        for (int i = 0, j=text.length()-1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testRecursive1() {
        boolean result = isPalindromeRecursive("MADAM");
        Assertions.assertTrue(result);
    }

    @Test
    public void testRecursive2() {
        boolean result = isPalindromeRecursive("MADDAM");
        Assertions.assertTrue(result);
    }

    @Test
    public void testRecursive3() {
        boolean result = isPalindromeRecursive("MADEAM");
        Assertions.assertFalse(result);
    }

    @Test
    public void testIterative1() {
        boolean result = isPalindromeIterative("MADAM");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIterative2() {
        boolean result = isPalindromeIterative("MADDAM");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIterative3() {
        boolean result = isPalindromeIterative("MADEAM");
        Assertions.assertFalse(result);
    }

}
