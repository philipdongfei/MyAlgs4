import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.math.BigInteger;

public class Ex_1_4_40{
    public static int[] randomArray(int n, int min, int max) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(min, max);
        }
        Arrays.sort(a);
        int dupes = removeDuplicates(a);
        while (dupes > 0){
            for (int i = a.length - dupes; i < a.length; i++) {
                a[i] = StdRandom.uniform(min, max);
            }
            Arrays.sort(a);
            dupes = removeDuplicates(a);
        }
        return a;
    }
    public static int removeDuplicates(int[] a) {
        int sent = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[sent]) 
                a[++sent] = a[i];
        }
        return a.length - sent - 1;
    }

    public static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++){
            ret = ret.multiply(BigInteger.valueOf(N-k))
                .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 3;
        int min = 100000;
        int max = 10000000;
        StdOut.printf("%7s", "size");
        for (int i = min; i < max; i += i)
            StdOut.printf("%10d", i);
        StdOut.println("       M");

        for (int i = 100; true; i += i) {
            StdOut.printf("%7d", i);
            for (int j = min; j < max; j += j) {
                double count = 0;
                for (int k = 0; k < n; k++) {
                    int[] a = randomArray(i, -1*j, j);
                    count += ThreeSumFast.count(a);
                }
                StdOut.printf("%10.1f", count/n);
            }
            StdOut.println();
        }
    }
}
