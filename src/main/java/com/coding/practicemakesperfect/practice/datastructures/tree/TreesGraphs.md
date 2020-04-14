# Tree

* A tree is a data structure composed of nodes.
* Each tree has a root node.
* The root has zero or more child nodes.
* Each child has zero or more child nodes.
* The tree can not contain cycles.
* The nodes may or may not be in a particular order, they may have any data type as values.
* A node is called *leaf node* if it has no children.

```java
class Node {
  int value;
  Node[] childrens;
}

class Tree {
    Node root;
}
```

## Binary Tree

* A binary tree is a tree in which each node has up to 2 child nodes.

## Binary Search Tree

* A binary search tree is a tree which imposes the condition that; for each node, it's left descendants are less than or equal to the current node which is less than the right descendants.

```
all-left-descendants <= n < all-right-descendants
```
* In some definitions, the binary search tree can not have duplicate values. But in others, the values can be on right or on either side. All are valid but need to be clarified.

## Balanced vs Unbalanced

* Two common type of balanced trees are Red-Black trees and AVL trees.

## Complete Binary Tree

* A complete binary tree is a tree in which every level of the tree is fully filled, except for the last level.

## Full Binary Tree

* A full binary tree is a tree in which every node has either zero or two nodes. There should be no node that has one child.

## Perfect Binary Tree

* A perfect binary tree is a tree which is both full and complete. All leaf nodes should be at the same level and fully filled.

## Min-Heap

* A __min-heap__ is a _complete binary tree_ where value of each node is less than its children. Therefore, the root is the node that has the minimum value.
* A _complete binary tree_ is a binary tree in which fully filled other than the rightest most element on the last level.)
* It has two key operations;
  * __insert :__ _(Bubble-up from bottom-most & right-most)_
    * Start by inserting the element at the bottom.
    * Insert this element to the rightmost node to maintain the complete binary tree property of the heap
    * Swap the element with its parent until you have the right order. 
    * This means we essentially bubble up the minimum element.
    * This takes O(N) time which n is the number of nodes.
  * __extract_min :__ _(Bubble-down to right-most until min-heap property is restored)_
    * Finding the minimum element is easy since it's in the top.
    * Remove the root element and swap it with the bottommost & rightmost element.
    * Bubble down this element from top to it's right child until the min-heap property is restored.
    * Takes O(N) time
    
## Prefix Tree (Trie)
 
* A trie is a variant of n-ary tree in which characters are store at each node.
* The "*" or null nodes indicates a complete word.
 
## Graph
 
* A tree is a type of graph but not all graphs are trees. Basically, a tree is a connected graph which without cycles.
* A graph is a collection of nodes with edges between some of them. 
* Graphs can either be directed of undirected. Directed edges are like a one-way street and undirected edges are like a two-way street.
* Graphs can have cycles.
  
### Graph Representation
 
There are two ways to represent a graph;
 
#### Adjacency List
 
* This is the most common way of representing a graph.
 
```java
 class Node {
    int value;
    Node[] adjacents;
 }
 
 class Graph {
    Node[] nodes;
 }
 ```
* Actually, we do not necessarily need any additional classes to represent a _Graph_. An Array or HashMap can be used to store list of nodes.
 
#### Adjacency Matrices
 
* An adjacency matrix is a NxN matrix where a true or one in matrix[i][j] indicates that an edge from node i to node j exists.
 
### Graph Search

There are 2 most common ways to search on a graph ;

#### Depth-First Search (DFS) (Recursion)

* Start from the root and go deep first and explore each branch completely before moving to the other branch. 
* We go deep first before going wide.
* DFS is most commonly used if we need to visit every node in the graph since it's a bit simpler.
* Pre-order or other forms of tree traversal are a from of DFS. But the difference is we need to check if the node is visited or not because graphs may have cycles otherwise we can stuck into an infinite loop. 

```java
class DFS {
  void search(Node node) {
    if (node == null) {
      return;
    }
    visit(Node);
    node.visited = true;
    
    for(Node n : node.getAdjacents()) {
      if (!n.visited) {
        search(n);
      }
    } 
  }
}
```

 
#### Breadth-First Search (BFS) (Uses Queue)

* Start from the root and explore each neighbour before going on to the any other children. 
* We go wide before going deep.
* If we want to find the shortest path between two nodes, BFS is generally better. 
* Common uses ;
  * Shortest path problems
  * Finding a friendship between 2 people in a friendship graph (we do not want to go too much distant from the source)
  
```java
class BFS {
  void search(Node root) {
    Queue queue = new Queue();
    root.marked = true;
    queue.add(root);
    
    while(!queue.isEmpty()) {
        Node node = queue.remove();
        visit(node);
        for(Node n : node.getAdjacents()) {
            if (!n.marked) {
              n.marked = true;
              queue.add(n);
            }
        }
    }
  }
}
```

#### Bidirectional Breadth-First Search (BBFS) (Uses Two Queues)

```java
class BBFS {
    boolean hasConnection(Node node1, Node node2) {
        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        
        Set<Node> visited1 = new HashSet();
        Set<Node> visited2 = new HashSet();
        
        queue1.add(node1);
        queue2.add(node2);
        
        visited1.add(node1);
        visited2.add(node2);
        
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (hasPath(queue1, visited1, visited2)) {
                return true;
            }
            if (hasPath(queue2, visited2, visited1)) {
                return true;
            }
        }
        return false;
    }
    
    boolean hasPath(Queue queue, Set visited1, Set visited2) {
        
        if (queue.isEmpty) {
            return false;
        }
        
        Node node = queue.remove();
        for(Node n : node.getAdjacents()) {
            if (visited2.contains(n)) {
                return true;
            } else {
                if (!visited1.contains(node)) {
                    visited1.add(node);
                    queue.add(node);
                }
            }
        }
        
        return false;
    }
}
```


