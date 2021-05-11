package com.coding.practices.crackingthecodinginterview.chapter2_linkedlists;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * Follow Up :
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class P01_RemoveDups {

    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public Node<String> removeDuplicates(Node<String> head) {
        Set<String> uniqueItems = new HashSet<>();

        Node<String> previous = null;
        Node<String> current = head;
        while (current != null) {
            String value = current.value;
            if (uniqueItems.contains(value)) {
                previous.next = current.next;
            } else {
                uniqueItems.add(value);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    @Test
    void test() {
        List<Node<String>> linkedList = new LinkedList<>();
        linkedList.add(new Node<>("a"));
        linkedList.add(new Node<>("b"));
        linkedList.add(new Node<>("b"));
        linkedList.add(new Node<>("a"));
        linkedList.add(new Node<>("a"));
        linkedList.add(new Node<>("c"));
        linkedList.add(new Node<>("d"));

        Node<String> node = removeDuplicates(linkedList.get(0));
    }
}
