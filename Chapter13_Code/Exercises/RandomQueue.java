import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] q;    // queue elements
    private int N;       // number of elements on queue
    private int first;   // index of first element of queue
    private int last;    // index of next available slot
    int[] getArray;

    public RandomQueue() {
        q = (Item[]) new Object[2];
        N = 0; 
        first = 0;
        last = 0;
        getArray = new int[100];
        for(int i=0; i<100; i++)
            getArray[i] = 0;
    }
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last = N;

    }
    private int uniform_iterator(int N)
    {
        int zero = N, index;
        for (int i = 0; i < N; i++)
        {
            if (getArray[i] == 1)
                zero--;
        }
        if (zero == 0)
            return -1;
        while (true) {
            index = (int)(StdRandom.random()*N);
            if (getArray[index] == 0){
                getArray[index] = 1;
                break;
            }
        }        
        return index;
    }
    private int uniform(int N)
    {
        int index = (int)(StdRandom.random()*N);
        return index;
    }

    public boolean isEmpty() { return N == 0; }
    public int size()    { return N; }

    public void add(Item item)
    {
        if (N == q.length) resize(2*q.length);
        q[N++] = item;
    }

    public void enqueue(Item item) {
        if (N == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        N++;
    }
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int randomIndex = uniform(N);
        Item temp = q[randomIndex];
        q[randomIndex] = q[last-1];
        last--; 
        N--;
        q[last] = null;
        return temp;
    }
    public Item smaple() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int randomIndex = uniform(N);
        Item temp = q[randomIndex];
        return temp;
    }

    public Iterator<Item> iterator() {
        return new RQArrayIterator();
    }
    private class RQArrayIterator implements Iterator<Item> {
        private int i = uniform_iterator(N);
        public boolean hasNext() {return i >= 0;}
        public void remove()    {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[i];
            i = uniform_iterator(N);
            return item;
        }
    }

    public static void main(String[] args) {
        Integer i, j;
        RandomQueue<String> rq = new RandomQueue<String>();
        /*
        public class Card
        {
            String Rank;    // 2,3,4,...,A
            String Suit;    //H,C,S,D
            @Override
            public String toString() {
                String r = "";
                r = "[" + Rank + " " + Suit + "]";
                return r;
            }
        }
        */
        String Ranks[] = new String[]{
            "2","3","4","5","6","7",
            "8","9","10","J","Q","K",
            "A"
        };

        String Suits[] = new String[]{
            "H","C","S","D"
        };


        for (i = 0; i < 4; i++){
            for (j = 0; j < 13; j++) {
                /*
                Card c = new Card();
                c.Rank = Ranks[j];
                c.Suit = Suits[i];
                */
                String c = "[" + Ranks[j] + " " + Suits[i] + "]";
                rq.enqueue(c);
            } 
        }
        int nCount = 0;
        for (String x : rq )
        {
            StdOut.print(x + " ");
            ++nCount;
        }
        StdOut.println();
        StdOut.println("Cards Total: " + nCount);
        StdOut.println("Deals bridge hands:");
        
        for (i = 0; i < 4; i++){
            for (j = 0; j < 13; j++) {
                StdOut.print(rq.dequeue() + " ");
            }
            StdOut.println(";");
        }

    }
}
