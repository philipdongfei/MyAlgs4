import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;


public class ThreadedST<Key extends Comparable<Key>, Value> 
{
    private Node root;     // root of BST
    private int Compares = 0;

    private class Node
    {
        private Key key;    // key
        private Value val;  // associated value
        private Node left, right;   // links to subtrees
        private int N;      // # nodes in subtree rooted here
        private int TotalOfCompares;//number of compares required to reach all nodes in the subtree rooted here.
        private int NumberOfCompares;//number of compares required to reach this node

        private Node pred; // links to the predecessor
        private Node succ; // links to the successor
        public Node(Key key, Value val, int N)
        { this.key = key; this.val = val; this.N = N; }
        public Node(Key key, Value val, int N, int NumberOfCompares)
        {
            this.key = key; this.val = val; this.N = N;
            this.NumberOfCompares = NumberOfCompares;
            this.TotalOfCompares = NumberOfCompares;

        }
    }
    public Key next(Key key) {
        if (key == null)
            return null;

        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {
                if (current.succ != null)
                    return current.succ.key;
                else 
                    return null;
            }
        }
        return null;
    }
    public Key prev(Key key) {
        if (key == null)
            return null;
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {
                if (current.pred != null)
                    return current.pred.key;
                else
                    return null;
            }
        }
        return null;
    }
    public int getCompares()
    { return Compares; }

    public boolean isEmpty() {
        return size() == 0;
    }
    public int size()
    { return size(root); }

    private int size(Node x)
    {
        if (x == null) return 0;
        else           return x.N;
    }
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
    public int height()
    {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains is null");
        return get(key) != null;
    }
    public Value get(Key key)
    {
        return get(root, key);
    }
    private Value get(Node x, Key key)
    { // Return value associated with key in the subtree rooted at x;
      // return null if key not present in subtree rooted at x.
      if (x == null) return null;
      Compares++; 
      int cmp = key.compareTo(x.key);
      if (cmp < 0) return get(x.left, key);
      else if (cmp > 0) return get(x.right, key);
      else return x.val;

    }
    public void put(Key key, Value val)
    {
        if (key == null) 
            throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        //Search for key, Update value if found; grow table if new.
        root = put(root, key, val, null, null);
        assert check();
        //StdOut.println("check: " + check());
    }
    private Node put(Node x, Key key, Value val, Node predecessor, Node successor)
    {
        // Change key's value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null)
        {
            Node newNode = new Node(key, val, 1);
            if (predecessor != null) {
                predecessor.succ = newNode;
                newNode.pred = predecessor;
            }
            if (successor != null) {
                newNode.succ = successor;
                successor.pred = newNode;
            }
            return newNode;

        }
        Compares++; 
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val, predecessor, x);
        else if (cmp > 0) x.right = put(x.right, key, val, x, successor);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }
    public Key max()
    {
        return max(root).key;
    }
    private Node max(Node x)
    {
        if (x.right == null) return x;
        return max(x.right);
    }
    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key) 
    {
        if (x == null) return null;
        Compares++; 
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else           return x;
    }
    public Key floor2(Key key) {
        return floor2(root, key, null);
    }
    private Key floor2(Node x, Key key, Key best) {
        if (x == null) return best;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor2(x.left, key, best);
        else if (cmp > 0) return floor2(x.right, key, x.key);
        else        return x.key;
    }

    public Key ceiling(Key key)
    {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key)
    {
        if (x == null) return null;
        Compares++; 
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else           return x;

    }
    public Key select(int k)
    {
        return select(root, k).key;
    }
    private Node select(Node x, int k)
    {
        // Return Node containing key of rank k.
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else    return x;
    }

    public int rank(Key key)
    {
        return rank(key, root);
    }
    private int rank(Key key, Node x)
    {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        Compares++; 
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public void deleteMin()
    {
        root = deleteMin(root, true);
    }
    private Node deleteMin(Node x, boolean updatePreAndSucc)
    {
        if (x == null) return null;
        if (x.left == null) {
            if (updatePreAndSucc && x.succ != null)
                x.succ.pred = null;

            return x.right;
        }
        x.left = deleteMin(x.left, updatePreAndSucc);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x == null)
            return null;
        if (x.right == null) {
            if (x.pred != null)
                x.pred.succ = null;
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }
    public void delete(Key key)
    {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        Compares++; 
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.left == null || x.right == null) {
                if (x.pred != null)
                    x.pred.succ = x.succ;
                if (x.succ != null)
                    x.succ.pred = x.pred;

                if (x.right == null) return x.left;
                if (x.left == null) return x.right;

            } else {

            Node t = x;
            x = min(t.right); // set x to point to its successor min(t.right) 
            x.right = deleteMin(t.right, false); //x.right containing all the keys that are larger than x.key
            x.left = t.left; //set x.left to t.left.
            x.pred = t.pred;
            if (x.pred != null)
                x.pred.succ = x;
            }
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private void print(Node x)
    {
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }
    public void print()
    {
        print(root);
    }
    public Iterable<Key> keys()
    {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        Compares++; 
        int cmplo = lo.compareTo(x.key);
        Compares++; 
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public double avgComparesRecursive() {
        if (root == null) return 0;

        int TotalComparesOfNodes = avgComparesRecursive(root, 1);

        return (double)TotalComparesOfNodes/(double)size() + 1; 
    }
    private int avgComparesRecursive(Node node, int preCompares) {
        if (node == null)
            return 0;
        int totalcompares = preCompares;
        totalcompares += avgComparesRecursive(node.left, preCompares+1);
        totalcompares += avgComparesRecursive(node.right, preCompares+1);
        return totalcompares;
    }
    public double avgCompares() {
        if (root == null) return 0;

        int TotalComparesOfNodes = avgCompares(root);

        return (double)TotalComparesOfNodes/(double)size() + 1; 
    }
    private int avgCompares(Node x) {
        //todo
        if (x == null) return 0;

        return 0; 
    }
    public Key randomKey() {
        if (isEmpty())
            return null;
        int randomIndex = StdRandom.uniform(size());
        return select(randomIndex);
    }
    private boolean check() {
        if (!isBST())  StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }
    /*
     * does this binary tree satisfy symmetric order?
     * Note: this test also ensures that data structure is a binary tree since order is strict
     */
    private boolean isBST() {
        return isBST(root, null, null);
    }
    /*
     * is the tree rooted at x a BST with all keys strictly between min and max
     * (if min or max is null, treat as empty constraint)
     * Credit: Bob Dondero's elegant solution.
     */
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }
    // are the size fields correct?
    private boolean isSizeConsistent()
    { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.N != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent;
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key: keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    public static void main(String[] args) 
    {
        String[] a = StdIn.readAllStrings();

        ThreadedST<String, Integer> bst = new ThreadedST<String, Integer>();

        for (int i = 0; i < a.length; i++)
        {
            bst.put(a[i], i);
        }
        StdOut.println("Compares: " + bst.getCompares());
        StdOut.println("Height: " + bst.height());
        StdOut.println("avgCompres: "+bst.avgComparesRecursive());
        StdOut.println("randomKey: "+bst.randomKey());
        //bst.print();
        for (String k : bst.keys("D", "T"))
        {
            StdOut.println(k + " " + bst.get(k));
        }

        StdOut.println("Predecessor of D: " + bst.prev("D") + " Expected: 1");
        bst.deleteMin();
        StdOut.println("Predecessor of D after deleteMin(): " + bst.prev("D") + " Expected: null");

        StdOut.println();
        StdOut.println("Successor of S: " + bst.next("S"));
        bst.deleteMax();
        StdOut.println("Successor of S after deleteMax(): " + bst.next("S"));

        


    }

}
