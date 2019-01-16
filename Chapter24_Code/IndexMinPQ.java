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
    public int minIndex(){
        return pq[1];
    }
    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void delete(int k) {
        exch(k, N--);
        swim(qp[k]);
        sink(qp[k]);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
    }
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
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
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

}


