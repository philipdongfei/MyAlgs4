import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;

public class Rhymer {
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return new String(sb);
    }
    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();

        // print words
        StdOut.println("Original:");
        for (int i = 0; i < strings.length; i++)
            StdOut.println(strings[i]);

        StdOut.println();

        // reverse order of letters in each word
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reverse(strings[i]);
        }

        // sort the words
        Arrays.sort(strings);

        // reverse order of letters in each word
        for (int i = 0; i < strings.length; i++)
            strings[i] = reverse(strings[i]);

        // print words
        StdOut.println("Rhymer:");
        for (int i = 0; i < strings.length; i++)
            StdOut.println(strings[i]);
    }
}
