import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class MTF_ArrayST<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Value[] vals;    // symbol table values
    private Key[]  keys;    // symbol table keys
    private int n = 0;      // number of elements in symbol table

    public MTF_ArrayST() {
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }

    // return the number of key-value pairs in the symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // resize the parallel arrays to the given capacity
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
        {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        keys = tempk;
        vals = tempv;
    }
    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {
        // to deal with duplicates
        delete(key);

        // double size of arrays if necessary.
        if (n >= vals.length) resize(2*n);

        // add new key add value at the end of array.
        vals[n] = val;
        keys[n] = key;
        n++;
    }
    public Value get(Key key) {
        for (int i = 0; i < n; i++)
        {
            if (keys[i].equals(key)) 
            {
                if (i == 0)
                    return vals[i];
                else { // move-to-front
                    Key k = keys[i];
                    Value v = vals[i];
                    for (int j = i; j > 0; j--)
                    {
                        vals[j] = vals[j-1];
                        keys[j] = keys[j-1];

                    }
                    vals[0] = v;
                    keys[0] = k;
                    return vals[0];
                }

            }

        }
        return null;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    // remove given key (and associated value)
    public void delete(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                if (n > 0 && n == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }

    public static void main(String[] args) {
        MTF_ArrayST<String, Integer> st = new MTF_ArrayST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
