import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Queue2<Item> implements Iterable<Item>
{
    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int N;      // number of items on the queue

    private class Node
    { // nested class to define nodes.
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; } // Or: N == 0.
    public int size()   { return N;  }

    public void enqueue(Item item)
    { // Add item to the end of the list.
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else        oldlast.next = last;
        N++;
    }

    public Item dequeue()
    { // Remove item from the beginning of the list.
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean find(Item key)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.item))
                return true;
        }
        return false;

    }

    public boolean find(Queue2<String> q, String key)
    {
        for (String s : q)
        {
            if (key.equals(s))
                return true;
        }
        return false;
    }

    public void delete(int k)
    {
        if (N < k)
            return;
        else if (N == k)
        {
            removeLastNode();
        }
        else if (k == 1)
        {
            dequeue();
        }
        else {
            Node x = first;
            --k;
            while ((k-1) != 0) {
                x = x.next;
                k--;
            }
            x.next = x.next.next;
            N--;
        }
        
    }

    public void removeLastNode() {
        if (N == 0) {
            return;
        } else if (N == 1) {
            first = null;
            last = null;
            N--;
        } else {
            Node beforeLast = first;
            while (true) {
                if (beforeLast.next.next == null) break;
                beforeLast = beforeLast.next;
            }
            beforeLast.next = null;
            N--;
        }
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

    public static void main(String[] args)
    {  // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<String>();
        Queue2<String> qq = new Queue2<String>();
        int k = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            qq.enqueue(item);
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");

        for (String str : qq){
            StdOut.print(str + " ");
        }
        qq.removeLastNode();
        StdOut.println();
        for (String str : qq){
            StdOut.print(str + " ");
        }
        StdOut.println();
        qq.delete(k);
        for (String str : qq){
            StdOut.print(str + " ");
        }
        StdOut.println();
        StdOut.printf("find %s ", args[1]);
        StdOut.println(qq.find(args[1]));
        StdOut.println();
        StdOut.println(qq.find(qq, args[1]));


    }
}
