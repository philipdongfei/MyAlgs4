import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Inversions;
import java.util.Arrays;

public class KendallTau {
    // return Kendall tau distance between two permutations
    public static long distance(int[] a, int[] b) {
        if (a.length != b.length)
            throw new IllegalArgumentException("Array dimensions disagreee");
        int n = a.length;

        int[] ainv = new int[n];
        for (int i = 0; i < n; i++)
            ainv[a[i]] = i;

        Integer[] bnew = new Integer[n];
        for (int i = 0; i < n; i++)
            bnew[i] = ainv[b[i]];

        return Inversions.count(bnew);
    }

    // return a reandom permutation of size n
    public static int[] permutation(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;
        StdRandom.shuffle(a);
        return a;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //int[] a = KendallTau.permutation(n);
        //int[] b = KendallTau.permutation(n);
        int[] a = {0, 3, 1, 6, 2, 5, 4};
        int[] b = {1, 0, 3, 6, 4, 2, 5};

        // print initial permutation
        for (int i = 0; i < n; i++)
            StdOut.println(a[i] + " " + b[i]);
        StdOut.println();

        StdOut.println("inversions = " + KendallTau.distance(a, b));
    }
}
