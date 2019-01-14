import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class QuickBentleyMcIlroy1 {

    // cutoff to insertion sort, must be >= 1.
    private static final int INSERTION_SORT_CUTOFF = 8;

    // cutoff to median-of-3 partitioning
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    // This class should not be instantiated.
    private QuickBentleyMcIlroy1() {}

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        if (hi <= lo) return;

        /*
        // cutoff to insertion sort
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
        // use median-of-3 as partitioning element
        else if (n <= MEDIAN_OF_3_CUTOFF) {
            int m = median3(a, lo, lo+n/2, hi);
            exch(a, m, lo);
        }
        // use Tukey ninther as partitioning element
        else {
            int eps = n/8;
            int mid = lo+n/2;
            int m1 = median3(a, lo, lo+eps, lo+eps+eps);
            int m2 = median3(a, mid-eps, mid, mid+eps);
            int m3 = median3(a, hi-eps-eps, hi-eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }
        */
        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];

        while (true) {
            StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
            show(a);
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            // pointers cross
            if (i == j && eq(a[i], v))
                exch(a, ++p, i);
            if (i >= j) break;
            StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
            show(a);

            exch(a, i, j);
            StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
            show(a);
            if (eq(a[i],v)) exch(a, ++p, i); // exch to left
            if (eq(a[j],v)) exch(a, --q, j); // exch to right
            StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
            show(a);
        }
        StdOut.println();
        i = j + 1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
        show(a);
        for (int k = hi; k >= q; k--)
            exch(a, k, i++);
        StdOut.printf("%2d %2d %2d %2d ", p, i, j, q);
        show(a);
        StdOut.println("-------------");
        sort(a, lo, j);
        sort(a, i, hi);

    }
    // sort from a[lo] to a[hi] using insertion sort.
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i=lo; i<=hi; i++)
            for (int j=i; j>lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    // return the index of the median element among a[i], a[j], and a[k].
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j])?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i):
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    // is v < w?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;  // optimization when reference equal.
        return v.compareTo(w) < 0;
    }
    // does v == w?
    private static boolean eq(Comparable v, Comparable w) {
        if (v == w) return true;  // optimization when reference equal
        return v.compareTo(w) == 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // check if array is sorted - useful for debugging.
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.printf("%2s %2s %2s %2s ", "p", "i", "j","q");
        show(a);
        QuickBentleyMcIlroy1.sort(a);
        assert isSorted(a);
        StdOut.printf("%12s", " ");
        show(a);
    }
}
