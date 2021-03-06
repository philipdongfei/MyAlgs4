import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_1_11 {

public static class Shell{
    private static int[] h = {1, 4, 13, 40, 121, 346, 1093};
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        StdOut.print("input   ");
        show(a);
        int N = a.length;
        int idx = 0;
        while (h[idx] < N/3 && idx < h.length-1) idx++; // 1,4,13,40,121,364,1093
        while (idx >= 0)
        {  // h-sort the array.
            StdOut.printf("%02d-sort ",h[idx]);
            for (int i = h[idx]; i < N; i++){
                // Insert a[i] among a[i-h],a[i-2*h],a[i-3*h]....
                for (int j = i; j >= h[idx] && less(a[j],a[j-h[idx]]); j -= h[idx])
                    exch(a,j,j-h[idx]);
                if (i > h[idx])
                    StdOut.printf("        ");
                show(a);
            }
            idx--;
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
public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Shell.sort(a);

}
}
