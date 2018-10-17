import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Bag<Item> implements Iterable<Item>
{
    private Node first;    // first node in list
    private int n;  // number of elements in bag
    private class Node
    {
        Item item;
        Node next;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item)
    {
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        { return current != null; }
        public void remove(){}
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.print("size of bag = " + bag.size());
        for (String s : bag)
            StdOut.println(s);
    }
}

