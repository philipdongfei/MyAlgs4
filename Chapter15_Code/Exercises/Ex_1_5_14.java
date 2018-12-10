import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_5_14{

public static class WeightedQuickUnionByHeightUF
{
    private int[] id;    // parent link (site indexed)
    private int[] sz;    // size of component for roots (site indexed)
    private int count;  // number of components
    private int cost;
    
    public WeightedQuickUnionByHeightUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int count()
    { return count;  }
    private void addcost()
    { cost++; }
    public void costzero()
    { cost = 0; }
    public void printIdAndCost()
    {
        StdOut.printf("id: ");
        for (int i = 0; i < id.length; i++)
            StdOut.printf("%d ", id[i]);
        StdOut.println();
        StdOut.printf("cost: %d\n", cost);
    }
    public boolean connected(int p, int q)
    { return find(p) == find(q); }
    public int find(int p) {
        // Follow links to find a root.
        addcost();
        while (p != id[p])
        {
            addcost(); 
            p = id[p];
            addcost();
        }
        return p;
    }
    public int getHeight(int p) {
        // Follow links to find a root.
        int height = 1;
        addcost();
        while (p != id[p])
        {
            height++;
            addcost(); 
            p = id[p];
            addcost();
        }
        return height;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) 
        { 
            addcost();
            addcost();
            addcost();
            id[i] = j; 
        }
        else if (sz[i] > sz[j])                
        { 
            addcost();
            addcost();
            addcost();
            id[j] = i; 
        }
        else //equal
        {
            id[j] = i;
            sz[i]++;
        }
        count--;
    }
    /*
    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt();    // Read number of sites.
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);      // Initialize N components.
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();  // Read pair to connect
            uf.costzero();
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.union(p, q);     // Combine components.
            StdOut.println(p + " " + q);   // and print connection.
            uf.printIdAndCost();
        }
        StdOut.println(uf.count() + " components");
    }
    */
}
    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt();    // Read number of sites.
        WeightedQuickUnionByHeightUF uf = new WeightedQuickUnionByHeightUF(N);      // Initialize N components.
        uf.printIdAndCost();
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();  // Read pair to connect
            uf.costzero();
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.union(p, q);     // Combine components.
            StdOut.println(p + " " + q);   // and print connection.
            uf.printIdAndCost();
            int max = 1;
            for (int i = 0; i < N; i++){
                int len = uf.getHeight(i);
                if (len > max)
                    max = len;
            }
            StdOut.printf("%8d: max = %3d, lg(n)=%5.1f\n",
                    N, max, Math.log(N)/Math.log(2));
        }
        //StdOut.println(uf.count() + " components");
    }
}
