import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;

public class Ex4_1_10 {
    private boolean[] marked;
    private int s;    // source
    private Bag<Integer> Removed;

    public Ex4_1_10(Graph G, int s){
        marked = new boolean[G.V()];
        this.s = s;
        Removed = new Bag<>();
    }

    public Bag<Integer> isRemoved(Graph G, int s) {
        this.s = s;
        dfs(G, s);
        return Removed;
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        boolean beRemoved = true;
        for (int w : G.adj(v)) {
            if (!marked[w]){
                beRemoved = false;
                dfs(G, w);
            }
        }
        if (beRemoved == true)
            Removed.add(v);
        
    }
    public static void main(String[] args) {
        Graph G  = new Graph(new In(args[0]));
        Ex4_1_10 tool = new Ex4_1_10(G, 0);
        StdOut.println(G);
        Bag<Integer> bag = tool.isRemoved(G, 0);
        for (int v : bag)
            StdOut.println("v " + v + " can be removed. " );
        
    }
}
