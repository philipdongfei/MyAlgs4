import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import java.util.Arrays;

public class FullyIndexCSV {
    public static void main(String[] args)
    {
        In in  = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        ST<String, String>[] st = null;
        while (in.hasNextLine())
        {
            String line = in.readLine();
            String[] tokens = line.split(",");
            int len = tokens.length;
            if (st == null)
                st = new ST<String, String>[len]();
            for(int i = 0; i < len; i++)
            {
                if (st[i] == null)
                    st[i] = new ST<String, String>();
                if (!st[i].contains(tokens[i]))
                {
                    st[i].put(tokens[i], line);
                }
            }
        }
    }
}
