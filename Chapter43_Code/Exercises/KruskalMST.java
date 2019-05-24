import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.MinPQ;


public class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;    // weight of MST
    private Queue<Edge> mst = new Queue<Edge>(); // edges in MST

    public KruskalMST(EdgeWeightedGraph G) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()){
            pq.insert(e);
        }
        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)){ // v-w does not create a cycle
                uf.union(v, w); // merge v and w components
                mst.enqueue(e); // add edge e to mst
                weight += e.weight();
            }
        }
        assert check(G);
    }
    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
        return weight;
    }
    // check optimality conditions (takes time proportional to E V lg*V)
    private boolean check(EdgeWeightedGraph G){
        // check total weight
        double total = 0.0;
        for (Edge e : edges()){
            total += e.weight();
        }
        if (Math.abs(total-weight()) > FLOATING_POINT_EPSILON){
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
            return false;
        }
        // check that it is acyclic 
        UF uf = new UF(G.V());
        for (Edge e : edges()){
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)){
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }
        for (Edge e : G.edges()){
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)){
                System.err.println("Not a spanning forest");
                return false;
            }
        }
        for (Edge e : edges()){
            uf = new UF(G.V());
            for (Edge f : mst){
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }
            for (Edge f : G.edges()){
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)){
                    if (f.weight() < e.weight()){
                        System.err.println("Edge " + f + 
                                " violates cut optimality conditions");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()){
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
