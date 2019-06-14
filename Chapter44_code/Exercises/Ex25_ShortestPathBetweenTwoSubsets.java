import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex25_ShortestPathBetweenTwoSubsets 
{
    public class DijkstraSPTwoSubsets {
        private DirectedEdge[] edgeTo; 
        private double[] distTo;
        private IndexMinPQ<Double> pq;
        private int closestVertexInSubsetT;

        DijkstraSPTwoSubsets(EdgeWeightedDigraph G, SET<Integer> subsetS, 
                SET<Integer> subsetT){

            edgeTo = new DirectedEdge[G.V()];
            distTo = new double[G.V()];
            pq = new IndexMinPQ<Double>(G.V());
            closestVertexInSubsetT = -1;

            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;
            for (int s : subsetS){
                distTo[s] = 0;
                pq.insert(s, 0.0);
            }
            while (!pq.isEmpty()){
                int v = pq.delMin();
                relax(G, v);
                if (subsetT.contains(v)){ // closest vertex in the subsetT 
                    closestVertexInSubsetT = v;
                    break;
                }
            }
        }
        private void relax(EdgeWeightedDigraph G, int v){
            for (DirectedEdge e : G.adj(v)){
                int neighbor = e.to();
                if (distTo[neighbor] > distTo[v] + e.weight()){
                    distTo[neighbor] = distTo[v] + e.weight();
                    edgeTo[neighbor] = e;

                    if (pq.contains(neighbor)) pq.change(neighbor, distTo[neighbor]);
                    else pq.insert(neighbor, distTo[neighbor]);
                }
            }
        }
        public Iterable<DirectedEdge> getShortestPathFromStoT(){
            if (closestVertexInSubsetT == -1)
                return null;
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[closestVertexInSubsetT]; e != null; e = edgeTo[e.from()])
                path.push(e);
            return path;
        }

    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        SET<Integer> subsetS  = new SET<>();
        subsetS.add(0);
        subsetS.add(1);
        SET<Integer> subsetT = new SET<>();
        subsetT.add(5);
        subsetT.add(6);
        DijkstraSPTwoSubsets sp = new Ex25_ShortestPathBetweenTwoSubsets().new DijkstraSPTwoSubsets(G, subsetS, subsetT);
        for (DirectedEdge e : sp.getShortestPathFromStoT()){
            StdOut.print(e + " ");
        }
        StdOut.println();

    }
}
