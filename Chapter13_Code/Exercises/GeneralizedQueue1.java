import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class GeneralizedQueue1<Item> 
{
    private Item[] q = (Item[]) new Object[1];    // Queue Item
    private int N; 
    private int first;
    private int last;

    private GeneralizedQueue1() {
        q = (Item[]) new Object[1];    // Queue Item
        N = 0;
        first = 0;
        last = 0;
    }
    public boolean isEmpty() { return N == 0; }
    private void resize(int capacity)
    {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
    }
    public void insert(Item x) {
        // add an item
        if (N == q.length) resize(2*q.length);
        q[N++] = x;

    }
    public Item delete(int k) {
        // delete and return the Kth least recently inserted item
        if (k >= N || k < 0) throw new NoSuchElementException("K underflow");
        Item item = q[k-1];
        for (int i = k; i < N; i++)
            q[i-1] = q[i];
        q[N-1] = null;
        N--;
        return item;
    }
    /* 
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++)
            s.append(q[i] + " ");
        return s.toString();
    }

    public static void main(String[] args) {
        GeneralizedQueue1<Integer> GQ = new GeneralizedQueue1<Integer>();

        for (int i = 0; i < 7; i++)
            GQ.insert(i);
        StdOut.println(GQ);
        GQ.delete(3);
        StdOut.println(GQ);
        GQ.delete(7);
        StdOut.println(GQ);




    }
}
