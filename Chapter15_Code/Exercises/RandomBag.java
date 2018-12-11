import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item>{
    Item[] items;
    int N;

    public RandomBag(){
        items = (Item[]) new Object[4];
        N = 0;
    }
    public boolean isEmpty(){ return N == 0; }
    public int size() { return N; }
    public void add(Item item) {
        items[N++] = item;
        if (items.length == N) {
            resize(items.length * 2);
        }
    }
    public void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            s += items[i] + " ";
        }
        return s;
    }
    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }
    private class RandomBagIterator implements Iterator<Item> {
        int current;

        public RandomBagIterator(){
            current = 0; 
            for (int i = 0; i < N; i++) {
                int random = StdRandom.uniform(0, N);
                Item copy = items[random];
                items[random] = items[i];
                items[i] = copy;
            }
        }
        @Override 
        public boolean hasNext(){
            return current < N;
        }
        @Override
        public Item next() {
            return items[current++];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove in iterator");
        }
    }
}

