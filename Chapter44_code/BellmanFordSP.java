import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;


public class BellmanFordSP
{
    private double[] distTo;  // length of path to v
    private DirectedEdge[] edgeTo; // last edge on path to v
    private boolean[] onQ;  // Is this vertex on the queue?
    private int[] passes;
    private Queue<Integer> queue;  // vertices being relaxed
    private int cost;  // number of calls to relax()
    private Iterable<DirectedEdge> cycle; // negative cycle inedgeTo[]?
    public BellmanFordSP(EdgeWeightedDigraph G, int s)
    {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<Integer>();
        passes = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
            passes[v] = 0;

        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }
    //Ex 4.4.43
    public BellmanFordSP(EdgeWeightedDigraph G){
        distTo = new double[G.V()+1];
        edgeTo = new DirectedEdge[G.V()+1];
        onQ = new boolean[G.V()+1];
        queue = new Queue<Integer>();
        int newVertex = G.V();
        EdgeWeightedDigraph newG = new EdgeWeightedDigraph(G.V()+1);
        for (DirectedEdge e : G.edges()){
            StdOut.println("add: " + e);
            newG.addEdge(e);
        }
        for(int i = 0; i < G.V(); i++){
            StdOut.println("add: " + newVertex + " -> " + i);
            newG.addEdge(new DirectedEdge(newVertex, i, 0));
        }
        for (int v = 0; v < newG.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY; 
        }
        distTo[newVertex] = 0;
        queue.enqueue(newVertex);
        onQ[newVertex] = true;
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.dequeue();
            StdOut.println("dequeue: " + v);
            onQ[v] = false;
            relax(newG, v);
        }

    }
    private void relax(EdgeWeightedDigraph G, int v)
    {
        passes[v]++;
        for (DirectedEdge e : G.adj(v))
        {
            StdOut.println(v + " adj: " + e + " weight: " + e.weight());
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w])
                {
                    StdOut.println("enqueue: " + w);
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }
    public double distTo(int v)
    { return distTo[v]; }
    public boolean hasPathTo(int v)
    { return distTo[v] < Double.POSITIVE_INFINITY; }
    public Iterable<DirectedEdge> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
    public DirectedEdge edgeTo(int v){
        return edgeTo[v];
    }
    private void findNegativeCycle()
    {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for(int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();

    }
    public boolean hasNegativeCycle()
    {
        return cycle != null;

    }
    public Iterable<DirectedEdge> negativeCycle()
    {
        return cycle;
    }
    public int[] getPasses(){
        return passes;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int s = Integer.parseInt(args[1]);
        BellmanFordSP sp = new BellmanFordSP(G, s);
        //Ex 4.4.43
        //BellmanFordSP sp = new BellmanFordSP(G);
        //int s = G.V();

        int[] passes = sp.getPasses();
        for (int v = 0; v < G.V(); v++)
            StdOut.println(v + " passes: " + passes[v]);

        if (sp.hasNegativeCycle()){
            StdOut.println("has Negative cycle");
            for (DirectedEdge e : sp.negativeCycle())
                StdOut.println(e);
        }
        else {
            StdOut.println("has not Negative cycle");
            //for (int v = 0; v < G.V()+1; v++){
            for (int v = 0; v < G.V(); v++){
                if (sp.hasPathTo(v)){
                    StdOut.printf("%d to %d (%5.2f) ", s, v, sp.distTo(v));
                    for (DirectedEdge e : sp.pathTo(v))
                        StdOut.print(e + " ");
                    StdOut.println();
                }
                else {
                    StdOut.printf("%d to %d        no path\n", s, v);
                }
            }
        }
    }
}
