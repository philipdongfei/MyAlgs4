import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Ex3_5_10 {

    public static class RedBlackBST<Key extends Comparable<Key>, Value> {
        private static final boolean RED = true;
        private static final boolean BLACK = false;
    
        private class Node
        {
            Key key;     //key
            Value val;   // associated data
            Node left, right;  // subtrees
            int N;      // # nodes in this subtree
            boolean color;      // color of link from
                                // parent to this node.
            Node(Key key, Value val, int N, boolean color)
            {
                this.key = key;
                this.val = val;
                this.N = N;
                this.color = color;
            }
        }
        private Node root;
        
    
        public RedBlackBST() {
    
        }
        private boolean isRed(Node x)
        {
            if (x == null) return false; //BLACK
            return x.color == RED;
        }
        public boolean isEmpty(){
            return root == null;
        }
    
        private Node rotateLeft(Node h)
        {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left)
                    + size(h.right);
            return x;
        }
        private Node rotateRight(Node h)
        {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.color = h.color;
            h.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left)
                    + size(h.right);
            return x;
        }
    
        private void flipColors(Node h)
        {
            h.color = !h.color;
            h.left.color = !h.left.color;
            h.right.color = !h.right.color;
        }
    
        public int size() {
            return size(root);
        }
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
    
        public Value get(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to get() is null");
            return get(root, key);
        }
        private Value get(Node x, Key key) {
            while (x != null) {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) x = x.left;
                else if (cmp > 0) x = x.right;
                else         return x.val;
            }
            return null;
        }
        public boolean contains(Key key) {
            return get(key) != null;
        }
    
        public void put(Key key, Value val)
        { // Search for key. Update value if found; grow table if new.
            if (key == null) throw new IllegalArgumentException("first argument to put() is null");
            if (val == null){
                delete(key);
                return;
            }
            root = put(root, key, val);
            root.color = BLACK;
            // assert check();
    
        }
    
        private Node put(Node h, Key key, Value val)
        {
            if (h == null) // Do standard insert, with red link to parent.
                return new Node(key, val, 1, RED);
    
            int cmp = key.compareTo(h.key);
            if (cmp <= 0) h.left = put(h.left, key, val);
            else if (cmp > 0) h.right = put(h.right, key, val);
            //else h.val = val;
    
            //if (cmp != 0) 
            {
                // fix-up any right-leaning links.
                if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
                if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
                if (isRed(h.left) && isRed(h.right)) flipColors(h);
    
                h.N = size(h.left) + size(h.right) + 1;
            }
            return h;
        }
    
        // Red-black tree deletion.
        public void deleteMin() {
            if (isEmpty()) throw new NoSuchElementException("BST underflow");
    
            Key minkey = min();

            while (contains(minkey)) {
                // if both children of root are black, set root to red
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;
                root = deleteMin(root);
                if (!isEmpty()) root.color = BLACK;
            }
            // assert check();
        }
        // delete the key-value pair with the minimum key rooted at h
        private Node deleteMin(Node h) {
            if (h.left == null)
                return null;
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = deleteMin(h.left);
            return balance(h);
        }
        public void deleteMax() {
            if (isEmpty()) throw new NoSuchElementException("BST underflow");
    
            Key maxkey = max();
            while (contains(maxkey)){
                // if both children of root are black, set root to red.
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;
                root = deleteMax(root);
                if (!isEmpty()) root.color = BLACK;
            }
            // assert check();
        }
    
        // delete the key-value pair with the maximum key rooted at h.
        private Node deleteMax(Node h) {
            if (isRed(h.left))
                h = rotateRight(h);
            if (h.right == null)
                return null;
    
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
    
            h.right = deleteMax(h.right);
    
            return balance(h);
        }
    
        public void delete(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to delete() is null");
            if (!contains(key)) return;
    
            while (contains(key)) {
                // if both children of root are black, set root to red.
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;
                root = delete(root, key);
                if (!isEmpty()) root.color = BLACK;
            }
            // assert check();
        }
    
        // delete the key-value pair with the given key rooted at h
        private Node delete(Node h, Key key) {
            // assert get(h, key) != null;
            
            if (key.compareTo(h.key) < 0) {
                if (!isRed(h.left) && !isRed(h.left.left))
                    h = moveRedLeft(h);
                h.left = delete(h.left, key);
            }
            else {
                if (isRed(h.left))
                    h = rotateRight(h);
                if (key.compareTo(h.key) == 0 && (h.right == null))
                    return null;
                if (!isRed(h.right) && !isRed(h.right.left))
                    h = moveRedRight(h);
                if (key.compareTo(h.key) == 0) {
                    Node x = min(h.right);
                    h.key = x.key;
                    h.val = x.val;
                    h.right = deleteMin(h.right);
                }
                else h.right = delete(h.right, key);
            }
            return balance(h);
        }
    
        // Assuming that h is red and both h.left and h.left.left
        // are black, make h.left or one of its children red.
        private Node moveRedLeft(Node h) {
            flipColors(h);
            if (isRed(h.right.left)) {
                h.right = rotateRight(h.right);
                h = rotateLeft(h);
                flipColors(h);
            }
            return h;
        }
        // Assuming that h is red and both h.right and h.right.left
        // are black, make h.right or one of its children red.
        private Node moveRedRight(Node h) {
            flipColors(h);
            if (isRed(h.left.left)) {
                h = rotateRight(h);
                flipColors(h);
            }
            return h;
        }
    
        // restore red-black tree invariant
        private Node balance(Node h) {
            // assert (h != null)
            if (isRed(h.right)) h = rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
            if (isRed(h.left) && isRed(h.right)) flipColors(h);
    
            h.N = size(h.left) + size(h.right) + 1;
            return h;
        }
    
    
        // the same of BST
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
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t != null) return t;
            else           return x;
        }
        public Key ceiling(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
            if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
            Node x = ceiling(root, key);
            if (x == null) return null;
            else        return x.key;
        }
    
        // the smallest key in the subtree rooted at x greater than or equal to the given key
        private Node ceiling(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp > 0) return ceiling(x.right, key);
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else           return x;
        }
    
        public Key select(int k)
        {
            if (k < 0 || k > size())
                throw new IllegalArgumentException("argument to select() is invalid: " + k);
            return select(root, k).key;
        }
        private Node select(Node x, int k)
        {
            // Return Node containing key of rank k
            if (x == null) return null;
            int t = size(x.left);
            if (t > k) return select(x.left, k);
            else if (t < k) return select(x.right, k-t-1);
            else        return x;
        }
        public int rank(Key key)
        {
            return rank(key, root);
        }
        private int rank(Key key, Node x)
        {
            // Return number of keys less than x.key in the subtree rooted at x.
            if (x == null) return 0;
            int cmp = key.compareTo(x.key);
            if  (cmp < 0) return rank(key, x.left);
            else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
            else          return size(x.left);
        }
        public Iterable<Key> keys() {
            if (isEmpty()) return new Queue<Key>();
            return keys(min(), max());
        }
    
        public Iterable<Key> keys(Key lo, Key hi) {
            if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
            if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
            Queue<Key> queue = new Queue<Key>();
            keys(root, queue, lo, hi);
            return queue;
        }
    
        // add the keys between lo and hi in the subtree rooted at x
        // to the queue.
        private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
            if (x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo <= 0) keys(x.left, queue, lo, hi);
            if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
            if (cmphi >= 0) keys(x.right, queue, lo, hi);
        }
    
    
        public int height() {
            return height(root);
        }
        private int height(Node x) {
            if (x == null) return -1;
            return 1 + Math.max(height(x.left), height(x.right));
        }
        ///
        ////Check integrity of red-black tree data structure.
        private boolean check() {
            if (!isBST())     StdOut.println("Not in symmetric order");
            if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
            if (!isRankConsistent()) StdOut.println("Ranks not consistent");
            if (!is23()) StdOut.println("Not a 2-3 tree");
            if (!isBalanced()) StdOut.println("Not balanced");
            return isBST() && isSizeConsistent() && isRankConsistent()
                && is23() && isBalanced();
        }
    
        // does this binary tree satisfy symmetric order?
        // Note: this test also ensures that data structure is a binary tree
        // since order is strict.
        private boolean isBST() {
            return isBST(root, null, null);
    
        }
        // is the tree rooted at x a BST with all keys strictly between min and max
        // (if min or max is null, treat as empty constraint)
        // Credit: Bob Dondero's elegant solution.
        private boolean isBST(Node x, Key min, Key max) {
            if (x == null) return true;
            if (min != null && x.key.compareTo(min) <= 0) return false;
            if (max != null && x.key.compareTo(max) >= 0) return false;
            return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
        }
        // are the size fields correct?
        private boolean isSizeConsistent() { return isSizeConsistent(root); }
        private boolean isSizeConsistent(Node x) {
            if (x == null) return true;
            if (x.N != size(x.left) + size(x.right) + 1) return false;
            return isSizeConsistent(x.left) && isSizeConsistent(x.right);
        }
    
        // check that ranks are consistent.
        private boolean isRankConsistent() {
            for (int i = 0; i < size(); i++)
                if (i != rank(select(i))) return false;
            for (Key key : keys())
                if (key.compareTo(select(rank(key))) != 0)
                    return false;
            return true;
        }
    
        // Does the tree have no red right links, and at most one(left)
        // red links in a row on any path?
        private boolean is23() { return is23(root); }
        private boolean is23(Node x) {
            if (x == null) return true;
            if (isRed(x.right)) return false;
            if (x != root && isRed(x) && isRed(x.left))
                return false;
            return is23(x.left) && is23(x.right);
        }
    
        // do all paths from root to leaf have same number of black edges?
        private boolean isBalanced() {
            int black = 0; // number of black links on path from root to min
            Node x = root;
            while (x != null) {
                if (!isRed(x)) black++;
                x = x.left;
            }
            return isBalanced(root, black);
        }
        // does every path from the root to a leaf have the given number
        // of black links?
        private boolean isBalanced(Node x, int black) {
            if (x == null) return black == 0;
            if (!isRed(x)) black--;
            return isBalanced(x.left, black) && isBalanced(x.right, black);
        }
    
        
    }
        public static void main(String[] args) {
            RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
            for (int i = 0; !StdIn.isEmpty(); i++){
                String key = StdIn.readString();
                st.put(key, i);
            }
            for (String s : st.keys())
                StdOut.println(s + " " + st.get(s));
            StdOut.println();
            StdOut.println("size: " + st.size());
            StdOut.println("delete min: ");
            st.deleteMin();
            for (String s : st.keys())
                StdOut.println(s + " " + st.get(s));
            StdOut.println("delete 8");
            st.delete("8");
            for (String s : st.keys())
                StdOut.println(s + " " + st.get(s));


        }
}
