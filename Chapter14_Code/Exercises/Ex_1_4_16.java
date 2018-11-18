import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_4_16{
    public static double closestPair(double[] a) {
        Arrays.sort(a);
        Stopwatch timer = new Stopwatch();
        double[] pair = count1(a);
        double time = timer.elapsedTime();
        StdOut.printf("%8.2f, %8.2f\n", pair[0],pair[1]);
        return time;
    }

    public static double[] count(double[] a){
        double[] pair = new double[2];
        int N = a.length;
        pair[0] = a[0];
        pair[1] = a[1];
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++){
                if (Math.abs(a[i]-a[j]) < Math.abs(pair[0]-pair[1])){
                    pair[0] = a[i];
                    pair[1] = a[j];
                }
            }
        return pair; 
    }
    public static double[] count1(double[] a) {
        int x = 0, y = 1;
        int N = a.length;
        double closest = Math.abs(a[x]-a[y]);
        for (int i = 2; i < N; i++ ) {
            double dist = Math.abs(a[i]-a[i-1]);
            if (dist < closest){
                x = i;
                y = i-1;
                closest = dist;
            }
        }
        return new double[]{a[x], a[y]};
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
