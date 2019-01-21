import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class MedianPQ<Key extends Comparable<Key>>{
    private MinPQ<Key> minpq;
    private MaxPQ<Key> maxpq;
    private int size;

    public MedianPQ(int maxN) {
        minpq = new MinPQ<Key>(maxN);
        maxpq = new MaxPQ<Key>(maxN);
        size = 0;
    }
    public void insert(Key key) {
        if (size == 0 || less(key, maxpq.max()))
            maxpq.insert(key);
        else
            minpq.insert(key);

        if (minpq.size() > maxpq.size()+1){
            Key m = minpq.delMin();
            maxpq.insert(m);
        } else if (maxpq.size() > minpq.size()+1){
            Key m = maxpq.delMax();
            minpq.insert(m);
        }
        size++;
    }
    public Key findMedian() {
        Key median;
        if (minpq.size() > maxpq.size())
            median = minpq.min();
        else 
            median = maxpq.max();
        return median;
    }
    public Key delMedian() {
        Key median;
        if (minpq.size() > maxpq.size())
            median = minpq.delMin();
        else
            median = maxpq.delMax();
        size--;
        return median;

    }
    public boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }
    public void show() {
        StdOut.print("min: ");
        minpq.show();
        StdOut.print("max: ");
        maxpq.show();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int N = a.length;
        MedianPQ<String> pq = new MedianPQ<String>(N);
        for (String s : a){
            if (s.compareTo("*") == 0)
                StdOut.println("median:"+pq.delMedian());
            else
                pq.insert(s);
            pq.show();
        }
        
    }

}



