import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Sort3 {
    public static void main(String[] args) {
        // read in 3 command-line integers to sort
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int t;

        // 3 compare-exchanges
        if (a > b) {t = a; a = b; b = t;}
        if (a > c) {t = a; a = c; c = t;}
        if (b > c) {t = b; b = c; c = t;}

        StdOut.println(a + " " + b + " " + c);
    
    }
}
