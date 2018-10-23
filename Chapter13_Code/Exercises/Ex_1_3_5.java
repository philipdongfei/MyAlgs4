import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Ex_1_3_5
{
    public static void ToBinary(Integer N)
    {
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }

    public static void main(String[] args)
    {
        Integer N =  Integer.parseInt(args[0]);
        ToBinary(N);

    }
}
