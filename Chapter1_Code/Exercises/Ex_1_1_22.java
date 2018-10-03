import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_1_22
{
    
    public static int rank(int key, int[] a, int lo, int hi)
    {
        StdOut.printf("lo=%d, hi=%d\n", lo, hi);

        if (lo > hi)
            return -1;
        int mid = lo + (hi-lo)/2;

        if (key < a[mid])
            return rank(key, a, lo, mid-1);
        else if (key > a[mid])
            return rank(key, a, mid+1, hi);
        else
            return mid;
        
    }

    public static int traces(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;

        return rank(key, a, lo, hi);
    }

    
    public static void main(String[] args)
    {
        // A deprecated API.
        //int[] whitelist = In.readInts(args[0]);
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (traces(key, whitelist) == -1)
                StdOut.println(key);

        }

    }
}
