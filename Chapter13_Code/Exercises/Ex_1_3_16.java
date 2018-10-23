import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;

public class Ex_1_3_16
{
    public static void main(String[] args) {
        int[] d = readDates();
        for (int i = 0; i < d.length; i++) {
            StdOut.println(d[i]);
        }
    }

    public static int[] readDates() {
        Queue<Character> q = new Queue<Character>();

        while (!StdIn.isEmpty()){
            q.enqueue(StdIn.readChar());
        }

        int N = q.size();
        int[] a = new int[3];
        String temp = "";
        int k = 0;

        for (int i = 0; i < N; i++) {
            char c = q.dequeue();
            if (c == '/') {
                a[k] = Integer.parseInt(temp);
                k += 1;
                temp = "";
            } else {
                temp += c;
            }
        }
        a[k] = Integer.parseInt(temp);

        return a;
    }
}

