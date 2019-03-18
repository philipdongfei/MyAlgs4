import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;


public class DeDup {
    private DeDup() {}

    public static void main(String[] args)
    {
        //HashSet<String> set;
        //set = new HashSet<String>();
        SET<String> set = new SET<String>();
        while (!StdIn.isEmpty())
        {
            String key = StdIn.readString();
            if (!set.contains(key))
            {
                set.add(key);
                StdOut.print(key + " ");
            }
        }
        StdOut.println();
    }
}
