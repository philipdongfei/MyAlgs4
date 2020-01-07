import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Graph;

public class LongestPath {
    private boolean[] marked;
    private int max;

    public LongestPath(Graph G, int s, int t)
    {
        marked = new boolean[G.V()];
        dfs(G, s, t, 0);
    }

    private void dfs(Graph G, int v, int t, int i)
    {
        if (v == t && i > max) max = i;
        if (v == t) return;
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w, t, i+1);
        marked[v] = false;
    }
    public int maxLength()
    { return max; }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = 0; 
        int t = G.V() - 1; 
        LongestPath lp = new LongestPath(G, s, t);

        StdOut.println("Graph: ");
        StdOut.println(G);
        StdOut.println("Longest path " + s + " to " + t);
        StdOut.println("Longest path value = " + lp.maxLength());

    }
}
