import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import java.util.Arrays;
import java.lang.Math;

public class ErdosRenyi {
    public static int count(int n) {
        int edges = 0, pairs = 0;
        UF uf = new UF(n);
        while (uf.count() > 1) {
            int p = StdRandom.uniform(n);
            int q = StdRandom.uniform(n);
            pairs++;
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            edges++;
        }
        return pairs;

    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] edges = new int[trials];

        // repeat the experiment trials times
        for (int t = 0; t < trials; t++) {
            edges[t] = count(N);
            //StdOut.println(t + ":" + edges[t]);
        }
        
        // report statistics
        StdOut.println("1/2 n ln n = " + 0.5*N*Math.log(N));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    }
}

