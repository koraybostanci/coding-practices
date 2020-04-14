package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter4_treesandgraphs;

import java.util.*;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is
 * a route between two nodes.
 */
public class P01_RouteBetweenNodes1 {

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

    boolean hasRoute(Node start, Node end) {
        if (start == end) {
            return true;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                for (Node n : node.getAdjacents()) {
                    if (!visited.contains(n)) {
                        if (n == end) {
                            return true;
                        }
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }

        return false;
    }
}
