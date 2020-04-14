package com.coding.practicemakesperfect.fundamental.algorithms.sorting.impl;

import com.coding.practicemakesperfect.fundamental.algorithms.sorting.base.SortAlgorithm;

/*
 *
 * Description :
 *   In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater
 * than the second. Then, we go to the next pair, and so on, continuously making sweeps of the array until it is
 * sorted. In doing so, the smaller items slowly "bubble" up to the beginning of the list.
 *
 * Complexity :
 *  Runtime : O(N^2) In average and worst case.
 *  Memory  : O(1)   No extra memory need, in-place sorting
 *
 * */
public class BubbleSort extends SortAlgorithm {

    @Override
    public void sort(int[] data) {

        print(data, "Before");

        int count = data.length;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (data[i] < data[j]) {
                    swap(data, i, j);
                }
            }
        }

        print(data, "After");

    }

}
