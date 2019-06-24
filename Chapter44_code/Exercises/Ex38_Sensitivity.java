import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;
import java.util.HashSet;

public class Ex38_Sensitivity {
    private class EdgeInformation {
        int from;
        int to;
        
        public EdgeInformation(int from, int to){
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object object){
            if (!(object instanceof EdgeInformation)){
                return false;
            }
            EdgeInformation other = (EdgeInformation)object;
            return this.from == other.from && this.to == other.to;
        }
        @Override
        public int hashCode(){
            int result = 17;
            result += from*31;
            result += to *37;
            return result;
        }
    }

    // An edge is upwards critical if by increasing weight by any value > 0 we increase the shortest path
    // distance from the source to some vertex v
    //
    // An edge is downwards critical if by decreasing weight by any value > 0 we decrease the shortest path from the source to some vertex v (however, by definition, if weight(e) = 0 then e is not downwards critical, because we can't decrease its weight below 0).
    // O(E*V)
    public boolean[][] computeSensitivity(EdgeWeightedDigraph G){
        // Initialize sensitivity matrix
        // we are considering that if an edge(v, w) does not exist, its weight is equal to infinity and any increase
        // in this weight does not increase any shortest-path distance between v and w.
        // Therefore, entries for non-existent edges are set to true.
        boolean[][] sensitivity = new boolean[G.V()][G.V()];

        HashSet<EdgeInformation> edgesInformation = new HashSet<>();
        for (DirectedEdge e : G.edges()){
            edgesInformation.add(new EdgeInformation(e.from(), e.to()));
        }
        for (int i = 0; i < sensitivity.length; i++){
            for (int j = 0; j < sensitivity[0].length; j++){
                if (!edgesInformation.contains(new EdgeInformation(i, j))){
                    sensitivity[i][j] = true;
                }
            }
        }
        for (int source = 0; source < G.V(); source++){
            // Run Dijkstra from source
            DijkstraSP sp = new DijkstraSP(G, source);

            // compute downwards critical edges in paths from source
            int[] downwardCriticalEdgesCount = new int[G.V()];

            for (DirectedEdge e : G.edges()){
                if (sp.distTo(e.from()) + e.weight() == sp.distTo(e.to())){
                    downwardCriticalEdgesCount[e.to()]++;
                }
            }
            // Check which edges adjacent to the source vetex are not upwards critical edges
            for (DirectedEdge e : G.adj(source)){
                if (downwardCriticalEdgesCount[e.to()] != 1){
                    sensitivity[source][e.to()] = true;
                }
            }
        }
        return sensitivity;
    }
    public static void main(String[] args){
        Ex38_Sensitivity ex38 = new Ex38_Sensitivity();
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        boolean[][] sensitivity = ex38.computeSensitivity(G);

        StdOut.println("Upwards critical edges : ");
        for (int i = 0; i < sensitivity.length; i++){
            for (int j = 0; j < sensitivity[0].length; j++){
                if (!sensitivity[i][j]){
                    StdOut.print(i + "->" + j + " ");
                }
            }
        }
        StdOut.println();
    }
}
