import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;


public class Ex4_3_16 {
    public static double[] getWeightRangeToBeInMST(EdgeWeightedGraph G, Edge newEdge){
        G.addEdge(newEdge);
        EdgeWeightedCycle edgeWeightedCycle = new EdgeWeightedCycle(G);
        Stack<Edge> cycle = new Stack<Edge>();
        for (Edge e : edgeWeightedCycle.cycle())
        {
            cycle.push(e);
        }

        Edge[] edgesInCycle = new Edge[cycle.size()];
        int edgesInCycleIndex = 0;

        for (Edge edgeInCycle : cycle)
            edgesInCycle[edgesInCycleIndex++] = edgeInCycle;

        Arrays.sort(edgesInCycle);

        double max, min = Double.NEGATIVE_INFINITY;
        if (newEdge != edgesInCycle[edgesInCycle.length-1])
            max = edgesInCycle[edgesInCycle.length-1].weight()-0.000001;
        else
            max = edgesInCycle[edgesInCycle.length-2].weight()-0.000001;
        return new double[]{min, max};

    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println("G: ");
        StdOut.println(G);
        StdOut.println();

        int v = Integer.parseInt(args[1]);
        int w = Integer.parseInt(args[2]);
        double weight = Double.parseDouble(args[3]);
        Edge newEdge = new Edge(v, w, weight);
        double[] weightRange = getWeightRangeToBeInMST(G, newEdge);
        StdOut.println("Weight range: " + weightRange[0] + " to " + weightRange[1]);

    }
}
