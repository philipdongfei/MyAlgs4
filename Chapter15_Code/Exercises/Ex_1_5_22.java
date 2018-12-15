import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_5_22 {
    public static class ErdosRenyi {
        private ErdosRenyi(){}
        public static int count(int n){
            int result = 0;
            WeightedQuickUnionUF uf = 
                new WeightedQuickUnionUF(n);
            while (uf.count() > 1) {
                result++;
                int p = StdRandom.uniform(n);
                int q = StdRandom.uniform(n);
                if (uf.connected(p,q)) continue;
                uf.union(p,q);
            }
            return result;
        }
        public static int countQF(int n){
            int result = 0;
            QuickFindUF uf = 
                new QuickFindUF(n);
            while (uf.count() > 1) {
                result++;
                int p = StdRandom.uniform(n);
                int q = StdRandom.uniform(n);
                if (uf.connected(p,q)) continue;
                uf.union(p,q);
            }
            return result;
        }
        public static int countQU(int n){
            int result = 0;
            QuickUnionUF uf = 
                new QuickUnionUF(n);
            while (uf.count() > 1) {
                result++;
                int p = StdRandom.uniform(n);
                int q = StdRandom.uniform(n);
                if (uf.connected(p,q)) continue;
                uf.union(p,q);
            }
            return result;
        }
    }

        public static void main(String[] args) {
            int runs = 10;
            int max = 100000;

            // QuickUnion
            StdOut.println("QuickUnion");
            StdOut.printf("%8s %8s %8s\n", "N",
                    "Cons", "Ratio");
            double prev = 0;
            for (int n = 500; n < max; n+=n) {
                int count = 0;
                Stopwatch s = new Stopwatch();
                for (int i = 0; i < runs; i++)
                    count += ErdosRenyi.countQU(n);
                double ratio = prev > 0 ? s.elapsedTime()/prev : 0;
                prev = s.elapsedTime();
                StdOut.printf("%8d %8d %6.1f\n", n, count/runs, ratio);
            }

            // QuickFind
            StdOut.println("QuickFind");
            StdOut.printf("%8s %8s %8s\n", "N",
                    "Cons", "Ratio");
            prev = 0;
            for (int n = 500; n < max; n+=n) {
                int count = 0;
                Stopwatch s = new Stopwatch();
                for (int i = 0; i < runs; i++)
                    count += ErdosRenyi.countQF(n);
                double ratio = prev > 0 ? s.elapsedTime()/prev : 0;
                prev = s.elapsedTime();
                StdOut.printf("%8d %8d %6.1f\n", n, count/runs, ratio);
            }

            // WeightedQuickUnionUF
            StdOut.println("WeightedQuickUnionUF");
            StdOut.printf("%8s %8s %8s\n", "N",
                    "Cons", "Ratio");
            prev = 0;
            for (int n = 500; n < max; n+=n) {
                int count = 0;
                Stopwatch s = new Stopwatch();
                for (int i = 0; i < runs; i++)
                    count += ErdosRenyi.count(n);
                double ratio = prev > 0 ? s.elapsedTime()/prev : 0;
                prev = s.elapsedTime();
                StdOut.printf("%8d %8d %6.1f\n", n, count/runs, ratio);
            }
        }
    
}
