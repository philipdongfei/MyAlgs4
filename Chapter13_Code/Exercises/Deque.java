import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Deque<Item> implements Iterable<Item>
{
    private DoubleNode Left;
    private DoubleNode Right;
    int N;

    private class DoubleNode
    {
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }

    public Deque(){
        Left = null;
        Right = null;
        N = 0;
    }


    public boolean isEmpty() { return N == 0; } // or: N == 0
    public int size() { return N; }

    public void pushLeft(Item item) {
        DoubleNode n = new DoubleNode();
        n.item = item;
        if (isEmpty()) {
            n.prev = n.next = null;
            Left = Right = n;
        } else {
            DoubleNode oldLeft = Left;
            n.next = Left;
            n.prev = null;
            oldLeft.prev = n;
            Left = n;
        }
        N++;
    }
    public void pushRight(Item item) {
        DoubleNode n = new DoubleNode();
        n.item = item;
        if (isEmpty()) {
            n.prev = n.next = null;
            Left = Right = n;
        } else {
            DoubleNode oldRight = Right;
            n.next = null;
            n.prev = Right;
            oldRight.next = n;
            Right = n;
        }
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new RuntimeException("deque is empty");
        Item item = Left.item;
        DoubleNode newLeft = Left.next;
        if (newLeft != null)
            newLeft.prev = null;
        Left.next = null;
        Left = newLeft;
        N--;
        if (isEmpty()) { Right = Left = null; }
        return item;
    }
    public Item popRight() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        Item item = Right.item;
        DoubleNode newRight = Right.prev;
        if (newRight != null)
            newRight.next = null;
        Right.prev = null;
        Right = newRight;
        N--;
        if (isEmpty()) { Left = Right = null; }
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>
    {
        private DoubleNode current = Left;

        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException();}

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>();

        dq.pushLeft("1");
        dq.pushRight("2");
        dq.pushLeft("3");
        dq.pushRight("4");
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
        /*
        StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
        StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
        StdOut.println(dq.popLeft());
        */
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
        StdOut.println(dq.popRight());
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
        StdOut.println(dq.popLeft());
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
        StdOut.println(dq.popRight());
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
        
    }
}
