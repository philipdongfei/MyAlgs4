import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_23 
{
    public static int rank(int key, int[] a)
    {
        int lo = 0, prev = -1;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                prev = mid;
                lo = mid + 1;
            }
        }

        StdOut.println("prev="+prev);
        if (prev != -1)
            return prev;
        return -1;
    }

    public static void main(String[] args)
    {
        // A deprecated API.
        //int[] whitelist = In.readInts(args[0]);
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        for (int i = 0; i < whitelist.length; i++)
            StdOut.printf("%d:%d ",i, whitelist[i]);
        StdOut.println();

        int index, key = 30;
        if ((index = rank(key, whitelist)) != -1)
            StdOut.println(index + ":" + whitelist[index]);

    }
}
