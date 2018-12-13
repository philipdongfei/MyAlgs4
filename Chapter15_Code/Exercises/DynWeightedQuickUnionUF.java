import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class DynWeightedQuickUnionUF
{
    private int[] id;    // parent link (site indexed)
    private int[] sz;    // size of component for roots (site indexed)
    private int count;  // number of components
    private int totalsite;

    public DynWeightedQuickUnionUF(){
        int N = 1;
        count = totalsite = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    private void resize(int max) {
        //resize sz[] and id[]
        //StdOut.println("resize: max="+max);
        //StdOut.println("resize: count="+count);
        int[] t_id = new int[max];
        int[] t_sz = new int[max];
        int i;
        for (i = 0; i < totalsite; i++){
            t_id[i] = id[i];
            t_sz[i] = sz[i];
        }
        for (i = totalsite; i < max; i++){
            t_id[i] = i;
            t_sz[i] = 1;
        }
        id = t_id;
        sz = t_sz;
    }
    public int newSite() {
        
        return count;
    }
    public int count()
    { return count;  }
    public boolean connected(int p, int q)
    { 
        int max;
        if (p > q)
            max = p+1;
        else 
            max = q+1;
        if (max > totalsite )
        {
            
            resize(max);
            count += (max - totalsite);
            totalsite = max;
            StdOut.println("Connection: count="+count);
        }
        return find(p) == find(q); 
    }
    public int find(int p) {
        // Follow links to find a root.
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else                { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt();    // Read number of sites.
        DynWeightedQuickUnionUF uf = new DynWeightedQuickUnionUF();      // Initialize N components.
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
