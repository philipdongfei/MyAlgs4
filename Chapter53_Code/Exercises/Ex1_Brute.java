import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;
//import edu.princeton.cs.algs4.Itera;


public class Ex1_Brute{
    private String pattern;
    private int patternLength;

    public Ex1_Brute(String pattern){
        this.pattern = pattern;
        patternLength = pattern.length();
    }

    // Search for pattern in text.
    // Return the index of the first occurrence of the pattern string
    // in the text string or textLength if no such match.
    public int search(String txt){
        int M = patternLength;
        int N = txt.length();
        for (int i = 0; i <= N - M; i++)
        {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i+j) != pattern.charAt(j))
                    break;
            if (j == M) return i;
        }
        return N;
    }
    // Alternate implementation.
    public int search2(String txt){
        int i, j, N = txt.length(), M = patternLength;
        for (i = 0, j = 0; i < N && j < M; i++)
        {
            if (txt.charAt(i) == pattern.charAt(j)) j++;
            else { i -= j; j = 0; }
        }
        if (j == M) return i - M;
        else    return N;
    }
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
        //StdOut.println("occurrenceIndex: " + occurrenceIndex);
        while (occurrenceIndex != text.length()){
            //StdOut.println("enqueue: " + occurrenceIndex);
            offsets.enqueue(occurrenceIndex);
            occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
        }
        return offsets;
    }

    private int searchFromIndex(String text, int textStartIndex){
        int textLength = text.length();
        for (int textIndex = textStartIndex;
                textIndex <= textLength - patternLength;textIndex++)
        {
            int patternIndex;

            for (patternIndex = 0; patternIndex < patternLength; patternIndex++)
            {
                if (text.charAt(textIndex + patternIndex) != pattern.charAt(patternIndex))
                {
                    break;
                }
            }
            if (patternIndex == patternLength)
            {
                return textIndex;

            }
        }
        return textLength;
    }
    public static void main(String[] args){
        String text = "abacadabrabracabracadabrabrabracad";

        String pat = "abracadabra";
        Ex1_Brute ex1 = new Ex1_Brute(pat);
        int index1 = ex1.search(text);
        StdOut.println("Index 1: " + index1 + " Expected: 14");

        String pat2 = "rab";
        Ex1_Brute ex2 = new Ex1_Brute(pat2);
        int index2 = ex2.search(text);
        StdOut.println("Index 2: " + index2 + " Expected: 8");


    }
}
