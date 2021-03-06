import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import java.util.Arrays;

public class Ex3_1_9 {

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);  //key-length cutoff
        //ST<String, Integer> st = new ST<String, Integer>();
        ST<String, Integer> st = new ST<String, Integer>();
        String last = "";
        int number = 0;
        while (!StdIn.isEmpty()) 
        { // Build symbol table and count frequencies.
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word)+1);
            number++;
            last = word;
        }
        StdOut.println("last: "+last);
        StdOut.println("the number of words:"+number);
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
    }
}
