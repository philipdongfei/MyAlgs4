import java.lang.Math;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

public class InterpolationSearchST<Value>
{
    private Integer[] keys;
    private Value[] vals;
    private int N;
    private int Compares_N = 0;
    private static final int INIT_CAPACITY = 16;

    public InterpolationSearchST() {
        this(INIT_CAPACITY);
    }
    public InterpolationSearchST(int capacity) 
    {
        // See Algorithm 1.1 for standard array-resizing code.
        keys = (Integer[]) new Integer[capacity];
        vals = (Value[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            keys[i] = i;
        }
        Compares_N  = 0;
    }
    public int getCompares(){
        return Compares_N;
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Integer[] tempk = (Integer[]) new Integer[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        for (int j = N; j < capacity; j++)
            tempk[j] = j;
        vals = tempv;
        keys = tempk;
    }
    public int size() 
    { return N; }
    public boolean isEmpty()
    { return N == 0; }

    public Value get(Integer key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else                                      return null;
    }
    public int rank(Integer key)
    {
        int lo = 0, hi = N-1;
        //StdOut.println("lo:"+lo);
        //StdOut.println("hi:"+hi);
        
        while ((lo <= hi) && (keys[lo] != keys[hi]) && (key >= keys[lo]) &&
                (key <= keys[hi])) 
        {
            //StdOut.println("key[lo]:"+keys[lo]);
            //StdOut.println("key[hi]:"+keys[hi]);
            int mid; 
            mid  = lo + (int)Math.floor(((Integer)key - (Integer)keys[lo])/((Integer)keys[hi] - (Integer)keys[lo])); 
            Compares_N++;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public void put(Integer key, Value val)
    { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
        {
            vals[i] = val;
            return;
        }
        if (N == keys.length) resize(2*keys.length);

        for (int j = N; j > i; j--)
        {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; 
        vals[i] = val;
        N++;
    }
    public Integer delete(Integer key)
    {
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
        { // the key is found.
            Integer k = keys[i];
            for (int j = i; j < N-2; j++)
            {
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            keys[N-1] = null;
            vals[N-1] = null;
            N--;
            if (N > 0 && N == keys.length/4) resize(keys.length/2);
            return k;
        }
        return null;

    }
    public Integer min()
    {
        return keys[0]; 
    }
    public Integer max()
    {
        return keys[N-1];
    }
    public Integer select(int k)
    {
        return keys[k];
    }
    public Integer ceiling(Integer key)
    {
        int i = rank(key);
        return keys[i];
    }
    public Integer floor(Integer key)
    {
        int i = rank(key);
        Compares_N++;
        if (i < N && keys[i].compareTo(key) == 0)
            return keys[i];
        else
            return keys[i-1];

    }
    public boolean contains(Integer key) 
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
    public Iterable<Integer> keys() {
        return keys(min(), max());
    }

    public Iterable<Integer> keys(Integer lo, Integer hi)
    {
        Queue<Integer> q = new Queue<Integer>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

}
