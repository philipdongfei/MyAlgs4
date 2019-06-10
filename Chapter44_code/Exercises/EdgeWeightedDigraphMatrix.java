import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDigraphMatrix
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;    // number of vertices
    private int E;      // number of edges
    //private Bag<DirectedEdge>[] adj;    // adjacency lists
    private double[][] adj; //adjacency matrix that stores the edge weights
                            //adjacency[i][j] = Double.POSITIVE_INFINITY if there is no direct edge
                            //between vertex i and vertex j
    
    public EdgeWeightedDigraphMatrix(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new double[V][V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new double[V];
            for (int w = 0; w < V; w++)
            {
                adj[v][w] = Double.POSITIVE_INFINITY;
            }


        }
    }
    public EdgeWeightedDigraphMatrix(In in)
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
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(DirectedEdge e)
    {
        int s = e.from();
        int t = e.to(); 
        if (hasEdge(s, t)){
            return;
        }
        adj[s][t] = e.weight();;
        E++;
    }
    public boolean hasEdge(int s, int t){
        return adj[s][t] != Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> adj(int v)
    { 
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int i = 0; i < adj.length; i++){
            if (hasEdge(v, i)){
                bag.add(new DirectedEdge(v, i, adj[v][i]));
            }
        }
        return bag;
    }
    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> b = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj(v))
                b.add(e);
        return b;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(v + ": ");
            for (DirectedEdge e : adj(v)){
                s.append(e + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedDigraphMatrix G = new EdgeWeightedDigraphMatrix(in);
        StdOut.println(G);
    }
}
