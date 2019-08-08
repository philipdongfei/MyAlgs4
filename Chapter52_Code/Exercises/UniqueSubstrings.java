import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


public class UniqueSubstrings {
    public TST<Integer> countUniqueSubstrings(String text){
        TST<Integer> tst = new TST<>();

        for (int L = 1; L <= text.length(); L++){
            for (int i = 0; i < text.length() - L + 1; i++){
                String sub = text.substring(i, i+L);
                tst.put(sub, 0);
            }
        }
        return tst;
    }
    public static void main(String[] args){
        UniqueSubstrings us = new UniqueSubstrings();

        for (int i = 0; !StdIn.isEmpty(); i++){
            String substr = StdIn.readString();
            StdOut.println("Text: " + substr);
            TST<Integer> tst = us.countUniqueSubstrings(substr);
            StdOut.println("size: " + tst.size());
            for (String sub : tst.keys()){
                StdOut.println(sub);
            }
            StdOut.println();
        }
    }
}
