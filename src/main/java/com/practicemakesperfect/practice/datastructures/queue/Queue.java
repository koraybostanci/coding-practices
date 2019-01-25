package com.practicemakesperfect.practice.datastructures.queue;


import java.util.NoSuchElementException;

public class Queue<T> {

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T value) {
        QueueNode<T> item = new QueueNode(value);

        if (last != null) {
            last.setNext(item);
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

        T value = first.getValue();
        first = first.getNext();

        if (first == null) {
            last = null;
        }

        return value;
    }

    public T peek() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

}