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
        */
    }

}
