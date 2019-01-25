package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FirstNonRepeatedCharacter : Write a function to find the first non-repeated character in a given string
 */
public class P11_FirstNonRepeatedCharacter {

    public Character findFirstNonRepeatedCharacter(String string) {
        if (string == null) {
            return null;
        }

        Map<Character, Integer> counts = new LinkedHashMap(string.length());

        for (Character c : string.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        Character result = counts.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst()
                .orElse(null);

        return result;
    }

    @Test
    void testNull() {
        Character result = findFirstNonRepeatedCharacter(null);
        Assert.assertEquals(null, result);
    }

    @Test
    void testBlank() {
        Character result = findFirstNonRepeatedCharacter("");
        Assert.assertEquals(null, result);
    }

    @Test
    void testOneCharacter() {
        Character result = findFirstNonRepeatedCharacter("a");
        Assert.assertEquals((Character)'a', result);
    }

    @Test
    void testSameTwoCharacters() {
        Character result = findFirstNonRepeatedCharacter("aa");
        Assert.assertEquals(null, result);
    }

    @Test
    void testWithNonRepeatedCharacter() {
        Character result = findFirstNonRepeatedCharacter("aba");
        Assert.assertEquals((Character) 'b', result);
    }

    @Test
    public void testFindFirstNonRepeatedCharacter() {
        Character result = findFirstNonRepeatedCharacter("geekforgeek");
        Assert.assertEquals((Character)'f', result);
    }

}
