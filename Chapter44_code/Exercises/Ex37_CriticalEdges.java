import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.Queue;
import java.util.HashSet;


public class Ex37_CriticalEdges {
    public DirectedEdge getCriticalEdge(EdgeWeightedDigraph G, int source, int target){
        // compute reverse digraph
        // It will be used to compute shortest paths using the target vertex as a source.
        EdgeWeightedDigraph reverseG = new EdgeWeightedDigraph(G.V());
        for (int v = 0; v < G.V(); v++){
            for (DirectedEdge edge : G.adj(v)){
                reverseG.addEdge(new DirectedEdge(edge.to(), edge.from(),
                            edge.weight()));
            }
        }
        // Get shortest paths from source
        DijkstraSP sp = new DijkstraSP(G, source);
        if (!sp.hasPathTo(target)){
            return null;
        }
        // Get shortest paths from the target
        DijkstraSP dijkstraSPFromTarget = new DijkstraSP(reverseG, target);

        // Get the islands in the graph.
        // The i-th island is the set of all vertices v, such that there exists a shortest path
        // from source to v using no more than i shortest-path vertices.
        int[] islands = getIslands(G, sp, source, target);

        // Compute bypass path lengths
        SegmentTree bypassPathLengths = computeBypassPathLengths(G, islands, sp, dijkstraSPFromTarget, target);
        // Return a critical edge, which is an edge that has the highest bypass length
        return getCriticalEdge(bypassPathLengths, sp, target);
    }
    private int[] getIslands(EdgeWeightedDigraph G, DijkstraSP sp, int source, int target) {
        int[] islands = new int[G.V()];
        for (int v = 0; v < G.V(); v++){
            islands[v] = -1;
        }
        int islandId = 0;
        for (DirectedEdge e : sp.pathTo(target)){
            if (islands[e.from()] == -1){
                islands[e.from()] = islandId++;
            }
            islands[e.to()] = islandId++;
        }

        // Do a breadth-first walk to find the island number of vertices that are not on the shortest path
        // from source to target.
        // These vertices are on a path from source to target that is not a shortest path.
        boolean[] visited = new boolean[G.V()];
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()){
            int currentVertex = queue.dequeue();
            for (DirectedEdge e : G.adj(currentVertex)){
                int neighbor = e.to();
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    if (islands[currentVertex] > islands[neighbor]){
                        islands[neighbor] = islands[currentVertex];
                    }
                    queue.enqueue(e.to());
                }
            }
        }
        return islands;
    }
    private SegmentTree computeBypassPathLengths(EdgeWeightedDigraph G, 
            int[] islands, DijkstraSP sp, DijkstraSP dijkstraSPFromTarget,
            int target){
        // bypassPathLengths[i] denotes the length of the shortest path 
        // that bypasses ei, where ei is the ith edge in the shortest
        // path from source to target.
        double[] bypassPathLengths = new double[G.V()];
        for (int v = 0; v < G.V(); v++){
            bypassPathLengths[v] = Double.POSITIVE_INFINITY;
        }
        HashSet<DirectedEdge> edgesInShortestPath = new HashSet<>();
        for (DirectedEdge e : sp.pathTo(target)){
            edgesInShortestPath.add(e);
        }
        SegmentTree segmentTree = new SegmentTree(bypassPathLengths);

        for (DirectedEdge e : G.edges()){
            if (!edgesInShortestPath.contains(e)){
                int island1 = islands[e.from()];
                int island2 = islands[e.to()];

                if (island1 < island2
                        && island1 != -1 && island2 != -1){
                    double shortestPathLength = sp.distTo(e.from()) + e.weight() + dijkstraSPFromTarget.distTo(e.to());
                    double currentShortestPathLength = segmentTree.rangeMinQuery(island1, island2-1);
                    if (shortestPathLength < currentShortestPathLength){
                        segmentTree.update(island1, island2-1, shortestPathLength);
                    }
                        }
            }
        }
        return segmentTree;
    }
    private DirectedEdge getCriticalEdge(SegmentTree bypassPathLengths, DijkstraSP sp, int target){
        // key = edge in shortest path from source to target
        // value = id of edge in the path
        SeparateChainingHashST<Integer, DirectedEdge> edgesInShortestPath = 
            new SeparateChainingHashST<>();
        int edgeIndex = 0;
        for (DirectedEdge e : sp.pathTo(target)){
            edgesInShortestPath.put(edgeIndex++, e);
        }

        int criticalEdgeId = 0;
        double highestBypassPathLength = Double.NEGATIVE_INFINITY;
        for (int edgeId = 0; edgeId < edgeIndex; edgeId++){
            if (bypassPathLengths.rangeSumQuery(edgeId, edgeId) > 
                    highestBypassPathLength){
                highestBypassPathLength = bypassPathLengths.rangeSumQuery(edgeId, edgeId);
                criticalEdgeId = edgeId;
                    }
        }
        return edgesInShortestPath.get(criticalEdgeId);
    }
    public static void main(String[] args){
        Ex37_CriticalEdges ex37 = new
            Ex37_CriticalEdges();
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int source1 = Integer.parseInt(args[1]), target1 = Integer.parseInt(args[2]);

        StdOut.print("Critical edge 1: ");
        DirectedEdge ce1 = ex37.getCriticalEdge(G, source1, target1);
        if (ce1 == null){
            StdOut.println("There is no path from " + source1 + " to " + 
                    target1);
        } else {
            StdOut.println(ce1);
        }
        StdOut.println();
    }


}
