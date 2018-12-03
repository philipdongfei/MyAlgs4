import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.Math;

public class Ex_1_4_45 {
    public static int untilAll(int n) {
        HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
        int count = 0;
        while (h.size() < n) {
            h.put(StdRandom.uniform(n), 1);
            count++;
        }
        return count;
    }
    public static double harmonic(int n) {
        double h = 1.0/n;
        while (--n > 0) {
            h += 1.0/n;
        }
        return h;
    }
    public static void main(String[] args) {
        int runs = 22;
        for (int n = 1; n < 1000000; n += n){
            double hypo = n * harmonic(n);
            double count = 0;
            double count_max = Integer.MIN_VALUE;
            double count_min = Integer.MAX_VALUE;
            for (int i = 0; i < runs; i++){
                int c = untilAll(n);
                count += c;
                if (c > count_max) count_max = c;
                if (c < count_min) count_min = c;
            }
            double count_avg = (count - count_max - count_min) / (runs - 2);
            StdOut.printf("%8d %10.1f\n", n, count_avg, hypo);
        }
    }
}
