import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Steque<Item> //implements Iterable<Item>
{
    private Node first;     // link to least recently added node 
    private Node last;      // link to most recently added node 
    private int N;      // number of items

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item)
    {
        Node n = new Node();
        n.item = item;
        if (isEmpty()){
            n.next = null;
            first = last = n;
        } else {
            n.next = last;
            last = n;
        }
        N++;
    }
    public Item pop()
    {
        if (isEmpty()) return null;
        Item item = last.item;
        last = last.next;
        N--;
        return item;
    }
    public void enqueue(Item item)
    {
        Node n = new Node();
        n.item = item;
        if (isEmpty()){
            n.next = null;
            first = last = n;
        } else {
            n.next = null;
            first.next = n;
        }
        N++;
    }
    @Override
    public String toString() {
        String r = "";
        Node current = last;
        while (current != null) {
            r += current.item + " ";
            current = current.next;
        }
        return r;
    }
/*
    public Iterator<Item> Iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = last;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){}
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
*/
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<Integer>();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        StdOut.println(steque);
        steque.pop();
        StdOut.println(steque);

    }

}
