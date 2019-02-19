import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex3_1_24 {
    public static void main(String[] args) 
    {
        int T = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double total = 0.0;
        for (int i = 0; i < T; i++) {
        InterpolationSearchST<Integer> st = new InterpolationSearchST<Integer>();
            for (int j = 0; j < N; j++) {
                Integer key = StdRandom.uniform(100);
                if (!st.contains(key)) st.put(key, 1);
                else                   st.put(key, st.get(key)+1);

            }
            for (Integer k : st.keys()){
                StdOut.println("key:"+k+" val:"+st.get(k));
            }
            total += st.size();
        }
        StdOut.printf("the average number of distinct keys: %8.2f\n", total/10.0);

    }
}
