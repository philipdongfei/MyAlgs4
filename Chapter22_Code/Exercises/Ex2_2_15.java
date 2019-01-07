import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_2_15 {
    public static class MergeBUQ {
        private static Queue<Queue> q;

        public static void sort(Comparable[] a) {
            q = new Queue<Queue>();
            for (Comparable c : a) {
                Queue<Comparable> tmp = new Queue<Comparable>();
                tmp.enqueue(c);
                q.enqueue(tmp);
            }
            while (q.size() > 1)
                q.enqueue(mergeQ(q.dequeue(), q.dequeue()));

            Queue<Comparable> b = q.dequeue();
            for (int i = 0; i < a.length; i++)
                a[i] = b.dequeue();
        }
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
        public static boolean isSorted(Comparable[] a){
            for (int i = 1; i < a.length; i++)
                if (a[i].compareTo(a[i-1]) < 0) return false;
            return true;
        }
        private static void show(Comparable[] a) {
            // Print the array, on a single line.
            for (int i = 0; i < a.length; i++)
                StdOut.print(a[i] + " ");
            StdOut.println();
        }

    }
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        MergeBUQ.show(a);
        MergeBUQ.sort(a);
        assert MergeBUQ.isSorted(a);
        MergeBUQ.show(a);
    }
}
