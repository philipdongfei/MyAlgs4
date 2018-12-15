import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_24
{
    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);

    }

    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int p = a > b ? a : b;
        int q = a <= b ? a : b;

        StdOut.println("the greatest common divisor of "+p+" and "+q+" is "+ gcd(p,q));
    }
}
