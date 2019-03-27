import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;

public class InvertedConcordance {
    public static void main(String[] args)
    {
        int CONTEXT = 5;

        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        ST<Integer, SET<String>> ts = new ST<>();

        // build up inverted concordance
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            if(!ts.contains(i)){
                ts.put(i, new SET<String>());

            }
            SET<String> set = ts.get(i);
            set.add(s);
        }
        StdOut.println("Finished building inverted concordance");

        // Process queries
        while (!StdIn.isEmpty()){
            String query = StdIn.readString();
            SET<String> set = ts.get(Integer.parseInt(query));
            if (set == null) set = new SET<String>();
            for (String s : set) {
                StdOut.println("  " + s);
            }
            StdOut.println();
        }
    }
}
