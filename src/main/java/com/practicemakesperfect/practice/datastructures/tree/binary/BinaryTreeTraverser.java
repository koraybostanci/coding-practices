package com.practicemakesperfect.practice.datastructures.tree.binary;

public class BinaryTreeTraverser {

    public void traverseInOrder(BinaryTreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            visit(node);
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(BinaryTreeNode node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            visit(node);
        }
    }

    private void visit(BinaryTreeNode node) {
        System.out.println("Value= " + node.getValue());
    }

}
