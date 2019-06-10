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













