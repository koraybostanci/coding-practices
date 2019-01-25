package com.coding.practicemakesperfect.practice.algorithms.searching.base;

import java.util.Arrays;

public abstract class SearchAlgorithm {

    public abstract int search(int[] arr, int x);

    protected void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
