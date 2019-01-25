package com.practicemakesperfect.crackingthecodinginterview.chapter2_linkedlists;

import com.practicemakesperfect.practice.datastructures.linkedlist.singly.Node;
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

    public boolean deleteNode(Node<Integer> node) {
        if (node == null || node.getNext() == null) {
            return false;
        }

        Node<Integer> next = node.getNext();
        node.setNext(next.getNext());
        node.setValue(next.getValue());
        return true;
    }

    @Test
    public void test() {
        // LinkedList : 1->2->3->4->5->6->7->8->9->10
        Node<Integer> head = buildLinkedList(10);

        //  Value=3
        Node<Integer> node = head.getNext().getNext();
        boolean success = deleteNode(node);

        Assertions.assertTrue(success);
        Assertions.assertEquals(4, head.getNext().getNext().getValue());
    }

    private Node<Integer> buildLinkedList(int count) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> current = head;
        for (int i = 2; i <= count; i++) {
            Node<Integer> node = new Node<>(i);
            current.setNext(node);
            current = node;
        }
        return head;
    }
}
