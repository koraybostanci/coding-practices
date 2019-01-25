package com.practicemakesperfect.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class P03_LongestSubstringWithoutRepeatedChars {

    /**
     * Using sliding window approach
     * The main idea here is to maximize the length of [i,j)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int max = 0;
        int i=0, j=0;

        Set<Character> chars = new HashSet<>();
        while (i < n && j < n) {
            if (!chars.contains(s.charAt(j))) {
                chars.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                chars.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    /**
     * Assuming a Unicode and not case sensitive
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start=0;
        int max = 0;
        int[] map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int c = (int)s.charAt(i);
            start = Math.max(map[c], start);
            map[c] = i + 1;
            max = Math.max(max, i + 1 - start);
        }

        return max;
    }

    @Test
    public void test1() {
        String s = "abcabcbb";
        int max = lengthOfLongestSubstring(s);

        Assertions.assertEquals(3, max);
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        int max = lengthOfLongestSubstring(s);

        Assertions.assertEquals(1, max);
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        int max = lengthOfLongestSubstring(s);

        Assertions.assertEquals(3, max);
    }

    @Test
    public void test4() {
        String s = "abcb";
        int max = lengthOfLongestSubstring(s);

        Assertions.assertEquals(3, max);
    }

}
