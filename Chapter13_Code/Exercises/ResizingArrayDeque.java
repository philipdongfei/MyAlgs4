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

    private ResizingArrayDeque()
    {
        Left = Right = 1;
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public int size()   { return N; }
    private void resize(int max)
    {// max = 3*N
        Item[] temp = (Item[]) new Object[max];
        StdOut.printf("resize: N=%d,max=%d\n", N, max);
        for (int i = N; i < 2*N; i++)
        {
            temp[i] = a[i-N];
            StdOut.printf("i=%d, i-N=%d, a[i-N]=%s\n", 
                    i, i-N, a[i-N]);
        }
        a = temp;
        Left = N-1;
        Right = 2*N; 
    }

    public void pushLeft(Item item){
        if (N == a.length || Left < 0 ) resize(3*a.length);
        a[Left--] = item;
        if (Left+1 == Right)
            ++Right;
        StdOut.printf("pushLeft:%d:%s\n", Left+1, a[Left+1]);
        N++;

    }

    public void pushRight(Item item) {
        if (N == a.length || Right+1 > a.length) resize(3*a.length);
        a[Right++] = item;
        if (Right-1 == Left)
            Left--;
        StdOut.printf("pushRight:%d:%s\n", Right-1, a[Right-1]);
        N++;

    }

    public Item popLeft() {
        Item item = a[++Left];
        a[Left] = null;
        N--;
        if (N > 0 && N % 3 == 0 && N == a.length/6) resize(a.length/3);
        return item;

    }

    public Item popRight() {
        Item item = a[--Right];
        a[Right] = null;
        N--;
        //don't test
        if (N > 0 && N % 3 == 0 && N == a.length/6) resize(a.length/3);
        return item;

    }

    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>
    {//FIFO
        private int i = Left;
        public boolean hasNext() { return i < Right-1; }
        public Item next()      { return a[++i]; }
        public void remove()    {}

    }
    public static void main(String[] args)
    {
        ResizingArrayDeque<String> dq = 
            new ResizingArrayDeque<String>();

        dq.pushLeft("1");
        for (String x : dq)
            StdOut.print(x + " ");
        StdOut.println();
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

