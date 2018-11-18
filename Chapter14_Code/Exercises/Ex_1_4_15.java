import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.HashMap;

public class Ex_1_4_15 {
    public static int count(int[] a) {
        double prev = 0, time = 0;
        Arrays.sort(a);
        int N = a.length, MAX = 250;

        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++)
            h.put(a[i], i);

        int cnt = 0;
            //Stopwatch timer = new Stopwatch();
            for (int i = 0; i < N; i++){
                for (int j = i+1; j < N; j++)
                    if (h.get(-a[i]-a[j]) != null && h.get(-a[i]-a[j]) > j)
                        cnt++;
            }
            /*
            time = timer.elapsedTime();
            if (N > 250 && time > 0 && prev > 0.0){
                StdOut.printf("%5.1f\n", prev);
                StdOut.printf("%6d %7.1f ", N, time);
                StdOut.printf("%5.1f\n", time/prev);
            }
            prev = time;
            */
        return cnt;
    }
    
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
