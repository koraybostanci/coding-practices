package com.coding.fundamental.datastructures.linkedlist.singly;


public class SinglyLinkedList<T> {

    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;

    public void push(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public void remove(T value) {
        Node node = head;

        if (node == null) {
            return;
        }

        if (node.value == value) {
            head = node.next;
            return;
        }

        Node next = null;
        while (node != null) {
            next = node.next;

            if (next == null) {
                return;
            }

            if (next.value == value) {
                break;
            }
            node = next;
        }

        node.next = next.next;
        next.next = null;
    }

    public Node getHead() {
        return head;
    }

}
