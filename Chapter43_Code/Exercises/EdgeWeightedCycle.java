import edu.princeton.cs.algs4.Stack;


public class EdgeWeightedCycle {
    private boolean[] marked;
    private Edge[] edgeTo;
    private Stack<Edge> cycle;
    private boolean[] onStack;

    public EdgeWeightedCycle(EdgeWeightedGraph G){
        onStack = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    private void dfs(EdgeWeightedGraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for (Edge e : G.adj(v)){
            int w = e.other(v);
            if (this.hasCycle()) return;
            else if (!marked[w])
            {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<Edge>();
                for (int x = v; x != w; x = edgeTo[x].other(x)){
                    cycle.push(edgeTo[x]);
                }
                cycle.push(e);
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle()
    { return cycle != null; }
    public Iterable<Edge> cycle()
    { return cycle; }
}
