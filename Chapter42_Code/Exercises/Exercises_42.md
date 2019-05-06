#EXERCISES

##Book Exercises

4.2.1 What is the maximum number of edges in a digraph with V vertices and no parallel edges? What is the minimum number of edges in a digraph with V vertices, none of which are isolated?
*Answer*: maximum: V*(V-1), minimum: V-1

4.2.2 Draw, in the style of the figure in the text (page 524), the adjacency lists built by Digraph's input stream constructor for the file tinyDGex2.txt depicted at left.

```
adj[]
0: ->6->5
1: ->
2: ->0->3
3: ->10->6
4: ->1
5: ->10->2
6: ->2
7: ->8->11
8: ->1->4
9: ->
10: ->3
11: ->8

```

4.2.3 Create a copy constructor for Digraph that takes as input a digraph G and creates and initializes a new copy of the digraph. Any changes a client makes to G should not affect the newly created digraph.

4.2.4 Add a method hasEdge() to Digraph which takes two int arguments v and w and returns true if the graph has an edge v->w, false otherwise.

4.2.5 Modify Digraph to disallow parallel edges and self-loops.

4.2.6 Develop a test client for Digraph.

4.2.7 The *indegree* of a vertex in a digraph is the number of directed edges that point to that vertex. The *outdegree* of a vertex in a digraph is the number of directed edges that emanate from that vertex. No vertex is reachable from a vertex of outdegree 0, which is called a *sink*; a vertex of indegree 0, which is called a *source*, is not reachable from any other vertex. A digraph where self-loops are allowed and every vertex has outdegree 1 is called a *map* (a function from
the set of integers from 0 to V-1 onto itself). Write a program Degrees.java that implements the following API:
```
public class Degrees
Degrees(Digraph G)
int indegree(int v)
int outdegree(int v)
Iterable<Integer> sources()
Iterable<Integer> sinks()
boolean isMap()

```

4.2.8 Draw all the nonisomorphic DAGs with two, three, four, and five vertices (see EXERCISE 4.1.28).

4.2.9 Write a method that checks whether or not a given permutation of DAG's vertices is a topological order of the DAG.

4.2.10 Given a DAG, does there exist a topological order that cannot result from applying a DFS-based algorithm, no matter in what order the vertices adjacent to each vertex are chosen? Prove your answer.

*Answer*: There is no topological order that cannot result from applying a DFS-based algorithm.
seen on proposition F.

4.2.11 Describe a family of sparse digraphs whose number of directed cycles grows exponentially in the number of vertices.


4.2.12 How many edges are there in the transitive closure of a digraph that is a simple directed path with V vertices and V-1 edges?

*Answer*: 

4.2.13 Give the transitive closure of the digraph with ten vertices and these edges:
3->7, 1->4 7->8, 0->5, 5->2, 3->8, 2->9, 0->6, 4->9, 2->6, 6->4

4.2.14 Prove that the strong components in G^R are the same as in G.

4.2.15 What are the strong components of a DAG?
*Solution*: Each vertex is its own strong component.

4.2.16 What happens if you run Kosaraju's algorithm on a DAG?
*Answer*: V strong components

4.2.17 True or false: The reverse postorder of a graph's reverse is the same as the postorder of the graph.
*Solution*: False

4.2.18 Compute the memory usage of a Digraph with V vertices and E edges, under the memory cost model of SECTION 1.4.
*Solution* 56+40V+64E

4.2.18 True or false: If we modify the Kosaraju-Sharir algorithm to run the first depth-first search in the digraph G (instead of the reverse digraph G^R) and second depth-first search in G^G (instead of G), then it will still find the strong components.

*Solution*: True. the strong components of a digraph are the same as the strong components of its reverse.

4.2.18 True or false: If we modify the Kosaraju-Sharir algorithm to replace the second depth-first search with breath-first search, then it will still find the strong components.

*Solution*: True.

4.2.19 *Topological sort and BFS*. Explain why the following algorithm does not necessarily produce a topological order: Run BFS, and label the vertices by increasing distance to their respective source.

*Solution*: because some vertices closer to the source may be preceded by vertices further from the source in a topological order.

BFS could be cused by topological sort. It would take O(|E|+|V|) time. The idea is to start from any vertex which has in-degree of zero, print the vertex and prune the outgoing edges of it and update in-degrees of its neighbors accordingly. Here are the detailed steps which make use of HashMap to store and modify in-degrees.

1. Count in-degree of all vertices.
2. Pick any vertex 'v' which has in-degree of 0.
3. Print 'v'. Remove the vertex 'v' and all edges coming out of it. Decrement in-degrees of all neighbors of vertex 'v' by 1.
4. Repeat step 2 and 3 till all vertices are removed.

4.2.20 *Directed Eulerian cycle*. An Eulerian cycle is a directed cycle that contains each edge exactly once. Write a graph client Euler that finds an Eulerian cycle or reports that no such tour exists. *Hint*: Prove that a digraph G has a directed Eulerian cycle if and only if G is connected and each vertex has its indegree equal to its outdegree.

4.2.21 *LCA of a DAG*. Given a DAG and two vertices v and w, find the *lowest common ancestor(LCA) of v and w. The LCA of v and w is an ancestor of v and w that has no descendants that are also ancestors of v and w. Computing the LCA is useful in multiple inheritance in programming languages, analysis of genealogical data (find degree of inbreeding in a pedigree graph), and other applications.
*Hint*: Define the height of a vertex v in a DAG to be the length of the longest path from a root to v. Among vertices that are ancestors of both v and w, the one with the greatest height is an LCA of v and w.

*Solution*:[LCA](https://en.wikipedia.org/wiki/Lowest_common_ancestor)

4.2.22 *Shortest ancestral path*. Given a DAG and two vertices v and w, find the *shortest ancestral path* between v and w. An ancestral path between v and w is a common ancestor x along with a shortest path from v to x and a shortest path from w to x. The shortest ancestral path is the ancestral path goes to a common ancestor x that is not an LCA. 
*Hint*: Run BFS twice, once from v and once from w.

4.2.23 *Strong component*. Describe a linear-time algorithm for computing the strong connected component containing a given vertex v. On the basis of that algorithm, describe a simple quadratic algorithm for computing the strong components of a digraph.

*Partial solution*: To compute the strong component containing s
- Find the set of vertices reachable from s
- Find the set of vertices that can reach s
- Take the intersection of the two sets
Using this as a subroutine, you can find all strong components in time proportioinal to t(E + V), where t is the number of strong components.

4.2.24 *Hamiltonian path in DAGs*. Given a DAG, design a linear-time algorithm to determine whether there is a directed path that visited each vertex exactly once.

*Solution*: Compute a topological sort and check if there is an edge between each consecutive pair of vertices in the topological order.

4.2.25 *Unique topological ordering*. Design an algorithm to determine whether a digraph has a unique topological ordering.
*Hint*: a digraph has a unique topological ordering if and only if there is a directed edge between each pair of consecutive vertices in the topological order (i.e., the digraph has a Hamiltonian path). If the digraph has multiple topological orderings, then a second topological order can be obtained by swapping a pair of consecutive vertices.

4.2.26 *2-satisfiability*. Given a boolean formula in conjunctive normal from with M clauses and N literals such that each clause has exactly two literals, find a satisfying assignment (if one exists).
*Solution sketch*: From the implication digraph with 2N vertices (one per literal and its negation). For each clause x + y, include edges from y' to x and from x' to y. claim: The formula is satisfiable if and only if no variable x is in the same strong component as its negation x'. Moreover, a topological sort of the kernel DAG (contract each strong component to a single vertex) yields a satisfying assignment.

**ToDo**: see wiki 2-SAT


4.2.27 *Digraph enumeration*. Show that the number of different V-vertex digraphs with no parallel edges is $2^V^2$. (How many digraphs are there that contain V vertices and E edges?) Then compute an upper bound on the percentage of 20-vertex digraphs that could ever be examined by any computer, under the assumptions that every electron in the universe examines a digraph every nanosecond, that the universe has fewer than 10^80 electrons, and that the age of the universe
will be less than 10^20 years.

4.2.28 *DAG enumeration*. Give a formula for the number of V-vertex DAGs with E edges.

*Solution*: (V-1)*V/2

4.2.29 *Arithmetic expressions*. Write a class that evaluates DAGs that represent arithmetic expressions. Use a vertex-indexed array to hold values corresponding to each vertex. Assume that values corresponding to leaves have been established. Describe a family of arithmetic expressions with the property that the size of the expression tree is exponentially larger than the size of the corresponding DAG (so the running time of your program for the DAG is proportional to the
logarithm of the running time for the tree).
4.2.29 *Arithmetic expressions*. Write a class that evaluates DAGs that represent arithmetic expressions. Use a vertex-indexed array to hold values corresponding to each vertex. Assume that values corresponding to leaves have been established. Describe a family of arithmetic expressions with the property that the size of the expression tree is exponentially larger than the size of the corresponding DAG (so the running time of your program for the DAG is proportional to the
logarithm of the running time for the tree).


4.2.29 *Arithmetic expressions*. Write a class that evaluates DAGs that represent arithmetic expressions. Use a vertex-indexed array to hold values corresponding to each vertex. Assume that values corresponding to leaves have been established. Describe a family of arithmetic expressions with the property that the size of the expression tree is exponentially larger than the size of the corresponding DAG (so the running time of your program for the DAG is proportional to the
logarithm of the running time for the tree).


4.2.30 *Queue-based topological sort*. Develop a nonrecursive topological sort implementation TopologicalX.java that maintains a vertex-indexed array that keeps track of the indegree of each vertex. Initialize the array and a queue of sources in a single pass through all the edges, as in Exercise 4.2.7.Then, perform the following operatioins until the source queue is empty:

- Remove a source from the queue and lable it.
- Decrement the entries in the indegree array corresponding to the destination vertex of each of the removed vertex's edges.
- If decrementing any entry causes it to become 0, insert the corresponding vertex onto the source queue.

4.2.31 *Euclidean digraphs*. Modify your solution to EXERCISE 4.1.37 to create an API EuclideanDigraph for graphs whose vertices are points in the plane, so that you can work with graphical representations.

###Web Exercises
40. *Shortest directed cycle*. Given a digraph, design an algorithm to find a directed cycle with the minimum number of edges (or report that the graph is acyclic). The running time of your algorithm should be proportional to E V in the worst case.

*Application*: give a set of patients in need of kidney transplants, where each patient has a family member willing to donate a kidney, but of the wrong type. Willing to donate to another person provided their family member gets a kidney. Then hospital performs a "domino surgery" where all transplants are done simultaneously.

*Solution*: run BFS from each vertex s. The shortest cycle through s is an edge v->s, plus a shortest path from s to v.
ShortestDirectedCycle.java.

41. *Odd-length directed cycle*. Design a linear-time algorithm to determine whether a digraph has an odd-length directed cycle.

*Solution*. We claim that a digraph G has an odd-length directed cycle if and only if one (or more) of its strong components is nonbipartite (when treated as an undirected graph).
- If the digraph G has an odd-length directed cycle, then this cycle will be entirely contained in one of the strong components. When the strong component is treated as an undirected graph, the odd-length directed cycle becomes an odd-length cycle. Recall that an undirected graph is bipartite if and only if it has no odd-length cycle.
- Suppose a strong component of G is nonbipartite (when treated as an undirected graph). This means that there is an odd-length cycle C in the strong component, ignoring direction. If C is a directed cycle, then we are done. Otherwise, if an edge v->w is pointing in the "wrong" direction, we can replace it with an odd-length path that is pointing in the opposite direction (which preserves the parity of the number of edges in the cycle). To see how, note that there exists a
    directed path P from w to v because v and w are in the same strong component. If P has odd length, then we replace edge v->w by P; if P has even length, then this path P combined with v->w is an odd-length cycle.

42. *Reachable vertex in a DAG*. Design a linear-time algorithm to determine whether a DAG has a vertex that is reachable from every other vertex.
*Solution*. Compute the outdegeree of each vertex. If the DAG has exactly one vertex v with outdegreee 0, then it is reachable from every other vertex.


43. *Reachable vertex in a digraph*. Design a linear-time algorithm to determine whether a digraph has a vertex that is reachable from every other vertex.

*Solution*. Compute the strong components and kernel DAG. Apply Exercise 4.2.37 to the kernel DAG.

44. *Web crawler*. Write a program WebCrawler.java that uses breadth-first search to crawl the web digraph, starting from a given web page. Do not explicitly build the web digraph.















##Web Exercises

