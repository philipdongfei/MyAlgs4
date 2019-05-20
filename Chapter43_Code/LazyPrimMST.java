import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.MinPQ;


public class LazyPrimMST {
    private boolean[] marked;  // MST vertices
    private Queue<Edge> mst;   // MST edges
    private MinPQ<Edge> pq;    // crossing (and ineligible) edges
    private double weight;

    public LazyPrimMST(EdgeWeightedGraph G)
    {
        weight = 0;
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();

        visit(G, 0);  // assumes G is connected ()
        while (!pq.isEmpty())
        {
            Edge e = pq.delMin();   // Get lowest-weight
            int v = e.either(), w = e.other(v);  // edge from pq
            if (marked[v] && marked[w]) continue;  // skip if ineligible
            mst.enqueue(e);     // Add edge to tree
            weight += e.weight();
            if (!marked[v]) visit(G, v);        // add vertex to tree
            if (!marked[w]) visit(G, w);   // (either v or w).
        }
    }
    private void visit(EdgeWeightedGraph G, int v)
    { // Mark v and add to pq all edges from v to unmarked vertices.
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);

    }
    public Iterable<Edge> edges()
    { return mst; }
    public double weight()
    {
        return weight;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()){
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
