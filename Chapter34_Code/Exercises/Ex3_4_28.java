import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
//import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;

public class Ex3_4_28 {
public class LinearProbingHashST<Key, Value>
{
    private int N;      // number of key-value pairs in the table.
    private int M = 16; // size of linear-probing table
    private Key[] keys;  // the keys
    private Value[] vals; // the values.
    private int TotalCmpOfHit; // total number of compares for hit
    private int TotalCmpOfMiss;

    public LinearProbingHashST()
    {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        TotalCmpOfHit = 0;
        TotalCmpOfMiss = 0;
    }
    public LinearProbingHashST(int Size)
    {
        keys = (Key[]) new Object[Size];
        vals = (Value[]) new Object[Size];
        TotalCmpOfHit = 0;
        TotalCmpOfMiss = 0;
    }
    public double getLoadFactor(){
        return (double)N/(double)M;
    }
    public double getAvgCostOfHit() {
        StdOut.println("Hit: " + 0.5 *(1.0 + (1.0/(1.0-getLoadFactor()))));
        return (double)TotalCmpOfHit/(double)N;
    }
    public double getAvgCostOfMiss() {
        StdOut.println("Miss: " + 0.5 *(1.0 + (1.0/Math.pow(1-getLoadFactor(), 2))));
        return (double)TotalCmpOfMiss/(double)N;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int hash(Key key)
    { 
        return (key.hashCode() & 0x7fffffff) % M; 
    }

    private void resize(int cap)
    {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
        TotalCmpOfHit = t.TotalCmpOfHit;
        TotalCmpOfMiss = t.TotalCmpOfMiss;
    }
    public void put(Key key, Value val)
    {
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");
        if (val == null){
            delete(key);
            return;
        }
        if (N >= M/2) resize(2*M);  // double M
        int i;
        int cmp = 1; 
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
        {
            cmp++;
            if (keys[i].equals(key)) 
            {
                vals[i] = val; 
                TotalCmpOfHit += cmp;
                return;
            }
        }
        TotalCmpOfMiss += cmp;
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public Value get(Key key)
    {
        int cmp = 1;
        for (int i = hash(key); keys[i] != null; i = (i+1)%M)
        {
            cmp++;
            if (keys[i].equals(key))
            {
                TotalCmpOfHit += cmp;
                return vals[i];

            }
        }
        TotalCmpOfMiss += cmp;
        return null;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public void delete(Key key)
    {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % M;
        while (keys[i] != null)
        {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);

    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
    
}

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
