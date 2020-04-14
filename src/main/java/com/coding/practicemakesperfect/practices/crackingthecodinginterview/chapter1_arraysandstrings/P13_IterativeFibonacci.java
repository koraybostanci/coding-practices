package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter1_arraysandstrings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P13_IterativeFibonacci {

    private final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int findWithCache(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = find(n);
        cache.put(n, result);

        return result;
    }

    public int find(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int result = a + b;

        for (int i = 2; i < n; i++) {
            a = b;
            b = result;
            result = a + b;
        }

        return result;
    }


    @Test
    public void testIterative() {
        int result = find(9);
        assertEquals(34, result);
    }

    @Test
    public void testIterativeWithCache() {
        int result = findWithCache(8);
        assertEquals(21, result);
    }
}
