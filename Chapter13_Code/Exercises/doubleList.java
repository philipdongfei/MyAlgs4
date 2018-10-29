import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class doubleList<Item> implements Iterable<Item>
{

    private DoubleNode first; // link to least recently added node
    private DoubleNode last;  // link to most recently added node
    private int N;      // number of items on the queue

    private class DoubleNode{
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }
    private DoubleList<Item> list()
    {
        return this;
    }

    public boolean isEmpty() { return N == 0; } // Or: N == 0.
    public int size()   { return N;  }

    public doubleList() {
        last = null;
        first = null;
        N = 0;
    }

    public void prepend(Item item)
    {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) { first = x; last = x; }
        else  { x.next = first; first.prev = x; first = x; }
        N++;
    }
    
    public void append(Item item)
    {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) { first = x; last = x; }
        else    { x.prev = last; last.next = x; last = x; }
        N++;
    }

    public static void insertFirst(Item item)
    {
        DoubleNode x = new DoubleNode();
        x.item = item;

        if (isEmpty())
        {
            first = x;
            first.prev = first.next = null;
            last = x;
        }
        else {
            x.prev = null;
            x.next = first;
            first.prev = x;
            first = item;
        }
        N++;
    }
    public static void insertLast(Item item){
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty())
        {
            last = x;
            last.next = last.prev = null;
            first = x;
        }
        else {
            x.next = null;
            x.prev = last;
            last.next = x;
            last = x;
        }
        N++;
    }
    public static Item removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");

        }
        Item item = first.item;
        first = first.next;
        if (first != null)
            first.prev = null;
        N--;
        if (isEmpty()) last = null;
        return item;
    }
    public static Item removeLast(){
        if (isEmpty()) throw new RuntimeException("List is empty");
        Item item = last.item;
        last = last.prev;
        N--;
        if (isEmpty()) first = null;
        return item;
    }
    public static void insertBefore(DoubleNode node, Item item) {
        if (node == null) throw new RuntimeException("Node is empty");
        if (node == first)
            prepend(item);
        else {
            DoubleNode x = new DoubleNode();
            x.item = item;
            x.prev = node.prev;
            x.next = node;
            node.prev = x;
            N++;
        }
    }
    public static void insertAfter(DoubleNode node, Item item) {
        if (node == null) throw new RuntimeException("Node is empty");
        if (node == last) {
            append(item);
        }
        else {
            DoubleNode x = new DoubleNode();
            x.item = item;
            x.prev = node;
            x.next = node.next;
            node.next = x;
            N++;
        }
    }
    public static void removeNode(DoubleNode node){
        if (node == null) throw new RuntimeException("Node is empty");
        if (node.prev == null && node.next == null)
            first = last = null;
        else
        {
            if (node.prev != null)
            {
                node.prev.next = node.next;
            }
            if (node.next != null)
            {
                node.next.prev = node.prev;
            }
        }
        N--;
    }
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator()
    {
        return new DoubleListIterator();
    }

    private class DoubleListIterator implements Iterator<Item>
    {
        private DoubleNode current = first;

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

    }




}
