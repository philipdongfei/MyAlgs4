import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int n;      // number of elements on PQ
    private int[] pq;   // binary heap using 1-based indexing
    private int[] qp;   // inverse of pq - qp[pq[i]] = pq[qp[i]] = i.
    private Key[] keys; // keys[i] = priority of i.

    /**
     * Initializes an empty indexed priority queue with indices between
     * {@code 0} and {@code minN-1}.
     *
     * @param minN the keys on this priority queue are index from {@code 0} to {@code minN-1}
     * @throws IllegalArgumentException if {@code minN < 0}
     **/
    public IndexMinPQ(int minN) {
        if (minN < 0) throw new IllegalArgumentException();
        n = 0;
        keys = (Key[])new Comparable[minN+1]; // make this of length minN
        pq = new int[minN+1];
        qp = new int[minN+1];   // make this of length minN
        for (int i = 0; i <= minN; i++)
            qp[i] = -1;
    }
    /**
     * Returns true if this priority queue is empty.
     * @return{@code true} if this priority queue is empty;
     *          {@code false} otherwise
     **/
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Is {@code i} an index on this priority queue?
     * @param i an index
     * @return {@code true} if {@code i} is an index on this priority queue;
     *          {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= i < minN}
     */
    public boolean contains(int i) {
        return qp[i] != -1;
    }
    /**
     * Returns the number of keys on this priority queue.
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }
    /**
     * Associate key with index i.
     *
     * @param i an index
     * @param key the key to associate with index {@code i}
     * @throw IllegalArgumentException unless {@code 0 <= i < minN}
     * @throw IllegalArgumentException if there already is an item
     *          associated with index {@code i}
     **/
    public void insert(int i, Key key) {
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }
    /**
     * Returns an index associated with a minimum key.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     **/
    public int minIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     **/
    public Key minKey() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * Removes a minimum key and returns its associated index.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this Priority queue is empty.
     **/
    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);

        assert pq[n+1] == min;
        qp[min] = -1;    // delete
        keys[min] = null;  // to help with garbage collection
        pq[n+1] = -1;    // not needed
        return min;
    }
    /**
     * Returns the key associated with index {@code i}.
     *
     * @param i the index of the key to return
     * @return the key associated with index {@code i}
     * @throws IllegalArgumentException unless {@code 0<=i< minN}
     * @throws NoSuchElementException no key is associated with index{@code i}
     **/
    public Key keyOf(int i) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    /**
     * Change the key associated with index{@code i} to the specified value.
     * @param i the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0<=i<minN}
     **/
    public void changeKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }
    /**
     * Change the key associated with index {@code i} to the specified value.
     * @param i the index of the key to change.
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0<=i<minN}
     * @deprecated Replace by {@code changeKey(int, Key)}.
     **/
    @Deprecated
    public void change(int i, Key key) {
        changeKey(i, key);
    }
    /**
     * Increase the key associated with index {@code i} to the specified value.
     * @param i the index of the key to increase
     * @param key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0<=i< minN}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index{@code i}
     */
    public void increaseKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        swim(qp[i]);
    }
    /**
     * Decrease the key associated with index {@code i} to the specified value.
     * @param i the index of the key to decrease
     * @param key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless (@code 0 <= i < minN)
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index {@code i}
     */
    public void decreaseKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        sink(qp[i]);
    }
    /**
     * Remove the key on the priority queue associated with index {@code i}.
     * @param i the index of the key to remove
     * @throw IllegalArgumentException unless {@code 0 <= i < minN}
     * @throw NoSuchElementException no key is associated with index {@code i}
     */
    public void delete(int i) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[i]]) < 0;
    }
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[i]]) > 0;
    }
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**
     * Returns an iterator that iterates over the keys on the
     * priority queue in descending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }
    private class HeapIterator implements Iterator<Integer>{
        // create a new pq
        private IndexMinPQ<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator(){
            copy = new IndexMinPQ<Key>(pq.length-1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);

        }
        public boolean hasNext() {return !copy.isEmpty();}
        public void remove() {throw new UnsupportedOperationException();}
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        // insert a bunch of strings.
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++)
            pq.insert(i, strings[i]);
        //print each key using the iterator
        for (int i : pq) {
            StdOut.println(i + " " + strings[i]);
        }
        StdOut.println();

        // increase or decrease the key
        for (int i = 0; i < strings.length; i++) {
            if (StdRandom.uniform() < 0.5)
                pq.increaseKey(i, strings[i]+strings[i]);
            else
                pq.decreaseKey(i, strings[i].substring(0,1));
        }
        // delete and print each key.
        while (!pq.isEmpty()) {
            String key = pq.minKey();
            int i = pq.delMin();
            StdOut.println(i + " " + key);
        }
        StdOut.println();

        // reinsert the same strings.
        for (int i = 0; i < strings.length; i++)
            pq.insert(i, strings[i]);
        // delete them in random order.
        int[] perm = new int[strings.length];
        for (int i = 0; i < strings.length; i++)
            perm[i] = i;
        StdRandom.shuffle(perm);
        for (int i = 0; i < perm.length; i++) {
            String key = pq.keyOf(perm[i]);
            pq.delete(perm[i]);
            StdOut.println(perm[i]+" "+key);
        }
    }
}
