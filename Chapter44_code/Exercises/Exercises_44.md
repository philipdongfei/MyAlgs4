#EXERCISES

## Book Exercises

4.4.1 True or false: Adding a constant to every edge weight does not change the solution to the single-source shortest-paths problem.

*Solution*: false. x->y->z: 1 + 1 = 2, x->z: 3, shortest path: x->y->z 
add a constant 2, x->y->z: (1+2) + (1+2) = 6, x->z: 3+2 = 5. shortest path: x->z.

4.4.2 Provide an implementation of toString() for EdgeWeightedDigraph.

4.4.3 Develop an implementation of EdgeWeightedDigraph for dense graphs that uses an adjacency-matrix (two-dimensional array of weights) representation (see EXERCISE 4.3.9). Ignore parallel edges.

4.4.4 Draw the SPT for source 0 of the edge-weighted digraph obtained by deleting vertex 7 from tinyEWD.txt(see page 644), and give the parent-link representation of the SPT. Answer the question for the same graph with all edge reversed.

4.4.5 Change the direction of edge 0->2 in tinyEWD.txt(see page 644). Draw two different SPTs that are rooted at 2 for this modified edge-weighted digraph.

4.4.6 Give a trace that shows the process of computing the SPT of the digraph defined in EXERCISE 4.4.5 with the eager version of Dijkstra's algorithm.

*Solution*.
0 2->0 0.26 0.26
1 5->1 0.32 0.94
2           0
3 7->3 0.39 0.73
4 0->4 0.38 0.64
5 7->5 0.28 0.62
6 3->6 0.52 1.25
7 2->7 0.34 0.34

4.4.7 Develop a version of DijkstraSP that supports a client method that returns a *second* shortest path from s to t in an edge-weighted digraph (and returns null if there is only one shortest path from s to t).

4.4.8 The diameter of a digraph is the length of the maximum-length shortest path connecting two vertices. Write a DijkstraSP client that finds the diameter of a given EdgeWeightedDigraph that has nonnegative weights.

4.4.9 The table below, from an old published road map, purports to give the length of the shortest routes connecting the cities. It contains an error. Correct the table. Also, add a table that shows how to achieve the shortest routes.

*Solution*. error: Westerly->Norwich: Westerly->New London->Norwich:18+12 < 101
Norwich->Westerly: Norwich->New London->Westerly: 18+12 < 101

4.4.10 Consider the edges in the digraph defined in EXERCISE 4.4.4 to be undirected edges such that each corresponds to equal-weight edges in both directions in the edge-weighted digraph. Answer EXERCISE 4.4.6 for this corresponding edge-weighted digraph.

4.4.11 Use the memory-cost model of SECTION 1.4 to determine the amount of memory used by EdgeWeightedDigraph to represent a graph with V vertices and E edges.

*Solution*. 56+40V+72E. 

4.4.12 Adapt the DirectedCycle and Topological classes from Section 4.2 to use the EdgeWeightedDigraph and DirectedEdge APIs of this section, thus implementing EdgeWeightedCycleFinder.java and EdgeWeightedTopological.java.


4.4.13 Show, in the style of the trace in the text, the process of computing the SPT with Dijkstra's algorithm for the digraph obtained by removing the edge 5->7 from tinyEWD.txt.

4.4.14 Show the paths that would be discovered by the two strawman approaches described on page 668 for the example tinyEWDn.txt shown on that page.


4.4.15 What happens to Bellman-Ford if there is a negative cycle on the path from s to v and then you call pathTo(v)?

*Solution*.If there is no check to stop the algorithm once a negative cycle is found it would never terminate because it would reach an infinite loop where the negative cycle is located.
It would continuously enqueue and dequeue the vertices that are part of the negative cycle.

4.4.16 Suppose that we convert an EdgeWeightedGraph into an EdgeWeightedDigraph by creating two DirectedEdge objects in the EdgeWeightedDigraph (one in each direction) for each Edge in the EdgeWeightedGraph and then use the Bellman-Ford algorithm. Explain why this approach fails spectacularly.

*Solution*: This can introduce negative cost cycles even if the edge-weighted graph does not contain them.

4.4.17 What happens if you allow a vertex to be enqueued more than once in the same pass in the Bellman-Ford algorithm?

*Answer*. The running time of the algorithm can go exponential. For example, consider what happens for the complete edge-weighted digraph whose edge weights are all -1.

4.4.18 Write a CPM client that prints all critical paths.

4.4.19 Find the lowest-weight cycle (best arbitrage opportunity) in the example shown in the text.

4.4.20 Find a currency-conversion table online or in a newspaper. Use it to build an arbitrage table. Note: Avoid tables that are derived (calculated) from a few values and that therefore do not give sufficiently accurate conversion information to be interesting. *Extra credit*: Make a killing in the money-exchange market!

4.4.21 Show, in the style of the trace in the text, the process of computing the SPT with the Bellman-Ford algorithm for the edge-weighted digraph of EXERCISE 4.4.5.

4.4.22 *Vertex weights*. Show that shortest-paths computations in edge-weighted digraphs with nonnegative weights on vertices (where the weight of a path is defined to be the sum of the weights of the vertices) can be handled by building an edge-weighted digraph that has weights on only the edges.

4.4.23 *Source-sink shortest paths*. Develop an API and implementation that use a version of Dijkstra's algorithm to solve the *source-sink* shortest path problem on edgeweighted digraphs.

4.4.24 *Multisource shortest paths*. Develop an API and implementation that uses Dijkstra's algorithm to solve the *multisource* shortest-paths problem on edge-weighted digraphs with positive edge weights: given a set of sources, find a shortest-paths forest that enables implementation of a method that returns to clients the shortest path from any source to each vertex. Hint: Add a dummy vertex with a zero-weight edge to each source, or initialize the priority queue with all sources,
with their distTo[] entries set to 0.


4.4.25 *Shortest path between two subsets*. Given a digraph with positive edge weights, and two distinguished subsets of vertices S and T, find a shortest path from any vertex in S to any vertex in T. Your algorithm should run in time proportional to ElogV, in the worst case.

4.4.26 *Single-source shortest paths in dense graphs*. Develop a version of Dijkstra's algorithm that can find the SPT from a given vertex in a dense edge-weighted digraph in time proportional to V^2. Use an ajdacency-matrix representation (See EXERCISE 4.4.3 and EXERCISE 4.3.29)

4.4.27 *Shortest paths in Euclidean graphs*. Adapt our APIs to speed up Dijkstra's algorithm in the case where it is known that vertices are points in the plane.

*Solution*: [reference](http://www.informit.com/articles/article.aspx?p=169575&seqNum=6)
Ex27_*.java, not find util.DrawUtilities & EdgeWeightedDigraphInterface



4.4.28 *Longest paths in DAGs*. Develop an implementation AcyclicLP that can solve the longest-paths problem in edge-weighted DAGs, as described in PROPOSITION T.

4.4.29 *General optimality*. Complete the proof of PROPOSITION W by showing that if there exists a directed path from s to v and no vertex on any path from s to v is on a negative cycle, then there exists a shortest path from s to v (Hint: see PROPOSITION P.)


4.4.30 *All-pairs shortest path in graphs with negative cycles*. Articulate an API like the one implemented on page 656 for the all-pairs shortest-paths problem in graphs with no negative cycles. Develop an implementation that runs a version of Bellman-Ford to identify weights pi[v] such that for any edge v->w, the edge weight plus the difference between pi[v] and pi[w] is nonnegative. Then use these weights to reweight the graph, so that Dijkstra's algorithm is
effective for finding all shortest paths in the reweighted graph.


4.4.31 *All-pairs shortest path on a line*. Given a weighted line graph (undirected connected graph, all vertices of degree 2, except two endpoints which have degree 1), devise an algorithm that preprocesses the graph in linear time and can return the distance of the shortest path between any two vertices in constant time.

*Partial solution*. Find a vertex s of degree 1 and run breadth-first (or depth-first) search to find the order in which the remaining vertices appear. Then, compute the length of the shortest path from s to v  each vertex v, say dist[v]. The shortest path between v and w is |dist[v] - dist[w]|


4.4.32 *Parent-checking heuristic*. Modify Bellman-Ford to visit a vertex v only if its SPT parent edgeTo[v] is not currently on the queue. This heuristic has been reported by Cherkassky, Goldberg, and Radzik to be useful in practice. Prove that it correctly computes shortest paths and that the worst-case running time is proportional to EV.


4.4.33 *Shortest path in a grid*. Given an N-by-N matrix of positive integers, find the shortest path from the (0,0) entry to the (N-1, N-1) entry, where the length of the path is the sum of the integers in the path. Repeat the problem but assume you can only move right and down.

4.4.34 *Monotonic shortest path*. Given a weighted digraph, find a monotonic shortest path from s to every other vertex. A path is monotonic if the weight of every edge on the path is either strictly increasing or strictly decreasing. The path should be simple (no repeated vertices). Hint: Relaxedges in ascending order and find a best path; then relax edges in descending order and find a best path.

4.4.35 *Bitonic shortest path*. Given a digraph, find a bitonic shortest path from s to every other vertex (if one exists). A path is bitonic if there is an intermediate vertex v such that the edges on the path from s to v are strictly increasing and the edges on the path from v to t are strictly decreasing. The path should be simple (no repeated vertices).

4.4.36 *Neighbors*. Develop an SP client that finds all vertices within a given distance d of a given vertex in a given edge-weighted disgraph. The running time of your method should be proportional to the size of the subgraph induced by those vertices and the vertices incident on them, or V (to initialize data structures), whichever is larger.

4.4.37 *Critical edges*. Develop an algorithm for finding an edge whose removal causes maximal increase in the shortest-paths length from one given vertex to another given vertex in a given edge-weighted digraph.

*Solution*:
[reference](https://bababadalgharaghtakamminarronnkonnbro.blogspot.com/2012/06/interviewstreet-going-office.html)

4.4.38 *Sensitivity*. Develop an SP client that performs a Sensitivity analysis on the edge-weighted digraph's edges with respect to a given pair of vertices s and t: Compute a V-by-V boolean matrix such that, for every v and w, the entry in row v and column w is true if v->w is an edge in the edge-weighted digraphs whose weight can be increased without the shortest-path length from v to w being increased and is false otherwise.

4.4.39 *Lazy implementation of Dijkstra's algorithm*. Develop an implementation LazyDijkstraSP.java of the lazy version of Dijkstra's algorithm that is described in the text.

4.4.40 *Bottleneck SPT*. Show that an MST of an undirected graph is equivalent to a bottleneck SPT of the graph: For every pair of vertices v and w, it gives the path connecting them whose longest edge is as short as possible.

4.4.41 *Bidirectional search*. Develop a class for the source-sink shortest-paths problem that is based on code like ALGORITHM 4.9 but that initializes the prority queue with both the source and the sink. Doing so leads to the growth of an SPT from each vertex; your main task is to decide precisely what to do when the two SPTs collide.

4.4.42 *Worst case(Dijkstra)*. Describe a family of graphs with V vertices and E edges for which the worst-case running time of Dijkstra's algorithm is achieved.

4.4.43 *Negative cycle detection*. Suppose that we add a constructor to ALGORITHM 4.11 that differs from the constructor given only in that it omits the second argument and that it initializes all distTo[] entries to 0. Show that, if a client uses that constructor, a client call to hasNegativeCycle() returns true if and only if the graph has a negative cycle (and negativeCycle() return that cycle).

*Answer*: Consider a digraph formed from the original by adding a new source with an edge of weight 0 to all the other vertices. After one pass, all distTo[] entries are 0, and finding a negative cycle reachable from that source is the same as finding a negative cycle anywhere in the original graph.

4.4.44 *Worst case (Bellman-Ford)*. Describe a family of graphs for which ALGORITHM 4.11 take time proportional to VE.

4.4.45 *Fast Bellman-Ford*. Develop an algorithm that breaks the linearithmic running time barrier for the single-source shortest-paths problem in general edge-weighted digraphs for the special case where the weights are integers known to be bounded in absolute value by a constant.

4.4.46 *Animate*. Write a client program that does dynamic graphical animations of Dijkstra's algorithm.

4.4.47 *Bellman-Ford queue never empties*. Show that if there is a negative cycle reachable from the source in the queue-based implementation of the Bellman-Bellman algorithm, then the queue never empties.

*Solution*: Consider a negative cycle and suppose that distTo[w] <= distTo[v] + length(v, w) for all edges on cycle W. Summing up this inequality for all edges on the cycle implies that the length of the cycle is nonnegative.

4.4.48 *Bellman-Ford negative cycle detection*. Show that if any edge is relaxed during the Vth pass of the generic Bellman-Ford algorithm, then the edgeTo[] array has a directed cycle and any such cycle is a negative cycle.

*Solution*: todo.

##Web Exercise

1. **Optimal substructure property**. Prove that every subpath on a shortest path from v to w is also a shortest path between the two endpoints.

2. **Unique shortest path tree**. Suppose that there is a unique shortest path from s to every other vertex. Prove that the SPT is unique.

3. **No negative cycles**. Prove that if the generic algorithm terminates, then there are no negative cycles reachable from s. Hint: upon termination, all edges reachable from s satisfy distTo[w] <= distTo[v] + e.weight(). Add up this inequality for all edges along a cycle.

4. **Predecessor graph**. True or false. During execution of Bellman-Ford in an edge-weighted digraph with no negative cycles, following the edgeTo[] array always yields a path back to s. Repeat the question for Dijkstra's algorithm.

5. **Yen's improvement to Bellman-Ford**. Partition the edges into two DAGs A and B: A consists of edges that go from a lower indexed vertex to a higher indexed vertex; B consists of edges that go from a higher indexed vertex to a lower indexed vertex. When iterating through all the edges in a phase of Bellman-from, first iterate through the edges in A in ascending order of vertex number (a topological order of A), then iterate through the edges in B in descending order of vertex number (a topological order of B). When iterating through the edges in A, any path in the SPT that starts at a vertex with the correct distTo[] value and uses only edges in A results in the correct distTo[] value; similarly for B. The number of passes needed is the maximum number of A-B alternations on a path, which is at most (V+1)/2. Thus, the number of passes is at most(V+1)/2 instead of V.


6. **Replacement paths**. Given an edge-weighted digraph with nonnegative weights and source s and sink t, design an algorithm to find the shortest path from s to t that does not use edge e for edge e. The order of growth of your algorithm should be E V log V.


7. **Road network data sets**.
- From the DIMACS challenge. Here are all the roads in each state.
- rome99.txt is a large portioin of the directed road network of Rome from the DIMACS challenge. The graph contains 3353 vertices and 8870 edges. Vertices correspond to intersections between  roads and edges correspond to roads or road segments. The edge weights are distances in meters.
- NYC.txt is the undirected road network of New York City. The graph contains 264346 vertices and 733846 edges.It is connected, contains parallel edges, but no self-loops. The edge weights are travel times and are strictly positive.


8. **Internet routing**. OSPF(Open shortest Path First) is a widely used protocol for Internet routing that uses Dijkstra's algorithm. RIP(Routing Information Protocol) is another routing protocol based on the Bellman-Ford algorithm.

9. **Shortest path with the ability to skip one edge**.Given an edge-weighted digraph with nonnegative weights, Design an E log V algorithm for finding the shortest path from s to t where you have the option to change the weight of any one edge to 0.

*Solution*. Compute the shortest path from s to every other vertex; compute the shortest path from every vertex to t. For each edge e = (v, w), compute the sum of the length of the shortest path from s to v and the length of the shortest path from w to t. The smallest such sum provides the shortest such path.

10. **Shortest paths in undirected graphs**. Write a program DijkstraUndirectedSP.java that solves the single-source shortest path problems in undirected graphs with nonnegative weights using Dijkstra's algorithm.

11. **Floyd-Warshall algorithm**. FloydWarshall.java implements the Floyd-Warshall algorithm for the all-pairs shortest path problem. It takes time proportional to V^3 and space proportional to V^2. It uses AdjMatrixEdgeWeightedDigraph.java

12. **Randomized Bellman-Ford**. Suppose that we choose the vertex order in Yen's algorithm uniformly at randomly (where A contains all the edges that go from a lower vertex in the permutation to a higher vertex). Prove that the expected number of passes is at most (V+1)/3.

13. **Suurball's algorithm**. Given a digraph with non-negative edge weights and two distinguished vertices s and t, find two edge-disjoint paths from s to t such that the sum of the weights of the two paths is minimized.

*Solution*. This can be done with a clever application of Dijkstra's algorithm, known as Suurball's algorithm.
[reference](https://en.wikipedia.org/wiki/Suurballe%27s_algorithm).


























