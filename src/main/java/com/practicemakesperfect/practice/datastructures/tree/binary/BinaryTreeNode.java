package com.practicemakesperfect.practice.datastructures.tree.binary;

public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }
}
