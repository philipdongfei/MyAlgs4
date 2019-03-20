import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.Queue;


public class Ex3_5_9 {

    public static class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private static final int INIT_CAPACITY = 2;
        private Key[] keys;
        private Value[] vals;
        private int N;
        private int Compares_N = 0;
    
        public BinarySearchST(){
            this(INIT_CAPACITY);
        }
    
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
        public int size(Key lo, Key hi) {
            if (lo.compareTo(hi) > 0) return 0;
            if (contains(hi)) return rank(hi) - rank(lo) + 1;
            else              return rank(hi) - rank(lo);
        }
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
                if (N > 0 && N == keys.length/4) resize(keys.length/2);
                return k;
            }
            return null;
    
        }
        public Key min()
        {
            if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
            return keys[0]; 
        }
        public Key max()
        {
            if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
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
            if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
            delete(min());
        }
        void deleteMax()
        {
            if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
            delete(max());
        }
        private void resize(int capacity) {
            assert capacity >= N;
            Key[] tempk = (Key[]) new Comparable[capacity];
            Value[] tempv = (Value[]) new Object[capacity];
            for (int i = 0; i < N; i++) {
                tempk[i] = keys[i];
                tempv[i] = vals[i];
            }
            //for (int j = N; j < capacity; j++)
            //    tempk[j] = j;
            vals = tempv;
            keys = tempk;
        }
        public Iterable<Key> keys() {
            return keys(min(), max());
        }
    
        public Iterable<Key> keys(Key lo, Key hi)
        {
            if (lo == null) throw new IllegalArgumentException("first arguement to keys() is null");
            if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
            Queue<Key> q = new Queue<Key>();
            if (lo.compareTo(hi) > 0) return q;
            for (int i = rank(lo); i < rank(hi); i++)
                q.enqueue(keys[i]);
            if (contains(hi))
                q.enqueue(keys[rank(hi)]);
            return q;
        }
    
    }
    public static void main(String[] args){

    }
}
