
import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] vals;
    private int N;
    private int Compares_N = 0;

    public BinarySearchST(int capacity) 
    {
        // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        Compares_N  = 0;
    }
    public int getCompares(){
        return Compares_N;
    }

    public int size() 
    { return N; }
    public boolean isEmpty()
    { return N == 0; }

    public Value get(Key key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else                                      return null;
    }
    public int rank(Key key)
    {
        int lo = 0, hi = N-1;
        while (lo <= hi) 
        {
            int mid = lo + (hi - lo)/2;
            Compares_N++;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public void put(Key key, Value val)
    { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
        {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--)
        {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; 
        vals[i] = val;
        N++;
    }
    public Key delete(Key key)
    {
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
        { // the key is found.
            Key k = keys[i];
            for (int j = i; j < N-2; j++)
            {
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            keys[N-1] = null;
            vals[N-1] = null;
            N--;
            return k;
        }
        return null;

    }
    public Key min()
    {
        return keys[0]; 
    }
    public Key max()
    {
        return keys[N-1];
    }
    public Key select(int k)
    {
        return keys[k];
    }
    public Key ceiling(Key key)
    {
        int i = rank(key);
        return keys[i];
    }
    public Key floor(Key key)
    {
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
            return keys[i];
        else
            return keys[i-1];

    }
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }
    void deleteMin()
    {
        delete(min());
    }
    void deleteMax()
    {
        delete(max());
    }
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

}
