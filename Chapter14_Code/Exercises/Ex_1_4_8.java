import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Ex_1_4_8{

    public static int count(int[] a)
    {    // Count pairs that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0, i, j;
        for (i = 0; i < N; i++){
            for (j = i+1; j < N; j++)
            {
                if (a[i] != a[j])
                {
                    if (j > i+1) {
                        StdOut.println("equal: "+a[i]);
                        cnt++;
                    }
                    break;
                }
            }
            i = j;
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
