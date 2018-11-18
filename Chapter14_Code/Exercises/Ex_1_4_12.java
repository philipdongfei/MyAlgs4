import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_4_12{
    public static void getCommonNum(int[] a, int[] b) {
        int N = a.length, cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(a[i], b) > i)
            {
                cnt++;
                //StdOut.printf("%d ", a[i]);
                //StdOut.println(a[i]);
            }    
        }
        //StdOut.println("Common: "+cnt);
    }

    public static void main(String[] args) {
        double prev = 0, time = 0;
        int MAX = 10000;
        for (int N  = 250; true; N+=N) {
            int[] a = new int[N];
            int[] b = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(-MAX,MAX);
                b[i] = StdRandom.uniform(-MAX,MAX);
            }
            //StdOut.println("N="+N);
            Arrays.sort(a);
            Arrays.sort(b);
            Stopwatch timer = new Stopwatch();
            getCommonNum(a, b);
            time = timer.elapsedTime();
            if (N > 250 ) {
                StdOut.printf("%6d %7.1f ", N, time);
                if (prev > 0)
                    StdOut.printf("%5.1f\n", time/prev);
                else
                    StdOut.printf("%5.1f\n", prev);
            }
            prev = time;
        } 
    }
}
