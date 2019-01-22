import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class Ex2_4_31 {

    public  static class MinPQ<Key extends Comparable<Key>>{
        private Key[] pq;
        private int N = 0;
    
        public MinPQ(int maxN) {
            pq = (Key[]) new Comparable[maxN+1];
        }
        public boolean isEmpty(){
            return N == 0; 
        }
        public int size(){
            return N;
        }
        public void insert(Key x) {
            pq[++N] = x;
            swim(N);
        }
        public void insertX(Key x) {
            pq[++N] = x;
            swimX(N);
        }
        public Key min() {
            if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
            Key key = pq[1];
            return key;
        }
        public Key delMin() {
            if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
            Key min = pq[1];
            exch(1, N--);
            sink(1);
            pq[N+1] = null; // to avoid loiteriq and help with garbage collection.
            return min;
        }
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
        public void show() 
        {
            for (int i = 1; i < (N+1); i++)
                StdOut.print(pq[i]+" ");
            StdOut.println();
        }
        private void swim(int k)
        {
            while (k > 1 && greater(k/2, k)){
                exch(k/2, k);
                k = k/2;
            }
        }
        
        private void swimX(int k) {
            if (k == 1) return;
            int ancestor = binaryofsearch(k);
            StdOut.println("ancestor="+pq[ancestor]+"k="+pq[k]);
            while (k/2 >= ancestor) {
                exch(k, k/2);
                k = k/2;
            }
        }
        private int binaryofsearch(int k) {
            int ancestor = k;
            int level = (int)((Math.log(N)/Math.log(2)));
            StdOut.println("N="+N+",level="+level);
            
            int[] parentsIndex = new int[level];
            int index = level-1; 
            for (int i = k/2; i >= 1; i /= 2){
                parentsIndex[index] = i; 
                //StdOut.println("index="+index+",i="+i);
                index--;
            }
            int lo = 0;
            int hi = level-1;
            StdOut.println("lo="+lo+",hi="+hi);
            int mid;
            while (lo <= hi) {
                mid = lo + (hi-lo)/2;
                StdOut.println("mid="+mid+" index="+parentsIndex[mid]);
                if (greater(parentsIndex[mid], k)){
                    hi = mid-1;
                    ancestor = parentsIndex[mid];
                    //if (ancestor == 1)
                    //    break;
                } else {
                    lo = mid + 1;
                }
            }
            
            return ancestor;
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
        private void exch(int i, int j) {
            Key swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }
        public static void main(String[] args) {
            String[] a = StdIn.readAllStrings();
            int n = a.length;
            MinPQ<String> pq = new MinPQ<String>(n);
            for (String item : a){
                pq.insert(item);
            }
            //StdOut.println(pq.isMinHeap());
            assert pq.isMinHeap();
            pq.show();
        }
    
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        MinPQ<String> pq = new MinPQ<String>(n);
        MinPQ<String> pqX = new MinPQ<String>(n);
        for (String item : a){
            pq.insert(item);
            pqX.insertX(item);
        }
        //StdOut.println(pq.isMinHeap());
        assert pq.isMinHeap();
        pq.show();
        assert pqX.isMinHeap();
        pqX.show();
    }
}
