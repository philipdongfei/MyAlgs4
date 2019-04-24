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

4.2.13 Give the transitive closure of the digraph with ten vertices and these edges:
3->7, 1->4 7->8, 0->5, 5->2, 3->8, 2->9, 0->6, 4->9, 2->6, 6->4

4.2.14 Prove that the strong components in G^R are the same as in G.

4.2.15 What are the strong components of a DAG?
*Solution*: Each vertex is its own strong component.

4.2.16 What happens if you run Kosaraju's algorithm on a DAG?

4.2.17 True or false: The reverse postorder of a graph's reverse is the same as the postorder of the graph.
*Solution*: False

4.2.18 Compute the memory usage of a Digraph with V vertices and E edges, under the memory cost model of SECTION 1.4.
*Solution* 56+40V+64E










##Web Exercises

