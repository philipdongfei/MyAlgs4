import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class FourSum {
    // print distinct 4-tuples (i,j,k,l) such that a[i]+a[j]+a[k]+a[l]=0
    public static int printAll(long[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    for (int l = k+1; l < N; l++)
                        if (a[i]+a[j]+a[k]+a[l] == 0)
                            StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l]);
        return cnt;
    }
    public static int count(long[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    for (int l = k+1; l < N; l++)
                        if (a[i]+a[j]+a[k]+a[l] == 0)
                            cnt++;
        return cnt;

    }
    public static void main(String[] args) {
        /*
        int N = StdIn.readInt();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readLong();
        }
        */
        In in = new In(args[0]);
        long[] a = in.readAllLongs();
        int cnt = count(a);
        StdOut.println(cnt);
        if (cnt < 10)
            printAll(a);
    }
}

