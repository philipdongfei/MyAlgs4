import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Sort4 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        if (a > b) {int t = b; b = a; a = t;}
        if (c > d) {int t = d; d = c; c = t;}
        if (a > c) {int t = c; c = a; a = t;}
        if (b > d) {int t = d; d = b; b = t;}
        if (b > c) {int t = c; c = b; b = t;}

        StdOut.println(a + " " + b + " " + c + " " + d);
    }
}
