//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Ex_1_1_28 
{
    public static void main(String[] args)
    {
        // A deprecated API.
        //int[] whitelist = In.readInts(args[0]);

        In in = new In(args[0]);
        List<Integer> list = new ArrayList<>();
        int[] whitelist = in.readAllInts();
        int index = 0, i;

        Arrays.sort(whitelist);

        for (i=0; i<whitelist.length; i++)
            StdOut.printf("%d ", whitelist[i]);
        StdOut.println();
        
        
        list.add(whitelist[0]);
        for (i = 1; i<whitelist.length;++i )
        {
            int j = i - 1;
            if (whitelist[i] != whitelist[j])
            {
                list.add(whitelist[i]);
            }
        }

        Integer[] newWhitelist = list.toArray(new Integer[list.size()]);

        for (i=0; i<newWhitelist.length;++i)
            StdOut.printf("%d ", newWhitelist[i]);
        StdOut.println();



    }

}
