import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;


public class KosarajuSharirPreorderSCC
{
    private boolean[] marked;    // reached vertices
    private int[] id;   // component identifiers
    private int count;      // number of strong components

    public KosarajuSharirPreorderSCC(Digraph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s : order.pre())
            if (!marked[s]) {
                dfs(G,s); count++;
            }

    }
    private void dfs(Digraph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }
    public boolean stronglyConnected(int v, int w)
    {
        return id[v] == id[w];
    }
    public int id(int v)
    {
        return id[v];
    }
    public int count()
    {
        return count;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        KosarajuSharirPreorderSCC scc = new KosarajuSharirPreorderSCC(G);

        // number of connected components
        int m = scc.count();
        StdOut.println(m + " strong components");

        // compute list of vertices in each strong component
        Queue<Integer>[] components = (Queue<Integer>[])new Queue[m];
        for (int i = 0; i < m; i++){
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++)
            components[scc.id(v)].enqueue(v);

        for (int i = 0; i < m; i++){
            for (int v : components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
        
        StdOut.println();
        StdOut.println("G^R Digraph has the same strong components. ");
        KosarajuSharirPreorderSCC sccr = new KosarajuSharirPreorderSCC(G.reverse());

        // number of connected components
        m = sccr.count();
        StdOut.println(m + " strong components");

        // compute list of vertices in each strong component
        Queue<Integer>[] components_r = (Queue<Integer>[])new Queue[m];
        for (int i = 0; i < m; i++){
            components_r[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++)
            components_r[sccr.id(v)].enqueue(v);

        for (int i = 0; i < m; i++){
            for (int v : components_r[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
