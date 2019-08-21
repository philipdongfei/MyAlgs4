import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.math.BigInteger;
import java.util.Random;


public class RabinKarp {
    private String pat;    // pattern (only needed for Las Vegas)
    private long patHash;  // pattern hash value
    private int M;      // pattern length
    private long Q;     // a large prime
    private int R = 256;    // alphabet size
    private long RM;    // R^(M-1) % Q

    public RabinKarp(String pat)
    {
        this.pat = pat; // save pattern (only needed for Las Vegas)
        this.M = pat.length();
        Q = longRandomPrime();  // See Exercise 5.3.33
        RM = 1;
        for (int i = 1; i <= M-1; i++) // Compute R^(M-1)%Q for use
            RM = (R * RM) % Q;      // in removing leading digit.
        patHash = hash(pat, M);
    }

    public boolean check(int i) // Monte Carlo
    { return true;  }  // For Las Vegas, check pat vs txt
    private long hash(String key, int M)
    { // compute hash for key[0..M-1].
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;

    }
    private int search(String txt)
    {  // Search for hash match in text.
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0; // Match at beginning
        for (int i = M; i < N; i++)
        {// Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + Q - RM*txt.charAt(i-M)%Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash)
                if (check(i - M + 1)) return i - M + 1; // match
        }
        return N;
    }
    private static long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    public static void main(String[] args){
        String pat = args[0];
        String txt = args[1];

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        // from brute force search method 1
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
