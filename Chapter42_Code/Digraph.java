import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;


public class Digraph 
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private int[] indegree; // indegree[v] = indegree of vertex v

    public Digraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        indegree = new int[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }
    public Digraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    public Digraph(Digraph G) 
    {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++)
            this.indegree[v] = G.indegree(v);
        for (int v = 0; v < G.V(); v++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]){
                reverse.push(w);
            }
            for (int w : reverse){
                adj[v].add(w);
            }
        }

    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w)
    {
        /*
        //disallow parallel edges and self-loops.
        if (hasEdge(v, w) || v == w)
            return;
        */
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    public boolean hasEdge(int v, int w) {
        for (int n : adj[v]){
            if (n == w)
                return true;
        }
        return false;
        
    }
    public int outdegree(int v) {
        return adj[v].size();
    }
    public int indegree(int v) {
        return indegree[v];
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
    public String toString()
    {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++)
        {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph DG = new Digraph(in);

        StdOut.println("Print Digraph: ");
        StdOut.println(DG);
    }
}
