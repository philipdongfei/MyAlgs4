import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
//import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;

public class Ex3_4_3 {
    public static class SeparateChainingHashST<Key, Value>
    {
        private int N;      // number of key-value pairs
        private int M;      // hash table size
        private SequentialSearchST<Key, Value>[] st;  // array of ST objects
    
        public SeparateChainingHashST()
        { this(997); }
        public SeparateChainingHashST(int M)
        {
            // Create M linked lists.
            this.M = M;
            st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
            for (int i = 0; i < M; i++)
                st[i] = new SequentialSearchST();
            N = 0;
    
        }
        public int size() {
            return N;
        }
        public boolean isEmpty() {
            return size() == 0;
        }
        private int hash(Key key)
        {
            return (key.hashCode() & 0x7fffffff) % M;
            //return (11 key) % M;
        }
        public Value get(Key key)
        {
            return (Value) st[hash(key)].get(key);
        }
        public void put(Key key, Value val)
        {
            int i = hash(key);
            if (!st[i].contains(key))
                N++;
            st[i].put(key, val, N);
        }
        public void deleteNodes(int k) {
            if (k < 0)
                throw new IllegalArgumentException("K cannot be negative");
            if (N == 0)
                return;

            for (Key key : keys())
            {
                if (st[hash(key)].greater(key, k))
                {
                    st[hash(key)].delete(key);
                    N--;

                }
            }

        }
        public void delete(Key key) {

        }
        public Iterable<Key> keys()
        {
            Queue<Key> queue = new Queue<Key>();
            for (int i = 0; i < M; i++) {
                for (Key key : st[i].keys())
                    queue.enqueue(key);
            }
            return queue;
        }
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        SeparateChainingHashST<String, Integer> st = 
            new SeparateChainingHashST<String, Integer>(5);
        for (int i = 0; i < a.length; i++)
        {
            st.put(a[i], i);
        }
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
        int[] kVal = {8,7,6,4,3,2,0};
        for (int k : kVal) {
            StdOut.println("delete k: " + k);
            st.deleteNodes(k);
            StdOut.println("size: " + st.size());
            for (String key : st.keys())
                StdOut.println(key + " " + st.get(key));
            StdOut.println();
        }
    }

}
