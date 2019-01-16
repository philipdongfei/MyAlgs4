import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_4_5 {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        MaxPQ<String> pq = new MaxPQ<String>(n);
        for (String s : a){
            pq.insert(s);
        }
        pq.show();
        /*
        String[] h = pg.getHeap();
        for (int i = 1; i < h.length; i++)
            StdOut.println(h[i]);
        */

    }
}
