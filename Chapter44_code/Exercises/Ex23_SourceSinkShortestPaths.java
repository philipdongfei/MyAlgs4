import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;


public class Ex23_SourceSinkShortestPaths {

    public interface DijkstraSPSourceSinkAPI{
        double distToTarget();
        boolean hasPathToTarget();
        Iterable<DirectedEdge> pathToTarget();
    }
    public class DijkstraSPSourceSink implements DijkstraSPSourceSinkAPI {
        private DirectedEdge[] edgeTo; 
        private double[] distTo; 
        private IndexMinPQ<Double> pq;
        private int target;

        public DijkstraSPSourceSink(EdgeWeightedDigraph G, int s, int t){
            edgeTo = new DirectedEdge[G.V()];
            distTo = new double[G.V()];
            pq = new IndexMinPQ<Double>(G.V());
            this.target = t;

            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;
            distTo[s] = 0;
            pq.insert(s, 0.0);
            while (!pq.isEmpty()){
                int v = pq.delMin();
                relax(G, v);
                if (v == target)
                    break;
            }
        }
        private void relax(EdgeWeightedDigraph G, int v)
        {
            for (DirectedEdge e : G.adj(v))
            {
                int w = e.to();
                if (distTo[w] > distTo[v] + e.weight())
                {
                    distTo[w] = distTo[v] + e.weight();
                    edgeTo[w] = e;
                    if (pq.contains(w)){
                        pq.change(w, distTo[w]);
                    } else {
                        pq.insert(w, distTo[w]);
                    }
                }
            }
        }
        @Override
        public double distToTarget(){
            return distTo[target];
        }
        @Override
        public boolean hasPathToTarget(){
            return distTo[target] < Double.POSITIVE_INFINITY;
        }
        @Override
        public Iterable<DirectedEdge> pathToTarget(){
            if (!hasPathToTarget())
                return null;
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge edge = edgeTo[target]; edge != null; 
                    edge = edgeTo[edge.from()])
                path.push(edge);
            return path;
        }

    }
    public static void main(String[] args){
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        int t = Integer.parseInt(args[2]);

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        DijkstraSPSourceSink spss = 
            new Ex23_SourceSinkShortestPaths().new DijkstraSPSourceSink(
                    G, s, t
                    );
        StdOut.println("Path " + s + " to " + t + ": ");
        for (DirectedEdge e : spss.pathToTarget())
            StdOut.print(e + " ");
        StdOut.println();
    }
}
