import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class histogram
{
    public static int[] histogram(int[] a, int M)
    {
        int[] res;
        res = new int[M];
        for (int i = 0; i < M; i++)
            res[i] = 0;

        int Len = a.length;

        for (int i = 0; i < Len; i++)
        {
            if (i < M)
                ++res[i];
        }

        return res;
        
    }

    public static void main(String[] args)
    {
        int[] a = {1,3,2,4,5,6};
        int M = 8;
        int[] array;
        array = histogram(a, M);
        for (int i = 0; i < M; i++)
            StdOut.printf("%d\n", array[i]);
    }
}
