import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_1_29 
{
    public static int rank(int key, int[] a)
    {
        int lo = 0, m = -1;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                m = mid;
                hi = mid - 1;
            }
        }
        if (m >= 0)
        {
            StdOut.printf("key=%d, i=%d, j=%d ", key, m, count(key, a, m));
            StdOut.println();
        
            return m;

        }
        else
            return -1;
    }

    public static int count(int key, int[] a, int m)
    {
        int c = 0;
        for (int i = m; i < a.length; i++)
        {
            if (key == a[i])
                ++c;
            else
                break;

        }
        return c;
    }

    public static void main(String[] args)
    {
        // A deprecated API.
        //int[] whitelist = In.readInts(args[0]);
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        int key = Integer.parseInt(args[1]);

        Arrays.sort(whitelist);

        rank(key, whitelist);

        /*
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);

        }
        */

    }
}
