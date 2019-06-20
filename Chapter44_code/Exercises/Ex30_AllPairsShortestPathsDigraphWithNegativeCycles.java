import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex30_AllPairsShortestPathsDigraphWithNegativeCycles {
    public interface AllPairsShortestPathsDigraphsWithoutNegativeCyclesInterface{
        Iterable<DirectedEdge> path(int source, int target);
        double dist(int source, int target);
        boolean hasPathTo(int source, int target);
    }

    public class AllPairsShortestPathsDigraphsWithoutNegativeCycles
            implements AllPairsShortestPathsDigraphsWithoutNegativeCyclesInterface {
            private double[][] distances;
            private DirectedEdge[][] edgeTo;

            AllPairsShortestPathsDigraphsWithoutNegativeCycles(EdgeWeightedDigraph edgeWeightedDigraph) {
                distances = new double[edgeWeightedDigraph.V()][edgeWeightedDigraph.V()];
                edgeTo = new DirectedEdge[edgeWeightedDigraph.V()][edgeWeightedDigraph.V()];
                double[] newWeight = new double[edgeWeightedDigraph.V()];

                // Initialize all distances to Double.POSITIVE_INFINITY
                for (int v = 0; v < edgeWeightedDigraph.V(); v++){
                    for (int neighbor = 0; neighbor < edgeWeightedDigraph.V(); neighbor++){
                        distances[v][neighbor] = Double.POSITIVE_INFINITY;
                    }
                }
                // Add a new vertex to the graph, connected all other vertices through edges of weight 0
                // O(V+E)
                EdgeWeightedDigraph edgeWeightedDigraphWithSource = new EdgeWeightedDigraph(edgeWeightedDigraph.V() + 1);
                for (int v = 0; v < edgeWeightedDigraph.V(); v++){
                    for (DirectedEdge edge : edgeWeightedDigraph.adj(v)){
                        edgeWeightedDigraphWithSource.addEdge(edge);
                    }
                }

                int newVertexId = edgeWeightedDigraph.V();
                for (int v = 0; v < edgeWeightedDigraph.V(); v++){
                    edgeWeightedDigraphWithSource.addEdge(new DirectedEdge(newVertexId, v, 0));

                }
                // Run Bellman-Ford to get the distances from the new vertex to every other vertex.
                // Also check if there is any negative cycle
                // O(V*E)
                BellmanFordSP bellmanfordsp = new BellmanFordSP(edgeWeightedDigraphWithSource, newVertexId);

                if (bellmanfordsp.hasNegativeCycle()){
                    throw new IllegalArgumentException("Graph has a negative cycle");
                }
                // Compute new weights, which are the distance from the new vertex to every other vertex 
                //O(V)
                for (int v = 0; v < edgeWeightedDigraph.V(); v++){
                    newWeight[v] = bellmanfordsp.distTo(v);
                }
                // Generate a new graph with the new weights
                // O(V+E)
                EdgeWeightedDigraph edgeWeightedDigraphWithNewWeights = new EdgeWeightedDigraph(edgeWeightedDigraph.V());
                for (int v = 0; v < edgeWeightedDigraph.V(); v++){
                    for (DirectedEdge e : edgeWeightedDigraph.adj(v)){
                        double edgeWeight = e.weight() + newWeight[e.from()] - newWeight[e.to()];
                        edgeWeightedDigraphWithNewWeights.addEdge(new DirectedEdge(e.from(), e.to(), edgeWeight));
                    }
                }
                // Run Dijkstra to compute all pairs shortest paths on the new graph.
                // Also compute the real all-pairs-shortest-path distancs by adjusting the new weights 
                // O(V*ElgV) + O(V^2) = O(V*ElgV)
                for (int source = 0; source < edgeWeightedDigraph.V(); source++)
                {
                    DijkstraSP  dijkstrasp = new DijkstraSP(edgeWeightedDigraphWithNewWeights, source);

                    for (int target = 0; target < edgeWeightedDigraph.V(); target++){
                        double realShortestPathDistance = dijkstrasp.distTo(target) - newWeight[source] + newWeight[target];
                        distances[source][target] = realShortestPathDistance;
                        DirectedEdge currentEdge = dijkstrasp.edgeTo(target);
                        if (currentEdge == null)
                            continue;

                        int vertexFrom = currentEdge.from();
                        int vertexTo = currentEdge.to();
                        double realWeight = currentEdge.weight() - newWeight[vertexFrom] + newWeight[vertexTo];

                        DirectedEdge realEdgeTo = new DirectedEdge(vertexFrom, vertexTo, realWeight);
                        edgeTo[source][target] = realEdgeTo;
                    }
                }
            }
            @Override
            public Iterable<DirectedEdge> path(int source, int target){
                if (!hasPathTo(source, target)){
                    return null;
                }
                Stack<DirectedEdge> path = new Stack<>();
                for (DirectedEdge e = edgeTo[source][target]; e != null;
                        e = edgeTo[source][e.from()]){
                    path.push(e);
                        }
                return path;
            }
            @Override
            public double dist(int source, int target){
                return distances[source][target];
            }

            @Override
            public boolean hasPathTo(int source, int target)
            {
                return distances[source][target] != 
                    Double.POSITIVE_INFINITY;
            }
    }

    public static void main(String[] args){
        Ex30_AllPairsShortestPathsDigraphWithNegativeCycles ex30 = 
            new Ex30_AllPairsShortestPathsDigraphWithNegativeCycles();

        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        AllPairsShortestPathsDigraphsWithoutNegativeCycles allpairsshortestpath = ex30.new AllPairsShortestPathsDigraphsWithoutNegativeCycles(G);

        for (int s = 0; s < G.V(); s++){
            for (int t = 0; t < G.V(); t++){
                StdOut.println("Distance from " + s + " to " + t + ": " +
                        allpairsshortestpath.dist(s, t));
            }
        }
        StdOut.println();

        for (int s = 0; s < G.V(); s++){
            for (int t = 0; t < G.V(); t++){
                StdOut.print("Shortest path from " + s + " to " + t + ": ");
                if (!allpairsshortestpath.hasPathTo(s, t)){
                    StdOut.println("No path exists");
                    continue;
                }
                for (DirectedEdge e : allpairsshortestpath.path(s, t)){
                    StdOut.print(e.from() + " -> " + e.to() + " (" + e.weight() + ") ");
                }
                StdOut.println();
            }
        }

    }

}
