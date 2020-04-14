package com.coding.practicemakesperfect.practice.algorithms.sorting.impl;

import com.coding.practicemakesperfect.practice.algorithms.sorting.base.SortAlgorithm;

/*
 *
 * Description :
 *   Sort algorithms order the elements of an array according to a predefined order.
 * Quicksort is a divide and conquer algorithm. In a divide and conquer sorting algorithm the original data is
 * separated into two parts "divide" which are individually sorted and "conquered" and then combined.
 *
 *   In quick sort, we pick a random element and partition the array, such that all numbers that are less than
 * the partitioning element come before all elements that are greater than it. The partitioning can be performed
 * efficiently through a series of swaps.
 *
 *   If we repeatedly partition the array (and its sub-arrays) around an element, the array will eventually
 * become sorted. However, as the partitioned element is not guaranteed to be the median
 * (or anywhere near the median), our sorting could be very slow.
 * This is the reason for the O(N^2) worst case runtime.
 *
 * If the array containsPair only one element or zero elements then the array is sorted.
 * If the array containsPair more than one element then:
 *    - Select an element from the array. This element is called the "pivot element". For example select the element
 *    in the middle of the array.
 *    - All elements which are smaller than the pivot element are placed in one array and all elements which are larger
 *    are placed in another array.
 *    - Sort both arrays by recursively applying Quicksort to them.
 *    - Combine the arrays.
 *
 * Quicksort can be implemented to sort "in-place". This means that the sorting takes place in the array and
 * that no additional array needs to be created.
 *
 * Complexity :
 *   Runtime : O(N*logN) average, O(N^2) worst case
 *   Memory  : O(logN)
 *
 * */
public class QuickSort extends SortAlgorithm {

    @Override
    public void sort(int[] data) {
        print(data);

        if (data == null || data.length == 0) {
            return;
        }

        quicksort(data, 0, data.length - 1);

    }

    private void quicksort(int[] data, int low, int high) {
        int i = low;
        int j = high;

        // Get the pivot element from the middle of the list
        int pivot = data[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (data[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (data[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values as we are done we can increase i and j
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j) {
            quicksort(data, low, j);
        }
        if (i < high) {
            quicksort(data, i, high);
        }
    }

}

