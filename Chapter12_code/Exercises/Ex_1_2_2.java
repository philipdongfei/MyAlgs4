import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_2
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        Interval1D[] intervals = new Interval1D[N];

        while(N > 0)
        {
            double lo = StdIn.readDouble();
            double hi = StdIn.readDouble();
            if (lo > hi)
            {
                double temp = lo;
                lo = hi;
                hi = temp;
            }
            Interval1D dinterval = new Interval1D(lo, hi);
            StdOut.printf("(%d)[%f,%f]:%f\n", N, lo, hi, dinterval.length());
            --N;
        }
    }
}
