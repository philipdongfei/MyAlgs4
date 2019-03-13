import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
//import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;

public class Ex3_4_20 {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        ///M = 4 
        StdOut.println("read file " + a.length);
        LinearProbingHashST<String, Integer> st = 
            new LinearProbingHashST<String, Integer>();
        for (int i = 0; i < a.length; i++)
        {
            st.put(a[i], i);
        }
        StdOut.println("avg cost of hit: " + st.getAvgCostOfHit());
        StdOut.println("avg cost of miss: " + st.getAvgCostOfMiss());
        for (String key : st.keys())
            StdOut.println(key + " " + st.hash(key) + " " + st.get(key));
        StdOut.println("avg cost of hit: " + st.getAvgCostOfHit());
        StdOut.println("avg cost of miss: " + st.getAvgCostOfMiss());
        StdOut.println("delete C:");
        st.delete("C");
        for (String key : st.keys())
            StdOut.println(key + " " + st.hash(key) + " " + st.get(key));
        StdOut.println("avg cost of hit: " + st.getAvgCostOfHit());
        StdOut.println("avg cost of miss: " + st.getAvgCostOfMiss());

        ///M = 10
        /*
        StdOut.println("M = 10");
        SeparateChainingHashST<String, Integer> st1 = 
            new SeparateChainingHashST<String, Integer>(10);
        for (int i = 0; i < a.length; i++)
        {
            st1.put(a[i], i);
        }
        for (String key : st1.keys())
            StdOut.println(key + " " + st1.hash(key) + " " + st1.get(key));
            */
    }


}
