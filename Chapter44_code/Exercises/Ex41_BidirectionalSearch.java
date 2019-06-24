import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex41_BidirectionalSearch {
    public class DijkstraSPSourceSinkBidirectional{
        private DirectedEdge[] edgeToSource;// last edge on path from source to vertex
        private double[] distToSource; //length of path from source to vertex
        private boolean[] relaxedFromSource; // vertices that have been relaxed in SPT rooted at source

        private DirectedEdge[] edgeToTarget; // last edge on inverse path from target to vertex
        private double[] distToTarget; // length of inverse path from target to vertex
        private boolean[] relaxedFromTarget; // vertices that have been relaxed in SPT rooted at target

        private IndexMinPQ<Double> pq;

        public DijkstraSPSourceSinkBidirectional(EdgeWeightedDigraph G, int source, int target){
            edgeToSource = new DirectedEdge[G.V()];
            distToSource = new double[G.V()];
            relaxedFromSource = new boolean[G.V()];

            edgeToTarget = new DirectedEdge[G.V()];
            distToTarget = new double[G.V()];
            relaxedFromTarget = new boolean[G.V()];

            // Reverse digraph will be used to create the shortest-path-tree from the target vertex
            EdgeWeightedDigraph reverseG = new EdgeWeightedDigraph(G.V());
            for (int v = 0; v < G.V(); v++){
                for (DirectedEdge e : G.adj(v)){
                    reverseG.addEdge(new DirectedEdge(e.to(), e.from(), e.weight()));
                }
            }
            pq = new IndexMinPQ<>(G.V()*2);
            for(int v = 0; v < G.V(); v++){
                distToSource[v] = Double.POSITIVE_INFINITY;
                distToSource[v] = Double.POSITIVE_INFINITY;
            }
            distToSource[source] = 0;
            distToTarget[target] = 0;
            pq.insert(source, 0.0);

            // When inserting vertices from the target SPT in the priority queue use a different index to avoid
            // collision with vertices from the source SPT.
            pq.insert(target + G.V(), 0.0);

            while (!pq.isEmpty()){
                int nextVertexToRelax = pq.delMin();
                relax(G, reverseG, nextVertexToRelax);

                // If it is a vertex from the target SPT, find its original index
                if (nextVertexToRelax >= G.V()){
                    nextVertexToRelax -= G.V();
                }
                // combine shortest paths if there are shortest paths from source to vertex and from vertex to target
                if (relaxedFromSource[nextVertexToRelax] && relaxedFromTarget[nextVertexToRelax]){
                    computeShortestPath(G);
                    break;
                }
            }
        }
        // shortest-path distance calculation based on https://courses.csail.mit.edu/6.006/spring11/rec/rec16.pdf
        private void computeShortestPath(EdgeWeightedDigraph G){
            double shortestDistance = Double.POSITIVE_INFINITY;
            int intermediateVertex = -1;

            for (int v = 0; v < G.V(); v++){
                if (distToSource[v] + distToTarget[v] < shortestDistance){
                    shortestDistance = distToSource[v] + distToTarget[v];
                    intermediateVertex = v;
                }
            }
            for (DirectedEdge e = edgeToTarget[intermediateVertex]; 
                    e != null; e = edgeToTarget[e.from()]){
                distToSource[e.from()] = distToSource[e.to()] + e.weight();
                edgeToSource[e.from()] = new DirectedEdge(e.to(), e.from(),
                        e.weight());
                    }
        }

        private void relax(EdgeWeightedDigraph G, EdgeWeightedDigraph reverseG, int v){
            // shortest-path-tree from source
            if (v< G.V()){
                for (DirectedEdge e : G.adj(v)){
                    int neighbor = e.to();
                    if (distToSource[neighbor] > distToSource[v] + e.weight()){
                        distToSource[neighbor] = distToSource[v] + e.weight();
                        edgeToSource[neighbor] = e;
                        if (pq.contains(neighbor)){
                            pq.change(neighbor, distToSource[neighbor]);

                        } else {
                            pq.insert(neighbor, distToSource[neighbor]);
                        }
                    }
                }
                relaxedFromSource[v] = true;
            } else {
                // shortest-path-tree from target
                int originalVertexId = v - G.V();
                for (DirectedEdge e : reverseG.adj(originalVertexId)){
                    int neighbor = e.to();
                    if (distToTarget[neighbor] > distToTarget[originalVertexId] + e.weight()){
                        distToTarget[neighbor] = distToTarget[originalVertexId] + e.weight();
                        edgeToTarget[neighbor] = e;

                        if (pq.contains(v)){
                            pq.change(v, distToTarget[neighbor]);
                        }else {
                            pq.insert(v, distToTarget[neighbor]);
                        }
                    }
                }
                relaxedFromTarget[originalVertexId] = true;
            }
        }
        public double distTo(int v){
            return distToSource[v];
        }
        public DirectedEdge edgeTo(int v){
            return edgeToSource[v];
        }
        public boolean hasPathTo(int v){
            return distToSource[v] < Double.POSITIVE_INFINITY;
        }

        public Iterable<DirectedEdge> pathTo(int v){
            if (!hasPathTo(v)){
                return null;
            }
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeToSource[v]; e != null;
                    e = edgeToSource[e.from()]){
                path.push(e);
                    }
            return path;
        }
    }
    public static void main(String[] args){
        Ex41_BidirectionalSearch ex41 = new Ex41_BidirectionalSearch();

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));

        int source = Integer.parseInt(args[1]);
        int target = Integer.parseInt(args[2]);

        DijkstraSPSourceSinkBidirectional sp = ex41.new DijkstraSPSourceSinkBidirectional(G, source, target);

        StdOut.println("Shortest path from " + source + " to " + target +
                ": ");
        if (sp.hasPathTo(target)){
            StdOut.printf("%d to %d (%.2f)  ", source, target, 
                    sp.distTo(target));
            for (DirectedEdge e : sp.pathTo(target)){
                StdOut.print(e + "  ");
            }
            StdOut.println();
        } else {
            StdOut.printf("%d to %d    no path\n", source, target);
        }

    }
}
