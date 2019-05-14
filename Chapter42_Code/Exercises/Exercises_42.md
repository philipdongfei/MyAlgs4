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

1. **Symbol digraph**. Modify SymbolGraph.java to create a program SymbolDigraph.java that implements a symbol digraph.

2. **Combinational circuits**. Determining the truth value of a combinational circuit given its inputs is a graph reachability problem (on a directed acyclic graph).

3. **Privilege escalation**. Include an array from user class A to user class B if A can gain the privileges of B. Find all users that can obtain Administrator access in Windows.

4. **Unix program tsort**.

5. **Checkers**. Extend the rules of checkers to an N-by-N checkerboard. Show how to determine whether a checker can become in king in the current move. (Use BFS or DFS.) Show how to determine whether black has a winning move. (Find a directed Eulerian path.)

6. **Preferential attachment model**. Web has a scale-free property and obeys a power law. New pages tend to preferentially attach to popular pages. Start with a single page that points to itself. At each step a new page appears with outdegree 1. With probability p the page points to a random page; with probability (1-p) the page points to an existing page with probability proportional to the indegree of the page.

7. **Subtype checking**. Given single inheritance relations (a tree), check if v is an ancestor of w. Hint: v is an ancestor of w if and only if pre[v] <= pre[w] and post[v] >= post[w].

*pre: preorder, post: postorder*.
v = 2, w = 4;
Preorder: 1 2 4 5 3 
Postorder: 4 5 2 3 1

8. **Subtype checking**. Repeat previous question, but with a DAG instread of a tree.

9. **LCA of a rooted tree**. Given a rooted tree and two vertices v and w, find the lowest common ancestor (lca) of v and w. The lca of v and w is the shared ancestor furthest from the root. Among most fundamental problem on rooted trees. Possible to solve in O(1) time per query with linear preprocessing time (Harel-Tarjan, Bender-Coloton)
Find a DAG where the shortest ancestral path goes to a common ancestor x that is not an LCA.

10. **Nine-letter word**. Find a nine-letter English word such that remains an English word after successively removing each of its letters (in an appropriate order). Build a digraph with words and vertices and an edge from one word to another if it can be formed by adding one letter.

*Answer*. one solution is startling->starting->staring->string->sting->sing->sin->in->i

11. **Spreadsheet recalculate**. Hopefully no cyclic dependencies. Use topological sort of formula cell graph to determine in which order to update the cells.

12. **Nesting boxes**. A d-dimensional box with dimensions (a1,a2,...,ad) nests inside a box with dimensions (b1,b2,...,bd) if the coordinates of the second box can be permuted so that a1<b1,a2<b2,...,ad<bd.

- Give an efficient algorithm for determining where one d-dimensional box nests inside another. Hint: sort.
- Show that nesting is transitive: if box i nests inside box j and box j nests inside box k, then box i nests inside box k.
- Given a set of n d-dimensional boxes, given an efficient algorithm to find the most boxes that can be simultaneously nested.

*Hint*: Create a digraph with an edge from box i to box j if i nests inside box j. Then run topological sort.

13. **Warshall's transitive closure algorithm**. WarshallTC.java algorithm is ideal for dense graphs. Relies on AdjMatrixDigraph.java.

14. **Brute-force strong components algorithm**. BruteSCC.java computes the strong components by first computing the transitive closure. It takes O(EV) time and O(V^2) space.

15. **Tarjan's strong components algorithm**. TarjanSCC.java implements Tarjan's algorithm for computing strong components.

16. **Gabow's strong components algorithm**. GabowSCC.java implements Gabow's algorithm for computing strong components.

17. **Digraph generator**. DigraphGenerator.java generated various digraphs.

18. **Finite Markov chains**. Recurrent state: once started in state, Markov chain will return with probability 1. Transient state: some probability that it will never return (some node j for which i can reach j, but j can't reach i). Irreducible Markov chain = all states recurrent. A Markov chain is irreducible if and only if it is strongly connected. The recurrent components are those with no leave edges in the kernel DAG. Communicating classes in Markov chain are the strong components.
Theorem. If G is strongly connected, then there is a unique stationary distribution pi. Moreover pi(v) > 0 for all v.
Theorem. If the kernel DAG of G has a single supernode with no leaving edges, then there is a unique stationary distribution pi. Moreover pi(v) > 0 for all v recurrent and pi(v) = 0 for all v transient.

19. **Descendants lemma**. Denote by pre[v] and post[v] as the preorder and postorder number of v, respectively, and by nd[v] the number of descendants of v (including v). Prove that the following four conditions are equivalent.
- Vertex v is an ancestor of vertex w.
- pre[v] <= pre[w] < pre[v] + nd(v)
- post[v] - nd[v] < post[w] <= post[v]
- pre[v] <= pre[w] and post[v] >= post[w] (nesting lemma)


20. **Edge lemma**. Prove that an edge(v, w) is one of the following four kinds:
- w is a child of v: (v, w) is a tree edge.
- w is a descendant but not a child of v: (v, w) is a forward edge.
- w is an ancestor of v: (v, w) is a back edge
- w and v are unrelated and pre[v] > pre[w]: (v, w) is a cross edge.


21. **Path lemma**. Prove that any path from v to w with pre[v] < pre[w] contains a common ancestor of v and w.

22. Prove that if (v, w) is an edge and pre[v] < pre[w], then v is an ancestor of w in the DFS tree.

23. **Postorder lemma**. Prove that if P is a path such that the last vertex x is highest in postorder, then every vertex on the path is a descendant of x (and hence has a path from x).

*Solution*. The proof is by induction on the length of P (or by contradiction). Let (v, w) be an edge such that w is a descendant of x and post[v] < post[x]. Since w is a descendant of x, we have pre[w] >= pre[x].
- If pre[v] >= pre[x], then v is a descendant of x (by the nesting lemma).
- If pre[v] < pre[x], then pre[v] < pre[w], which implies (by the previous exercise) that v is an ancestor of w and hence related to x. But post[v] < post[x] implies v is a descendant of x.


24. **Pre-topological order**. Desgin a linear-time algorithm to find a pre-topological order: and ordering of the vertices such that if there is a path from v to w and w appears before v in the ordering, then there must also be a path from w to v.
*Hint*: reverse postorder is a pre-topological order. This is the crus of the proof of correctness of the Kosaraju-Sharir algorithm.

25. **Wordnet**. Using WordNet to Measure Semantic Orientations of Adjectives.


26. **Garbage collection**. Automatic memory management in languages like Java is a challenging problem. Allocating memory is easy, but discovering when a program is finished with memory (and reclaiming it) is more difficult. Reference counting: doesn't work with circular linked structure. Mark-and-sweep algorithm. Root = local variables and static variables. Run DFS from roots, marking all variables references from roots, and so on. Then, make second pass: free all unmarked objects and unmark all marked objects. Or a copying garbage collector would then move all of the marked objects to a single memory area. Uses one extra bit per object. JVM must pause while garbage collection occurs. Fragments memory.

*Applications*: C leak detector (leak = unreachable, unfreed memory).

27. **Directed cycle deterction applications**. Application: check for illegal inheritance loop, check for deadlocking. A directory is a list of files and other directories. A symbolic link is a reference to another directory. When listing all files in a directory, need to be careful to avoid following a cycle of symbolic links!

28. **Topological sort applications**. Application: course prerequisites, order in which to compile components of a large computer program, causalities, class inheritance, deadlocking detection, temporal dependencies, pipeline of computing jobs, check for symbol link loop, evaluate formula in spreadsheet.

29. **Strong component applications**. Applications to CAD, Markov chains (irreducible), spider traps and web search, pointer analysis, garbage collection.

30. **One-way street theorem**. Implement an algorithm to orient the edges in an undirected graph so that it is strongly connected. Robbins theorem asserts that this is possible if and only if the undirected graph is two edge connected (no bridges). In this case, a solution is to run DFS and oriented all edges in the DFS tree away from the root and all of the remaining edges toward the root.

31. **Orient edges in mixed graph to make acyclic**. A mixed graph is a graph with some edges that are directed and others that are undirected. Design a linear-time algorithm to determine whether it is possible to orient the undirected edges so that the resulting digraph is acyclic.

*Application*: old city with narrow roads wants to make every road one way but still allow every intersection in the city to be reachable from every other city.

32. **Orient edges in mixed graph to make a directed cycle**. A mixed graph is a graph with some edges that are directed and others that are undirected. Design a linear-time algorithm to determine whether it is possible to orient the undirected edges so that the resulting digraph has a directed cycle.

*Application*: determining whether a maximum flow is unique.
*Solution*: [one algorithm](https://cstheory.stackexchange.com/questions/32332/reference-for-mixed-graph-acyclicity-testing-algorithm)

33. **Postorder lemma variant**. Let S and T be two strong components in a digraph G. Prove that if there is an edge e from a vertex in S to a vertex in T, then the highest postorder number of a vertex in S is higher than the higher postorder number of a vertex in T.


34. **Number of paths in a DAG**. Given a DAG and two distinguished vertices s and t, design a linear-time algorithm to compute the number of directed paths from s to t.

*Hint*: topological sort.

35. **Path of length L in a DAG**. Given a DAG and two distinguished vertices s and t, design an algorithm to determine if there exists a path from s to t containing exactly L edges.

36. **Core vertices**. Given a digraph G, a vertex v is a core vertex if every vertex in G is reachable from v. Design a linear-time algorithm that finds all core vertices.

*Hint*: create the strong components of G and look at the kernel DAG.

37. **Strong components and bipartite matching**. Given a bipartite graph G, and unmatched edge is one that does not appear in any perfect matching. Desgin an algorithm to find all unmatched edges.

*Hint*: prove that the following algorithm does the job. Find a perfect matching in G; orient the edges in the matching from one side of the bipartition to the other side; orient the remaining edges in the opposite direction; among the edges not in the perfect matching, return those that have endpoints in different strongly connected components.

38. **Transitive reduction of a digraph**. The transitive reduction of a digraph is a digraph with the fewest number of edges that has the same transitive closure as the original digraph. Design an E V algorithm to compute the transitive reduction of a digraph.

39. **Transitive reduction of a DAG**. Design a linear-time algorithm to compute the transitive reduction of a DAG. Prove that the transitive reduction of a DAG is unique.

40. **Odd-length path**. Given a digraph G and a source vertex s, design a linear-time algorithm to determine all vertices that are reachable from s via a path (not necessarily simple) with an odd number of edges.

*Solution*. Create a new digraph G' with two vertices v and v' for each vertex v in G. For each edge v->w in G, include two edges: v->w' and w->v'. Now, any path from s to v' in G' corresponds to an odd-length path from s to v in G. Run either BFS or DFS to determine the vertices reachable from s.

41. Find a topological order of a DAG that cannot be computed as the reverse postorder of a DFS, no matter in which order the DFS chooses starting vertices in the constructor. Show that every topological order of a DAG can be computed as the reverse postorder of a DFS, provided that the DFS can choose the order of the starting vertices in the constructor arbitrarily.

42. **Nonrecursive DFS**. Write a program NonrecursiveDirectedDFS.java that implements depth-first search using an explicit stack instead of recursion. Write a program NonrecursiveDirectedCycle.java that find a directed cycle without using recursion.

43. **Nonrecursive topological sort**. Extend the queue-based topological sort algorithm TopologicalX.java from Exercise 4.2.39 to find a directed cycle if the digraph has a directed cycle. Name your program DirectedCycle.java

44. **Cartalk puzzle**. Find the longest word in a dictionary that has the property that you can remove one letter at a time (from either end or the middle) and the resulting string is also a word in the dictionary. For example, STRING is a 6-letter word with this property (STRING->STING->SING->SIN->IN->I)

45. **Reverse postorder vs. preorder. True or false: The reverse postorder of a digraph is the same as the preorder of the digraph.

46. **Reverse postorder vs. preorder in Kosaraju-Sharir**. Suppose that you use the preorder of the digraph instead of the reverse postorder in the Kosaraju-Sharir algorithm. Will it still produce the strong components?

*Answer*: No, run KosarajuSharirPreorderSCC.java on tinyDG.txt


