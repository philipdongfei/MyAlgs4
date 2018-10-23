import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;

public class Ex_1_3_15
{
    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();
        int k = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        while (q.size() > k)
            q.dequeue();
        StdOut.println("Kth = " + q.dequeue());

    }
}

