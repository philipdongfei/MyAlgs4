import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;


public class DirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;    // vertices on a cycle (if one exists)
    private boolean[] onStack;    // vertices on recursive call stack

    public DirectedCycle(Digraph G)
    {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (this.hasCycle()) return;
            else if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }

        }
        onStack[v] = false;
    }
    public boolean hasCycle()
    {
        return cycle != null;
    }
    public Iterable<Integer> cycle()
    { 
        return cycle;
    }
    // certify that digraph has a directed cycle if it reports one
    private boolean check() {
        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()){
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle())
                StdOut.print(v + " ");
            StdOut.println();
        }
        else
            StdOut.println("No directed cycle");
        StdOut.println("hasCycle: " + finder.hasCycle());
        StdOut.println();
    }
}
