import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;



public class Ex36_Neighbors {
    public class DijkstraSPMaxDistance {
        private DirectedEdge[] edgeTo; // last edge on path to vertex
        private double[] distTo;  // length of path to vertex
        private IndexMinPQ<Double> pq;

        public DijkstraSPMaxDistance(EdgeWeightedDigraph G, int source, int maxDistance){
            edgeTo = new DirectedEdge[G.V()];
            distTo = new double[G.V()];
            pq = new IndexMinPQ<>(G.V());

            for (int v = 0; v < G.V(); v++){
                distTo[v] = Double.POSITIVE_INFINITY;
            }
            distTo[source] = 0;
            pq.insert(source, 0.0);

            while (!pq.isEmpty()){
                relax(G, pq.delMin(), maxDistance);
            }
        }
        private void relax(EdgeWeightedDigraph G, int v, int maxDistance){
            for (DirectedEdge e : G.adj(v)){
                int neighbor = e.to();
                if (distTo[neighbor] > distTo[v] + e.weight()
                        && distTo[v] + e.weight()  <= maxDistance){
                    distTo[neighbor] = distTo[v] + e.weight();
                    edgeTo[neighbor] = e;

                    if (pq.contains(neighbor)){
                        pq.change(neighbor, distTo[neighbor]);

                    } else {
                        pq.insert(neighbor, distTo[neighbor]);
                    }

                        }
            }
        }
        public double distTo(int v){
            return distTo[v];
        }
        public DirectedEdge edgeTo(int v){
            return edgeTo[v];
        }
        public boolean hasPathTo(int v){
            return distTo[v] < Double.POSITIVE_INFINITY;
        }
        public SET<Integer> verticesWithinMaxDistance(){
            SET<Integer> verticesWithinMaxDistance = new
                SET<>();
            for (int v = 0; v < distTo.length; v++){
                if (hasPathTo(v)){
                    verticesWithinMaxDistance.add(v);
                }
            }
            return verticesWithinMaxDistance;
        }
        public Iterable<DirectedEdge> pathTo(int v){
            if (!hasPathTo(v)){
                return null;
            }
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[v]; e != null;
                    e = edgeTo[e.from()]){
                path.push(e);
                    }
            return path;
        }

    }
    public static void main(String[] args){
        Ex36_Neighbors ex36 = new Ex36_Neighbors();
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int maxDistance1 = Integer.parseInt(args[1]);
        DijkstraSPMaxDistance sp1 = ex36.new 
            DijkstraSPMaxDistance(G, 0, maxDistance1);
        StdOut.println("Vertices within distance 20 from G: "
                );
        for (int v : sp1.verticesWithinMaxDistance()){
            StdOut.print(v + " ");
        }
        StdOut.println();
    }
}



