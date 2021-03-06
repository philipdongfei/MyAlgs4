import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex2_4_27 {

    public static class MaxPQ<Key extends Comparable<Key>>
    {
        private Key[] pq;    // heap-ordered complete binary tree
        private int N = 0;  // in pq[1..N] with pq[0] unused.
        private Key minkey = null;
        public MaxPQ(int maxN)
        {
            pq = (Key[]) new Comparable[maxN+1];
        }
        public MaxPQ(Key[] pq){
            N = pq.length;
            this.pq = (Key[]) new Comparable[N+1];
            for (int i=0; i<N; i++){
                this.pq[i+1] = pq[i];
            }
            for (int k = N/2; k >= 1; k--)
                sink(k);
            assert isMaxHeap();
        }
        public boolean isEmpty()
        {
            return N==0;
        }
        public int size()
        {
            return N;
        }
        public void insert(Key v)
        {
            if (N == pq.length-1) resize(2*pq.length);

            pq[++N] = v;
            if (minkey == null || v.compareTo(minkey) < 0)
                minkey = v;
            swim(N);
        }
        public Key delMax()
        {
            Key max = pq[1];    // Retrieve max key from top.
            exch(1, N--);       // Exchange with last item.
            pq[N+1] = null;     // Avoid loitering.
            sink(1);            // Restore heap property.
            return max; 
        }
        public Key minvalue(){
            int i = min(1, 1);
            if (i < 0)
                return null;
            return pq[i];
        } 
        public int min(int k, int v){
            if (isEmpty()) return -1;
            if (k > N) return v;
            int left = 2*k;
            int right = 2*k+1;
            //StdOut.println("N:"+N+" left:"+left+" right:"+right);
            if (left > N) return v;
            if (less(v, left))
                v = min(left, v);
            else
                v = min(left, left);
            if (right > N) return v;
            if (less(v, right))
                v = min(right, v);
            else
                v = min(right, right);
            return v;
           /*
           Key min;
            if (isEmpty())
                min= null;
            else if (N == 1)
                min= pq[1];
            else {
                int k = 1;
                int m = k;
                while (k <= N) {
                    int left = 2*k;
                    int right = 2*k+1;
                    StdOut.println("left:"+left+" right:"+right);
                    if ((left <= N)) m = left;
                    if ((right <= N) && less(right, min)) m = right;
                    k = min;
                }
                min= pq[mn];
            }
            return min;
            */
        }
        public Key min() {
            /*
            if (isEmpty())
                minkey = null;
            else if (N == 1)
                minkey = pq[1];
            else {
                int k = 1;
                int min = k;
                while (2*k < N) {
                    int left = 2*k;
                    int right = 2*k+1;
                    StdOut.println("left:"+left+" right:"+right);
                    if ((left <= N)) min = left;
                    if ((right <= N) && less(right, min)) min = right;
                    k = min;
                }
                minkey = pq[min];
            }
            */
            return minkey;
        }
        // helper function to double the size of the heap array
        private void resize(int capacity) {
            assert capacity > N;
            Key[] temp = (Key[]) new Object[capacity];
            for (int i = 1; i <= N; i++) {
                temp[i] = pq[i];
            }
            pq = temp;
    
        }
        public void show() 
        {
            for (int i = 1; i < (N+1); i++)
                StdOut.print(pq[i]+" ");
            StdOut.println();
        }
        public boolean isMaxHeap(){
            if (N <= 1) return true;
            for (int k = 1; k <= N; k++){
                if ((2*k) <= N && less(k, 2*k)) return false;
                if ((2*k+1) <= N && less(k, 2*k+1)) return false;
            }
            return true;
        }
        private boolean less(int i, int j)
        {
            return pq[i].compareTo(pq[j]) < 0;
        }
        private void exch(int i, int j)
        {
            Key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }
        private void swim(int k)
        {
            while (k > 1 && less(k/2, k))
            {
                exch(k/2, k);
                k = k/2;
            }
        }
        private void sink(int k)
        {
            while (2*k <= N)
            {
                int j = 2*k;
                if (j < N && less(j, j+1)) j++;
                if (!less(k, j)) break;
                exch(k, j);
                k = j;
            }
        }
    
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        MaxPQ<String> pq = new MaxPQ<String>(n);
        for (String s : a){
            if (s.compareTo("*") == 0)
            {
                StdOut.println(pq.min());
                StdOut.println(pq.minvalue());

            }   
            else
                pq.insert(s);
            pq.show();
        }
    }
}
