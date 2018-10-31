import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<Item> implements Iterable<Item>
{
    private Item[] a = (Item[])new Object[1];     
    private int N ;
    int[] getArray;

    private RandomBag(){
        N = 0;
        a = (Item[]) new Object[1];
    } 
    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    private int uniform(int N)
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

    public boolean isEmpty() { return N == 0; }
    public int size()    { return N; }

    public void add(Item item)
    {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }


    public Iterator<Item> iterator()
    {
        return new RandomBagIterator();
    }
    private class RandomBagIterator implements Iterator<Item>
    {
        private RandomBagIterator() {
            getArray = new int[N];
            for(int i=0; i<N; i++)
                getArray[i] = 0;

        }
        private int current = uniform(N);
        public boolean hasNext()
        { return current >= 0; }
        public void remove() {}
        public Item next()
        {
            Item item = a[current];
            current = uniform(N);
            return item;
        }
        

    }



    
}

