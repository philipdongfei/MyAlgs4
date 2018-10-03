import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_1_30
{
    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);

    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        boolean[][] a = new boolean[N][N];
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int p = i>j ? i : j;
                int q = i<j ? i : j;

                if (gcd(p, q) == 1)
                    a[i][j] = true;
                else
                    a[i][j] = false;

                StdOut.println(i+" "+j+" "+a[i][j]);
                StdOut.println();
            }
        }

    }
}
