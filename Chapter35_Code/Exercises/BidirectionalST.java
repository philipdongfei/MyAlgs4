import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import java.util.Arrays;


public class BidirectionalST {
    private ST<String, String> st;
    private ST<String, String> ts;

    BidirectionalST(){
        st = new ST<>();
        ts = new ST<>();
    }
    public void put(String key, String val)
    {
        if (key == null) throw new IllegalArgumentException("Illegal first");
        if (val == null) throw new IllegalArgumentException("Illegal second");
        st.put(key, val);
        ts.put(val, key);
    }
    public String getByKey(String key)
    {
        if (key == null) throw new IllegalArgumentException("Illegal first");
        String val = null;
        if (st.contains(key))
            val = st.get(key);
        return val;
    }
    public String getByValue(String val)
    {
        if (val == null) throw new IllegalArgumentException("Illegal second");

        String key = null;
        if (ts.contains(val))
            key = ts.get(val);
        return key;
    }
    public static void main(String[] args)
    {
        BidirectionalST BidST = new BidirectionalST();
        BidST.put("1", "a");
        BidST.put("2", "b");
        BidST.put("3", "c");
        BidST.put("4", "d");
        StdOut.println("key 2: " + BidST.getByKey("2"));
        StdOut.println("val d: " + BidST.getByValue("d"));
        

    }
}
