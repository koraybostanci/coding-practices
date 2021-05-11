# __Graphs__

* A tree is actually a type of graph, but not all graphs are trees. Simply put, a tree is a connected graph without cycles.

* A graph is simply a collection of nodes with edges between (_some of_) them.

* Graphs can be either _**directed**_ (_like the following graph_) or _**undirected**_. While directed edges are like a one-way street, undirected edges are like a two-way street.

In terms of programming, there are two common ways to represent a graph.

_**Adjacency List**_

You don't necessarily need any additional classes to represent a graph. An array (_or a hash table_) of lists (_arrays, arraylists, linked lists, etc._) can store the _**adjacency list**_. The graph above could be represented as:

0: 1
1: 2
2: 0, 3
3: 2
4: 6
5: 4
6: 5

This is a bit more compact, but it isn't quite as clean. We tend to use node classes unless there's a compelling reason not to.

_**Adjacency Matrices**_

An adjacency matrix is an NxN boolean matrix (_where N is the number of nodes_), where a true value at matrix [i][j] indicates an edge from node i to node j. (_You can also use an integer matrix with 0s and 1s._)
In an undirected graph, an adjacency matrix will be symmetric. In a directed graph, it will not (_necessarily_) be.

***Graph Search***

The two most common ways to search a graph are depth-first search and breadth-first search.

**DFS :** We start at the root (_or another arbitrarily selected node_) and explore each branch completely before moving on to the next branch. That is, we go deep first (_hence the name depth-first search_) before we go wide.

In DFS, we visit a node a and then iterate through each of a's neighbors. When visiting a node b that is a neighbor of a, we visit all of b's neighbors before going on to a's other neighbors. That is, a exhaustively searches b's branch before any of its other neighbors.

Note that pre-order and other forms of tree traversal are a form of DFS. The key difference is that when implementing this algorithm for a graph, we must check if the node has been visited. If we don't, we risk getting stuck in an infinite loop.

**BFS :** We start at the root (_or another arbitrarily selected node_) and explore each neighbor before going on to any of their children. That is, we go wide (_hence breadth-first search_) before we go deep.