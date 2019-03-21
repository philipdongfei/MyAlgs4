import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Queue;


public class Ex3_5_12 {

    public static void main(String[] args) {
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        ST<String, Queue<String>> st = new ST<String, Queue<String>>();

        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            if (!st.contains(key))
                st.put(key,new Queue<String>());
            st.get(key).enqueue(val);
        }
        while (!StdIn.isEmpty()){
            String query = StdIn.readString();
            if (st.contains(query)) {
                for(String val : st.get(query))
                    StdOut.print(val + " ");
                StdOut.println();
            }
            else            StdOut.println("Not found");

        }
    }
}
