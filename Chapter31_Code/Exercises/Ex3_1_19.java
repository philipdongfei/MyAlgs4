import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import java.util.Arrays;


public class Ex3_1_19 {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);  //key-length cutoff
        ST<String, Integer> st = new ST<String, Integer>();
        while (!StdIn.isEmpty()) 
        { // Build symbol table and count frequencies.
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word)+1);


        }
        //StdOut.println("Compares: " + st.getCompares());
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        Queue<String> qMax = new Queue<String>();
        for (String word : st.keys())
        {
            if (st.get(word) > st.get(max))
            {
                while(!qMax.isEmpty())
                    qMax.dequeue();
                max = word;
                qMax.enqueue(word);

            } else if (st.get(word) == st.get(max))
            {
                qMax.enqueue(word);
            }
        }
        while (!qMax.isEmpty())
        {
            String maxes = qMax.dequeue();
            StdOut.println(maxes + " " + st.get(maxes));
        }
    }
    
}
