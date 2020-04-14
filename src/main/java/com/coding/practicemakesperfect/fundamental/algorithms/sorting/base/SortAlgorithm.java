package com.coding.practicemakesperfect.fundamental.algorithms.sorting.base;

import java.util.Arrays;

public abstract class SortAlgorithm {

    public abstract void sort(int[] data);

    protected void print(int[] data, String prefix) {
        System.out.println(prefix + ": " + Arrays.toString(data));
    }

    protected void print(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    protected void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
