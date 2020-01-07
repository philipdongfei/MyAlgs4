import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class BruteForceLCP
{
    public BruteForceLCP(){}

    private static int lcp(String s, String t)
    {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i)) return i;
        return N;
    }
    public static void main(String[] args){
        String s = "acctgttacc";
        String t = "accgttaa";

        int N = lcp(s, t);
        StdOut.println("lcp length: " + N);

    }
}
