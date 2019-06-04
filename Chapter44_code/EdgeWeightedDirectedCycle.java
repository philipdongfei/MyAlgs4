import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;


public class EdgeWeightedDirectedCycle
{
    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;    // vertices on a cycle (if one exists)
    private boolean[] onStack;    // vertices on recursive call stack

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G)
    {
        onStack = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(EdgeWeightedDigraph G, int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (this.hasCycle()) return;
            else if (!marked[w])
            {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<DirectedEdge>();
                DirectedEdge f = e;
                while (f.from() != w){
                    cycle.push(f);
                    f = edgeTo[f.from()];
                }
                cycle.push(f);
                return;
            }

        }
        onStack[v] = false;
    }
    public boolean hasCycle()
    {
        return cycle != null;
    }
    public Iterable<DirectedEdge> cycle()
    { 
        return cycle;
    }
    // certify that digraph has a directed cycle if it reports one
    private boolean check() {
        if (hasCycle()) {
            // verify cycle
            DirectedEdge first = null, last = null;
            for (DirectedEdge e : cycle()) {
                if (first == null) first = e;
                if (last != null){
                    if (last.to() != e.from()){
                        System.err.printf("cycle edges %s and %s not incident\n", last, e);
                        return false;
                    }
                }
                last = e;
            }
            if (first.from() != last.to()) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (finder.hasCycle()){
            StdOut.print("Directed cycle: ");
            for (DirectedEdge e : finder.cycle())
                StdOut.print(e + " ");
            StdOut.println();
        }
        else
            StdOut.println("No directed cycle");
        StdOut.println("hasCycle: " + finder.hasCycle());
        StdOut.println();
    }
}
