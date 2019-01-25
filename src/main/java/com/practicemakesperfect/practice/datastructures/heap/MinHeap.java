package com.practicemakesperfect.practice.datastructures.heap;

import java.util.Arrays;

public class MinHeap {

    private int[] values;

    public MinHeap() {
        this.values = new int[]{};
    }

    public MinHeap(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("values can not be null");
        }
        this.values = values;
    }

    public int getLength() {
        return values.length;
    }

    public int extractMin() {
        if (values.length == 0) {
            return -1;
        }

        if (values.length == 1) {
            return values[0];
        }

        int min = values[0];
        values[0] = values[values.length - 1];
        buble_down(0);

        return min;
    }

    public void insert(int value) {
        int index = values.length;
        int[] newValues = Arrays.copyOf(values, values.length * 2);
        newValues[index] = value;
        values = newValues;

        buble_up(index);
    }

    private void buble_up(int index) {
        // TODO:
    }

    private void buble_down(int index) {
        int smaller_index = get_smaller_child_index(index);
        if (smaller_index == -1) {
            return;
        }

        int temp = values[smaller_index];
        values[smaller_index] = values[index];
        values[index] = temp;

        buble_down(smaller_index);

    }

    private int get_smaller_child_index(int index) {
        int left = get_left_child_index(index);
        int right = get_right_child_index(index);

        return left < right ? left : right;
    }

    private int get_child_index(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index: " + String.valueOf(index));
        }
        return (2 * index);
    }

    private int get_left_child_index(int index) {
        return get_child_index(index) + 1;
    }

    private int get_right_child_index(int index) {
        return get_child_index(index) + 2;
    }

    private int get_parent(int index) {
        int value = ((index - 1) / 2);
        return value;
    }
}

