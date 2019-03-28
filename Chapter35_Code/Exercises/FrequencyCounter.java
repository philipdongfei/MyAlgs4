import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.RedBlackBST;
import java.util.Arrays;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);  //key-length cutoff
        ST<Integer, SET<String>> alphabetSize = new ST<>();
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        RedBlackBST<Integer, SET<String>> ts  = new RedBlackBST<Integer, SET<String>>();
        while (!StdIn.isEmpty()) 
        { // Build symbol table and count frequencies.
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word)+1);

            if (!alphabetSize.contains(word.length()))
                alphabetSize.put(word.length(), new SET<String>());
            SET<String> wordst = alphabetSize.get(word.length());
            wordst.add(word);

        }
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
        {
            if (st.get(word) > st.get(max))
                max = word;
            StdOut.println(word + " " + st.get(word));
            Integer fq = st.get(word);
            if (!ts.contains(fq))
                ts.put(fq, new SET<String>());
            SET<String> set = ts.get(fq);
            set.add(word);
        }
        StdOut.println();
        StdOut.println("order of frequency: ");
        for (Integer fq : ts.keys()){
            StdOut.println(fq + " : ");
            for (String word : ts.get(fq))
                StdOut.println(" " + word);
        }
    
        StdOut.println(max + " " + st.get(max));
        StdOut.println();
        for (Integer size : alphabetSize.keys())
        {
            StdOut.println(size + ":");
            for (String word : alphabetSize.get(size))
                StdOut.println(" " + word);
        }

    }
}
