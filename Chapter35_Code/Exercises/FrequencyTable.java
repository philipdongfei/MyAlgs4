import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.ST;


public class FrequencyTable<Key extends Comparable<Key>>{
    private ST<Key, Integer> st = new ST<Key, Integer>();

    public void hit(Key key){
        if (st.contains(key))
            st.put(key, st.get(key)+1);
        else
            st.put(key, 1);
    }
    public int count(Key key){
        if (st.contains(key)) return st.get(key);
        else                  return 0;
    }
    public void show(){
        for (Key key : st.keys())
            StdOut.println(st.get(key) + " " + key);
    }
    public static void main(String[] args){
        FrequencyTable<String> freq = new FrequencyTable<String>();
        while (!StdIn.isEmpty()){
            String key = StdIn.readString();
            freq.hit(key);
        }
        freq.show();
    }
}
