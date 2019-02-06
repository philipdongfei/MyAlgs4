import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Math;


public class SegmentTreeRMQ<Key extends Comparable<Key>>{
    private Key[] st;

    private Key minVal(int x, int y) {
        if (x > st.length)
            return st[y];
        if (y > st.length)
            return st[x];

        int min = 0;
        if (less(x, y))
            min = x;
        else
            min = y;
        return st[min];
    }

    private int getMid(int s, int e) {
        return s+(e-s)/2;
    }
    private int RMQUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se)
            return index;
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;
        int mid = getMid(ss, se);
        return st[minVal(RMQUtil(ss, mid, qs, qe, 2*index+1),
                RMQUtil(mid+1, se, qs, qe, 2*index+2))];
    }
    private Key RMQ(int n, int qs, int qe) {
        if (qs < 0 || qe > n-1 || qs > qe) {
            StdOut.println("Invalid Input");
            return null;
        }
        
        return st[RMQUtil(0, n-1, qs, qe, 0)];
    }

    private Key constructSTUtil(Key[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = minVal(constructSTUtil(arr, ss, mid, si*2+1),
                constructSTUtil(arr, mid+1, se, si*2+2));
        return st[si];
    }
    private void constructST(Key arr[], int n) {
        int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int max_size = 2*(int)Math.pow(2,x)-1;
        st = (Key[]) new Comparable[max_size];

        constructSTUtil(arr, 0, n-1, 0);
    }
    private boolean less(int x, int y) {
        return st[x].compareTo(st[y]) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,3,2,7,9,11};
        int n = arr.length;
        SegmentTreeRMQ<Integer> tree = new SegmentTreeRMQ<Integer>();

        tree.constructST(arr, n);

        int qs = 1;
        int qe = 5;
        StdOut.println("Minimum of values in range ["
                +qs+", "+qe+"] is = "+tree.RMQ(n, qs, qe));
    }


}
