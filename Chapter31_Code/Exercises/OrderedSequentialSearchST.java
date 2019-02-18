import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    public class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private Node first;
    private int size;

    public OrderedSequentialSearchST() {
        first = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");
        // to deal with duplicates
        delete(key);
        if (isEmpty()) {
            first = new Node(key, val, null);
            size++;
            return;
        }
        // check first node
        if (first.key.compareTo(key) == 0) {
            first.val = val;
            return;
        } else if (first.key.compareTo(key) > 0) {
            first = new Node(key, val, first);
            size++;
            return;
        }
        // check all other nodes
        for (Node node = first; node != null; node = node.next) {
            if (node.next != null) {
                int cmp = node.next.key.compareTo(key);
                if (cmp == 0) {
                    node.next.val = val;
                } else if (cmp > 0) {
                    Node newNode = new Node(key, val, node.next);
                    node.next = newNode;
                    size++;
                    return;
                }
            } else {
                Node newNode = new Node(key, val, null);
                node.next = newNode;
                size++;
                return;
            }
        }
    }
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Arguement to get() cannot be null");
        for (Node node = first; node != null; node = node.next) {
            if (node.key.compareTo(key) == 0)
                return node.val;
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Arguement to delete() cannot be null");
        if (isEmpty())
            return;
        if (first.key.compareTo(key) == 0) {
            first = first.next;
            size--;
            return;
        }
        for (Node node = first; node != null; node = node.next) {
            if (node.next != null && node.next.key.compareTo(key) == 0) {
                node.next = node.next.next;
                size--;
                return;
            }
        }
    }
    public Iterable<Key> keys() {
        Queue<Key> queue =new Queue<Key>();
        for (Node node = first; node != null; node = node.next)
            queue.enqueue(node.key);
        return queue;
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

    
}
