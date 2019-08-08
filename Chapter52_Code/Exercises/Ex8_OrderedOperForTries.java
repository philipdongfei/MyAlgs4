import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


public class Ex8_OrderedOperForTries {

    public static class TrieOrdered<Value> {
        // Returns the highest key in the symbol table smaller than or equal to key.
    private static int R = 256; // radix
    private Node root;

    private static class Node
    {
        private Object value;
        private Node[] next = new Node[R];
    }
    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }
    private Node get(Node x, String key, int d)
    {// Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }
    public void put(String key, Value val)
    {
        root = put(root, key, val, 0);
    }
    private Node put(Node x, String key, Value val, int d)
    {
        // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.value = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
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
        if (x.value != null) cnt++;
        for (char c = 0; c < R; c++)
            cnt += size(x.next[c]);
        return cnt;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public Iterable<String> keys()
    {
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String pre)
    {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }
    private void collect(Node x, String pre, 
            Queue<String> q)
    {
        if (x == null) return;
        if (x.value != null) q.enqueue(pre);
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }
    public Iterable<String> keysThatMatch(String pat){
        Queue<String> q = new Queue<String>();
        collect(root, "", pat, q);
        return q;
    }
    private void collect(Node x, String pre, String pat, Queue<String> q)
    {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.value != null) 
            q.enqueue(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++)
            if (next == '.' || next == c)
                collect(x.next[c], pre+c, pat, q);
    }
    public String longestPrefixOf(String s)
    {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }
    private int search(Node x, String s, int d, int length)
    {
        if (x == null) return length;
        if (x.value != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d+1, length);
    }
    public void delete(String key)
    {
        root = delete(root, key, 0);
    }
    private Node delete(Node x, String key, int d)
    {
        if (x == null) return null;
        if (d == key.length())
            x.value = null;
        else
        {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.value != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }
        public String floor(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            return floor(root, key, 0, new StringBuilder(), null, true);
        }

        private String floor(Node node, String key, int digit, StringBuilder prefix, String lastKeyFound, boolean mustBeEqualDigit)
        {
            if (node == null){
                return null;
            }
            if (prefix.toString().compareTo(key) > 0){
                return lastKeyFound;
            }
            if (node.value != null){
                lastKeyFound = prefix.toString();
            }
            char currentChar;
            if (mustBeEqualDigit && digit < key.length()){
                currentChar = key.charAt(digit);
            } else {
                currentChar = (char)(R - 1);
            }
            for (char nextChar = currentChar;true;
                    nextChar--){
                if(node.next[nextChar] != null){
                    if (nextChar < currentChar){
                        mustBeEqualDigit = false;
                    }
                    lastKeyFound = floor(node.next[nextChar],
                            key, digit+1, prefix.append(nextChar),
                            lastKeyFound, mustBeEqualDigit);
                    if (lastKeyFound != null){
                        return lastKeyFound;
                    }
                    prefix.deleteCharAt(prefix.length() - 1);
                }
                // nextChar value never becomes less than zero
                // in the for loop, so we need this extra 
                // validation
                if (nextChar == 0){
                    break;
                }

                    }
            return lastKeyFound;

        }

        // Returns ths smallest key in the symbol table
        // greater than or equal to key.
        public String ceiling(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");

            }
            return ceiling(root, key, 0, new StringBuilder(), true);
        }
        private String ceiling(Node node, String key, int digit, StringBuilder prefix, boolean mustBeEqualDigit){
            if (node == null){
                return null;
            }
            if (node.value != null && prefix.toString().compareTo(key) >= 0){
                return prefix.toString();
            }
            char currentChar;

            if (mustBeEqualDigit && digit < key.length()){
                currentChar = key.charAt(digit);
            } else {
                currentChar = 0;
            }
            for (char nextChar = currentChar; nextChar < R;
                    nextChar++){
                if (node.next[nextChar] != null){
                    if (nextChar > currentChar){
                        mustBeEqualDigit = false;
                    }
                    String keyFound = ceiling(node.next[nextChar], 
                            key, digit+1, prefix.append(nextChar),
                            mustBeEqualDigit);
                    if (keyFound != null){
                        return keyFound;
                    }
                    prefix.deleteCharAt(prefix.length()-1);
                }
                    }
            return null;
        }
        public String select(int index){
            if (index < 0 || index >= size()){
                throw new IllegalArgumentException("Index cannot be negative and must be lower than trie size");
            }
            return select(root, index, new StringBuilder());
        }
        private String select(Node node, int index, StringBuilder prefix)   
        {
            if (node == null){
                return null;
            }
            if (node.value != null){
                index--;

                // Found the key with the target index
                if (index == -1){
                    return prefix.toString();
                }
            }
            for (char nextChar = 0; nextChar < R; nextChar++){
                if (node.next[nextChar] != null){
                    if (index - size(node.next[nextChar]) < 0){
                        return select(node.next[nextChar], index, prefix.append(nextChar));
                    } else {
                        index = index - size(node.next[nextChar]);
                    }
                }
            }
            return null;
        }

        public int rank(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            return rank(root, key, 0, 0);
        }
        private int rank(Node node, String key, int digit, int size){
            if (node == null || digit == key.length()){
                return size;
            }
            if (node.value != null){
                if (digit < key.length()){
                    size++;
                } else {
                    return size;
                }
            }
            char currentChar = key.charAt(digit);
            for (char nextChar = 0; nextChar < currentChar; nextChar++){
                size += size(node.next[nextChar]);
            }

            return rank(node.next[currentChar], key, digit+1, size);
        }
        public String min(){
            if (isEmpty()){
                return null;
            }
            return min(root, new StringBuilder());
        }
        private String min(Node node, StringBuilder prefix){
            if (node.value != null){
                return prefix.toString();
            }
            for (char nextChar = 0; nextChar < R; nextChar++){
                if (node.next[nextChar] != null){
                    return min(node.next[nextChar], prefix.append(nextChar));
                }
            }
            return prefix.toString();
        }
        public String max(){
            if (isEmpty()){
                return null;
            }
            return max(root, new StringBuilder());
        }
        private String max(Node node, StringBuilder prefix){
            for (char nextChar = (char)(R-1); true; nextChar--){
                if (node.next[nextChar] != null){
                    return max(node.next[nextChar], prefix.append(nextChar));
                }
                // nextChar value never becomes less than zero in the 
                // for loop, so we need this extra validation
                if (nextChar == 0){
                    break;
                }
            }
            return prefix.toString();
        }
        public void deleteMin(){
            if (isEmpty()){
                return;
            }
            String minKey = min();
            delete(minKey);
        }
        public void deleteMax(){
            if (isEmpty()){
                return;
            }
            String maxKey = max();
            delete(maxKey);
        }


    }

    public static void main(String[] args){
        Ex8_OrderedOperForTries order = new Ex8_OrderedOperForTries();
        order.trieTests();
    }
    private void trieTests(){
        StdOut.println("*************Trie tests*************");
        TrieOrdered<Integer> trieOrdered = new TrieOrdered<>();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            trieOrdered.put(key, i);
        }
        StdOut.println("Floor of Re: " + trieOrdered.floor("Re"));
        StdOut.println("Expected: Re");
        StdOut.println("Floor of Algori: " + trieOrdered.floor("Algori"));
        StdOut.println("Expected: Algor");
        StdOut.println("Floor of Ball: " + trieOrdered.floor("Ball"));
        StdOut.println("Expected: Algorithms");
        StdOut.println("Floor of Tarjan: " + trieOrdered.floor("Tarjan"));
        StdOut.println("Expected: TST");
        StdOut.println("Floor of AA: " + trieOrdered.floor("AA"));
        StdOut.println("Expected: null");
        StdOut.println("Floor of Zoom: " + trieOrdered.floor("Zoom"));
        StdOut.println("Expected: Trie123");
        StdOut.println("Floor of TAB: " + trieOrdered.floor("TAB"));
        StdOut.println("Expected: Rene");



    }
}
