package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter4_treesandgraphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class P05_ValidateBST {

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
    }

    boolean isBinarySearchTree(Node node) {
        return isBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value < min || node.value > max) {
            return false;
        }

        return isBinarySearchTree(node.left, min, node.value-1) &&
                isBinarySearchTree(node.right, node.value+1, max);
    }

    @Test
    public void testTrue() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        boolean result = isBinarySearchTree(tree.root);
        assertTrue(result);
    }

    @Test
    public void testFalse() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(6);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        boolean result = isBinarySearchTree(tree.root);
        assertFalse(result);
    }

}
