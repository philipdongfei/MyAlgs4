import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_10 
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1, premid = -1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                // Modify:
                premid = mid;
                hi = mid - 1;
                StdOut.println("premid:"+premid);
            }
        //    StdOut.println("lo:"+lo+" hi:"+hi);
        }
        // Modify: 
        if (premid >= 0)
            return premid;
        return -1;
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
            int index;
            if ((index = rank(key, whitelist)) > -1){
                StdOut.println(index + ":" + key);
                if ((index-1) >= 0)
                    StdOut.println("whitelist["+(index-1)+"]:"+whitelist[index-1]);
            }
        }
    }
}
