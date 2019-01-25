package com.practicemakesperfect.crackingthecodinginterview.chapter2_linkedlists;

import com.practicemakesperfect.practice.datastructures.linkedlist.singly.Node;
import com.practicemakesperfect.practice.datastructures.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * Follow Up :
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class P01_RemoveDups {

    public Node<String> removeDuplicates(Node<String> head) {
        Set<String> uniqueItems = new HashSet<>();

        Node<String> previous = null;
        Node<String> current = head;
        while (current != null) {
            String value = current.getValue();
            if (uniqueItems.contains(value)) {
                previous.setNext(current.getNext());
            } else {
                uniqueItems.add(value);
                previous = current;
            }
            current = current.getNext();
        }
        return head;
    }

    @Test
    public void test() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.push("a");
        linkedList.push("b");
        linkedList.push("b");
        linkedList.push("a");
        linkedList.push("a");
        linkedList.push("c");
        linkedList.push("d");

        Node<String> node = removeDuplicates(linkedList.getHead());
    }
}
