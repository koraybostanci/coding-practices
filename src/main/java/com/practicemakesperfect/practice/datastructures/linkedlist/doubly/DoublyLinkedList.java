package com.practicemakesperfect.practice.datastructures.linkedlist.doubly;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }
}
