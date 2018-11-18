import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_4_17{
    public static double closestPair(double[] a) {
        Stopwatch timer = new Stopwatch();
        double[] pair = fathest(a);
        double time = timer.elapsedTime();
        StdOut.printf("%8.4f, %8.4f\n", pair[0],pair[1]);
        return time;
    }
    public static double[] fathest(double[] a)
    {
        double[] pair = new double[2];
        int N = a.length;
        double max, min;
        max = min = a[0];
        for (int i = 1; i < N; i++){
            if (max < a[i])
                max = a[i];
            if (min > a[i])
                min = a[i];
        }
        pair[0] = max;
        pair[1] = min;
        return pair;
    }

    public static void main(String[] args){
        double MAX = 100000.0, prev = 0.0, time = 0.0;
        for (int N = 250; true; N += N){
            double[] a = new double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(-MAX, MAX);
            time = closestPair(a);
            StdOut.printf("%6d %8.5f %8.5f ", N, time, prev);
            if (N > 250 && time > 0.0 && prev > 0.0)
                StdOut.printf("%5.1f\n", time/prev);
            else
                StdOut.printf("%5.1f\n", 0.0);
            prev = time;
        }
    }
}
