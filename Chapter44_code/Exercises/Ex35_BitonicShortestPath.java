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
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Ex35_BitonicShortestPath {
    public class Path implements Comparable<Path> {
        private Path previousPath;
        private DirectedEdge directedEdge;
        private double weight;
        private boolean isDescending;
        private int numberOfEdges;

        Path(DirectedEdge edge){
            this.directedEdge = edge;
            weight = edge.weight();
            numberOfEdges = 1;
        }
        Path(Path previousPath, DirectedEdge edge){
            this(edge);
            this.previousPath = previousPath;

            weight += previousPath.weight();
            numberOfEdges += previousPath.numberOfEdges;

            if (previousPath != null && previousPath.directedEdge.weight() > directedEdge.weight()){
                isDescending = true;
            }
        }
        public double weight(){
            return weight;
        }
        public boolean isDescending(){
            return isDescending;
        }
        public int numberOfEdges(){
            return numberOfEdges;
        }
        public Iterable<DirectedEdge> getPath(){
            LinkedList<DirectedEdge> path = new LinkedList<>();
            Path iterator = previousPath;

            while (iterator != null && iterator.directedEdge != null) {
                path.addFirst(iterator.directedEdge);
                iterator = iterator.previousPath;
            }
            path.add(directedEdge);
            return path;
        }
        @Override
        public int compareTo(Path other){
            if (this.weight < other.weight){
                return -1;
            } else if (this.weight > other.weight){
                return 1;
            } else {
                return 0;
            }
        }
    }
    public class VertexInformation {
        private DirectedEdge[] edges;
        private int edgeIteratorPosition;

        VertexInformation(DirectedEdge[] edges){
            this.edges = edges;
            edgeIteratorPosition = 0;
        }
        public void incrementEdgeIteratorPosition(){
            edgeIteratorPosition++;
        }
        public DirectedEdge[] getEdges(){
            return edges;
        }
        public int getEdgeIteratorPosition(){
            return edgeIteratorPosition;
        }
    }

    public class BitonicSP {
        private Path[] bitonicPathTo; // bitonic path to vertex

        // O(p lg P), where P is the number of paths in the digraph
        // Includes optimization to prune paths that are not bitonic, ie. ascending + descending + ascending
        // or descending + ascending
        public BitonicSP(EdgeWeightedDigraph G, int source){
            bitonicPathTo = new Path[G.V()];
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

            List<Path> allCurrentPaths = new ArrayList<>();

            relaxAllEdgesInSpecificOrder(G, source, edgesComparator, 
                    allCurrentPaths, true);

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
                    allCurrentPaths, false);

        }

        private void relaxAllEdgesInSpecificOrder(EdgeWeightedDigraph G, 
                int source, Comparator<DirectedEdge> edgesComparator, 
                List<Path> allCurrentPaths, boolean isAscendingOrder){
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
            PriorityQueueResize<Path> pq = new PriorityQueueResize(PriorityQueueResize.Orientation.MIN);

            // If we are relaxing edges for the first time, add the initial paths to the priority queue
            if (isAscendingOrder){
                VertexInformation sourceVertexInformation = 
                    verticesInformation.get(source);
                while (sourceVertexInformation.getEdgeIteratorPosition() <
                        sourceVertexInformation.getEdges().length){
                    DirectedEdge edge = sourceVertexInformation.getEdges()[sourceVertexInformation.getEdgeIteratorPosition()];
                    sourceVertexInformation.incrementEdgeIteratorPosition();
                    Path path = new Path(edge);
                    pq.insert(path);
                    allCurrentPaths.add(path);
                        }
            }
            // If we are relaxing edges for the second time, add all existing
            // ascending paths to the priority queue
            if (!allCurrentPaths.isEmpty()){
                for (Path currentPath : allCurrentPaths){
                    pq.insert(currentPath);
                }
            }
            while (!pq.isEmpty()){
                Path currentShortestPath = pq.deleteTop();
                DirectedEdge currentEdge = 
                    currentShortestPath.directedEdge;
                int nextVertexInPath = currentEdge.to();
                VertexInformation nextVertexInformation = 
                    verticesInformation.get(nextVertexInPath);

                //Edge case : a bitonic path consisting of 2 edges of the same weight.
                //s to v with only one edge is strictly increasing, v to t with only one edge is strictly decreasing
                boolean isEdgeCase = false;

                if (currentShortestPath.numberOfEdges() == 2
                        && currentEdge.weight() == currentShortestPath.previousPath.directedEdge.weight()){
                    isEdgeCase = true;
                        }
                if ((currentShortestPath.isDescending() || isEdgeCase)
                        && (currentShortestPath.weight() < bitonicPathDistTo(nextVertexInPath)
                            || bitonicPathTo[nextVertexInPath] == null)){
                    bitonicPathTo[nextVertexInPath] = currentShortestPath;
                            }
                double weightInPreviousEdge = currentEdge.weight();
                while (nextVertexInformation.getEdgeIteratorPosition() <
                        nextVertexInformation.getEdges().length){
                    DirectedEdge edge = 
                        verticesInformation.get(nextVertexInPath).getEdges()[nextVertexInformation.getEdgeIteratorPosition()];
                    boolean isEdgeInEdgeCase = currentShortestPath.numberOfEdges() == 1 && edge.weight() == weightInPreviousEdge;
                    if (!isEdgeInEdgeCase && ((isAscendingOrder && edge.weight() <= weightInPreviousEdge) || (!isAscendingOrder && edge.weight() >= weightInPreviousEdge))){
                        break;
                    }
                    nextVertexInformation.incrementEdgeIteratorPosition();
                    Path path = new Path(currentShortestPath, edge);
                    pq.insert(path);

                    // If we are relaxing edges for the first time, store the ascending paths so they can be further
                    // relaxed when computing the descending paths on the second relaxation
                    if (isAscendingOrder){
                        allCurrentPaths.add(path);
                    }
                        }
            }
        }
        public double bitonicPathDistTo(int v){
            if (hasBitonicPathTo(v)){
                return bitonicPathTo[v].weight();
            } else {
                return Double.POSITIVE_INFINITY;
            }
        }
        public boolean hasBitonicPathTo(int v){
            return bitonicPathTo[v] != null;
        }
        public Iterable<DirectedEdge> bitonicPathTo(int v){
            if (!hasBitonicPathTo(v)){
                return null;
            }
            return bitonicPathTo[v].getPath();
        }
    }

}
