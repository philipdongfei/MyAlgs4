import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class QuickDualPivot {

    // quicksort the array a[] using dual-pivot quicksort.
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }
    // quicksort the subarray a[lo..hi] using dual-pivot quicksort
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        // make sure a[lo]<=a[hi].
        if (less(a[hi], a[lo])) exch(a, lo, hi);

        int lt = lo+1, gt = hi-1;
        int i = lo+1;
        while (i <= gt) {
            if (less(a[i], a[lo])) exch(a, lt++, i++);
            else if (less(a[hi], a[i])) exch(a, i, gt--);
            else    i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        sort(a, lo, lt-1);
        if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);

        assert isSorted(a, lo, hi);
    }

    // is v < w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length-1);
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i]+" ");
        StdOut.println();
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
        QuickDualPivot.sort(a);
        show(a);
    }
}
