import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Sort6 {
    public static void main(String[] args) {
        // read in 6 command-line integers to sort
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);
        int f = Integer.parseInt(args[5]);
        if (a > b) { int t = b; b = a; a = t; }
        if (c > d) { int t = d; d = c; c = t; }
        if (e > f) { int t = f; f = e; e = t; }
        if (c > e) { int t = e; e = c; c = t; }
        if (a > c) { int t = c; c = a; a = t; }
        if (b > d) { int t = d; d = b; b = t; }
        if (d > f) { int t = f; f = d; d = t; }
        if (b > c) { int t = c; c = b; b = t; }
        if (d > e) { int t = e; e = d; d = t; }
        if (b > d) { int t = d; d = b; b = t; }
        if (c > e) { int t = e; e = c; c = t; }
        if (c > d) { int t = d; d = c; c = t; }
        StdOut.println(a + " " + b + " " + c + " " + d + " " + e + " " 
                + f);
    }
}



