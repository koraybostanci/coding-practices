package com.coding.fundamental.datastructures.queue;


import java.util.NoSuchElementException;

public class Queue<T> {

    public class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T value) {
        Node<T> item = new Node(value);

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