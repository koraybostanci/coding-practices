package com.coding.fundamental.datastructures.linkedlist.doubly;

public class DoublyLinkedList<T> {

    public class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
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
                node = node.next;
            }
            node.next = newNode;
        }
    }
}
