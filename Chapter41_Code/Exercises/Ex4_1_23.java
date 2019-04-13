import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;


public class Ex4_1_23 {
    public static Graph SubGraph(String file, String sp, SymbolGraph sg, CC cc, int maxid )
    {
        In in = new In(file);
        Graph subG = new Graph(sg.G().V());
        int E = in.readInt();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = sg.index(a[0]);
            if (cc.id(v) == maxid){
                for (int i = 1; i < a.length; i++)
                    subG.addEdge(v, sg.index(a[i]));
            }
        }
        return subG;
    } 
    public static void main(String[] args)
    {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G(); 
        CC cc = new CC(G);

        int M = cc.count();
        StdOut.println(M + " components");

        Bag<Integer>[] components;
        components = (Bag<Integer>[])new Bag[M];
        for (int i = 0; i < M; i++)
            components[i] = new Bag<Integer>();
        for(int v = 0; v < G.V(); v++)
            components[cc.id(v)].add(v);
        int less10 = 0;
        int maxid = 0;
        for (int i = 0; i < M; i++)
        {
            if (components[i].size() < 10)
                less10++;
            if (components[maxid].size() < components[i].size())
                maxid = i;
        }
        Graph maxG = SubGraph(args[0],args[1], sg, cc, maxid);
        String name = "Bacon, Kevin";
        GraphProperties gp = new GraphProperties(maxG);
        StdOut.println("diameter: " + gp.diameter());
        StdOut.println("radius: " + gp.radius());
        StdOut.println("center: " + gp.center());
    }
}
