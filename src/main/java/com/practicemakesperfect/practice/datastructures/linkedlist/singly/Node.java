package com.practicemakesperfect.practice.datastructures.linkedlist.singly;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

}
