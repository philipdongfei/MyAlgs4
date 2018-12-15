import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_7
{
    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b)+mystery(a);

    }

    public static void main(String[] args)
    {
        String s = args[0];
        StdOut.println("Input: ");
        StdOut.println(s);
        StdOut.println("Output: ");
        StdOut.println(mystery(s));

    }
}
