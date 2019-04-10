import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class GraphProperties {
    private int[] ecce;
    private int diameter;
    private int radius;
    private int center;
    private int girth;
    private Graph G;

    public GraphProperties(Graph G){
        this.G = G;
        ecce = new int[G.V()];
        diameter = 0;
        radius = Integer.MAX_VALUE;
        center = 0;
        girth = Integer.MAX_VALUE;
        CC cc = new CC(G);
        StdOut.println("cc count: " + cc.count());
        StdOut.println("Graph E: " + G.E());
        StdOut.println("Graph V: " + G.V());
        if (cc.count() != 1)
            throw new IllegalArgumentException("Graph G is not connected.");
        for (int i = 0; i < G.V(); i++)
            computeEccentricity(i);
        Cycle cyc = new Cycle(G);
        if (cyc.hasCycle() == false)
        {
            girth = Integer.MAX_VALUE;
        }
            

    }
    private void computeEccentricity(int v) {
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, v);
        ecce[v] = 0;
        int w = v;
        int t_girth = Integer.MAX_VALUE;
        for (int i = 0; i < G.V(); i++)
        {
            if (i != v)
            {
                int d = bfp.distTo(i);
                if (d > ecce[v]) {
                    ecce[v] = d;
                }
                if (t_girth > d){
                    t_girth = d;
                    w = i;
                }

            }
        }
        if (ecce[v] > diameter)
            diameter = ecce[v];
        
        if (ecce[v] < radius){
            radius = ecce[v];
            center = v;
        }
        BreadthFirstPaths bfp1 = new BreadthFirstPaths(G, w);
        t_girth +=  bfp1.distTo(v);
        if (t_girth < girth)
            girth = t_girth;

    }
    public int eccentricity(int v){
        return ecce[v];
    }
    public int diameter(){
        return diameter;
    }
    public int radius(){
        return radius;
    }
    public int center(){
        return center;
    }
    public int girth(){
        return girth;
    }

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        GraphProperties GP = new GraphProperties(G);
        for (int i = 0; i < G.V(); i++)
            StdOut.println("v " + i + " eccentricity: " + GP.eccentricity(i));
        StdOut.println("diameter: " + GP.diameter());
        StdOut.println("radius: " + GP.radius());
        StdOut.println("center: " + GP.center());
        StdOut.println("girth: " + GP.girth());
    }


}
