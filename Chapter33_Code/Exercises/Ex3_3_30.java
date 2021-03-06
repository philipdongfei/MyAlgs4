import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;


public class Ex3_3_30 {
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
            int depth;
            Node(Key key, Value val, int N, boolean color)
            {
                this.key = key;
                this.val = val;
                this.N = N;
                this.color = color;
            }
        }
        private Node root;
        private Node cacheItem;
        
    
        private int internalPathLength() {
            if (root == null)
                return 0;
            int internalPathLen = 0;

            Queue<Node> qu = new Queue<Node>();

            root.depth = 0;
            qu.enqueue(root);

            while (!qu.isEmpty()) {
                Node current = qu.dequeue();
                internalPathLen += current.depth;
                if (current.left != null) {
                    current.left.depth = current.depth + 1;
                    qu.enqueue(current.left);
                }
                if (current.right != null) {
                    current.right.depth = current.depth + 1;
                    qu.enqueue(current.right);
                }
            }
            return internalPathLen;
        }
        public int averagePathLength() {
            if (size() == 0)
                return 0;
            return (internalPathLength()/size()) + 1;
        }
        private boolean isRed(Node x)
        {
            if (x == null) return false; //BLACK
            return x.color == RED;
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
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }
    
        public int size() {
            return size(root);
        }
        private int size(Node x)
        {
            if (x == null) return 0;
            else           return x.N;
        }
    
        public void put(Key key, Value val)
        { // Search for key. Update value if found; grow table if new.
            if (cacheItem != null && cacheItem.key.compareTo(key) == 0)
            {
                cacheItem.val = val;
                StdOut.println("Cache hit");
                return;
            }
            root = put(root, key, val);
            root.color = BLACK;
    
        }
    
        private Node put(Node h, Key key, Value val)
        {
            if (h == null) // Do standard insert, with red link to parent.
            {
                Node newNode = new Node(key,val,1,RED);
                cacheItem = newNode;
                return newNode;
                //return new Node(key, val, 1, RED);
            }
            //flipping colors on the way down
            if (isRed(h.left) && isRed(h.right)) flipColors(h);
    
            int cmp = key.compareTo(h.key);
            if (cmp < 0) h.left = put(h.left, key, val);
            else if (cmp > 0) h.right = put(h.right, key, val);
            else {
                h.val = val;
                cacheItem = h;

            }
    
            // balancing on the way up.
            if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
    
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
        public Key select(int k)
        {
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
    
        ///
        
    }

    public static void main(String[] args) 
    {
        String[] a = StdIn.readAllStrings();

        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();

        for (int i = 0; i < a.length; i++)
            st.put(a[i], i);
        StdOut.println("size = " + st.size());
        StdOut.println("min = " + st.min());
        StdOut.println("max = " + st.max());
        StdOut.println("average path length: " + st.averagePathLength());
        StdOut.println();

    
    }
    
}
