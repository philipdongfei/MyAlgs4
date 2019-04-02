import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;


public class Search {

    private WeightedQuickUnionUF uf;
    private int source;
    private Graph G;
    public  Search(Graph G, int s)
    {
        this.G = G;
        this.source = s;
        uf = new WeightedQuickUnionUF(G.V());

        for (int v = 0; v < G.V(); v++){
            for (int adj : G.adj(v))
                uf.union(v, adj);
        }

    }
    public boolean marked(int v)
    {
        return uf.connected(source, v);
    }
    public int count()
    {
        int v = uf.find(source);
        return uf.getSizes(v);
    }

}


