import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;


public class Ex2_web_4 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        String[] a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readString();
        }
        Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
    }
}
