import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex3_1_12 {

    public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> {
        public class Item implements Comparable<Item> {
            private Key key;
            private Value val;

            Item(Key key, Value val) {
                this.key = key;
                this.val = val;
            }
            @Override
            public int compareTo(Item that) {
                int cmp = this.key.compareTo(that.key);
                return cmp;
                /*
                if (cmp < 0)
                    return -1;
                else if (cmp > 0)
                    return +1;
                return 0;
                */
            }
        }

        private Item[] items;
        private int size;

        private static final int DEFAULT_INITIAL_CAPACITY = 8;

        public BinarySearchSymbolTable() {
            items = new BinarySearchSymbolTable.Item[DEFAULT_INITIAL_CAPACITY];
            size = 0;
        }
        public BinarySearchSymbolTable(int capacity) {
            items = new BinarySearchSymbolTable.Item[capacity];
            size = 0;
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size() == 0;
        }
        public Value get(Key key) {
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < size && items[i].key.compareTo(key) == 0) {
                return items[i].val;
            } else
            {
                return null;
            }
        }
        public int rank(Key key) {
            int lo = 0, hi = size-1;
            while (lo <= hi) {
                int mid = lo + (hi - lo)/2;
                int cmp = key.compareTo(items[mid].key);
                if (cmp < 0) hi = mid - 1;
                else if (cmp > 0) lo = mid + 1;
                else return mid;
            }
            return lo;
        }
        public void put(Key key, Value val) {
            int i = rank(key);
            if (i < size && items[i].key.compareTo(key) == 0)
            {
                items[i].val = val;
                return;
            }
            for (int j = size; j > i; j--) {
                items[j] = items[j-1];
            }
            items[i] = new Item(key, val);
            size++;
        }

        public boolean contains(Key key) {
            return get(key) != null;
        }


    }
}
