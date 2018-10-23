/* Ex_1_3_8
 *
 *
 */


import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class DoublingStackOfStrings<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];  // stack items
    private int N = 0;

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    private void resize(int max) {
    // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) 
    {// Add item to top of stack. 
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public  Item pop()
    {// Remove item from top of stack.
        Item item = a[--N];
        a[N] = null; // Avoid loitering 
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>
    {// Support LIFO iteration.
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() {}
    }
    
    public static void main(String[] args) {
        DoublingStackOfStrings<String> s;
        s = new DoublingStackOfStrings<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");

        for (String str : s)
            StdOut.println(str);
    }
}
