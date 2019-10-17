import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;
import java.math.BigInteger;
import java.util.Random;


public class RabinKarp {
    protected String pat;    // pattern (only needed for Las Vegas)
    protected long patHash;  // pattern hash value
    protected int M;      // pattern length
    protected long Q;     // a large prime
    protected int R = 256;    // alphabet size
    protected long RM;    // R^(M-1) % Q
    private boolean isMonteCarloVersion;

    public RabinKarp(String pat)
    {
        this.pat = pat; // save pattern (only needed for Las Vegas)
        this.M = pat.length();
        Q = longRandomPrime();  // See Exercise 5.3.33
        RM = 1;
        isMonteCarloVersion = true;
        for (int i = 1; i <= M-1; i++) // Compute R^(M-1)%Q for use
            RM = (R * RM) % Q;      // in removing leading digit.
        patHash = hash(pat, M);
    }
    public RabinKarp(String pat, boolean isMonteCarloVersion)
    {
        this.pat = pat; // save pattern (only needed for Las Vegas)
        this.M = pat.length();
        Q = longRandomPrime();  // See Exercise 5.3.33
        RM = 1;
        this.isMonteCarloVersion = isMonteCarloVersion;
        for (int i = 1; i <= M-1; i++) // Compute R^(M-1)%Q for use
            RM = (R * RM) % Q;      // in removing leading digit.
        patHash = hash(pat, M);
    }

    public boolean check(int i) // Monte Carlo
    { return true;  }  // For Las Vegas, check pat vs txt
    protected boolean check(String text, int textIndex){
        if (isMonteCarloVersion)
            return true;

        // Las Vegas version
        for (int patternIndex = 0; patternIndex < M;
                patternIndex++)
        {
            if (pat.charAt(patternIndex) != text.charAt(textIndex + patternIndex)){
                return false;
            }
        }
        return true;

    }
    public int search(In inputStream) {
        // Uses only local variables, with no extra instance variables
        int textIndex;

        // Maintains a circular queue as a buffer of the last patternLength characters to use when removing the leading digit in the rolling hash computation.
        char[] buffer = new char[M];

        // compute hash and initialize buffer
        long textHash = hash(inputStream, buffer);

        int endBufferIndex = buffer.length - 1;

        if (patHash == textHash){
            return 0; // match
        }
        for (textIndex = M; inputStream.hasNextChar(); textIndex++){
            // Remove leading character, add trailing character, check for match.
            int leadingDigitIndex;

            if (endBufferIndex + 1 - M < 0){
                leadingDigitIndex = M - (endBufferIndex + 1);
                leadingDigitIndex = M - leadingDigitIndex;
            } else {
                leadingDigitIndex = endBufferIndex + 1 - M;
            }

            char leadingDigit = buffer[leadingDigitIndex];
            char nextChar = inputStream.readChar();

            textHash = (textHash + Q - RM * leadingDigit % Q) % Q;
            textHash = (textHash * R + nextChar) % Q;


            if (patHash == textHash){
                return (textIndex - M + 1); // match
            }
            if (endBufferIndex + 1 == buffer.length){
                endBufferIndex = 0;
            } else {
                endBufferIndex++;
            }
            buffer[endBufferIndex] = nextChar;
        }
        return textIndex; // no match
    }

    // Horner's method applied to modular hashing
    protected long hash(In inputStream, char[] buffer){
        // Compute hash for the first patternLength characters in inputStream
        long hash = 0;

        for (int patternIndex = 0; inputStream.hasNextChar() && patternIndex < M; patternIndex++)
        {
            char nextChar = inputStream.readChar();
            buffer[patternIndex] = nextChar;

            hash = (hash * R + nextChar) % Q;
        }

        return hash;
    }
    protected long hash(String key, int M)
    { // compute hash for key[0..M-1].
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;

    }
    protected int search(String txt)
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
    protected static long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    public int count(String text){
        int count = 0;
        int occurrenceIndex = searchFromIndex(text, 0);

        while (occurrenceIndex != text.length()){
            count++;
            if (occurrenceIndex + 1 >= text.length()){
                break;
            }
            occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
        }
        return count;
    }

    public Iterable<Integer> searchAll(String text){
        Queue<Integer> offsets = new Queue<>();

        int occurrenceIndex = searchFromIndex(text, 0);

        while (occurrenceIndex != text.length()){
            offsets.enqueue(occurrenceIndex);

            if (occurrenceIndex + 1 >= text.length()){
                break;
            }
            occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
        }
        return offsets;
    }
    protected int searchFromIndex(String text, int textStartIndex){
        String eligibleText = text.substring(textStartIndex);

        int textLength = eligibleText.length();
        //int patternLength = M;
        //long patternHash = patHash; 
        //long largePrimeNumber = Q;

        if(textLength < M){
            return textStartIndex + textLength; // no match
        }

        long textHash = hash(eligibleText, M);

        if (patHash == textHash && check(eligibleText, 0))
            return textStartIndex; // match
        for (int textIndex = M; textIndex < textLength; textIndex++)
        {
            // Remove leading character, add trailing character, check for match
            textHash = (textHash + Q - RM * eligibleText.charAt(textIndex - M) % Q) % Q;
            textHash = (textHash * R + eligibleText.charAt(textIndex)) % Q;

            int offset = textIndex - M + 1;

            if (patHash == textHash && check(eligibleText, offset)){
                return textStartIndex + offset;
            }
        }
        return textStartIndex + textLength; // no match
    }
    public static void main(String[] args){
        String pat = args[0];
        String txt = args[1];
        String file = args[2];

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        // from brute force search method 1
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
        StdOut.println("count: " + searcher.count(txt));
        Iterable<Integer> indexes = searcher.searchAll(txt);
        for (int index : indexes)
            StdOut.print(index + ", ");
        StdOut.println();
        StdOut.println(txt);
        for (int index : indexes){
            for (int i = 0; i < index; i++)
                StdOut.print(" ");
            StdOut.println(pat);
        }
        StdOut.println("InputStream ");
        In inputStream = new In(file);
        StdOut.println("Index: " + searcher.search(inputStream));
        inputStream.close();
    }
}
