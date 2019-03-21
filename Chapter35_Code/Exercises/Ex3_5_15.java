import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class Ex3_5_15 {
    private static RedBlackBST<String, Integer> produceKGram(String text, int k)
    {
        if (k > text.length())
            throw new IllegalArgumentException("k cannot be higher than text length");
        RedBlackBST<String, Integer> KGrams = 
            new RedBlackBST<>();
        for (int i = 0; i <= text.length() - k; i++)
        {
            String strK = text.substring(i, i+k);
            KGrams.put(strK, i);
        }
        return KGrams;
    }

    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty())
        {
            String text = StdIn.readLine();
            RedBlackBST<String, Integer> st = produceKGram(text, k);
            for (String strK : st.keys())
                StdOut.println(strK + " " + st.get(strK));
            StdOut.println();
            
        }
        StdOut.println();
    }
}
