package com.coding.practices.crackingthecodinginterview.chapter4_treesandgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is
 * a route between two nodes.
 */
public class P01_RouteBetweenNodes2 {

    class Node {
        private final int value;
        private List<Node> adjacents;

        public Node(int value) {
            this.value = value;
            this.adjacents = new ArrayList<>();
        }

        public int getValue() {
            return value;
        }

        public List<Node> getAdjacents() {
            return adjacents;
        }

        public void addAdjacent(Node node) {
            adjacents.add(node);
        }
    }

    class Graph {
        private List<Node> nodes;

        public Graph() {
            this.nodes = new ArrayList<>();
        }

        public List<Node> getNodes() {
            return nodes;
        }

        public void addNode(Node node) {
            this.nodes.add(node);
        }
    }

    boolean hasRoute(final Node start, final Node end) {
        final Queue<Node> queue1 = new PriorityQueue<>();
        final Queue<Node> queue2 = new PriorityQueue<>();

        Set<Node> visited1 = new HashSet<>();
        Set<Node> visited2 = new HashSet<>();

        queue1.add(start);
        queue2.add(end);

        visited1.add(start);
        visited2.add(end);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (hasRoute(queue1, visited1, visited2)) {
                return true;
            }
            if (hasRoute(queue2, visited2, visited1)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasRoute(final Queue<Node> queue, final Set<Node> visited1, final Set<Node> visited2) {
        if (queue.isEmpty()) {
            return false;
        }

        final Node node = queue.remove();
        if (visited2.contains(node)) {
            return true;
        } else {
            if (!visited1.contains(node)) {
                visited1.add(node);
                queue.add(node);
            }
        }

        return false;
    }
}
