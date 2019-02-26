import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Ex3_2_14 {

public static class NonrecursiveBST<Key extends Comparable<Key>, Value> {
    // root of BST
    private Node root;

    private class Node {
        private Key key;    // sorted by key
        private Value val;  // associated value
        private Node left, right;  // leaf and right subtrees
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public int size() {
        return size(root);
    }
    
    private int size(Node x){
        if (x == null) return 0;
        else {
            int sz = 1;
            sz += size(x.left);
            sz += size(x.right);
            return sz;
        }
    }


    public Key min() {
        if (root == null)
            throw new NoSuchElementException("Empty");
        Node current = root;

        while (current != null) {
            if (current.left == null)
                return current.key;
            else
                current = current.left;
        }
        return null;
    }
    public Key max() {
        if (root == null) throw new NoSuchElementException("Empty");
        Node current = root;
        while (current != null) {
            if (current.right == null)
                return current.key;
            else
                current = current.right;
        }
        return null;
    }
    public Key floor(Key key) {
        Node current = root;
        Key currentFloor = null;

        while (current != null) {
            int compare = key.compareTo(current.key);
            if (compare < 0)
                current = current.left;
            else if (compare > 0) {
                currentFloor = current.key;
                current = current.right;
            } else {
                currentFloor = current.key;
                break;
            }
        }
        return currentFloor;
    }
    public Key ceiling(Key key) {
        Node current = root;
        Key currentCeiling = null;

        while (current != null) {
            int compare = key.compareTo(current.key);
            if (compare < 0) {
                currentCeiling = current.key;
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                currentCeiling = current.key;
                break;
            }
        }
        return currentCeiling;
    }

    public Key select(int index) {
        if (index >= size())
            throw new IllegalArgumentException("Index is higher than size");
        Node current = root;
        while (current != null) {
            int leftSubtreeSize = size(current.left);

            if (leftSubtreeSize == index) {
                return current.key;
            } else if (leftSubtreeSize > index)
                current = current.left;
            else {
                index -= (leftSubtreeSize + 1);
                current = current.right;
            }
        }
        return null;
    }

    public int rank(Key key) {
        Node current = root;
        int rank = 0;

        while (current != null) {
            int compare = key.compareTo(current.key);

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                rank += size(current.left) + 1;
                current = current.right;
            } else {
                rank += size(current.left);
                return rank;
            }
        }
        return rank;
    }

    // insert (nonrecursive version).
    public void put(Key key, Value val) {
        Node z = new Node(key, val, 1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = z;
        else        parent.right = z;
    }
    // Search BST for given key, nonrecursive version.
    Value get(Key key) {
        Node x= root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }
    // Inorder traversal.
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new Queue<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.enqueue(x.key);
                x = x.right;
            }
        }
        return queue;
    }
}
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        NonrecursiveBST<String, Integer> st = new NonrecursiveBST<String, Integer>();
        for (int i = 0; i < n; i++)
            st.put(a[i], i);
        StdOut.println("min = " + st.min());
        StdOut.println("max = " + st.max());
        StdOut.println("size = " + st.size());
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
