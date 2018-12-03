import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_4_38 {
    public static class ThreeSum {
        public static int count(int[] a) {
            int count = 0;
            for (int i = 0; i < a.length; i++){
                for (int j = i+1; j < a.length; j++)
                    for (int k = j+1; k < a.length; k++)
                        if (a[i]+a[j]+a[k] == 0)
                            count++;
            }
            return count;
        }

        public static int count2(int[] a) {
            int count = 0;
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a.length; j++)
                    for (int k = 0; k < a.length; k++)
                        if (i < j && j < k)
                            if (a[i] + a[j] + a[k] == 0)
                                count++;
            return count;
        }
    }
    public static class DoublingTest{
        private static final int MAXIMUM_INTEGER = 1000000;

        public static double timeTrial(int n, int v) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
            }
            Stopwatch timer = new Stopwatch();
            if (v == 1) ThreeSum.count(a);
            else    ThreeSum.count2(a);
            return timer.elapsedTime();
        }
    }

    public static void main(String[] args) {
        StdOut.printf("%7s %8s %8s %8s\n", "size", "v1", "v2", "v2/v1");
        for (int i = 250; true; i += i) {
            double t1 = DoublingTest.timeTrial(i, 1);
            double t2 = DoublingTest.timeTrial(i, 2);
            StdOut.printf("%7d %8.3f %8.3f %8.3f\n", i, t1, t2, t2/t1);
        }
    }
}
