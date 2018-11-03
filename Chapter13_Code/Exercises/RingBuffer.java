import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RingBuffer<Item> {
    private Item[] array;
    private int N, SZ;
    private int first;    // head
    private int last;     // tail
    
    private RingBuffer(int size) {
        array = (Item[])new Object[size];
        first = 0;
        last = 0;
        N = 0;
        SZ = size;
    }
    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == SZ; }
    public int size() { return N; }

    public void enbuffer(Item item) {
        if (isFull()) throw new NoSuchElementException("buffer overflow");
        array[last++] = item;
        last = last % SZ;
        N++;
    }
    public Item debuffer() {
        //StdOut.println("first="+first+" last="+last);
        if (isEmpty()) throw new NoSuchElementException("buffer empty");
        Item item = array[first++];
        first = first % SZ;
        N--;
        return item;
    }
    /* 
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = first; i < first + N; i++)
        {
            s.append("["+i%SZ+","+array[i%SZ]+"]"+" ");
        }   
        return s.toString();
    }

    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        RingBuffer<Integer> rb = new RingBuffer<Integer>(size);
        int i;

        for (i = 0; i < size; i++)
            rb.enbuffer(i);
        StdOut.println("rb="+rb);
        StdOut.println("del:"+rb.debuffer());
        StdOut.println("rb="+rb);
        StdOut.println("enbuffer:"+i);
        rb.enbuffer(i);
        StdOut.println("rb="+rb);
    }


}
