import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.Math;

public class Ex_1_4_44{
    public static int untilRepeat(int n) {
        int count = 0;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int r = StdRandom.uniform(n);
        while (!h.containsKey(r)) {
            h.put(r, 1);
            r = StdRandom.uniform(n);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int runs = 100;
        for (int n = 100; n < 10000000; n += n) {
            double hypo = Math.sqrt(Math.PI * n / 2);
            double count = 0;
            for (int i = 0; i < runs; i++) {
                count += untilRepeat(n);
            }
            StdOut.printf("%8d %7.1f %7.1f\n", n, count/runs, hypo);
        }
    }
}
