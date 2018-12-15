import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_5_25 {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int p, q, max = 1000;
        double prev = 0;

        StdOut.println("QuickFind");
        StdOut.printf("%8s %8s %8s\n", "N",
                "Cons", "Ratio");

        for (int n = N; n < max; n += n) {
            Stopwatch s = new Stopwatch();
            int avg_cons = 0;
            for (int t = 0; t < T; t++) {
                RandomGrid grid = new RandomGrid();
                RandomGrid.Connection[] cons = RandomGrid.generate(n);
                //StdOut.println("cons size: "+cons.length);
                QuickFindUF uf = new QuickFindUF(n*n); 

                for (RandomGrid.Connection con : cons){
                    //StdOut.println(i + ": "+ con.p + " " + con.q);
                    p = con.p;
                    q = con.q;
                    p--;
                    q--;
                    if (uf.count() == 1)
                        break;
                    if (uf.connected(p, q)) continue;
                    uf.union(p, q);
                    avg_cons++;
                }
            } 
            double ratio = prev > 0 ? s.elapsedTime() / prev : 0;
            prev = s.elapsedTime();
            StdOut.printf("%8d %8d %6.1f\n", n, avg_cons/T, ratio);
        } 
        StdOut.println("QuickUnion");
        StdOut.printf("%8s %8s %8s\n", "N",
                "Cons", "Ratio");
        for (int n = N; n < max; n += n) {
            Stopwatch s = new Stopwatch();
            int avg_cons = 0;
            for (int t = 0; t < T; t++) {
                RandomGrid grid = new RandomGrid();
                RandomGrid.Connection[] cons = RandomGrid.generate(n);
                //StdOut.println("cons size: "+cons.length);
                QuickUnionUF uf = new QuickUnionUF(n*n); 

                for (RandomGrid.Connection con : cons){
                    //StdOut.println(i + ": "+ con.p + " " + con.q);
                    p = con.p;
                    q = con.q;
                    p--;
                    q--;
                    if (uf.count() == 1)
                        break;
                    if (uf.connected(p, q)) continue;
                    uf.union(p, q);
                    avg_cons++;
                }
            }
            double ratio = prev > 0 ? s.elapsedTime() / prev : 0;
            prev = s.elapsedTime();
            StdOut.printf("%8d %8d %6.1f\n", n, avg_cons/T, ratio);
        } 
        StdOut.println("WeightedQuickUnion");
        StdOut.printf("%8s %8s %8s\n", "N",
                "Cons", "Ratio");
        for (int n = N; n < max; n += n) {
            Stopwatch s = new Stopwatch();
            int avg_cons = 0;
            for (int t = 0; t < T; t++) {
                RandomGrid grid = new RandomGrid();
                RandomGrid.Connection[] cons = RandomGrid.generate(n);
                //StdOut.println("cons size: "+cons.length);
                WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n*n); 

                for (RandomGrid.Connection con : cons){
                    //StdOut.println(i + ": "+ con.p + " " + con.q);
                    p = con.p;
                    q = con.q;
                    p--;
                    q--;
                    if (uf.count() == 1)
                        break;
                    if (uf.connected(p, q)) continue;
                    uf.union(p, q);
                    avg_cons++;
                }
            }
            double ratio = prev > 0 ? s.elapsedTime() / prev : 0;
            prev = s.elapsedTime();
            StdOut.printf("%8d %8d %6.1f\n", n, avg_cons/T, ratio);
        } 
    }
}
        
    

