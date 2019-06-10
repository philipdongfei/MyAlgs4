import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex4_4_14 {

    public static void main(String[] args){
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        double smallest = Double.parseDouble(args[2]);
        //Strawman I.
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        //Strawman II.
        //EdgeWeightedDigraph G = new EdgeWeightedDigraph(in, smallest);

        DijkstraSP sp = new DijkstraSP(G, s);
        for (int t = 0; t < G.V(); t++)
        {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t))
                for (DirectedEdge e : sp.pathTo(t))
                    StdOut.print(e + " ");
            StdOut.println();
        }
        //////////////////
        /////Strawman II.


    }
}
