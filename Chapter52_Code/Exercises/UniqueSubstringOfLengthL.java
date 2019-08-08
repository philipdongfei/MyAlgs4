import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


public class UniqueSubstringOfLengthL {
    public static TST<Integer> countUniqueSubstrings(String text, int L){
        TST<Integer> tst = new TST<>();

        int maxIndex = text.length() - L + 1;

        for (int i = 0; i < maxIndex; i++){
            String sub = text.substring(i, i + L);
            tst.put(sub, 0);
        }
        return tst;
    }
    public static void main(String[] args){
        
        int L = Integer.parseInt(args[1]);
        String text = args[0]; 

        TST<Integer> tst = countUniqueSubstrings(text, L);
        StdOut.println("size: " + tst.size());
        for (String sub : tst.keys()){
            StdOut.println(sub);
        }
        StdOut.println();
    }

}
