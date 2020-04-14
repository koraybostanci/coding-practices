package com.coding.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

/**
 * URLify: Write a method to replace all spaces in a string with '%20:
 * You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * EXAMPLE
 * Input  : "Mr John Smith"
 * Output : "Mr%20John%20Smith"
 */
public class P03_Urlify {

    public String urlify(String string, char oldValue, char newValue) {
        char[] charMap = string.toCharArray();

        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] == oldValue) {
                charMap[i] = newValue;
            }
        }

        return charMap.toString();
    }

}
