//import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.NoSuchElementException;

public class Ex3_5_19 {
/*
    public interface MultiHashSET<Key>{
        void add(Key key);
        void delete(Key key);
        boolean contains(Key key);
        boolean isEmpty();
        int size();
        Iterable<Key> keys();
        String toString();
    }
    public interface MultiSET<Key> {
        void add(Key key);
        void delete(Key key);
        boolean contains(Key key);
        boolean isEmpty();
        int size();
        Key min();
        Key max();
        Key floor(Key key);
        Key ceiling(Key key);
        void deleteMin();
        void deleteMax();
        Iterable<Key> keys();
        String toString();
    }
    */
    /*
    public static class SequentialSearchMultiSET<Key, Value>
    {
        private Node first;    // first node in the linked list
        private int n;
        private int Compares_N = 0;
    
        private class Node
        {// linked-list node
            Key key;
            Value val;
            Node next;
            public Node(Key key, Value val, Node next)
            {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
        public int getCompares(){
            return Compares_N;
        }
        public int size() {
            return n;
        }
        public boolean isEmpty() {
            return size() == 0;
        }
        public Value get(Key key)
        {// Search for key, return associated value.
            for (Node x = first; x != null; x = x.next)
            {
                Compares_N++;
                if (key.equals(x.key))
                    return x.val;    //search hit
            }
            return null;             // search miss
        }
        public void put(Key key, Value val)
        {// Search for key. Update value if found; grow table if new.
            
            if (val == null) { //delete key
                for (Node x = first; x != null; x = x.next)
                {
                    Compares_N++;
                    if (key.equals(x.key))
                    { 
                        x.val = val;
                        n--;
                    }    // Search hit: update val.
                }
                return;
            }
            first = new Node(key, val, first); // Search miss: add new node.
            n++;
        }
        boolean contains(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to contains() is null");
            return get(key) != null;
        }
    
        void delete(Key key) {
            put(key, null);
        }
        
        public Iterable<Key> keys() {
            Queue<Key> queue = new Queue<Key>();
            for (Node x = first; x != null; x = x.next)
            {
                if (x.val != null)
                    queue.enqueue(x.key);

            }
            return queue;
        }
    }
    */


    public static class SeparateChainingMultiST<Key extends Comparable<Key>, Value>  {
        private SequentialSearchMultiST<Key, Value> st;

        private SeparateChainingMultiST(){
            st = new SequentialSearchMultiST<>();
        }
        public boolean isEmpty(){
            return st.isEmpty();
        }
        public int size(){
            return st.size();
        }
        public void add(Key key, Value val) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.put(key, val);
        }
        public Value get(Key key)
        {
            return st.get(key);
        }
        public Iterable<Value> getAll(Key key)
        {
            return st.getAll(key);
        }
        public void delete(Key key) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.delete(key);

        }
        public boolean contains(Key key){
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            return st.contains(key);
        }
        public Key min() {
            if (isEmpty())
                return null;
            Key min = null;
            for (Key key : st.keys())
            {
                if (min == null)
                    min = key;
                else if (min.compareTo(key) > 0)
                    min = key;
            }
            return min;
        }
        public Key max() {
            if (isEmpty())
                return null;
            Key max = null;
            for (Key key : st.keys())
            {
                if (max == null)
                    max = key;
                else if (max.compareTo(key) < 0)
                    max = key;
            }
            return max;
        }
        public void deleteMin()
        {
            if (isEmpty())
                return;
            Key min = min();
            if (min != null)
                st.delete(min);
        }
        public void deleteMax()
        {
            if (isEmpty())
                return;
            Key max = max();
            if (max != null)
                st.delete(max);
        }
        @Override
        public String toString() {
            if (isEmpty())
                return "{}";
            String strFormat = "";
            for (Key key : st.keys())
            {
                strFormat += key + " ";
            }
            return strFormat;
        } 


    }
    public static class BinarySearchMultiST<Key extends Comparable<Key>, Value> {
        private MultiST<Key, Value> st;

        private BinarySearchMultiST(){
            st = new MultiST<>();
        }
        public boolean isEmpty(){
            return st.isEmpty();
        }
        public int size(){
            return st.size();
        }
        public void add(Key key, Value val) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.put(key, val);
        }
        public Value get(Key key)
        {
            return st.get(key);
        }
        public Iterable<Value> getAll(Key key)
        {
            return st.getAll(key);
        }
        public void delete(Key key) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.delete(key);

        }
        public boolean contains(Key key){
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            return st.contains(key);
        }
        public Key min() {
            if (isEmpty())
                return null;
            Key min = st.min();
            return min;
        }
        public Key max() {
            if (isEmpty())
                return null;
            Key max = st.max();
            return max;
        }
        /*
        public void deleteMin()
        {
            if (isEmpty())
                return;
            st.deleteMin();
        }
        public void deleteMax()
        {
            if (isEmpty())
                return;
            st.deleteMax();
        }
        public Key select(int k){
            if (isEmpty())
                return null;
            if (k < 0 || k >= st.size())
                throw new IllegalArgumentException("argument k is illegal");
            return st.select(k);
        }
        public Key floor(Key key){
            if (key == null) throw new IllegalArgumentException("argument to floor() is null");
            return st.floor(key);
        }
        public Key ceiling(Key key){
            if (key == null)
                throw new IllegalArgumentException("argument to ceiling is null");
            return st.ceiling(key);
        }
        */

        @Override
        public String toString() {
            if (isEmpty())
                return "{}";
            String strFormat = "";
            for (Key key : st.keys())
            {
                strFormat += key + " ";
            }
            return strFormat;
        } 
    }

    public static void main(String[] args) {
        //SeparateChainingMultiST<String,String> st = new SeparateChainingMultiST<String, String>();
        BinarySearchMultiST<String, String> st = new BinarySearchMultiST<>();
        st.add("c", "c");
        st.add("a", "a");
        st.add("b", "b");
        st.add("a", "ab");
        st.add("a", "ac");
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("st min: " + st.min());
        StdOut.println("st max: " + st.max());
        StdOut.println("st getall a's value:");
        for (String val : st.getAll("a"))
            StdOut.println("a " + val);
        StdOut.println("delete b");

        st.delete("b");
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("delete a");
        st.delete("a");
        StdOut.println("st: " + st);
        /*
        StdOut.println("delete max:");
        st.deleteMax();
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        */

    }


}



