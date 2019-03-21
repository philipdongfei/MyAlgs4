import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Bag;

public class Ex3_5_14 {
    public static ST<String, Bag<String>> invert(ST<String, Bag<String>> st)
    {
        ST<String, Bag<String>> ts = new ST<String, Bag<String>>();
        for (String k : st.keys()) {
            for (String v : st.get(k)){
                String key = v; 
                String val = k;
                if (!ts.contains(key))
                    ts.put(key, new Bag<String>());
                ts.get(key).add(val);

            }
        }
        return ts;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        String sp = args[1];

        ST<String, Bag<String>> st = new ST<String, Bag<String>>();

        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for (int i = 1; i < a.length; i++)
            {
                String val = a[i];
                if (!st.contains(key)) st.put(key, new Bag<String>());
                st.get(key).add(val);
            }
        }
        ST<String, Bag<String>> ts = invert(st);

        while(!StdIn.isEmpty())
        {
            String query = StdIn.readLine();
            if (st.contains(query))
                for (String s : st.get(query))
                    StdOut.println(" " + s);
            
            if (ts.contains(query))
                for (String s : ts.get(query))
                    StdOut.println(" " + s);
        }
    }
}
