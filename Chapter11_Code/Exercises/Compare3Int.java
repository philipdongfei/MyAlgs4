import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Compare3Int
{
    public static void main(String[] args)
    {
        int D1 = Integer.parseInt(args[0]);
        int D2 = Integer.parseInt(args[1]);
        int D3 = Integer.parseInt(args[2]);

        if (D1 == D2 && D2 == D3)
            StdOut.println("equal");
        else
            StdOut.println("no equal");
    }
}
