import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;



public class Ex34_MonotonicShortestPath {

    public class Path /*implements Comparable<Path>*/ {
        private double weight;
        private DirectedEdge lastEdge;

        Path(double weight, DirectedEdge lastEdge){
            this.weight = weight;
            this.lastEdge = lastEdge;
        }
        public double weight(){
            return weight;
        }
        public DirectedEdge lastEdge(){
            return lastEdge;
        }
        /*
        @Override
        public int compareTo(Path path){
            if (this.weight > path.weight)
                return 1;
            if (this.weight < path.weight)
                return -1;
            if (this.weight == path.weight)
                return 0;
        }
        */
    }
    public class VertexInformation {
        private DirectedEdge[] edges;
        private int currentEdgeIteratorPosition;

        VertexInformation(DirectedEdge[] edges){
            this.edges = edges;
            this.currentEdgeIteratorPosition = 0;
        }
        public void incrementEdgeIteratorPosition(){
            currentEdgeIteratorPosition++;
        }
        public DirectedEdge[] getEdges(){
            return edges;
        }
        public int getCurrentEdgeIteratorPosition(){
            return currentEdgeIteratorPosition;
        }
    }

    public class DijkstraMonotonicSP {
        private double[] distTo;    // length of path to vertex
        private DirectedEdge[] edgeTo;   // last edge on path to vertex
        
        private double[] distToMonotonicAscending;  // length of monotonic
                                                    // ascending path to vertex
        private DirectedEdge[] edgeToMonotonicAscending;// last edge on monotonic ascending path to vertex

        private double[] distToMonotonicDescending; // length of monotonic descending path to vertex
        private DirectedEdge[] edgeToMonotonicDescending; // last edge on monotonic descending path to vertex

        // O(E lg E)
        // If negative edge weights are present, still works but become O(2^V)
        public DijkstraMonotonicSP(EdgeWeightedDigraph G, int source){
            distToMonotonicAscending = new double[G.V()];
            distToMonotonicDescending = new double[G.V()];
            distTo = new double[G.V()];

            edgeToMonotonicAscending = new DirectedEdge[G.V()];
            edgeToMonotonicDescending = new DirectedEdge[G.V()];
            edgeTo = new DirectedEdge[G.V()];

            for (int v = 0; v < G.V(); v++){
                distTo[v] = Double.POSITIVE_INFINITY;
                distToMonotonicAscending[v] = Double.POSITIVE_INFINITY;
                distToMonotonicDescending[v] = Double.POSITIVE_INFINITY;
            }
            // Relax edges in ascending order to get a monotonic increasing shortest path
            Comparator<DirectedEdge> edgesComparator = new Comparator<DirectedEdge>(){
                @Override
                public int compare(DirectedEdge e1, DirectedEdge e2){
                    if (e1.weight() > e2.weight()){
                        return -1;
                    } else if (e1.weight() < e2.weight()){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            };

            relaxAllEdgesInSpecificOrder(G, source, edgesComparator, distToMonotonicAscending, edgeToMonotonicAscending, true);

            // Relax edges in descending order to get a monotonic decreasing shortest path
            edgesComparator = new Comparator<DirectedEdge>(){
                @Override
                public int compare(DirectedEdge e1, DirectedEdge e2){
                    if (e1.weight() < e2.weight()){
                        return -1;
                    } else if (e1.weight() > e2.weight()){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            };
            relaxAllEdgesInSpecificOrder(G, source, edgesComparator, 
                    distToMonotonicDescending, edgeToMonotonicDescending, true);

            // compare distances to get the shortest monotonic path
            compareMonotonicPathsAndComputeShortest();
        }
        private void relaxAllEdgesInSpecificOrder(EdgeWeightedDigraph G, int source, Comparator<DirectedEdge> edgesComparator, double[] distToVertex,
                DirectedEdge[] edgeToVertex, boolean isAscendingOrder){
            // Create a map with vertices as keys and sorted outgoing edges as values
            SeparateChainingHashST<Integer, VertexInformation> verticesInformation = new SeparateChainingHashST<>();
            for (int v = 0; v < G.V(); v++){
                DirectedEdge[] edges = new DirectedEdge[G.outdegree(v)];
                int edgeIndex = 0;
                for (DirectedEdge e : G.adj(v)){
                    edges[edgeIndex++] = e;
                }
                Arrays.sort(edges, edgesComparator);

                verticesInformation.put(v, new VertexInformation(edges));
            }
            PriorityQueue<Path> pq = new PriorityQueue<>(new Comparator<Path>(){
                @Override
                public int compare(Path p1, Path p2){
                    if (p1.weight() < p2.weight()){
                        return -1;

                    } else if (p1.weight() > p2.weight()){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            distToVertex[source] = 0;

            VertexInformation sourceVertexInformation = 
                verticesInformation.get(source);
            while (sourceVertexInformation.currentEdgeIteratorPosition <
                    sourceVertexInformation.getEdges().length){
                DirectedEdge edge = sourceVertexInformation.getEdges()[sourceVertexInformation.getCurrentEdgeIteratorPosition()];
                sourceVertexInformation.incrementEdgeIteratorPosition();
                Path path = new Path(edge.weight(), edge);
                pq.offer(path);
                    }
            while (!pq.isEmpty()){
                Path currentShortestPath = pq.poll();
                DirectedEdge currentEdge = currentShortestPath.lastEdge();
                int nextVertexInPath = currentEdge.to();
                VertexInformation nextVertexInformation = verticesInformation.get(nextVertexInPath);
                double weightInPreviousEdge = currentEdge.weight();

                while (nextVertexInformation.getCurrentEdgeIteratorPosition() < nextVertexInformation.getEdges().length){
                    DirectedEdge edge = 
                        verticesInformation.get(nextVertexInPath).getEdges()[nextVertexInformation.getCurrentEdgeIteratorPosition()];
                    if ((isAscendingOrder && edge.weight() <= weightInPreviousEdge) || (!isAscendingOrder && edge.weight() >= weightInPreviousEdge)){
                        break;
                    }
                    nextVertexInformation.incrementEdgeIteratorPosition();
                    edgeToVertex[nextVertexInPath] = currentShortestPath.lastEdge();
                    distToVertex[nextVertexInPath] = currentShortestPath.weight();
                    Path path = new Path(currentShortestPath.weight() + edge.weight(), edge);
                    pq.offer(path);
                }
                if (edgeToVertex[nextVertexInPath] == null){
                    edgeToVertex[nextVertexInPath] = currentEdge;
                    distToVertex[nextVertexInPath] = currentShortestPath.weight();
                }
            }
        }
        private void compareMonotonicPathsAndComputeShortest(){
            for (int v = 0; v < edgeTo.length; v++){
                if (distToMonotonicAscending[v] <= distToMonotonicDescending[v]){
                    distTo[v] = distToMonotonicAscending[v];
                    edgeTo[v] = edgeToMonotonicAscending[v];
                } else {
                    distTo[v] = distToMonotonicDescending[v];
                    distTo[v] = distToMonotonicDescending[v];
                }
            }
        }
        public double distTo(int v){
            return distTo[v];
        }
        public boolean hasPathTo(int v){
            return distTo[v] != Double.POSITIVE_INFINITY;
        }
        public Iterable<DirectedEdge> pathTo(int v){
            if (!hasPathTo(v)){
                return null;
            }
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
                path.push(e);
            }
            return path;
        }

    }

    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        DijkstraMonotonicSP sp1 = new
            Ex34_MonotonicShortestPath().new DijkstraMonotonicSP(G,0);
        StdOut.println("Monotonic shortest paths 1: ");
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.print("Path from vertex 0 to vertex " + v + ":  ");
            if (sp1.hasPathTo(v)){
                for (DirectedEdge e : sp1.pathTo(v)){
                    StdOut.print(e + " ");
                }
            } else {
                StdOut.print("There is no monotonic path to vertex " + v);
            }
            StdOut.println();
        }

    }
}
