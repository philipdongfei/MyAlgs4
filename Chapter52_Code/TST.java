import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


public class TST<Value>
{
    private Node root; // root of trie
    private class Node<Value>
    {
        char c;  // character
        Node left, mid, right; // left, middle, and right subtries
        Value val;  // valueassociated with string
    }
    public Value get(String key) // same as for tries 
    {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value)x.val;

    }
    private Node get(Node x, String key, int d)
    {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() -1)
            return get(x.mid, key, d+1);
        else return x;
    }
    public void put(String key, Value val)
    { root = put(root, key, val, 0); }
    private Node put(Node x, String key, Value val, int d)
    {
        char c = key.charAt(d);
        if (x == null) { x = new Node(); x.c = c; }
        if ( c < x.c ) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)
            x.mid = put(x.mid, key, val, d+1);
        else x.val = val;
        return x;
    }
    public String longestPrefixOf(String query){
        if (query == null){
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()){
            char c = query.charAt(i);
            if (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }
    public Iterable<String> keysWithPrefix(String prefix){
        if (prefix == null){
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new Queue<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.enqueue(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    public Iterable<String> keysThatMatch(String pattern){
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
    private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue){
        if (x == null) return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.c){
            if (i == pattern.length() - 1 && x.val != null) 
                queue.enqueue(prefix.toString() + x.c);
            if (i < pattern.length() - 1){
                collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
    }

    
    public void delete(String key){
        if (key == null){
            throw new IllegalArgumentException("key cannot be null");
        }
        if (contains(key))
            return;
        root = delete(root, key, 0);
    }
    private Node delete(Node node, String key, int digit){
        if (node == null)
            return null;
        if (digit == key.length() - 1){
            //node.size = node.size - 1;
            node.val = null;
        } else {
            char nextChar = key.charAt(digit);
            if (nextChar < node.c){
                node.left = delete(node.left, key, digit);

            } else if (nextChar > node.c){
                node.right = delete(node.right, key, digit);
            } else {
                //node.size = node.size - 1;
                node.mid = delete(node.mid, key, digit+1);
            }
        }
        if (size(node) == 0) {
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            } else {
                Node aux = node;
                node = min(aux.right);
                node.right = deleteMin(aux.right);
                node.left = aux.left;
            }
        }
        return node;
    }
    private Node min(Node node){
        if (node.left == null)
            return node;
        return min(node.left);
    }
    private Node deleteMin(Node node){
        if (node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
    public boolean contains(String key){
        if (key == null)
            throw new IllegalArgumentException("key cannot be null");
        return get(key) != null;
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;
        if (x.left != null) cnt += size(x.left);
        if (x.mid != null) cnt += size(x.mid);
        if (x.right != null) cnt += size(x.right);
        return cnt;
    }
    public Iterable<String> keys()
    {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }
    // all keys in subtrie rooted at x with given prefix
    private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue){
        if (x == null) return;
        collect(x.left, prefix, queue);
        if (x.val != null) queue.enqueue(prefix.toString() + x.c);
        collect(x.mid, prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }

    public static void main(String[] args){
        // build symbol table from standard intpu
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        // print results

        if (st.size() < 100){
            StdOut.println("size: " + st.size());
            StdOut.println("keys(\"\"):");
            for (String key : st.keys()){
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();
        }
        /*
        StdOut.println("delete(\"shells\"): ");
        st.delete("shells");
        */
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
        StdOut.println();

        StdOut.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
            StdOut.println(s);
        StdOut.println("longestPrefixOf(\"shellsort\"):");
        StdOut.println(st.longestPrefixOf("shellsort"));
        StdOut.println();

        StdOut.println("longestPrefixOf(\"quicksort\"):");
        StdOut.println(st.longestPrefixOf("quicksort"));
        StdOut.println();
        StdOut.println("longestPrefixOf(\"sea\"):");
        StdOut.println(st.longestPrefixOf("sea"));
        StdOut.println();

        StdOut.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
            StdOut.println(s);
        StdOut.println();
    }

}
