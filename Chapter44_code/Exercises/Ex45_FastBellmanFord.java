import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import java.util.ArrayList;


public class Ex45_FastBellmanFord {
    // O(E + K * V) = O(E + V), since K is a constant, where K = max possible path length = maxWeight *(V-1)
    // Since there may be negative edge weights, a constant number of linear scans in the distances[] array may happen
    // and some vertices may be relaxed more than once.
    // This leaves the algorithm runtime below linearithmic, but not necessarily linear.
    public class BellmanFordSPBoundedIntegerWeights {

        private int[] distTo;    // length of path to vertex
        private DirectedEdge[] edgeTo; // last edge on path to vertex
        private int callsToRelax; // number of calls to relax()
        private Iterable<DirectedEdge> cycle; // If there is a negative cycle in edgeTo[], return it

        // The possible path distances are in the range[-maxWeight*(V-1),...,maxWeight*(V-1)]
        // because the maximum number of edges in any path is V-1.
        // We cannot use negative indexes in any array, so we add maxWeight*(V-1) to each index,
        // to be able to index all the distances.
        private ArrayList<Integer>[] distances; // Theoretically, an array of HashSets would be faster, but in practice an array of ArrayLists has proven to be faster in this case.

        private int maxPathDistance;

        public BellmanFordSPBoundedIntegerWeights(EdgeWeightedDigraph G, int source,  int maxWeight)
        {
            distTo = new int[G.V()];
            edgeTo = new DirectedEdge[G.V()];

            maxPathDistance = maxWeight * (G.V()-1);
            distances = (ArrayList<Integer>[])new ArrayList[maxPathDistance*2+1];

            for (int distance = 0; distance < distances.length; distance++){
                distances[distance] = new ArrayList<>();
            }
            for (int  v = 0; v < G.V(); v++){
                distTo[v] = Integer.MAX_VALUE;
            }
            distTo[source] = 0;
            // using 0 + maxPathDistance for readability: we always add maxPathDistance to indexes in distances[] because of possible negative distances
            distances[0 + maxPathDistance].add(source);
            int lastComputedShortestDistance = 0 + maxPathDistance;

            while (!hasNegativeCycle()){
                int nextVertexToRelax = getShortestDistanceVertex(lastComputedShortestDistance);

                if (nextVertexToRelax == -1){
                    // All shortest distances have been found
                    break;
                }
                lastComputedShortestDistance = relax(G, nextVertexToRelax);
            }
        }
        // Total runtime in the entire algorithm of (O(v*K)), where K = max possible path length
        // Does a linear scan to find the next closest vertex, but keeps track of the position of the last vertex found
        // to do a constant number of scans in the distacnes[] array during the entire algorithm
        private int getShortestDistanceVertex(int lastComputedShortestDistance){
            while (distances[lastComputedShortestDistance].isEmpty()){
                lastComputedShortestDistance++;
                if (lastComputedShortestDistance == distances.length){
                    return -1;
                }
            }
            Integer vertexToRemove = distances[lastComputedShortestDistance].get(0);
            distances[lastComputedShortestDistance].remove(vertexToRemove);

            return vertexToRemove;


        }

        // Total runtime in the entire algorithm is ~E
        // Cannot guarantee E because a vertex may be relaxed more than once if a new shortest-path to it is found
        // due to negative edge weights
        private int relax(EdgeWeightedDigraph G, int v){
            int lastComputedShortestDistance = distTo[v] + maxPathDistance;

            for (DirectedEdge e : G.adj(v)){
                Integer neighbor = e.to();
                if (distTo[neighbor] > distTo[v] + e.weight()){
                    if (hasPathTo(neighbor)){
                        int distancesIndex = distTo[neighbor] + maxPathDistance;
                        distances[distancesIndex].remove(neighbor);
                    }
                    distTo[neighbor] = distTo[v] + (int)e.weight();
                    edgeTo[neighbor] = e;

                    int distancesIndex = distTo[neighbor] + maxPathDistance;
                    distances[distancesIndex].add(neighbor);
                    if (distTo[neighbor] + maxPathDistance < lastComputedShortestDistance){
                        lastComputedShortestDistance = distTo[neighbor] + maxPathDistance;
                    }
                }

                if (callsToRelax++ % G.V() == 0){
                    findNegativeCycle();
                }
            }
            return lastComputedShortestDistance;
        }

        public int distTo(int vertex){
            return distTo[vertex];
        }
        public boolean hasPathTo(int v){
            return distTo[v] != Integer.MAX_VALUE;
        }
        public Iterable<DirectedEdge> pathTo(int v){
            if (!hasPathTo(v)){
                return null;
            }
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            {
                path.push(e);
            }
            return path;

        }
        private void findNegativeCycle(){
            int vertices = edgeTo.length;
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(vertices);

            for (int v = 0; v < vertices; v++){
                if (edgeTo[v] != null)
                    G.addEdge(edgeTo[v]);
            }
            EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
            cycle = finder.cycle();
        }
        public boolean hasNegativeCycle(){
            return cycle != null;
        }
        public Iterable<DirectedEdge> negativeCycle(){
            return cycle;
        }

    }
    private void printShortestPathsTree(EdgeWeightedDigraph G, 
            BellmanFordSPBoundedIntegerWeights sp, int s){
        for (int v = 0; v < G.V(); v++){
            if (sp.hasPathTo(v)){
                StdOut.printf("%d to %d (%d)  ", s, v, sp.distTo(v));

                for (DirectedEdge e : sp.pathTo(v)){
                    StdOut.print(e + " ");
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d   no path\n", s, v);
            }
        }
    }
    public static void main(String[] args){
        Ex45_FastBellmanFord ex45 = new
            Ex45_FastBellmanFord();
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        int maxWeight = Integer.parseInt(args[2]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        BellmanFordSPBoundedIntegerWeights sp = ex45.new
            BellmanFordSPBoundedIntegerWeights(G, s, maxWeight);

        StdOut.println("shortest paths tree: ");
        ex45.printShortestPathsTree(G, sp, s);
        StdOut.println();
    }
}


