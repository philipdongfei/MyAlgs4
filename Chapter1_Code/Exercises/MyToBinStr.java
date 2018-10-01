import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class MyToBinStr 
{
    public static void main(String[] args)
    {
        
        int N = Integer.parseInt(args[0]);
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;

        StdOut.printf("BinaryString:%s\n", s);

        s = "";
        int m = N;
        do {
            s = (m % 2) + s;
        }while((m /= 2) > 0);
        StdOut.printf("BinaryString:%s\n", s);
    }
}

