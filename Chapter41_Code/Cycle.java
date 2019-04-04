import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Cycle
{
    private boolean[] marked;
    private boolean hasCycle = false;
    public Cycle(Graph G)
    {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s])
                dfs(G, s, s);
    }
    private void dfs(Graph G, int v, int u)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u)// check for cycle (but disregard reverse of edge leading to v) 
                hasCycle = true;
    }
    public boolean hasCycle()
    { return hasCycle; }
    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        Cycle finder = new Cycle(G);
        if (finder.hasCycle()){
            StdOut.println("Graph has cycle");
        } else {
            StdOut.println("Graph is acyclic");
        }
    }
}
