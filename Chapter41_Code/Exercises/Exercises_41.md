#EXERCISES

##Book Exercises

4.1.1 What is the maximum number of edges in a graph with V vertices and no parallel edges? What is the minimum number of edges in a graph with V vertices, none of which are isolated?

*Answer*: the maximum number of edges: V*(V-1)/2
the minimum number of edges: V - 1

4.1.2 Draw, in the style of the figure in the text(page 524), the adjacency lists built by Graph's input stream constructor for the file tinyGex2.txt depicted at left.

4.1.3 Create a copy constructor for Graph.java that takes as input a graph G and creates and initializes a new copy of the graph. Any changes a client takes to G should not affect the newly created graph.

4.1.4 Add a method hasEdge() to Graph which takes two int arguments v and w returns true if the graph has an edge v-w, false otherwise.

4.1.5 Modify Graph to disallow parallel edges and self-loops.

4.1.6 Consider the four-vertex graph with edges 0-1, 1-2,2-3, and 3-0. Draw an array of adjacency-lists that could not have been built calling addEdge() for these edges no matter what order.

4.1.7 Develop a test client for Graph that reads a graph from the input stream named as command-line argument and then prints it, replying on toString().


4.1.8 Develop an implementation for the Search API on page 528 that uses UF, as described in the text.

4.1.9 Show, in the style of the figure on page 533, a detailed trace of the call dfs(0) for the graph built by Graph's input stream constructor for the file tinyGex2.txt (see ExERCISE 4.1.2). Also, draw the tree represented by edgeTo[].


4.1.10 Prove that every connected graph has a vertex whose removal (including all adjacent edges) will not disconnect the graph, and write a DFS method that finds such a vertex. Hint: Consider a vertex whose adjacent vertices are all marked.

4.1.11 Draw the tree represented by edgeTo[] after the call bfs(G,0) in ALGORITHM 4.2 for the graph built by Graph's input stream constructor for the file tinyGex2.txt (see EXERCISE 4.1.2).

4.1.12 What does the BFS tree tell us about the distance from v to w when neither is at the root?

*Answer*: Yes.

4.1.13 Add a distTo() method to BreadthFirstPaths.java, which returns the number of edges on the shortest path from the source to a given vertex. A distTo() query should run in constant time.









