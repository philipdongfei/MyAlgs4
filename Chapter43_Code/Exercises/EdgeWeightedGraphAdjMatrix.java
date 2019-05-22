import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraphAdjMatrix
{
    private final int V;    // number of vertices
    private int E;      // number of edges
    //private Bag<Edge>[] adj;    // adjacency lists
    private double[][] adjacent;  
    
    public EdgeWeightedGraphAdjMatrix(int V)
    {
        this.V = V;
        this.E = 0;
        adjacent = new double[V][V];
        for (int v1 = 0; v1 < V; v1++)
        {
            adjacent[v1] = new double[V];
            for (int v2 = 0; v2 < V; v2++)
            {
                adjacent[v1][v2] = Double.POSITIVE_INFINITY;

            }

        }
    }
    public EdgeWeightedGraphAdjMatrix(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }

    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(Edge e)
    {
        int v = e.either(), w = e.other(v);
        double weight = e.weight();
        if (adjacent[v][w] != Double.POSITIVE_INFINITY)
            return;
        adjacent[v][w] = weight;
        adjacent[w][v] = weight;
        E++;
    }
    public Iterable<Edge> adj(int v)
    { 
        Bag<Edge> adjEdges = new Bag<>();
        for (int i = 0; i < V; i++){
            if (adjacent[v][i] != Double.POSITIVE_INFINITY)
                adjEdges.add(new Edge(v, i, adjacent[v][i]));

        }
        return adjEdges; 
    }
    public Iterable<Edge> edges()
    {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj(v))
                if (e.other(v) > v) b.add(e);
        return b;
    }
}
