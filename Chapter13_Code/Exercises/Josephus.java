import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        Queue<Integer> q = new Queue<Integer>();
        int pos = 1;

        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }

        while(!q.isEmpty()) {
            if (pos % M == 0)
                StdOut.print(q.dequeue() + " ");
            else
                q.enqueue(q.dequeue());
            pos++;
        }
        StdOut.println();
        
    }
}
