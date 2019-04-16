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

2. **Degree**. The degree of a vertex is the number of incident edges. Add a method int degree(int v) to Graph that returns the degree of the vertex v.

3. Suppose you use a stack instead of a queue when running breadth-first search. Does it staill compute shortest paths?

*Answer*: No.

4. **DFS with an explicit stack**. Given an example of possibility of stack overflow with DFS using the function call statck, e.g., line graph. Modify DepthFirstPaths.java so that it uses an explicit stack instead of the function call stack.

5. **Perfect maze**. Generate a perfect maze like this one
Write a prgram Maze.java that takes a command-line argument n, and generates a random n-by-n perfect maze. A maze is perfect if it has exactly one path between every pair of points in the maze. i.e., no inaccessible locations, no cycles, and no open spaces. Here's a nice algorithm to generate such mazes. Consider an n-by-n grid of cells, each of which initially has a wall between it and its four neighboring cells. For each cell(x,y), maintain a variable
north[x][y] that is true if there is wall separating (x, y) and (x, y+1). We have analogous variables east[x][y], south[x][y], and west[x][y] for the corresponding walls. Note that if there is a wall to the north of (x,y) then north[x][y] = south[x][y+1] = true. Construct the maze by knocking down some of the walls as follows:
a. Start at the lower level cell(1,1).
b. Find a neighbor at random that you haven't yet been to.
c. If you find one, move there, knocking down the wall. If you don't find one, go back to the previous cell.
d. Repeat steps ii. and iii. until you've been to every cell in the grid.

*Hint*: maintain an (n+2)-by-(n-2) grid of cells to avoid tedious special cases.

Here is a Mincecraft maze created by Carl Eklof using this algorithm.

6. **Getting out of the maze**. Given an n-by-n maze (like the one created in the previous exercise), write a program to find a path from the start cell(1,1) to the finish cell(n,n), if it exists. To find a solution to the maze, run the following algorithm, staring from (1,1) and stopping if we reach cell(n,n).

```
explore(x,y)
-------------
- Mark the current cell(x,y) as "visited."
- If no wall to north and unvisited, then explore(x, y+1).
- If no wall to east and unvisited, then explore(x+1, y).
- If no wall to south and unvisited, then explore(x, y-1).
- If no wall to west and unvisited, then explore(x-1, y).

```

7. **Maze game**. Develop a maze game like this one from gamesolo.com, where you traverse a maze, collecting prizes.

8. **Actor graph**. An alternate (and perhaps more natural) way to compute Kevin Bacon numbers is to build a graph where each node is an actor. Two actors are connected by an edge if they appear in a movie together. Calculate Kevin Bacon numbers by running BFS on the actor graph. Compare the running time versus the algorithm described in the text. Explain why the approach in the text is preferable. 
*Answer*. it avoids multiple parallel edges. As a result, it's faster and uses less memory. Moreover, it's more convenient since you don't have to label the edges with the movie names - all names get stored in the vertices.

9. **Center of the Hollywood universe**. We can measure how good of a center that Kevin Bacon is by computing their Hollywood number. The Hollywood number of Kevin Bacon is the average Bacon number of all the actors. The Hollywood number of another actor is computed the same way, but we make them be the source instead of Kevin Bacon. Compute Kevin Bacon's Hollywood number and find an actor and actress with better Hollywood numbers.

10. **Fringe of the Hollywood universe**. Find the actor (who is connected to Kevin Bacon) that has the highest Hollywood number.

11. **Word ladders**. Write a program WordLadder.java that takes two 5 letter string from the command line, and reads in a list of 5 letter words from standard input, and  prints out a shortest word ladder connecting the two strings (if it exists). Two words can be connected in a word ladder chain if they differ in exactly one letter. As an example, the following word ladder connects green and brown.
```
green greet great groat grown brown
```
You can also try out your program on this list of 6 letter words.
























