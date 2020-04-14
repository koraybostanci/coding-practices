package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter2_linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked list, given only
 * access to that node.
 *
 * You are not given access to the head of the linked list. You only have access to that node.
 */
public class P03_DeleteMiddleNode {

    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean deleteNode(Node<Integer> node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node<Integer> next = node.next;
        node.next = next.next;
        node.value = next.value;
        return true;
    }

    @Test
    public void test() {
        // LinkedList : 1->2->3->4->5->6->7->8->9->10
        Node<Integer> head = buildLinkedList(10);

        //  Value=3
        Node<Integer> node = head.next.next;
        boolean success = deleteNode(node);

        Assertions.assertTrue(success);
        Assertions.assertEquals(4, (int)head.next.next.value);
    }

    private Node<Integer> buildLinkedList(int count) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> current = head;
        for (int i = 2; i <= count; i++) {
            Node<Integer> node = new Node<>(i);
            current.next = node;
            current = node;
        }
        return head;
    }
}
