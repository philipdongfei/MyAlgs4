import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_3_12 {
    public static class Quick3way{
        public static void sort(Comparable[] a) {
            //StdRandom.shuffle(a); // Eliminate dependence on input.
            sort(a, 0, a.length-1);
        }
        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) {
                StdOut.printf("%02d    %02d ", lo, hi);
                show(a);
                return;

            }
            int lt = lo, i = lo+1, gt = hi;
            Comparable v = a[lo];
            while (i <= gt) {
                StdOut.printf("%02d %02d %02d ", lt, i, gt);
                show(a);
                int cmp = a[i].compareTo(v);
                if (cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else        i++;
                StdOut.printf("%02d %02d %02d ", lt, i, gt);
                show(a);
            }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            StdOut.printf("%02d    %02d ", lt, gt);
            show(a);
            sort(a, lo, lt-1);
            sort(a, gt+1, hi);
        }
        private static int partition(Comparable[] a, int lo, int hi) {
            // Partition into a[lo..i-1], a[i], a[i+1..hi].
            int i = lo, j = hi+1;    //left and right scan indices
            Comparable v = a[lo];    // partitioning item
            while (true){
                // Scan right, scan left, check for scan complete, and exchange.
                while (less(a[++i], v)) if (i == hi) break;
                while (less(v, a[--j])) if (j == lo) break;
                if (i >= j) break;
                exch(a, i, j);
            }
            exch(a, lo, j);     // Put v = a[j] into position
            return j;          // with a[lo..j-1]<=a[j]<=a[j+1..hi].
        }
        
        private static boolean less(Comparable v, Comparable w){
            return v.compareTo(w) < 0;
        }
        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i]; a[i] = a[j]; a[j] = t;
        }
        private static void show(Comparable[] a) {
            // Print the array, on a single line.
            for (int i = 0; i < a.length; i++)
                StdOut.print(a[i] + " ");
            StdOut.println();
        }
        public static boolean isSorted(Comparable[] a){
            // Test whether the array entries are in order.
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i-1])) return false;
            return true;
        }
        public static void main(String[] args) {
            // Read strings from standard input, sort them, and print.
            String[] a = StdIn.readAllStrings();
            //StdOut.print("%9s");
            show(a);
            sort(a);
            assert isSorted(a);
            //StdOut.print("%9s");
            show(a);
        }
    }
        public static void main(String[] args) {
            // Read strings from standard input, sort them, and print.
            String[] a = StdIn.readAllStrings();
            StdOut.printf("%9s", " ");
            Quick3way.show(a);
            Quick3way.sort(a);
            assert Quick3way.isSorted(a);
            StdOut.printf("%9s", " ");
            Quick3way.show(a);
        }

}
