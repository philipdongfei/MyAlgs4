import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;

/*
 * the recurrence relation
 */
public class Goofy {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        sort(a, lo, hi-1);  // first n-1 items
        if (less(a[hi], a[hi-1])) {
            exch(a, hi-1, hi);
            sort(a, lo, hi-1); // first n-1 items
        }
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
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Goofy.sort(a);
        show(a);
        assert isSorted(a);
    }
}
