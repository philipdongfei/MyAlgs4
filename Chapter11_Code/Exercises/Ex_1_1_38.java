import java.util.Date;
//import edu.princeton.cs.algs4.Date;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_38
{
    public static int rank(int key, int[] a)
    {
        for (int i=0; i<a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }

    public static void main(String[] args)
    {
        // A deprecated API.
        //int[] whitelist = In.readInts(args[0]);
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        Date a = new Date();
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);

        }
        Date b = new Date();
        long c = b.getTime() - a.getTime();
        StdOut.printf("BruteForce time: %7dms\n", c);

    }
}
