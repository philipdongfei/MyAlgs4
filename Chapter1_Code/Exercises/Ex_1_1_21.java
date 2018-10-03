import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex_1_1_21
{
    public static void main(String[] args)
    {
        while(!StdIn.isEmpty()) {
        //while(StdIn.hasNextLine()) {
            String name = StdIn.readString();
            int m = StdIn.readInt();
            int n = StdIn.readInt();
            StdOut.printf("%8s | %8d | %8d | %8.3f\n", 
                    name, m, n, (m*1.0)/n);
        }
    }
}
