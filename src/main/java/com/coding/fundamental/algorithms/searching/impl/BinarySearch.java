package com.coding.fundamental.algorithms.searching.impl;


import com.coding.fundamental.algorithms.searching.base.SearchAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Description :
 * One very important benefit of having sorted elements is the ability to quickly search through them.
 * If you have a sequence of sorted elements you can use binary search to find if it includes a given element or
 * to find the proper place of a new element in the sorted sequence with time complexity O(logN).
 * For big enough sequences this is much better than the linear approach of searching through the whole sequence until
 * you find the answer.
 *
 * In binary search, we look for an element x in a sorted array by first comparing x to the midpoint of the array.
 * If x is less than the midpoint, then we search the left half of the array. If x is greater than the midpoint,
 * then we search the right half of the array. We then repeat this process, treating the left and right halves
 * as sub-arrays. Again, we compare x to the midpoint of this sub-array and then search either its left or right side.
 * We repeat this process until we either find x or the sub-array has size O.
 *
 * Constraints :
 *   Works on sorted arrays of numbers
 *   Direction of the sorting (ascending, descending) is important for selecting the right sub-sequence array while comparing.
 * */
public class BinarySearch extends SearchAlgorithm {

    @Override
    public int search(int[] array, int x) {
        print(array);

        int lowIndex  = 0;
        int highIndex = array.length - 1;

        int index;
        int value;

        while (lowIndex <= highIndex) {
            index = (lowIndex + highIndex) / 2;
            value = array[index];

            if (x == value) {
                return index;
            }

            if (x > value) {
                lowIndex = index + 1;
            } else if (x < value) {
                highIndex = index - 1;
            }
        }

        return -1;
    }

    @Test
    void search_returnsIndex_whenArrayContainsXAsFirstElement() {
        final int[] array = { 2, 4, 8, 9, 16, 20, 34, 90 };
        final int index = search(array, 2);
        assertTrue(index == 0);
    }

    @Test
    void search_returnsIndex_whenArrayContainsXAsLastElement() {
        final int[] array = { 1, 4, 8, 9, 16, 20, 34, 90 };
        final int index = search(array, 90);
        assertTrue(index == array.length -1);
    }

    @Test
    void search_returnsIndex_whenArrayContainsX() {
        final int[] array = { 1, 4, 8, 9, 16, 20, 34, 90 };
        final int index = search(array, 4);
        assertTrue(index == 1);
    }

    @Test
    void search_returnsIndex_whenArrayDoesNotContainX() {
        final int[] array = { 1, 4, 8, 9, 16, 20, 34, 90 };
        final int index = search(array, 7);
        assertTrue(index == -1);
    }
}

