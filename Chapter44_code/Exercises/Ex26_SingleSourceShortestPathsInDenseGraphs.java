import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex26_SingleSourceShortestPathsInDenseGraphs{
    public class DijkstraSPDenseGraph {
        private DirectedEdge[] edgeTo;
        private double[] distTo;

        public DijkstraSPDenseGraph(EdgeWeightedDigraphMatrix G, int source) 
        {
            edgeTo = new DirectedEdge[G.V()];
            distTo = new double[G.V()];

            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;
            distTo[source] = 0;
            boolean[] visited = new boolean[G.V()];
            int nextVertexToRelax = source;

            for (int relaxedVertex = 0; relaxedVertex < G.V(); relaxedVertex++)
                nextVertexToRelax = relax(G, nextVertexToRelax, visited);
        }
        private int relax(EdgeWeightedDigraphMatrix G, int v, boolean[] visited) 
        {
            visited[v] = true;
            for (DirectedEdge e : G.adj(v)){
                int w = e.to();
                if (distTo[w] > distTo[v] + e.weight()){
                    distTo[w] = distTo[v] + e.weight();
                    edgeTo[w] = e;
                }
            }
            int nextVertexToRelax = -1;
            double minWeight = Double.POSITIVE_INFINITY;

            for (int vertexToCheck = 0; vertexToCheck < G.V(); vertexToCheck++)
            {
                if (!visited[vertexToCheck] && distTo[vertexToCheck] < minWeight){
                    nextVertexToRelax = vertexToCheck;
                    minWeight = distTo[vertexToCheck];
                }
            }
            return nextVertexToRelax;
        }
        public double distTo(int vertex){
            return distTo[vertex];
        }
        public boolean hasPathTo(int v){
            return distTo[v] < Double.POSITIVE_INFINITY;
        }
        public Iterable<DirectedEdge> pathTo(int v){
            if (!hasPathTo(v)){
                return null;
            }
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
                path.push(e);
            return path;
        }

        public DirectedEdge edgeTo(int v){
            return edgeTo[v];
        }

    }

    public static void main(String[] args){
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        EdgeWeightedDigraphMatrix G = 
            new EdgeWeightedDigraphMatrix(in);
        DijkstraSPDenseGraph sp = 
            new Ex26_SingleSourceShortestPathsInDenseGraphs().new
            DijkstraSPDenseGraph(G, s);
        StdOut.printf("%13s %10s\n", "edgeTo[]", "distTo[]");
        for (int v = 0; v < G.V(); v++)
            StdOut.printf("%d %11s %9.2f\n", v, sp.edgeTo(v), 
                    sp.distTo(v));
        StdOut.println();
        for (int v = 0; v < G.V(); v++){
            StdOut.printf("Path " + s + " To " + v + ": ");
            for (DirectedEdge e : sp.pathTo(v))
                StdOut.print(e + " ");
            StdOut.println();

        }

    }
}
