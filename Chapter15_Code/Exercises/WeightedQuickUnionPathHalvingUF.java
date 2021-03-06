//https://algs4.cs.princeton.edu/15uf/WeightedQuickUnionPathHalvingUF.java.html
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class WeightedQuickUnionPathHalvingUF {
    private int[] parent; // parent[i] = parent of i
    private int[] size;  // size[i] = number of sites in tree rooted at i 
                        // Note: not necessarily correct if i is not a root node

    private int count; // number of components

    public WeightedQuickUnionPathHalvingUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // path compression by halving
            p = parent[p];
        }
        return p;
    }

    // validate that p is a valid index.
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Index " + p +
                " is not between 0 and " + (n-1));
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        //make smaller root point to larger one
        if (size[rootP] < size[rootQ]){
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionPathHalvingUF uf = new
            WeightedQuickUnionPathHalvingUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
