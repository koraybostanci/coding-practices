package com.coding.practices.crackingthecodinginterview.chapter4_treesandgraphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        private Node addRecursive(final Node current, final int value) {
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

        public void add(final int value) {
            root = addRecursive(root, value);
        }

        private void addAll(final int[] values) {
            for (int i = 0; i < values.length; i++) {
                add(values[i]);
            }
        }
    }

    public boolean areEqual(final Node node1, final Node node2) {
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
    void testTrue() {
        final int[] values1 = {6,4,8,3,5,7,9};
        final BinaryTree tree1 = new BinaryTree();
        tree1.addAll(values1);

        final int[] values2 = {6,4,8,3,5,7,9};
        final BinaryTree tree2 = new BinaryTree();
        tree2.addAll(values2);

        assertTrue(areEqual(tree1.root, tree2.root));
    }

    @Test
    void testFalse() {
        final int[] values1 = {6,4,8,3,5,7,9};
        final BinaryTree tree1 = new BinaryTree();
        tree1.addAll(values1);

        final int[] values2 = {6,4,8,3,5,7,10};
        final BinaryTree tree2 = new BinaryTree();
        tree2.addAll(values2);

        assertFalse(areEqual(tree1.root, tree2.root));
    }
}
