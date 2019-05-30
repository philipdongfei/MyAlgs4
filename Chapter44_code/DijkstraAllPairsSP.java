import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraAllPairsSP
{
    private DijkstraSP[] all;
    DijkstraAllPairsSP(EdgeWeightedDigraph G)
    {
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++)
            all[v] = new DijkstraSP(G, v);
    }
    Iterable<DirectedEdge> path(int s, int t)
    { return all[s].pathTo(t); }
    double dist(int s, int t)
    { return all[s].distTo(t); }
    boolean hasPathTo(int s, int t)
    { return all[s].distTo(t) < Double.POSITIVE_INFINITY; }

    public static void main(String[] args){
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        int t = Integer.parseInt(args[2]);
        DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
        StdOut.print(s + " to " + t);
        StdOut.printf(" (%4.2f): ", sp.dist(s, t));
        if (sp.hasPathTo(s, t))
            for (DirectedEdge e : sp.path(s, t))
                    StdOut.print(e + "  ");
        StdOut.println();
    }

}
