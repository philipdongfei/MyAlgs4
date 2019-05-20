import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;


public class PrimMST
{
    private Edge[] edgeTo;  // shortest edge from tree vertex
    private double[] distTo;    // distTo[w] = edgeTo[w].weight()
    private boolean[] marked;   // true if v on tree
    private IndexMinPQ<Double> pq; // eligible crossing edges
    
    public PrimMST(EdgeWeightedGraph G)
    {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<Double>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0); //Initialize pq with 0, weight 0.0
        while (!pq.isEmpty())
            visit(G, pq.delMin()); // Add closest vertex to tree.
    }
    private void visit(EdgeWeightedGraph G, int v)
    {// Add v to tree; update data structrues.
        marked[v] = true;
        for (Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (marked[w]) continue; // v-w is ineligible.
            if (e.weight() < distTo[w])
            {// Edge e is new best connection from tree to w.
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else    pq.insert(w, distTo[w]);
            }
        }
    }
    public Iterable<Edge> edges()
    {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++){
            Edge e = edgeTo[v];
            if (e != null)
                mst.enqueue(e);
        }
        return mst;

    }
    public double weight()
    {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()){
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
