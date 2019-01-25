package com.practicemakesperfect.practice.datastructures.linkedlist.singly;


public class SinglyLinkedList<T> {

    private Node<T> head;

    public void push(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    public void remove(T value) {
        Node node = head;

        if (node == null) {
            return;
        }

        if (node.getValue() == value) {
            head = node.getNext();
            return;
        }

        Node next = null;
        while (node != null) {
            next = node.getNext();

            if (next == null) {
                return;
            }

            if (next.getValue() == value) {
                break;
            }
            node = next;
        }

        node.setNext(next.getNext());
        next.setNext(null);
    }

    public Node getHead() {
        return head;
    }

}
