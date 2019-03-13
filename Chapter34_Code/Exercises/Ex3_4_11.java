import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
//import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;

public class Ex3_4_11 {
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
    
        }
        private void resize(int chains) {
            SeparateChainingHashST<Key, Value> temp = 
                new SeparateChainingHashST<Key, Value>(chains);
            for (int i = 0; i < M; i++) {
                for (Key key : st[i].keys()) {
                    temp.put(key, st[i].get(key));
                }
            }
            this.M = temp.M;
            this.N = temp.N;
            this.st = temp.st;
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
            //return (key.hashCode() % M);
        }
        public Value get(Key key)
        {
            return (Value) st[hash(key)].get(key);
        }
        public void put(Key key, Value val)
        {
            if (2*N >= M) resize(2*M);
            st[hash(key)].put(key, val);
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

        ///M = 4 
        StdOut.println("M = 4");
        SeparateChainingHashST<String, Integer> st = 
            new SeparateChainingHashST<String, Integer>(4);
        for (int i = 0; i < a.length; i++)
        {
            st.put(a[i], i);
        }
        for (String key : st.keys())
            StdOut.println(key + " " + st.hash(key) + " " + st.get(key));
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
