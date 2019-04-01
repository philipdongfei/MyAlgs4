import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;


public class Search {

    private int source;
    private Graph G;
    private Bag<Integer> BagV;
    public  Search(Graph G, int s)
    {
        this.G = G;
        this.source = s;
        BagV = new Bag<>();

        BagV = ConnV(G, s, source, BagV); 
    }
    // UF
    Bag<Integer> ConnV(Graph G, int a, int s, Bag<Integer> bag)
    {
        for (int w : G.adj(a))
        {
            if (w != s){
                bag.add(w);
                bag = ConnV(G, w, s, bag);
            }
        }
        return bag;
    }
    public boolean marked(int v)
    {
        for (int w : BagV)
            if (v == w)
                return true;
        return false;
    }
    public int count()
    {
        return BagV.size();
    }

}


