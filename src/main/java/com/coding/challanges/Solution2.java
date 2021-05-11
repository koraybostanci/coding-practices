package com.coding.challanges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution2 {

    private final Character REF_CHARACTER = 'a';

    List<Integer> lengthEachScene(List<Character> inputList) {
        final int[] last = new int[26];
        for (int i = 0; i < inputList.size(); ++i) {
            last[inputList.get(i) - REF_CHARACTER] = i;
        }

        int j = 0, anchor = 0;
        final List<Integer> result = new ArrayList();
        for (int i = 0; i < inputList.size(); ++i) {
            j = max(j, last[inputList.get(i) - REF_CHARACTER]);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return result;
    }

    @Test
    void test1() {
        final List<Character> inputList = asList('a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j', 'e');
        final List<Integer> result = lengthEachScene(inputList);
        assertEquals(result, asList(5, 7));
    }

    @Test
    void test2() {
        final List<Character> inputList = asList('z', 'z', 'c', 'b', 'z', 'c', 'h', 'f', 'i', 'h', 'i');
        final List<Integer> result = lengthEachScene(inputList);
        assertEquals(result, asList(6, 5));
    }

}
