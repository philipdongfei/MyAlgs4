import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedTopological
{
    private Iterable<Integer> order;    // topological order

    public EdgeWeightedTopological(Digraph G)
    {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
    public EdgeWeightedTopological(EdgeWeightedDigraph G){
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
    public Iterable<Integer> order()
    { return order;  }
    public boolean isDAG()
    { return order != null; }
    public static void main(String[] args)
    {
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, separator);

        EdgeWeightedTopological top = new EdgeWeightedTopological(sg.digraph());
        for (int v : top.order())
            StdOut.println(sg.name(v));
    }
}
