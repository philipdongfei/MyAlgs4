import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class UF {
    private int[] id;    // access to component id (site indexed)
    private int count;   // number of components

    public UF(int N){
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    public int count()
    { return count;  }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    /*********************
     *Quick-find.
     ********************/
    /*
    private int find(int p){
        return id[p];
    }
    public void union(int p, int q){
        // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);

        // Nothing to do if p and q are already
        // in the same component.
        if (pID == qID) return;

        // Rename p's component to q's name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }
    */
    /**************************
     * Quick-union
     *************************/
    private int find(int p)
    {// Find component name.
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q)
    { // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt();    // Read number of sites.
        UF uf = new UF(N);      // Initialize N components.
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();  // Read pair to connect
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.union(p, q);     // Combine components.
            StdOut.println(p + " " + q);   // and print connection.

        }
        StdOut.println(uf.count() + " components");
    }
}
