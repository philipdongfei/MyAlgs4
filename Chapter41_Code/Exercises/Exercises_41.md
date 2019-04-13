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

4.1.14 Suppose you use a stack instead of a queue when running breath-first search. Does it still compute shourtest paths?

*Answer*: No. BFS_Stack.java

4.1.15 Modify the input stream constructor for Graph to also allow adjacency lists from standard input (in a manner similar to SymbolGraph), as in the example tinyGadj.txt shown at right. After the number of vertices and edges, each line contains a vertex and its list of adjacent vertices.

4.1.16 The *eccentricity* of a vertex v is the the length of the shortest path from that vertex to the furthest vertex from v. The *diameter* of a graph is the maximum eccentricity of any vertex. The radius of a graph is the smallest eccentricity of any vertex. A center is a vertex whose eccentricity is the radius. Implement the following API:
public class GraphProperties
GraphProperties(Graph G);
int eccentricity(int v);
int diameter();
int radius();
int center();

4.1.17 The *girth* of a graph is the length of its shortest cycle. If a graph is acyclic, then its girth is infinite. Add a method girth() to GraphProperties that returns the girth of the graph. *Hint*: Run BFS from each vertex. The shortest cycle containing s is a shortest path from s to some vertex v, plus the edge from v back to s.

4.1.18 Show, in the style of the figure on page 545, a detailed trace of CC for finding the connected components in the graph built by Graph's input stream constructor for the file tinyGex2.txt (see EXERCISE 4.1.2).

4.1.19 Show, in the style of the figures in this section, a detailed trace of Cycle for finding a cycle in the graph built by Graph's input stream constructor for the file tinyGex2.txt (see EXERCISE 4.1.2). What is the order of growth of the running time of the Cycle constructor, in the worst case?

*Answer*: worst case: O(V+E)

4.1.20 Show, in the style of the figures in this section, a detailed trace of TwoColor for finding a two-coloring of the graph built by Graph's input stream constructor for the file tinyGex2.txt. What is the order of growth of the running time of the TwoColor constructor, in the worst case?

*Answer*: worst case: O(V+E)

4.1.21 Run SymbolGraph with movies.txt to find the Kevin Bacon number of this year's Oscar nominees.

4.1.22 Write a program BaconHistogram that prints a histogram of Kevin Bacon numbers, indicating how many performers from movies.txt have a Bacon number of 0,1,2,3,... Include a category for those who have an infinite number (not connected to Kevin Bacon).

4.1.23 Compute the number of connected components in movies.txt, the size of the largest component, and the number of components of size less than 10. Find the eccentricity, diameter, radius, a center, and the girth of the largest component in the graph. Does it contain Kevin Bacon?

4.1.24 Modify DegreeOfSeparation to take an int value y as a command-line argument and ignore movies that are more than y years old.

4.1.25 Write a SymbolGraph client DegreesOfSeparationDFS.java that uses depth-first instead of breadth-first search to find paths connecting two performers.

4.1.26 Determine the amount of memory used by Graph to represent a graph with v ertices and E edges, using the memory-cost model of Section 1.4.

*Solution*. 56+40V+128E. MemoryOfGraph.java computes it empirically assuming that no Integer values are cached--Java typically caches the integers -128 to 127.

4.1.27 Two graphs are *isomorphic* if there is a way to rename the vertices of one to make it identical to the other. Draw all the nonisomorphic graphs with two,three,four, and five vertices.

4.1.28 Modify Cycle so that it works even if the graph contains self-loops and parallel edges.

4.1.29 *Eulerian and Hamiltonian cycles*. Consider the graphs defined by the following four sets of edges:

which of these graphs have Euler cycles (cycles that visit each edge exactly once)?
which of them have Hamilton cycle (cycles that visit each vertex exactly once)?

4.1.30 *Graph enumeration*. How many different undirected graphs are there with V vertices and E edges (and no parallel edges)?

4.1.31 *Parallel edge detection*. Devise a linear-time algorithm to count the parallel edges in a graph.

Hint: maintain a boolean array of the neighbors of a vertex, and reuse this array by only reinitializing the entries as needed.

4.1.32 *Odd cycles*. Prove that a graph is two-colorable (bipartite) if and only if it contains no odd-length cycle.

4.1.33 *Symbol graph*. Implement a one-pass SymbolGraph (it need not be a Graph client). Your implementation may pay an extra log V factor for graph operations, for symbol-table lookups.

4.1.34 *Biconnectedness*. A graph is *biconnected* if every pair of vertices is connected by two disjoint paths. An *articulation point* in a connected graph is a vertex that would disconnect the graph if it (and its adjacent edges) were removed. Prove that any graph with no articulation points is biconnected. Hint: Given a pair of vertices s and t and a path connecting them, use the fact that none of the vertices on the path are articulation points to construct two disjoint
paths connecting s and t.

4.1.35 *Edge connectivity*. A *bridge* in a graph is an edge that, if removed, would separate a connected graph into two disjoint subgraphs. A graph that has no bridges is said to be edge connected. Develop a DFS-based data type for determing whether a given graph is edge connected.

4.1.36 *Euclidean graphs*. Design and implement an API EuclideanGraph for graphs whose vertices are points in the plane that include coordinates. Include a method show() that uses StdDraw to draw the graph.

4.1.37 *Image processing*. Implement the flood fill operation on the implicit graph defined by connecting adjacent points that have the same color in an image.


##Web Exercises

1. Find some interesting graphs. Are they directed or undirected? Sparse or dense?


















