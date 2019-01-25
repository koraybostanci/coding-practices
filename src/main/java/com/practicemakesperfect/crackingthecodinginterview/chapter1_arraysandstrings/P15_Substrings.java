package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible substrings of given string
 */
public class P15_Substrings {

    /**
     * Time Complexity : O(n^2)
     */
    public List<String> findAllSubstrings(String string) {
        List<String> subStrings = new ArrayList<>();
        if (string == null) {
            return subStrings;
        }

        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                String value = string.substring(i, j);
                subStrings.add(value);
            }
        }

        return subStrings;
    }

    @Test
    public void test() {
        String string = "ABCD";
        List<String> substrings = findAllSubstrings(string);
    }
}
