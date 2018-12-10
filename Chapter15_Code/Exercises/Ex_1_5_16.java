import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;

public class Ex_1_5_16 {
public static class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i.
    private int count;  // number of components
    private int access;

    public QuickFindUF(int n) {
        access = 0;
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }
    public int count() {
        return count;
    }
    private void addAccess(int v) {
        access += v;
    }
    public int getAccess() {
        return access;
    }
    public int find(int p) {
        validate(p);
        addAccess(1);
        return id[p];
    }
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index "+p+" is not between 0 and "+(n-1));
        }
    }
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        addAccess(2);
        return id[p] == id[q];
    }
    public void union(int p, int q) {
        validate(p);
        validate(q);
        access = 0;
        addAccess(2);
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) {
                id[i] = qID;
                addAccess(1);
            }
        count--;
    }
}
public static class QuickUnionUF {
    private int[] parent;
    private int count;
    private int access;

    public QuickUnionUF(int n) {
        access = 0;
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    private void addAccess(int v) {
        access += v;
    }
    public int getAccess() {
        return access;
    }

    public int count() {
        return count;
    }
    public int find(int p) {
        validate(p);
        addAccess(1);
        while (p != parent[p]){
            addAccess(1);
            p = parent[p];
            addAccess(1);

        }
        return p;
    }
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n){
            throw new IllegalArgumentException("index "+p+" is not between 0 and "+(n-1));
        }
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        access = 0;
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        addAccess(1);
        parent[rootP] = rootQ;
        count--;
    }
}

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int i = 0;
        double r = 0.5;
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(0,n/2);

        QuickUnionUF qu = new QuickUnionUF(n);
        QuickFindUF qf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qu.connected(p, q)) continue;
            qu.union(p, q);
            if (qf.connected(p,q)) continue;
            qf.union(p,q);
            //TODO:
            StdDraw.setPenColor(0,0,200);
            StdDraw.point(i, qu.getAccess());
            StdDraw.circle(i, qu.getAccess(), r);
            StdDraw.setPenColor(200,0,0);
            StdDraw.point(i, qf.getAccess());
            StdDraw.circle(i, qf.getAccess(), r);
            //StdOut.println(p + " " + q);
            i++;
        }
        StdOut.println(qu.count() + " components");
        StdOut.println(qf.count() + " components");
    }
}
