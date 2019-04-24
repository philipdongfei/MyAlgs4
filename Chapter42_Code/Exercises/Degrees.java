import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;


public class Degrees
{
    private int V;
    private int E;
    private Digraph G;
    private Bag<Integer> sources;
    private Bag<Integer> sinks;
    private boolean isMap;

    public Degrees(Digraph G){
        this.G = G;
        this.V = G.V();
        this.E = G.E();
        sources = new Bag<Integer>();
        sinks = new Bag<Integer>();

        isMap = true;
        for (int v = 0; v < V; v++){
            int outdegree = G.outdegree(v);
            if (outdegree == 0)
                sinks.add(v);
            if (isMap == true && outdegree != 1)
                isMap = false;
            if (G.indegree(v) == 0)
                sources.add(v);
        }

    }
    public int indegree(int v) {
        return G.indegree(v);
    }
    public int outdegree(int v) {
        return G.outdegree(v);
    }
    public Iterable<Integer> sources(){
        return sources;
    }
    public Iterable<Integer> sinks(){
        return sinks;
    }
    public boolean isMap(){
        return isMap;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph DG = new Digraph(in);
        StdOut.println(DG);
        Degrees deg = new Degrees(DG);


        StdOut.println("indegree: ");
        for (int v = 0; v < DG.V(); v++){
            StdOut.println(v + " indegree: " + deg.indegree(v));
            StdOut.println(v + " outdegree: " + deg.outdegree(v));
        }
        StdOut.println("sources: ");
        for (int v : deg.sources() )
            StdOut.print(v + " ");
        StdOut.println();

        StdOut.println("sinks: ");
        for (int v : deg.sinks())
            StdOut.print(v + " ");
        StdOut.println();
        StdOut.println("isMap: " + deg.isMap());
    }
}
