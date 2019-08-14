import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Brute_SubstringSearch {
    public static int search(String pat, String txt){
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++)
        {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            if (j == M) return i; // found
        }
        return N; // not found
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

