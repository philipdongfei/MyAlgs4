import edu.princeton.cs.algs4.*;
import java.util.*;

public class String_demo
{
    // is the string a palindrome?
    public static boolean isPalindrome(String s)
    {
        int N = s.length();
        for (int i = 0; i < N/2; i++)
            if (s.charAt(i) != s.charAt(N-1-i))
                return false;
        return true;
    }

    // check whether an array of string is in
    // alphabetical order.
    public static boolean isSorted(String[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            if (a[i-1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "now is ";
        String b = "the time ";
        String c = "to";

        StdOut.println(a.length());
        StdOut.println(a.charAt(4));
        StdOut.println(a.concat(c));
        StdOut.println(a.indexOf("is"));
        StdOut.println(a.substring(2,5));
        StdOut.println(a.split(" ")[0]);
        StdOut.println(a.split(" ")[1]);
        StdOut.println(b.equals(c));

        // extract file name and extension from 
        // a conmmand-line argument
        String s = args[1];
        int dot = s.indexOf(".");
        String base = s.substring(0, dot);
        String extension = s.substring(dot + 1, s.length());

        // print all lines in standard input that
        // contain a string specified on the command
        // line
        String query = args[0];
        while (!StdIn.isEmpty())
        {
            String ss= StdIn.readLine();
            if (ss.contains(query)) StdOut.println(ss);
        }

        // create an array of the strings on StdIn
        // delimited by whitespace.
        String input = StdIn.readAll();
        String[] words = input.split("\\s+");

        StdOut.println("isPalindrome: "+isPalindrome(args[0]));


        In in = new In(args[1]);
        String[] list = in.readAllLines();
        StdOut.println("isSorted: " + isSorted(list));


    }



    
}
