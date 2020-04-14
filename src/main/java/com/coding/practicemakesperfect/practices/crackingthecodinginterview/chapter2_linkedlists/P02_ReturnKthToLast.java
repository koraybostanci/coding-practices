package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter2_linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class P02_ReturnKthToLast {

    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     *  Solution-1 : push all items to a stack and start to pop until you have the kth item.
     *  In this solution we need a new data model (stack)
     *
     *  Solution-2 : use an iterative approach. Define 2 pointers p1 and p2. Let p1 start and go for k steps.
     *  When p1 reaches kth element, p1 and p2 goes same pace until p1 reaches at the end.
     *  p2 will be the result.
     */
    public Node<String> findNodeAt(Node<String> head, int k) {
        if (head == null) {
            return null;
        }

        Node<String> p1 = head;
        Node<String> p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    @Test
    public void testKth() {
        Node<String> head = buildLinkedList(10);

        Node<String> node = findNodeAt(head, 3);
        assertEquals("8",node.value);
    }

    @Test
    public void testNull() {
        Node<String> head = buildLinkedList(5);

        Node<String> node = findNodeAt(head, 6);
        assertNull(node);
    }

    private Node<String> buildLinkedList(int count) {
        Node<String> head = new Node<>("1");
        Node<String> current = head;
        for (int i = 2; i <= count; i++) {
            Node<String> node = new Node<>(String.valueOf(i));
            current.next = node;
            current = node;
        }
        return head;
    }

}
