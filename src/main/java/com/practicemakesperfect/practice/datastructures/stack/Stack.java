package com.practicemakesperfect.practice.datastructures.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private StackNode<T> top;

    public void push(T value) {
        StackNode<T> item = new StackNode(value);
        item.setNext(top);
        top = item;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T value = top.getValue();
        top = top.getNext();
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
