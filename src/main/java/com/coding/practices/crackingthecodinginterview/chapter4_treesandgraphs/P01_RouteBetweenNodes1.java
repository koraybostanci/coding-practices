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
public class P01_RouteBetweenNodes1 {

    class Node {
        private final int value;
        private List<Node> adjacentList;

        public Node(int value) {
            this.value = value;
            this.adjacentList = new ArrayList<>();
        }

        public int getValue() {
            return value;
        }

        public List<Node> getAdjacentList() {
            return adjacentList;
        }

        public void addAdjacent(Node node) {
            adjacentList.add(node);
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

        final Set<Node> visited = new HashSet<>();
        final Queue<Node> queue = new PriorityQueue<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                for (Node n : node.getAdjacentList()) {
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
