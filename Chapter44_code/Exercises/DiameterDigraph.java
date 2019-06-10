import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class DiameterDigraph 
{
    EdgeWeightedDigraph G;
    DiameterDigraph(EdgeWeightedDigraph G)
    {
        this.G = G;
    }
    public double findDiameter() {
        double diameter = Double.NEGATIVE_INFINITY;

        for (int v = 0; v < G.V(); v++){
            DijkstraSP sp = new DijkstraSP(G, v);

            for (int w = 0; w < G.V(); w++){
                if (sp.distTo(w) > diameter)
                    diameter = sp.distTo(w);
            }
        }
        return diameter;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        DiameterDigraph findD = new DiameterDigraph(G);
        StdOut.println(G);
        StdOut.println("diameter: " + findD.findDiameter());

    }
}
