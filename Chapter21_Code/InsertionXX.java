import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class InsertionXX{
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int min = 0, k;
        for (k=1; k<N; k++) {
            if (less(a[k],a[min])) min = k;
        }
        exch(a, min, 0);

        for (int i = 2; i < N; i++)
        { // Insert a[i] among a[i-1], a[i-2],a[i-3].....
            // moves larger elements to the right one position 
            // with one array access per entry.
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1]))
            {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
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
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
