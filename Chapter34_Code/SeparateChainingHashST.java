import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;


public class SeparateChainingHashST<Key, Value>
{
    private static final int INIT_CAPACITY = 4;
    private final int[] PRIMES = {
        1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
        32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
        8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
        536870909, 1073741789, 2147483647
    };
    private int N;      // number of key-value pairs
    private int M;      // hash table size
    private double avgList; //
    private int lgM;

    private SequentialSearchST<Key, Value>[] st;  // array of ST objects

    public SeparateChainingHashST()
    { this(INIT_CAPACITY); }
    public SeparateChainingHashST(int M)
    {
        // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();

    }
    public SeparateChainingHashST(int M, double avgList)
    {
        // Create M linked lists.
        this.M = M;
        this.avgList = avgList;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();

        lgM = (int)(Math.log(M)/Math.log(2));
    }
    private double getLoadFactor()
    {
        if (M > 0)
            return (double)N/(double)M;
        return 0.0;
    }
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new 
            SeparateChainingHashST<Key, Value>(chains, avgList);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }
    private int hash(Key key)
    {
        //return (key.hashCode() & 0x7fffffff) % M;
        int t = key.hashCode() & 0x7fffffff;
        if (lgM < 26) t = t % PRIMES[lgM+5];
        return t % M;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException(
                "argument to contains() is null"
                );
        return get(key) != null;
    }

    public Value get(Key key)
    {
        if (key == null) throw new IllegalArgumentException(
                "argument to get() is null"
                );
        int i = hash(key);
        return (Value) st[i].get(key);
    }
    public void put(Key key, Value val)
    {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        
        //StdOut.println("put:" + getLoadFactor() + " " + avgList);
        //StdOut.println("put: " + N + "/" + M);
        // 
        if (getLoadFactor() >= avgList) {
            StdOut.println("put resize 2*M");
            resize(2*M);
            lgM++;
        }
        if (N >= M/2) resize(2*M);
        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, val);
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete is null");
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        if (M > INIT_CAPACITY && getLoadFactor() <= (avgList/4.0)){
            StdOut.println("put resize M/2");
            resize(M / 2);
            lgM--;
        }
        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2*M) resize(M/2);

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
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = 
            new SeparateChainingHashST<String, Integer>(3, 0.2);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
