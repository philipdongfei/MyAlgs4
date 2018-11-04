import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Stack42<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public Stack42() {
        first = null;
        N = 0;
    }
    public Stack42(Stack42 s) {
        Object o;
        Item temp;
        while(!s.isEmpty()){
            o = s.pop();
            temp = (Item)o;
            if (temp != null)
                this.push(temp);
        }
    }
    public boolean isEmpty() { return first == null; }
    public int size()   { return N; }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        { return current != null; }
        public void remove() {}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args)
    {
        Stack42<String> s = new Stack42<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.push(item);
        }
        Stack42<String> t = new Stack42<String>(s);

        for (String str : t)
            StdOut.print(str+" ");
        StdOut.println();

    }
}
