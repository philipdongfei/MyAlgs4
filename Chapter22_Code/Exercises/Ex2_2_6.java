import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_2_6 {
    public static void main(String[] args) {
        int height = (int)(6*512*Math.log(512)/Math.log(2));
        StdDraw.setXscale(0,512);
        StdDraw.setYscale(0, height);
        int max = 512*2;

        for (int n = 0; n <= 512; n++) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform(max);
            }
            Merge.sort(a);
            int m = Merge.getAccess();
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform(max);
            }
            MergeBU.sort(a);
            int bu = MergeBU.getAccess();
            double limit = 6*n*Math.log(n)/Math.log(2);

            StdOut.printf("%4d %6d %6d %6.1f\n", 
                    n, m, bu, limit);

            // Draw
            StdDraw.setPenColor(200,0,0);
            StdDraw.point(n, m);
            StdDraw.setPenColor(0,0,200);
            StdDraw.point(n, bu);
            StdDraw.setPenColor(50,50,50);
            StdDraw.point(n, limit);
        }
    }
}
