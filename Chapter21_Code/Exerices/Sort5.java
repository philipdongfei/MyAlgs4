import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Sort5 {
    public static void main(String[] args) {
        int A = Integer.parseInt(args[0]);
        int B = Integer.parseInt(args[1]);
        int C = Integer.parseInt(args[2]);
        int D = Integer.parseInt(args[3]);
        int E = Integer.parseInt(args[4]);
        
        if (A > B) {int t = A; A = B; B = t;}
        if (D > E) {int t = D; D = E; E = t;}
        if (A > C) {int t = A; A = C; C = t;}
        if (B > C) {int t = B; B = C; C = t;}
        if (A > D) {int t = A; A = D; D = t;}
        if (C > D) {int t = C; C = D; D = t;}
        if (B > E) {int t = B; B = E; E = t;}
        if (B > C) {int t = B; B = C; C = t;}
        if (D > E) {int t = D; D = E; E = t;}

        StdOut.println(A + " " + B + " " + C + " " + D + " " + E);
    }
}
