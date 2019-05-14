import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class TransitiveClosure {
    private DirectedDFS[] all;
    TransitiveClosure(Digraph G)
    {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++)
            all[v] = new DirectedDFS(G, v);
    }
    public boolean reachable(int v, int w)
    { 
        validateVertex(v);
        validateVertex(w);
        return all[v].marked(w); 
    }
    private void validateVertex(int v) {
        int V = all.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + 
                    v + " is not between 0 and " + (V-1));
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        TransitiveClosure tc = new TransitiveClosure(G);

        // print header
        StdOut.print("     ");
        for (int v = 0; v < G.V(); v++)
            StdOut.printf("%3d", v);
        StdOut.println();
        StdOut.println("--------------------------------------------");

        // print transitive closure
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%3d: ", v);
            for (int w = 0; w < G.V(); w++){
                if (tc.reachable(v,w)) StdOut.printf("  T");
                else    StdOut.printf("   ");
            }
            StdOut.println();
        }
    }
}
