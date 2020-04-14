# __LinkedLists__

* is a data structure that represents a sequence of nodes.
* in a singly linked list, each node points to the next node in the linked list.
* in a doubly linked list, each node both points to the next and previous nodes in the linked list.
* does not provide constant time to access a particular index. you need to iterate over the list to find the nth element.
* you can add/remove items from the beginning of the list in a constant time.

```java
class Node {
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
    }

    void appendToHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
        }
    }

    void appendToTail(int value) {
        Node newNode = new Node(value);

        Node node = head;
        while(hasNext(node)) {
            node = node.next;
        }

        node.next = newNode;
    }

    boolean hasNext(Node node) {
        return node.next != null;
    }
}
```