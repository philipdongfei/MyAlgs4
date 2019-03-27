import edu.princeton.cs.algs4.Queue;
import java.util.NoSuchElementException;

public class MultiSET<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;

        private Node left;
        private Node right;

        private int Size;

        public Node(Key key, Value val, int Size){
            this.key = key;
            this.val = val;
            this.Size = Size;
        }
    }
    private Node root;

    public int size(){
        return size(root);
    }
    private int size(Node n) {
        if (n == null)
            return 0;
        return n.Size;
    }
    public boolean isEmpty(){
        return size(root) == 0;
    }

    public Value get(Key key){
        if (key == null)
            return null;
        return get(root, key);
    }
    private Value get(Node n, Key key){
        if (n == null)
            return null;
        int compare = key.compareTo(n.key);
        if (compare < 0)
            return get(n.left, key);
        else if (compare > 0)
            return get(n.right, key);
        else
            return n.val;
    }
    public boolean contains(Key key){
        if (key == null)
            throw new IllegalArgumentException("Argument key cannot be null");
        return get(key) != null;
    }
    public void put(Key key, Value val) {
        if (key == null)
            return ;
        if (val == null){
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    private Node put(Node n, Key key, Value val){
        if (n == null)
            return new Node(key, val, 1);
        int compare = key.compareTo(n.key);

        if (compare <= 0)
            n.left = put(n.left, key, val);
        else 
            n.right = put(n.right, key, val);
        n.Size = size(n.left) + 1 + size(n.right);
        return n;
    }
    public Key min(){
        if (root == null)
            throw new NoSuchElementException("Empty binary search tree");
        return min(root).key;
    }
    private Node min(Node n){
        if (n.left == null)
            return n;
        return min(n.left);
    }
    public Key max(){
        if (root == null)
            throw new NoSuchElementException("Empty binary search tree");
        return max(root).key;
    }
    private Node max(Node n){
        if (n.right == null)
            return n;
        return max(n.right);
    }
    public void deleteMin(){
        if (root == null)
            return;
        Key minkey = min();
        while (contains(minkey))
            root = deleteMin(root);
    }
    private Node deleteMin(Node n){
        if (n.left == null)
            return n.right;
        n.left = deleteMin(n.left);
        n.Size = size(n.left) + 1 + size(n.right);
        return n;
    }
    public void delete(Key key){
        if (isEmpty())
            return;
        while(contains(key)){
            root = delete(root, key);
        }
    }
    private Node delete(Node n, Key key){
        int compare = key.compareTo(n.key);
        if (compare < 0)
            n.left = delete(n.left, key);
        else if (compare > 0)
            n.right = delete(n.right, key);
        else {
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;
            else{
                Node aux = n;
                n = min(aux.right);
                n.right = deleteMin(aux.right);
                n.left = aux.left;
            }
        }
        n.Size = size(n.left) + 1 + size(n.right);
        return n;
    }
    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        if (lo == null)
            throw new IllegalArgumentException("lo cann't be null");
        if (hi == null)
            throw new IllegalArgumentException("hi cann't be null");
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node n, Queue<Key> queue, Key lo, Key hi){
        if (n == null)
            return;
        int comparelo = lo.compareTo(n.key);
        int comparehi = hi.compareTo(n.key);
        if (comparelo <= 0)
            keys(n.left, queue, lo, hi);
        if (comparelo <= 0 && comparehi >= 0)
            queue.enqueue(n.key);
        if (comparehi >= 0)
            keys(n.right, queue, lo, hi);
    }
}
