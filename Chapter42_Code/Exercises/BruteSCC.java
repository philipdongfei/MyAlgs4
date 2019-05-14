import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


public class BruteSCC {
    private int count;  // number of strongly connected components
    private int[] id; // id[v] = id of strong component containing v

    public BruteSCC(Digraph G) {
        // initially each vertex is in its own component
        count = 0;
        id = new int[G.V()];
        for (int  v = 0; v < G.V(); v++)
            id[v] = v;

        // compute transitive closure
        TransitiveClosure tc = new TransitiveClosure(G);

        // if v and w are mutally reachable, assign v to w's component
        for (int v = 0; v < G.V(); v++)
            for (int w = 0; w < v; w++)
                if (tc.reachable(v, w) && tc.reachable(w,v))
                    id[v] = id[w];

        // compute number of strongly connected components
        for (int v = 0; v < G.V(); v++)
        {
            //StdOut.println("id[" + v + "]: " + id[v]);
            if(id[v] == v)
                 count++;
            //StdOut.println("count: " + count);

        }
    }

    // return the number of strongly connected components
    public int count() { return count; }

    // are v and w strongly connected?
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
    // in which strongly connected component is vertex v?
    public int id(int v) { return id[v]; }

    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        BruteSCC scc = new BruteSCC(G);

        // number of connected components
        int m = scc.count();
        StdOut.println(m + " components");
        StdOut.println(G.V() + " vertices");

        // compute list of vertices in each strong component
        Queue<Integer>[] components = (Queue<Integer>[])new Queue[G.V()];
        for (int i = 0; i < G.V() ; i++){
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++){
            StdOut.println("id(" + v + "): " + scc.id(v) );
            components[scc.id(v)].enqueue(v);
        }
        // print results
        for (int i = 0; i < G.V(); i++){
            for (int v : components[i]){
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
