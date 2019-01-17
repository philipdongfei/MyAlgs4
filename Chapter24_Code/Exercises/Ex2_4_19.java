import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;


public class Ex2_4_19 {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        MaxPQ<String> pq = new MaxPQ<String>(a);
        pq.show();
    }

}
