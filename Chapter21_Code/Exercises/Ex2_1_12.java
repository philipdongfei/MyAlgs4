import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_1_12 {

public static class Shell{
    public static int[][] sort(Comparable[] a) {
        // Sort a[] into increasing order.
        //StdOut.print("input   ");
        //show(a);
        int N = a.length;
        int h = 1;
        int count = 1;
        while (h < N/3){
            h = 3*h + 1; // 1,4,13,40,121,364,1093
            count++;
        } 
        int[][] ret = new int[2][count];
        int idx = 0;
        while (h >= 1)
        {  // h-sort the array.
            int size = N/h;
            int compares = 0;
            for (int i = h; i < N; i++){
                // Insert a[i] among a[i-h],a[i-2*h],a[i-3*h]....
                for (int j = i; j >= h && less(a[j],a[j-h]); j -= h)
                {
                    exch(a,j,j-h);
                    compares++;
                }
                //show(a);
            }
            ret[0][idx] = size;
            ret[1][idx] = compares;
            h = h/3;
            idx++;
        }
        return ret;
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
        for (int n = 100; n < 1000000; n*=10) {
            Double[] a = new Double[n];
            for (int i=0; i<n; i++){
                a[i] = StdRandom.random();
            }
            int[][] stats = Shell.sort(a);
            StdOut.println(n);
            for (int size : stats[0]) {
                StdOut.printf("%8d", size);
            }
            StdOut.println();
            for (int compares : stats[1]) {
                StdOut.printf("%8d", compares/n);
            }
            StdOut.println();
        }
}
}
