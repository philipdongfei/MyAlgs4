import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSizes {

    // print size of resuting subarray.
    private static void merge(int lo, int mid, int hi) {
        StdOut.printf("%2d", hi - lo + 1);
        StdOut.print(" ");
    }

    // top-down mergesort a[lo..hi].
    private static void topDownMergesort(int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        topDownMergesort(lo, mid);
        topDownMergesort(mid+1, hi);
        merge(lo, mid, hi);
    }

    public static void topDownMergesort(Comparable[] a) {
        topDownMergesort(0, a.length-1);
    }
    public static void bottomUpMergesort(Comparable[] a) {
        int n = a.length;
        for (int len = 1; len < n; len *= 2){
            for (int lo = 0; lo < n-len; lo += len+len){
                int mid = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(lo, mid, hi);
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String[] a = new String[n];
        MergeSizes.topDownMergesort(a);
        StdOut.println();
        MergeSizes.bottomUpMergesort(a);
        StdOut.println();
    }
}
