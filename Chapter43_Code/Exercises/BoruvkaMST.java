import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Bag;


public class BoruvkaMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private Bag<Edge> mst = new Bag<Edge>(); // edges in MST
    private double weight;  // weight of MST
    
    public BoruvkaMST(EdgeWeightedGraph G){
        UF uf = new UF(G.V());

        // repeat at most log V times or until we have V-1 edges
        for (int t = 1; t < G.V() && mst.size() < G.V() - 1; t = t + t){
            // foreach tree in forest, find closest edge
            // if edge weights are equal, ties are broken in favor of first edge in G.edges()
            Edge[] closest = new Edge[G.V()];
            for (Edge e : G.edges()){
                int v = e.either(), w = e.other(v);
                int i = uf.find(v), j = uf.find(w);
                if (i == j) continue;
                if (closest[i] == null || less(e, closest[i])) closest[i] = e;
                if (closest[j] == null || less(e, closest[j]))
                    closest[j] = e;
            }
            // add newly discovered edges to MST
            for (int i = 0; i < G.V(); i++){
                Edge e = closest[i];
                if (e != null){
                    int v = e.either(), w = e.other(v);
                    // don't add the same edge twice
                    if (!uf.connected(v, w)){
                        mst.add(e);
                        weight += e.weight();
                        uf.union(v, w);
                    }
                }
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
    private static boolean less(Edge e, Edge f){
        return e.weight() < f.weight();
    }
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
        BoruvkaMST mst = new BoruvkaMST(G);
        for (Edge e : mst.edges())
            StdOut.println(e);
        StdOut.printf("%.5f\n", mst.weight());
    }

}
