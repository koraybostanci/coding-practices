package com.coding.fundamental.algorithms.sorting.impl;


import com.coding.fundamental.algorithms.sorting.base.SortAlgorithm;

/*
 *
 * Description :
 *   Radix sort is a sorting algorithm for integers (and some other data types) that takes advantage of the fact that
 * integers have a finite number of bits. In radix sort, we iterate through each digit of the number,
 * grouping numbers by each digit.
 *
 *   For example; if we have an array of integers, we might first sort by the first digit, so that the
 * Os are grouped together. Then, we sort each of these groupings by the next digit. We repeat this process
 * sorting by each subsequent digit. until finally the whole array is sorted.
 *
 * Complexity :
 *   Runtime : O(k*N)
 *   Memory  :
 *
 * */
public class RadixSort extends SortAlgorithm {

    @Override
    public void sort(int[] data) {
        /*TODO : NotImplemented*/
        print(data);
    }

}

