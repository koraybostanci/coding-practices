package com.coding.fundamental.datastructures.tree.binary;

public class BinaryTreeTraverser {

    public void traverseInOrder(BinaryTree.BinaryTreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            visit(node);
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(BinaryTree.BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(BinaryTree.BinaryTreeNode node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            visit(node);
        }
    }

    private void visit(BinaryTree.BinaryTreeNode node) {
        System.out.println("Value= " + node.getValue());
    }

}
