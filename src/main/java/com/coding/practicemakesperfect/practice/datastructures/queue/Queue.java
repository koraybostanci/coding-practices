package com.coding.practicemakesperfect.practice.datastructures.queue;


import java.util.NoSuchElementException;

public class Queue<T> {

    public class QueueNode<T> {
        private T value;
        private QueueNode<T> next;

        QueueNode(T value) {
            this.value = value;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T value) {
        QueueNode<T> item = new QueueNode(value);

        if (last != null) {
            last.next = item;
        }
        last = item;

        if (first == null) {
            first = last;
        }
    }

    public T remove() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T value = first.value;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return value;
    }

    public T peek() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

}