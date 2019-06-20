import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex31_AllPairsShortestPathOnALine {
    public class AllPairsShortestPathOnALine{
        private double[] distanceFromSource;
        AllPairsShortestPathOnALine(EdgeWeightedGraph G){
            boolean isLineGraph = true;
            int numberOfVerticesWithDegree1 = 0;
            int sourceVertex = -1;
            // Find one of the two sources
            for (int v = 0; v < G.V(); v++){
                int outdegree = 0;

                for (Edge e : G.adj(v)){
                    if (e.weight() < 0){
                        throw new IllegalArgumentException("Edge weights cannot be negative");
                    }
                    outdegree++;
                }
                if (outdegree == 1){
                    if (sourceVertex == -1)
                        sourceVertex = v;
                    numberOfVerticesWithDegree1++;
                } else if (outdegree == 0 || outdegree > 2){
                    isLineGraph = false;
                    break;
                }

            }
            if (numberOfVerticesWithDegree1 != 2)
                isLineGraph = false;
            if (!isLineGraph)
                throw new IllegalArgumentException("Graph is not a line graph");
            distanceFromSource = new double[G.V()];
            boolean[] visited = new boolean[G.V()];

            for (int v = 0; v < distanceFromSource.length; v++)
                distanceFromSource[v] = Double.POSITIVE_INFINITY;
            // Do a breadth-first-search to compute the distances from the source in O(V+E)
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(sourceVertex);
            visited[sourceVertex] = true;

            distanceFromSource[sourceVertex] = 0;

            while (!queue.isEmpty()){
                int currentVertex = queue.dequeue();
                for (Edge e : G.adj(currentVertex)){
                    int neighbor = e.other(currentVertex);

                    if (!visited[neighbor]){
                        distanceFromSource[neighbor] = distanceFromSource[currentVertex] + e.weight();
                        queue.enqueue(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        public double dist(int source, int target){
            return Math.abs(distanceFromSource[source] = distanceFromSource[target]);
        }

    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        AllPairsShortestPathOnALine path = new
            Ex31_AllPairsShortestPathOnALine().new AllPairsShortestPathOnALine(G);
        for (int s = 0; s < G.V(); s++){
            for (int t = 0; t < G.V(); t++){
               StdOut.println("Distance from " + s + " to " + t + ":  " + path.dist(s, t));
                }
        }
        StdOut.println();
    }
}
