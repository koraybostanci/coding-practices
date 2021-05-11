package com.coding.fundamental.algorithms.sorting.impl;

import com.coding.fundamental.algorithms.sorting.base.SortAlgorithm;

/*
 *
 * Description :
 *   Simple, but inefficient. Find the smallest element using a linear scan and move it to the front
 * (swapping it with the front element).Then, find the second smallest and move it, again doing a linear scan.
 * Continue doing this until all the elements are in place.
 *
 * Complexity :
 *   Runtime : O(N^2) In average and worst case
 *   Memory  : O(1)   No extra memory need, in-place sorting
 *
 * */
public class SelectionSort extends SortAlgorithm {

    @Override
    public void sort(int[] data) {

        print(data,"Before");

        int length = data.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }

        print(data, "After");
    }
}

