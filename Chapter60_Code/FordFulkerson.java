import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.lang.Math;

public class FordFulkerson
{
    private boolean[] marked; // Is s->v path in residual graph?
    private FlowEdge[] edgeTo; // last edge on shortest s->v path
    private double value;  // current value of maxflow

    public FordFulkerson(FlowNetwork G, int s, int t)
    {
        // Find maxflow in flow network G from s to t.
        while (hasAugmentingPath(G, s, t))
        {
            // while there exists an augmenting path, use it.
            // Compute bottleneck capacity.
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            // Augment flow.
            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottle);
            value += bottle;

        }
    }

    public double value() { return value; }
    public boolean inCut(int v) { return marked[v]; }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t)
    {
        marked = new boolean[G.V()]; //Is path to this vertex known?
        edgeTo = new FlowEdge[G.V()]; // last edge on path
        Queue<Integer> q = new Queue<Integer>();

        marked[s] = true;  // Mark the source
        q.enqueue(s);       // and put it on the queue.

        while (!q.isEmpty())
        {
            int v = q.dequeue();
            for (FlowEdge e : G.adj(v))
            {
                int w = e.other(v);
                if (e.residualCapacityTo(w) > 0 && !marked[w])
                { // For every edge to an unmarked vertex (in residual)
                    edgeTo[w] = e; // Save the last edge on a path.
                    marked[w] = true;  // Mark w because a path is known
                    q.enqueue(w);     // and add it to the queue.
                }
            }

        }
        return marked[t];
    }
    public static void main(String[] args)
    {
        FlowNetwork G = new FlowNetwork(new In(args[0]));
        int s = 0, t = G.V() - 1;
        FordFulkerson maxflow = new FordFulkerson(G, s, t);
        StdOut.println("Max flow from " + s + " to " + t);
        for (int v = 0; v < G.V(); v++)
            for (FlowEdge e : G.adj(v))
                if ((v == e.from()) && e.flow() > 0)
                    StdOut.println("   " + e);
        StdOut.println("Max flow value = " + maxflow.value());
    }

}
