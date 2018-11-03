import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<Item> implements Iterable<Item>
{
    private int N;
    private Node first;
    private Node last;
    
    private class Node
    {
        private Item item;
        private Node next;
    }

    public List()
    {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }
    public Item removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }
    public void prepend(Item item)
    {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x; last = x; }
        else        { x.next = first; first = x; }
        N++;
    }
    public void append(Item item)
    {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {first = x; last = x;}
        else    { last.next = x; last = x; }
        N++;
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null;}
        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public Item delete(int k)
    {
        if (k < 1) return null;

        int i = 1;
        Node prev = null,
             curr = first;

        while (i < k && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (curr != null) {
            if (prev == null)
                first = curr.next;
            else
                prev.next = curr.next;
            if (curr.next == null)
                last = prev;
            N--;
            return curr.item;
        }
        else 
            return null;
    }

    public boolean contains(Item item){
        Node curr = first;
        while (curr != null && !curr.item.equals(item))
            curr = curr.next;
        return curr != null;
    }
    public void remove(Item item) {
        List<Integer> idx = new List<Integer>();
        int i = 1;
        for (Item x : this){
            if (x.equals(item))
                idx.prepend(i);
            i++;
        }
        for (int k : idx)
            delete(k);
    }



}
