package com.coding.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string "aabcccccaaa" would become "a2blc5a3". If the "compressed" string
 * would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class P06_StringCompression {

    /**
     *
     * Test cases :
     * aabcccccaaa  ->  a2blc5a3
     * aab          ->  aab
     */
    public String compress(String string) {

        if (string == null || string.length() == 0) {
            return string;
        }

        StringBuilder builder = new StringBuilder();

        Character previous = null;
        int count = 0;

        for (Character current : string.toCharArray()) {
            if (previous == null) {
                previous = current;
                count++;
                continue;
            }

            if (previous.equals(current)) {
                count++;
            } else {
                builder.append(previous.toString() + count);
                count = 1;
            }
            previous = current;
        }
        builder.append(previous.toString() + count);

        return string.length() < builder.length() ? string : builder.toString();
    }

    @Test
    public void test1() {
        String compressed = compress("aabcccccaaa");
        assertEquals("a2b1c5a3", compressed);
    }

    @Test
    public void test2() {
        String compressed = compress("aab");
        assertEquals("aab", compressed);
    }

}
