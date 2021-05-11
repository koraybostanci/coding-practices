package com.coding.fundamental.algorithms.searching.base;

import java.util.Arrays;

public abstract class SearchAlgorithm {

    public abstract int search(int[] array, int x);

    protected void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
