import java.util.Arrays;
import java.lang.Math;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_20
{
    public static double ln(int N)
    {
        StdOut.println("N="+N);
        if (N == 1) return 0;
        

        return ln(N-1)+Math.log(N); 
    }

    public static void main(String[] args)
    {
        StdOut.println("ln(N!)="+ln(3));
        StdOut.println();
    }
}
