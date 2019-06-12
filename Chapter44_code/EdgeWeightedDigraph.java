import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDigraph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;    // number of vertices
    private int E;      // number of edges
    private Bag<DirectedEdge>[] adj;    // adjacency lists
    
    public EdgeWeightedDigraph(int V)
    {
        StdOut.println("Init V = " + V);
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }
    public EdgeWeightedDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }
    public EdgeWeightedDigraph(In in, int dummyV)
    {
        this(in.readInt()+dummyV);
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }
    public EdgeWeightedDigraph(In in, double smallest)
    {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble() + smallest;
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(DirectedEdge e)
    {
        adj[e.from()].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v)
    { return adj[v]; }
    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> b = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj[v])
                b.add(e);
        return b;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]){
                s.append(e + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
