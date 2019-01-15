import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>>
{
    private int N;      // number of elements on PQ
    private int[] pq;   // binary heap using 1-based indexing
    private int[] qp;   // inverse: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // items with priorities.
    public IndexMinPQ(int maxN){
        keys = (Key[]) new Comparable[maxN+1];
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        for (int i=0; i <= maxN; i++) qp[i] = -1;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public boolean contains(int k) {
        return qp[k] != -1;
    }
    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }
    public Key min() {
        return keys[pq[1]];
    }
    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }
}


