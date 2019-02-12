import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;


public class Distinct {
    // return number of distinct entries in array a[]
    public static int distinct(Comparable[] a) {
        if (a.length == 0) return 0;
        Arrays.sort(a);
        int distinct = 1;
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) != 0)
                distinct++;
        return distinct;
    }
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);

        int[] distinct = new int[trials];
        for (int t = 0; t < trials; t++) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = StdRandom.uniform(m);
            distinct[t] = distinct(a);
        }
        double empirical = StdStats.mean(distinct);
        double alpha = (double) n/m;
        double theoretical = m * (1 - Math.exp(-alpha));
        StdOut.printf("Theoretical = %.3f\n", theoretical);
        StdOut.printf("Empirical   = %.3f\n", empirical);
    }
}
