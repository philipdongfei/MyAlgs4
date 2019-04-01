import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {
    public static int degree(Graph G, int v)
    {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }
    public static int maxDegree(Graph G)
    {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);
        return max;
    }
    public static double avgDegree(Graph G)
    {
        return 2.0*G.E()/G.V();
    }
    public static int numberOfSelfLoops(Graph G)
    {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count/2;    // each edge counted twice
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);

        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree           = " + avgDegree(G));
        StdOut.println("number of self loops     = " + numberOfSelfLoops(G));
        StdOut.println("degree of vertex 0       = " + degree(G, 0));
    }
}
