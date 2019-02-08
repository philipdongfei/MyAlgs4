import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Quick;
import java.util.Arrays;

public class Ex2_5_4 {
    public static String[] dedup(String[] a) {
        if (a.length == 0) return null;
        Quick.sort(a);
        Queue<String> q = new Queue<String>();
        int Count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) != 0)
            {
                q.enqueue(a[i-1]);
            }
        }
        Count = q.size();
        String[] b = new String[Count];
        for (int i = 0; i < Count; i++)
            b[i] = q.dequeue();
        return b;
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        String[] d = dedup(a);
        for (String sub: d) {
            StdOut.println(sub);
        }
    }

}

