import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;
import java.util.Arrays;


public class Concordance {
    public static void main(String[] args)
    {
        int wordIndex = 0;
        SET<String> strPunctuation = new SET<>();
        strPunctuation.add(".");
        strPunctuation.add(",");
        strPunctuation.add("!");
        ST<String, SET<Integer>> st = new
            ST<>();
        In in = new In(args[0]);
        while (in.hasNextLine()){
            String[] words = in.readLine().split(" ");

            for (String word : words){
                if (!strPunctuation.contains(word))
                {
                    if (!st.contains(word)){
                        st.put(word, new SET<Integer>());
                    }
                    st.get(word).add(wordIndex);
                    wordIndex++;
                }

            }
        }
        StdOut.println("Please enter the query word:");
        while (!StdIn.isEmpty())
        {
            String query = StdIn.readLine();
            if (st.contains(query))
                for (Integer index : st.get(query))
                    StdOut.println(" " + index);
        }
    }
}
