import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_5_1{

public static class UF {
    private int[] id;    // access to component id (site indexed)
    private int count;   // number of components
    private int cost;

    public UF(int N){
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    private void addcost()
    { cost++; }
    public void costzero()
    { cost = 0; }

    public int count()
    { return count;  }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    /*********************
     *Quick-find.
     ********************/
    private int find(int p){
        addcost();
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
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID){
                id[i] = qID;
                addcost();
            } 
            addcost();
        }
        count--;
    }
    public void printIdAndCost()
    {
        StdOut.printf("id: ");
        for (int i = 0; i < id.length; i++)
            StdOut.printf("%d ", id[i]);
        StdOut.println();
        StdOut.printf("cost: %d\n", cost);
    }
    /**************************
     * Quick-union
     *************************/
    /*
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
    */
/*
    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt();    // Read number of sites.
        UF uf = new UF(N);      // Initialize N components.
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();  // Read pair to connect
            cost = 0;
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
        StdOut.println("N="+N);
        UF uf = new UF(N);      // Initialize N components.
        uf.printIdAndCost();
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
}
