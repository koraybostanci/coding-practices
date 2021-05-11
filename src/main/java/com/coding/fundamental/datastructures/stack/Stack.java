package com.coding.fundamental.datastructures.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    public class StackNode<T> {
        private T value;
        private StackNode<T> next;

        StackNode(T value) {
            this.value = value;
        }
    }

    private StackNode<T> top;

    public void push(T value) {
        StackNode<T> item = new StackNode(value);
        item.next = top;
        top = item;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T value = top.value;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
