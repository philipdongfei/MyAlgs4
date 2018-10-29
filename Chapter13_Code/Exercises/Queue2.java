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

    public void removeAfter(Node node) 
    {
        if (node == null || node.next == null)
            return;
        node.next = node.next.next;
        N--;
    }

    public void insertAfter(Node first, Node second)
    {
        if (first == null || second == null)
            return;
        second.next = first.next;
        first.next = second;
        N++;
    }

    public void removeKeys(Item key)
    {
        if (N == 0 || key == null)
            return;
        else if (N == 1)
        {
            if (first.item.equals(key))
            {
                first = null;
                last = null;
                N--;
            }

        } 
        else 
        {
            Node newfirst = first;
            while (true)
            {
                if (newfirst == null) break;
                if (newfirst.item.equals(key)) {
                    newfirst = newfirst.next;
                    N--;
                } else 
                    break;
            }

            first = newfirst;

            if (first == null) return;

            if (first != null) {
                for (Node x = first; x != null && x.next != null; x = x.next)
                {
                    if (x.next.item.equals(key))
                    {
                        x.next = x.next.next;
                        N--;
                    }
                   // if (x.next == null)
                   //     break;

                }
            }

        }

    }

    public static void remove(Queue2<String> q, String key)
    {
       q.removeKeys(key); 
    }

    public Integer findMax() {
        return max(first);
    }
    public Integer max(Node fn) 
    {
        if (fn == null)
            return 0;

        Integer result = (Integer)fn.item;
        for (Node current = fn.next; current != null; current = current.next)
        {
            if ((Integer)current.item > result)
                result = (Integer)current.item;
        }

        return result;

    }

    public Integer findMax_Recur() {
        Integer result = new Integer(0);
        Integer maxitem = max(first, result);
        return maxitem;

    }

    private Integer max(Node fn, Integer result)
    {
        if (fn == null) return result;
        else {
            if ((Integer)fn.item > result)
                result = (Integer)fn.item;
            return max(fn.next, result);
        }
    }

    public void reverse_Queue_iter() {
        first = reverse_iter(first);
    }
    public Node reverse_iter(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public void reverse_Queue_Recur(){
        first = reverse_recur(first);
    }

    public Node reverse_recur(Node first)
    {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse_recur(second);
        second.next = first;
        first.next = null;
        return rest;
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
        Queue2<Integer> qi = new Queue2<Integer>();
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

        qq.reverse_Queue_Recur();
        for (String str : qq){
            StdOut.print(str + " ");
        }
        //qq.removeLastNode();
        remove(qq, args[0]); 
        StdOut.println();
        qq.reverse_Queue_iter();
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
