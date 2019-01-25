package com.practicemakesperfect.practice.datastructures.stack;

public class StackNode<T> {

    private T value;
    private StackNode<T> next;

    StackNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
