import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.*;


public class Ex_1_1_27
{
    public static double binomial(int n, int k, double p, Counter c)
    {
        if ((n == 0) && (k == 0)) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        c.increment();

        return (1.0 - p)*binomial(n-1, k, p,c) + p*binomial(n-1, k-1, p, c);
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]),
            k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        Counter c = new Counter("calls");


        double b = binomial(n,k,p,c);
        StdOut.println(b);
        StdOut.println(c);
    }

}
