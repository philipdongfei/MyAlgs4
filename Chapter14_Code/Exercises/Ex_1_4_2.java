import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class Ex_1_4_2 //ThreeSum
{
    public static int count(int[] a)
    {// Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        long total;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                {
                    total = (long)a[i] + (long)a[j] + (long)a[k];
                    if (total == 0)
                        cnt++;

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
