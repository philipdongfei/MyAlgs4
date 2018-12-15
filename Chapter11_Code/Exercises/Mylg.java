import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Mylg
{
    public static int Mylg(int N)
    {
        int res = 0;
        int n = N;
        do {
           if (n/2 > 0)
               ++res;
        }while((n /= 2) > 0);

        return res;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        StdOut.printf("lg(N)=%d\n", Mylg(N));
    }
}
