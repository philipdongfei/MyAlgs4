import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_4_39 {
    
    public static class DoublingRatio {
        public static double timeTrial(int N) {
            int MAX = 1000000;
            int[] a = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(-MAX, MAX);
            Stopwatch timer = new Stopwatch();
            int cnt = ThreeSum.count(a);
            return timer.elapsedTime();
        }
    }
    public static void main(String[] args) {
        DoublingRatio dr = new DoublingRatio();
        double prev = dr.timeTrial(125);
        double time, totaltime = 0.0 ;
        for (int N = 250; true; N += N){
            StdOut.printf("%6d ", N);
            for(int i = 0; i < 1000; i++) {
                time = dr.timeTrial(N);
                totaltime += time;
                if (i == (10-1) || i == (100-1)){
                    time = totaltime / (double)(i+1.0);
                    StdOut.printf("%9.3f div %9.3f ", time, prev);
                    if (prev > 0.0)
                        StdOut.printf("%7.3f ", time/prev);
                    else
                        StdOut.printf("%7.3f ", 0.0);
                }
            }
            time = totaltime / 1000.0;
            StdOut.printf("%9.3f div %9.3f ", time,prev);
            if (prev > 0.0)
                StdOut.printf("%7.3f\n", time/prev);
            else
                StdOut.printf("%7.3f\n", 0.0);
            prev = time;
        }
    }
}
