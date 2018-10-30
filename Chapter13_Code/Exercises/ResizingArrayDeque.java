import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class ResizingArrayDeque<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[3];   //Deque items
    private int Left;
    private int Right;
    private int N = 0;

    public bool isEmpty() { return N == 0; }
    public int size()   { return N; }
    private void resize(int max)
    {// max = 3*N
        Item[] temp = (Item[]) new Object[max];
        for (int i = N; i < 2*N; i++)
            temp[i] = a[i-N];
        a = temp;
        Left = N;
        Right = 2*N - 1; 
    }

    public void pushLeft(Item item){

    }

    public void pushRight(Item item) {

    }

    Item popLeft() {

    }

    Item popRight() {

    }

    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>
    {//FIFO
        private int i = 0;
        public boolean hasNext() { return i < N; }
        public Item next()      { return a[i++]; }
        public void remove()    {}

    }

}

