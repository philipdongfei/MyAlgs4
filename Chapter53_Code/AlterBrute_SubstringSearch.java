import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class AlterBrute_SubstringSearch {
    public static int search(String pat, String txt){
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++)
        {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {i -= j; j = 0;}
        }
        if (j == M) return i - M; // found
        else  return N; // not found
    }
    public static void main(String[] args){
        String txt = args[0]; //"ABACADABRAC";
        String pat = args[1]; //"ABRA";

        int index = search(pat, txt);
        if (index == txt.length())
            StdOut.println("not found");
        else
            StdOut.println("found, index = " + index);
    }
}

