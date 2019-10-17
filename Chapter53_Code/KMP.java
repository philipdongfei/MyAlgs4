import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;

public class KMP
{
    private String pat;
    private int[][] dfa;
    private int patternLength;

    public KMP(String pat)
    {
        // Build DFA from pattern
        this.pat = pat;
        int M = pat.length();
        patternLength = M;
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++)
        { // Compute dfa[][j]
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X]; // copy mismatch cases.
            dfa[pat.charAt(j)][j] = j + 1; // Set match case.
            X = dfa[pat.charAt(j)][X]; // Update restart state.
        }
    }

    public int search(In inputStream){
        // Uses only local variables, with no extra instance variables
        int patternIndex = 0;
        int textIndex = 0;

        while (inputStream.hasNextChar() && patternIndex < pat.length())
        {
            patternIndex = dfa[inputStream.readChar()][patternIndex];
            textIndex++;
        }
        if (patternIndex == pat.length()){
            return textIndex - pat.length();
        } else {
            return textIndex;
        }
    }

    public int search(String txt)
    { // Simulate operation of DFA on txt.
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M; // found (hit end of pattern)
        else        return N;    // not found (hit end of text)


    }
    public int count(String txt){
        int count = 0; 
        int occurrenceIndex = searchFromIndex(txt, 0);
        while(occurrenceIndex != txt.length()){
            count++;
            occurrenceIndex = searchFromIndex(txt, occurrenceIndex+1);
        }
        return count;
    }

    public Iterable<Integer> searchAll(String txt){
        Queue<Integer> offsets = new Queue<>();
        int occurrenceIndex = searchFromIndex(txt, 0);

        while (occurrenceIndex != txt.length()){
            offsets.enqueue(occurrenceIndex);
            occurrenceIndex = searchFromIndex(txt, occurrenceIndex+1);

        }
        return offsets;
    }

    private int searchFromIndex(String txt, int textStartIndex){
        int textIndex;
        int patternIndex;
        int textLength = txt.length();

        for (textIndex = textStartIndex, patternIndex = 0;
                textIndex < textLength && patternIndex < patternLength;
                textIndex++)
        {
            patternIndex = dfa[txt.charAt(textIndex)][patternIndex];
        }
        if (patternIndex == patternLength){
            return textIndex - patternLength; // found
        } else {
            return textLength; // not found
        }

    }
    public static void main(String[] args)
    {
        String pat = args[0];
        String txt = args[1];
        String file = args[2];
        KMP kmp = new KMP(pat);
        StdOut.println("text:    " + txt);
        int offset = kmp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
        StdOut.println("count: " + kmp.count(txt));
        Iterable<Integer> indexes = kmp.searchAll(txt);
        for (int index : indexes)
            StdOut.print(index + ", ");
        StdOut.println();
        StdOut.println(txt);
        for (int index : indexes){
            for (int i = 0; i < index; i++)
                StdOut.print(" ");
            StdOut.println(pat);
        }
        // Instream
        StdOut.println("search Instream");
        In inputStream = new In(file);
        //StdOut.println(inputStream);
        StdOut.println("Index: " + kmp.search(inputStream));
        inputStream.close();


    }
}
