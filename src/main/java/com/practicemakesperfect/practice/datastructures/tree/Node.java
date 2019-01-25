package com.practicemakesperfect.practice.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public T value;
    public List<Node> children;

    public Node(T value) {
        this.value = value;
        this.children = new ArrayList();
    }

    public T getValue() {
        return this.value;
    }

    public List<Node> getChildren() {
        return this.children;
    }

}
