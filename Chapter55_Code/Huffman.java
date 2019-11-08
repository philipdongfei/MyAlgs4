import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;


public class Huffman {
    private static final int R = 256;

    private Huffman(){}

    private static class Node implements Comparable<Node>
    {

        private char ch; // unused for internal nodes
        private int freq; // unused for expand
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right)
        {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        public boolean isLeaf()
        {
            assert ((left == null) && (right == null)) ||
                ((left != null ) && (right != null));
            return (left == null) && (right == null);
        }
        public int compareTo(Node that)
        {
            return this.freq - that.freq;
        }
    }

    public static void expand()
    {
        Node root = readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++)
        {
            Node x = root;
            while (!x.isLeaf())
                if (BinaryStdIn.readBoolean())
                    x = x.right;
                else x = x.left;
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }
    private static String[] buildCode(Node root)
    {
       String[] st = new String[R];
       buildCode(st, root, "");
       return st;
    }
    private static void buildCode(String[] st, Node x, String s)
    {
        if (x.isLeaf())
        {
            st[x.ch] = s;
            return;
        }
        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }
    private static Node buildTrie(int[] freq)
    {
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char c = 0; c < R; c++)
            if (freq[c] > 0)
                pq.insert(new Node(c, freq[c], null, null));

        while (pq.size() > 1)
        {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.insert(parent);
        }
        return pq.delMin();
    }
    private static void writeTrie(Node x)
    {
        if (x.isLeaf())
        {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static Node readTrie()
    {
        if (BinaryStdIn.readBoolean())
            return new Node(BinaryStdIn.readChar(), 0, null, null);
        return new Node('\0', 0, readTrie(), readTrie());
    }
    public static void compress()
    {
        // Read input.
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        // Tabulate frequency counts
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        // Build Huffman code trie.
        Node root = buildTrie(freq);

        // Build code table (recursive).
        String[] st = new String[R];
        buildCode(st, root, "");

        // Print trie for decode (recursive).
        writeTrie(root);

        // Print number of chars.
        BinaryStdOut.write(input.length);

        // Use Huffman code to encode input.
        for (int i = 0; i < input.length; i++)
        {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++)
            {
                if (code.charAt(j) == '1')
                    BinaryStdOut.write(true);
                else if (code.charAt(j) == '0')
                    BinaryStdOut.write(false);
                else throw new IllegalArgumentException("Illeag state");
            }
        }
        BinaryStdOut.close();
    }
    public static void main(String[] args)
    {
        if (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}




