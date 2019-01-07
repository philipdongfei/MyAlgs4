import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.Comparator;


public class Ex2_2_14 {
    public static Queue<Comparable> mergeQ(Queue<Comparable> a, Queue<Comparable> b) {
        Queue<Comparable> q = new Queue();
        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty()) q.enqueue(b.dequeue());
            else if (b.isEmpty()) q.enqueue(a.dequeue());
            else if (a.peek().compareTo(b.peek()) < 0)
                q.enqueue(a.dequeue());
            else q.enqueue(b.dequeue());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Comparable> a = new Queue<Comparable>();
        Queue<Comparable> b = new Queue<Comparable>();
        int n = 20;
        int cura = 0;
        int curb = 0;
        while (--n > 0) {
            cura += 2;
            curb += 12;
            a.enqueue(cura);
            b.enqueue(curb);
        }
        StdOut.println(a);
        StdOut.println(b);
        StdOut.println(mergeQ(a,b));
    }

}
