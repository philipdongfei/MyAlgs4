import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class GeneralizedQueue2<Item> {
    private Node first;    // link to least recently added node
    private Node last;     // link to most recently added node
    private int N;

    private class Node
    {
        Item item; 
        Node next;
    }

    public GeneralizedQueue2(){
        first = last = null;
        N = 0;

    }
    public boolean isEmpty() { return first == null; }
    public void insert(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else        oldlast.next = last;
        N++;
    }
    public Item delete(int k) {
        if (k < 0 || k > N) throw new NoSuchElementException("k underflow"); 
        Node Kpre = null;
        for (int i = 1; i < k; i++)
            Kpre = first.next;
        Item item = Kpre.next.item;
        Kpre.next = Kpre.next.next;
        N--;
        return item;
    }
    /* 
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node point = first;
        while(point != null){
            s.append(point.item + " ");
            point = point.next;
        }
        return s.toString();
    }
    public static void main(String[] args) {
        GeneralizedQueue2<Integer> GQ = new GeneralizedQueue2<Integer>();

        for (int i = 0; i < 7; i++)
            GQ.insert(i);
        StdOut.println(GQ);
        GQ.delete(3);
        StdOut.println(GQ);
        GQ.delete(7);
        StdOut.println(GQ);
    }

}
