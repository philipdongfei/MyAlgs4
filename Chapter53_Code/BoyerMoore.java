import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class BoyerMoore {
    private int[] right;
    private String pat;

    BoyerMoore(String pat){
        // Compute skip table
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;  // -1 for chars not in pattern
        for (int j = 0; j < M; j++) // rightmost position for
            right[pat.charAt(j)] = j;  // chars in pattern
    }
    public int search(String txt)
    { // Search for pattern in txt
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N-M; i += skip)
        { // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = M-1; j >= 0; j--)
                if (pat.charAt(j) != txt.charAt(i+j))
                {
                    skip = j - right[txt.charAt(i+j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            if (skip == 0) return i; //found.
        }
        return N; // not found
    }
    //Count the pattern in the text
    public int count(String text){
        int count = 0;
        int occurrenceIndex = searchFromIndex(text, 0);

        while (occurrenceIndex != text.length()){
            count++;
            occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
        }
        return count;
    }
    public Iterable<Integer> searchAll(String text){
        Queue<Integer> offsets = new Queue<>();

        int occurrenceIndex = searchFromIndex(text, 0);

        while (occurrenceIndex != text.length()){
            offsets.enqueue(occurrenceIndex);
            occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
        }
        return offsets;
    }

    private int searchFromIndex(String text, int textStartIndex){
        int textLength = text.length();
        int patternLength = pat.length();

        int skip;

        for (int textIndex = textStartIndex; textIndex <= textLength - patternLength; textIndex += skip)
        {
            // Does the pattern match the text at position textIndex?
            skip = 0;
            for (int patternIndex = patternLength - 1;
                    patternIndex >= 0; patternIndex--)
            {
                if (pat.charAt(patternIndex) != text.charAt(textIndex + patternIndex))
                    {
                        skip = Math.max(1, patternIndex - right[text.charAt(textIndex + patternIndex)]);
                        break;
                    }
                }
                if (skip == 0){
                    return textIndex;// found
            }

        }
        return textLength; // not found
    }

    public static void main(String[] args)
    {
        String pat = args[0];
        String txt = args[1];
        BoyerMoore bm = new BoyerMoore(pat);
        StdOut.println("text:    " + txt);
        int offset = bm.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);

        StdOut.println("count: " + bm.count(txt));
        Iterable<Integer> indexes = bm.searchAll(txt);
        for (int index : indexes)
            StdOut.print(index + ", ");
        StdOut.println();
        StdOut.println(txt);
        for (int index : indexes){
            for (int i = 0; i < index; i++)
                StdOut.print(" ");
            StdOut.println(pat);
        }
    }
}
