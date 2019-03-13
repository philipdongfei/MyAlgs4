import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

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
    { return (key.hashCode() & 0x7fffffff) % M; }

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
        keys[i] = null;
        vals[i] = null;
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
