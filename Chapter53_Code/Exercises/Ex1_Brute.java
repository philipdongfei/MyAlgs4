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

    public int search(In inputStream) {
        int textIndex;

        // circular queue.
        char[] buffer = new char[patternLength];

        int startBufferIndex = 0;
        int endBufferIndex = -1;
        int totalTextIndex = 0;

        for (textIndex = 0; inputStream.hasNextChar(); textIndex++)
        {

            // Make sure the buffer has the required characters
            while (textIndex + patternLength - 1 >= totalTextIndex)
            {
                if (inputStream.hasNextChar()) {
                    if (endBufferIndex + 1 == buffer.length){
                        endBufferIndex = 0;
                    } else {
                        endBufferIndex = endBufferIndex + 1;
                    }

                    buffer[endBufferIndex] = inputStream.readChar();
                    totalTextIndex++;
                } else {
                   // StdOut.println("return 0");
                    return totalTextIndex; // not found
                }
            }
            int patternIndex;
            //StdOut.println("buffer: " + buffer);
            //StdOut.println("pattern: "  + pattern);

            for (patternIndex = 0; patternIndex < patternLength; patternIndex++)
            {
                int bufferIndex;
                if (startBufferIndex + patternIndex >= buffer.length){
                    bufferIndex = patternIndex - (buffer.length - startBufferIndex);
                } else {
                    bufferIndex = startBufferIndex + patternIndex;
                }
                //StdOut.print(buffer[bufferIndex]);
                if (buffer[bufferIndex] != pattern.charAt(patternIndex))
                {
                    break;
                }
            }
            if (startBufferIndex + 1 == buffer.length){
                startBufferIndex = 0;
            } else {
                startBufferIndex = startBufferIndex + 1;
            }
            if (patternIndex == patternLength){
                StdOut.println();
                return textIndex; // found
            }

        }
        // No need to clear the buffer since it is a local variable and will be collected by the garbage collector
        // once the method returns.
        StdOut.println();
        return totalTextIndex; // not found


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

        String pattern = args[0];
        String file = args[1];
        In inputStream = new In(file);
        Ex1_Brute ex3 = new Ex1_Brute(pattern);
        int index3 = ex3.search(inputStream);
        for (int i = 0; i < index3; i++)
            StdOut.print(" ");
        StdOut.println(pattern);
        StdOut.println("Index 3: " + index3 + " Expected: 8");
        inputStream.close();

    }
}
