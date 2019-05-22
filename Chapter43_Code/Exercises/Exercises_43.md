#EXERCISES

##Book Exercises

4.3.1 Prove that you can rescale the weights by adding a positive constant to all of them or by multiplying them all by a positive constant without affecting the MST. 

*Solution*. Kruskal's algorithm accesses the edge weights only through the compareTo() method. Adding a positive constant to each weight (or multiplying by a positive constant) won't change the result of the compareTo() method.

4.3.2 Draw all of the MSTs of the graph depicted at right (all edge weights are equal).

4.3.3 Show that if a graph's edges all have distinct weights, the MST is unique.

*Solution*. For the sake of contradiction, suppose there are two different MSTs of G, say T1 and T2. Let e = v-w be the min weight edge of G that is in one of T1 or T2, but not both. Let's suppose e is in T1. Adding e to T2 creates a cycle C. There is at least one edge, say f, in C that is not in T1 (otherwise T1 would be cyclic). By our choice of e, w(e) <= w(f). Since all of the edge weights are distinct, w(e) < w(f). Now, replacing f with e in T2 yields a new spanning tree with weight less
than that of T2 (contradicting the minimality of T2).

4.3.4 Consider the assertion that an edge-weighted graph has a unique MST only if its edge weights are distinct. Give a proof or counterexample.

4.3.5 Show that the greedy algorithm is valid even when edge weights are not distinct.

*Answer*.
Assume that there are two edges, e and f, which have the same weight in the graph.

Case 1: 
Both e and f are minimum-weight edges in a cut C with no black edges. Coloring either e or f black would be part 
of the generation of a valid MST, since they both have the minimum weight in the cut. The edges e and f will not 
be chosen together, because once either e or f is chosen, C will already have a black edge.

Case 2:
Edges e and f are minimum-weight edges in different cuts: C1 and C2.
In this case, they will both be colored black and will be part of the MST.

Case 3:
Edges e and f are in the same cut C but are not minimum-weight edges.
In this case, neither e nor f will be chosen.

Case 4:
Edges e and f are in different cuts (C1 and C2) but are not minimum-weight edges.
In this case, neither e nor f will be chosen.

Therefore, the greedy algorithm will be valid even when edge weights are not distinct.

4.3.6 Give the MST of the weighted graph obtained by deleting vertex 7 from tinyEWG.txt.

*Solution*.
1-3
0-2
2-3
4-5
1-5
6-2

4.3.7 How would you find a maximum spanning tree of an edge-weighted graph?

*Solution*. Negative the weight of each edge (or reverse the sense of comparison in the compareTo() method).

4.3.8 Prove the following, known as the cycle property: Given any cycle in an edge-weighted graph (all edge weights distinct), the edge of maximum weight in the cycle does not belong to the MST of the graph.

4.3.9 Implement the constructor for EdgeWeightedGraph.java that reads an edge-weighted graph from an input stream.

4.3.10 Develop an EdgeWeightedGraph implementation for dense graphs that uses an adjacency-matrix (two-dimensional array of weights) representation. Disallow parallel edges.

4.3.11 Determine the amount of memory used by EdgeWEightedGraph.java to represent a graph with V vertices and E edges, using the memory-cost model of Section 1.4.

*Solution*. 56+40V+112E. MemoryOfEdgeWEightedGraph.java computes it empirically assuming that no Integer values are cached -- Java typically caches the integers -128 to 127.

4.3.12 Suppose that a graph has distinct edge weights. Does its shortest edge have to belong to the MST? Can its longest edge belong to the MST? Does a min-weight edge on every cycle have to belong to the MST? Prove your answer to each question or give a counterexample.

*Solution*. The shortest edge has to belong to the MST.
The longest edge can belong to the MST.
a min-weight edge on every cycle have to belong to the MST.

4.3.13 Give a counterexample that shows why the following strategy does not necessarily find the MST: 'Start with any vertex as a single-vertex MST, then add V-1 edges to it, always taking next a min-weight edge incident to the vertex most recently added to the MST.'

4.3.14 Given an MST for an edge-weighted graph G, suppose that na edge in G that does not disconnect G is deleted. Describe how to find an MST of the new graph in time proportional to E.

*Solution*. If the edge in not in the MST, then the old MST is an MST of the updated graph. Otherwise, deleting the edge from the MST leaves two connected components. Add the minimum weight edge with one vertex in each component.

4.3.15 Given an MST for an edge-weighted graph G and a new edge e, describe how to find an MST of the new graph in time proportional to V.

*Solution*. Add edge e to the MST create a unique cycle. Delete the maximum weight edge on this cycle.

4.3.16 Given an MST for an edge-weighted graph G and a new edge e, write a program that determines the range of weights for which e is in an MST.

4.3.17 Implement toString() for EdgeWeightedGraph

4.3.18 Give traces that show the process of computing the MST of the graph defined in EXERCISE 4.3.6 with the lazy version fo Prim's algorithm, the eager version of Prim's algorithm, and Kruskal's algorithm.

4.3.19 Suppose that you use a priority-queue implementation that maintains a sorted list. What would be the order of growth of the worst-case running time for Prim's algorithm and for Kruskal's algorithm for graphs with V vertices and E edges? When would this method be appropriate, if ever? Defend your answer.

*Solution*. Prim's algorithm would run in time proportional to V^2, which is optimal for dense graphs.

4.3.20 True or false: At any point during the execution of Kruskal's algorithm, each vertex is closer to some vertex in its subtree than any vertex not in its subtree. Prove your answer.

*Solution*. True.
Since Kruskal's algorithm adds edges to an MST by order of weight/length, if there is an edge e = v-w of length 1 
and there is an edge f = v-z of length 2, there are two possible cases:

Case 1: Edge e is chosen before edge f.
In this case, vertex v is closer to a vertex in its subtree (vertex w) than to a vertex not in its subtree (vertex z).

Case 2: Edge f is chosen before edge e.
This can only happen if choosing edge e would generate a cycle. But in order to generate a cycle there must be another 
vertex connected to both vertex v and vertex w. Let's call this vertex a. If vertex a is already connected to vertex v 
this means that the length of the edge connecting v-a is smaller than the length of edge e. Therefore, even in this 
case vertex v is closer to a vertex in its subtree (vertex a) than to a vertex not in its subtree (both vertices w and z).


4.3.21 Provide an implementation of edges() for PrimMST.java

```
public Iterable<Edge> edges()
{
  Bag<Edge> mst = new Bag<Edge>();
  for (int v = 1; v < edgeTo.length; v++)
    mst.add(edgeTo[v]);
  return mst;
}
```







