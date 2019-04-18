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

12. **Faster word ladders**. To speed things up (if the word list is very large), don't write a nested loop to try all pairs of words to see if they are adjacent. 

13. Suppose you delete all of the bridges in an undirected graph. Are the connected components of the resulting graph the biconnected components? 
*Answer*. no, two biconnected components can be connected through an articulation point.
**Bridges and articulation points**. A bridge (or cut edge) is an edge whose removal disconnects the graph. An articulation point (or cut vertex) is a vertex whose removal (and removal of all incident edges) disconnects the remaining graph. Bridges and articulations points are important because they represent a single point of failure in a network. Brute force: delete edge (or vertex) and check connectivity. Takes O(E(V+E)) and O(V(V+E)) time, respectively. Can improve both to
O(E+V) using clever extension to DFS.

14. **Biconnected components**. An undirected graph is biconnected if for every pair of vertices v and w, there are two vertex-disjoint paths between v and w. (Or equivalently a simple cycle through any two vertices.) We define a cocyclicity equivalence relation on the edges: two edges e1 and e2 are are in same biconnected component if e1 = e2 or there exists a cycle containing both e1 and e2. Two biconnected components share at most one vertex in common. A vertex is an articulation
    point if and only if it is common to more than one biconnected component. Program Biconnected.java identifies the bridges and articulation points.


15. **Biconnected components**. Modify Biconnected to print out the edges that constitute each biconnected component. 
*Hint*: each bridge is its own biconnected component; to compute the other biconnected components, mark each articulation point as visited, and then run DFS, keeping track of the edges discovered from each DFS start points.

16. Perform numerical experiments on the number of connected components for random undirected graphs. Phase change around 1/2 ln V. (See Property 18.13 in Algs Java).

17. **Rogue**. (Andrew Appel.) A monster and a player are each located at a distinct vertex in an undirected graph. In the role playing game Rogue, the player and the monster alternate turns. In each turn the player can move to an adjacent vertex or stays put. Determine all vertices that the player can reach before the monster. Assume the player gets the first move.

**TODO**:

18. **Rogue**. (Andrew Appel.) A monster and a player are each located at a distinct vertex in an undirected graph. The goal of the monster is to land on the same vertex as the player. Devise an optimal strategy for the monster.

**TODO**:

19. **Articulation point**. Let G be a connected, undirected graph. Consider a DFS tree for G. Prove that vertex v is an articulation point of G if and only if either (i) v is the root of the DFS tree and has more than one child or (ii) v is not the root of the DFS tree and for some child w of v there is no back edge between any descendant of w (include w) and proper ancestor of v. In other words, v is an articulation point if and only if (i) v is the root and has more than
    one child or (ii) v has a child w such that low[w] >= pre[v].

20. **Sierpinski gasket**. Nice example of an Eulerian graph.

21. **Preferential attachment graphs**. Create a random graph on V vertices and E edges as follows: start with V vertices v1, ...,v_n in any order. Pick an element of sequence uniformly at random and add to end of sequence. Repeat 2E times (using growing list of vertices). Pair up the last 2E vertices to form the graph.
Roughly speaking, it's equivalent to adding each edge one-by-one with probability proportional to the product of the degrees of the two endpoints. 

22. **Wiener index**. The Wiener index of a vertex is the sum of the shortest path distances between v and all other vertices. The Wiener index of a graph G is the sum of the shortest path distances over all pairs of vertices. Used by mathematical chemists (vertices = atoms, edges = bonds).

23. **Random walk**. Easy algorithm for getting out of a maze (or st connectivity in a graph): at each step, take a step in a random direction. With complete graph, takes V log V time (coupon collector); for line graph or cycle, takes V^2 time (gambler's ruin). In general the cover time is at most 2E(V-1), a classic result of Aleliunas, Karp, Lipton, Lovasz, and Rackoff.

24. **Deletion order**. Given a connected graph, determine an order to delete the vertices such that each deletion leaves the (remaining) graph connected. Your algorithm should take time proportional to V + E in the worst case.

25. **Center of a tree**. Given a graph that is a tree (connected and acyclic), find a vertex such that its maximum distance from any other vertex is minimized.
Hint: find the diameter of the tree (the longest path between vertices) and return a vertex in the middle.

26. **Diameter of a tree**. Given a graph that is a tree (connected and acyclic), find the longest path, i.e., a pair of vertices v and w that are as far apart as possible. Your algorithm should run in linear time.

*Hint*: Pick any vertex v. Compute the shortest path from v to every other vertex. Let w be the vertex with the largest shortest path distance. Compute the shortest path from w to every other vertex. Let x be the vertex with the largest shortest path distance. The path from w to x gives the diameter.

27. **Bridges with union-find**. Let T be a spanning tree of a connected graph G. Each non-tree edge e in G forms a fundamental cycle consisting of the edge e plus the unique path in the tree joining its endpoings. Show that an edge is a bridge if and only if it is not on some fundamental cycle. Thus, all bridges are edges of the spanning tree. Design an algorithm to find all of the bridges (and bridge components) using E + V time plus E + V union-find operations.

28. **Nonrecursive depth-first search**. Write a program NonrecursiveDFS.java that implements depth-first search with an explicit stack instead of recursion.

Here is an alternate implementation suggested by Bin Jiang in the eaerly 1990s. The only extra memory is for a stack of vertices but that stack must support arbitrary deletion (or at least the movement of an arbitrary item to the top of the stack).
```
private void dfs(Graph G, int s) {
    SuperStack<Integer> stack = new SuperStack<Integer>();
    stack.push(s);
    while (!stack.isEmpty()) {
        int v = stack.peek();
        if (!marked[v]){
            marked[v] = true;
            for (int w : G.adj(v)) {
            if (!marked[w]) {
                if (stack.contains(w)) stack.delete(w);
                stack.push(w);
            }
            }
        }
        else {
        // v's adjacency list is exhausted
            stack.pop();
        }
    }
}
```

Here is yet another implementation. It is, perhaps, the simplest nonrecursive implementation, but it uses space proportional to E + V in the worst case (because more than one copy of a vertex can be on the stack) and it explores the vertices adjacent to v in the reverse order of the standard recursive DFS. Also, an edgeTo[v] entry may be updated more than once, so it may not be suitable for backtracking applications.

```
private void dfs(Graph G, int s) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(s);
    while(!stack.isEmpty()) {
        int v = stack.pop();
        if (!marked[v]) {
            marked[v] = true;
            for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                stack.push(w);
            }
            }
        }
    }
}
```

29. **Nonrecursive depth-first search**. Explain why the following nonrecursive method (analogous to BFS but using a stack instead of a queue) does not implement depth-first search.

```
private void dfs(Graph G, int s) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(s);
    marked[s] = true;
    while (!stack.isEmpty()) {
        int v = stack.pop();
        for (int w : G.adj(v)) {
        if (!marked[w]) {
            stack.push(w);
            marked[w] = true;
            edgeTo[w] = v;
        }
        }
    }
}
```
*Solution*: Consider the graph consisting of the edges 0-1,0-2,1-2, and 2-1, with vertex 0 as the source.

30. **Matlab connected components**. bwlabel() or bwlabeln() in Matlab label the connected components in a 2D or kD binary image. bwconncomp() is newer version.

31. **Shortest path in complement graph**. Given a graph G, design an algorithm to find the shortest path (number of edges) between s and every other vertex in the complement graph G'. The complement graph contains the same vertices as G but includes an edge v-w if and only if the edge v-w is not in G. Can you do any better than explicitly computing the complement graph G' and running BFS in G'?

32. **Delete a vertex without disconnecting a graph**. Given a connected graph, design a linear-time algorithm to find a vertex whose removal (deleting the vertex and all incident edges) does not disconnect the graph.

*Hint 1(using DFS)*: run DFS from some vertex s and consider the first vertex in DFS that finishes.
*Hint 2(using BFS)*: run BFS from some vertex s and consider any vertex with the highest distance.

33. **Spanning tree**. Design an algorithm that computes a spanning tree of a connected graph is time proportional to V + E. 
*Hint*: use either BFS or DFS.

34. **All paths in a graph**. Write a program AllPaths.java that enumerates all simple paths in a graph between two specified vertices. 
*Hint*: use BFS and backtracking. Warning: there many be exponentially many simple paths in a graph, so no algorithm can run efficiently for large graphs.


















