import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class Sort2distinct {
    // rearranges a[] in ascending order assuming a[] has most 
    // 3 distinct values.
    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length-1;
        int i = 0;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0)        exch(a, lt++, i++);
            else if (cmp > 0)   exch(a, i, gt--);
            else    i++;
        }
    }

    // exchange a[i] and a[j].
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    // test client.
    public static void main(String[] args) {
        // parse command-line argument as an array of 1-character strings
        String s= args[0];
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = s.substring(i, i+1);

        // sort a print ressults
        sort(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }
}
