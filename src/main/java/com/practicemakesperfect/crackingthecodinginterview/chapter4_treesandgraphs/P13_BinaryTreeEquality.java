package com.practicemakesperfect.crackingthecodinginterview.chapter4_treesandgraphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Write a function that checks if given 2 binary trees are structurally equal and have same values in nodes.
 */
public class P13_BinaryTreeEquality {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    class BinaryTree {
        Node root;

        private Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = addRecursive(current.right, value);
            } else {
                return current;
            }

            return current;
        }

        public void add(int value) {
            root = addRecursive(root, value);
        }

        private void addAll(int[] values) {
            for (int i = 0; i < values.length; i++) {
                add(values[i]);
            }
        }
    }

    public boolean areEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null) {
            return node1.value == node2.value &&
                    areEqual(node1.left, node2.left) &&
                    areEqual(node1.right, node2.right);
        }

        return false;
    }

    @Test
    public void testTrue() {
        int[] values1 = {6,4,8,3,5,7,9};
        BinaryTree tree1 = new BinaryTree();
        tree1.addAll(values1);

        int[] values2 = {6,4,8,3,5,7,9};
        BinaryTree tree2 = new BinaryTree();
        tree2.addAll(values2);

        boolean result = areEqual(tree1.root, tree2.root);
        Assertions.assertTrue(result);
    }

    @Test
    public void testFalse() {
        int[] values1 = {6,4,8,3,5,7,9};
        BinaryTree tree1 = new BinaryTree();
        tree1.addAll(values1);

        int[] values2 = {6,4,8,3,5,7,10};
        BinaryTree tree2 = new BinaryTree();
        tree2.addAll(values2);

        boolean result = areEqual(tree1.root, tree2.root);
        Assertions.assertFalse(result);
    }
}
