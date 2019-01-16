import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_4_1 {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        MaxPQ<String> pg = new MaxPQ<String>(n);
        for (String s : a){
            if (s.compareTo("*") == 0)
                StdOut.println(pg.delMax());
            else
                pg.insert(s);
        }
    }
}
