import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class MinMaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MinMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N == 0; 
    }
    public int size(){
        return N;
    }
    public void insert(Key x) {
        // TODO
        pq[++N] = x;
        BubbleUp(N);
        show();
       // swim(N);
    }
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = pq[1];
        return key;
    }
    public Key max() {
    // TODO
        Key maxkey = null;
        if (greater(2, 3))
            maxkey = pq[2];
        else
            maxkey = pq[3];

        return maxkey;
    }

    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, N--);
        TrickleDownMin(1);
        //sink(1);
        pq[N+1] = null; // to avoid loiteriq and help with garbage collection.
        return min;
    }
    public Key delMax() {
        // TODO
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key maxkey = null;
        int k = 1;
        if (N >= 3) {
            if (greater(2, 3)){
                maxkey = pq[2];
                exch(2, N--);
                k = 2;
            }   
            else{
                maxkey = pq[3];
                exch(3, N--);
                k = 3;
            }
        }else //if (N == 2)
        {
            maxkey = pq[N--];
            k = N;
        }   
        TrickleDownMax(k);
        pq[N+1] = null; // to avoid loiteriq and help with garbage collection.
        return maxkey;

    }
    /*
    public boolean isMinHeap(){
        if (N <= 1) return true;
        for (int k = 1; k <= N; k++){
            if ((2*k) <= N && greater(k, 2*k)) return false;
            if ((2*k+1) <= N && greater(k, 2*k+1)) return false;
        }
        return true;
    }
    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > N) return true;
        int left = 2*k;
        int right = 2*k+1;
        if (left <= N && greater(k, left)) return false;
        if (right <= N && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
    */
    public void show() 
    {
        for (int i = 1; i < (N+1); i++)
            StdOut.print(pq[i]+" ");
        StdOut.println();
    }

    private void TrickleDown(int k) {
        if (k > N) return; //throw new NoSuchElementException("k is out of array.");
        int lv = level(k);
        if (lv % 2 == 0) // even is min level
        {
            TrickleDownMin(k);
            
        } else {
        // odd is max level 
            TrickleDownMax(k);
        }
    }
    private void TrickleDownMin(int k) {
        if (2*k > N) return; //throw new NoSuchElementException("k has not children."); 
        int m; // index of smallest of the children and grandchildren(if any) of A[k]
        m = getMinOfChildren(k);// TODO
        if (m > (2*k+1)) // grandchildren
        {
            if (less(m, k)){
                exch(k, m);
                int parent_m = getParent(m);
                if (greater(m, parent_m))
                    exch(m, parent_m);
                TrickleDownMin(m);
            }
        } else if(m > k && m < (2*k+1)){
            if (less(m, k))
                exch(m, k);
        }
    }
    private void TrickleDownMax(int k) {
        if (2*k > N) return; //throw new NoSuchElementException("k has not children."); 
        int m; // index of smallest of the children and grandchildren(if any) of A[k]
        m = getMaxOfChildren(k);// TODO
        if (m > (2*k+1)) // grandchildren
        {
            if (greater(m, k)){
                exch(k, m);
                int parent_m = getParent(m); // TODO
                if (less(m, parent_m))
                    exch(m, parent_m);
                TrickleDownMax(m);
            }
        } else if(m > k && m < (2*k+1)){
            if (greater(m, k))
                exch(m, k);
        }

    }
    private int getParent(int k) {
        int root = 0;
        if (k > 1) {

        int left = k;
        if (k % 2 == 1)
            left = k - 1;
        root = left / 2;
        }
        return root;

    }

    private int getMinOfChildren(int k) {
        /*
        int left = 2*k;
        int right = left + 1;
        int lleft = 2*left;
        int lright = lleft+1;
        int rleft = 2*right;
        int rright = rleft+1;
        */
        int[] subtree = new int[6];
        subtree[0] = 2*k;
        subtree[1] = subtree[0]+1;
        subtree[2] = 2*subtree[0];
        subtree[3] = subtree[2]+1;
        subtree[4] = 2*subtree[1];
        subtree[5] = subtree[4]+1;
        int minchild = subtree[0];
        for (int i = 1; i < 6; i++){
            if (subtree[i] > N)
                break;
            if (greater(minchild,  subtree[i]))
                minchild = subtree[i];
        }
        return minchild;

    }
    private int getMaxOfChildren(int k) {
        int[] subtree = new int[6];
        subtree[0] = 2*k;
        subtree[1] = subtree[0]+1;
        subtree[2] = 2*subtree[0];
        subtree[3] = subtree[2]+1;
        subtree[4] = 2*subtree[1];
        subtree[5] = subtree[4]+1;
        int maxchild = subtree[0];
        for (int i = 1; i < 6; i++){
            if (subtree[i] > N)
                break;
            if (less(maxchild ,subtree[i]))
                maxchild = subtree[i];
        }
        return maxchild;
    }

    private void BubbleUp(int k) {
        if (k > N) return;//throw new NoSuchElementException("k has not children."); 
        int parent_k = getParent(k);
        int lv = level(k);
        if (lv % 2 == 0) // min
        {
            if (parent_k > 0 && greater(k, parent_k)){
                exch(k, parent_k);
                BubbleUpMax(parent_k);
            }else{
                BubbleUpMin(k);
            }

        }else  // max
        {
            if (parent_k > 0 && less(k, parent_k)){
                exch(k, parent_k);
                BubbleUpMin(parent_k);
            }else {
                BubbleUpMax(k);
            }
        }
    }
    private void BubbleUpMin(int k) {
        int parent_kk, parent_k = getParent(k);
        if (parent_k > 0) {
            parent_kk = getParent(parent_k);
            if (parent_kk > 0) {
                if (less(k, parent_kk)){
                    exch(k, parent_kk);
                    BubbleUpMin(parent_kk);
                }
            }
        }
    }
    private void BubbleUpMax(int k) {
        int parent_kk, parent_k = getParent(k);
        if (parent_k > 0) {
            parent_kk = getParent(parent_k);
            if (parent_kk > 0) {
                if (greater(k, parent_kk)){
                    exch(k, parent_kk);
                    BubbleUpMax(parent_kk);
                }
            }
        }
    }

    // the level of the node k.
    private int level(int k) {
        return (int)Math.floor(Math.log(k)/Math.log(2));
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
    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        MinMaxPQ<Integer> pq = new MinMaxPQ<Integer>(n);
        for (Integer item : a){
            pq.insert(item);
        }
        //StdOut.println(pq.isMinHeap());
        //assert pq.isMinHeap();
        pq.show();
        StdOut.println("min:"+pq.min());
        StdOut.println("max:"+pq.max());
        StdOut.println("delmin:"+pq.delMin());
        pq.show();
        StdOut.println("delmax:"+pq.delMax());
        pq.show();
        StdOut.println("delmin:"+pq.delMin());
        pq.show();
        StdOut.println("delmax:"+pq.delMax());
        pq.show();
        StdOut.println("delmin:"+pq.delMin());
        pq.show();
        StdOut.println("delmax:"+pq.delMax());
        pq.show();
        StdOut.println("delmin:"+pq.delMin());
        pq.show();
        StdOut.println("delmax:"+pq.delMax());
        pq.show();

    }

}
