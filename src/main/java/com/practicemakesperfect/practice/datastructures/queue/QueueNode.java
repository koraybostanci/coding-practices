package com.practicemakesperfect.practice.datastructures.queue;

public class QueueNode<T> {

    private T value;
    private QueueNode<T> next;

    QueueNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
