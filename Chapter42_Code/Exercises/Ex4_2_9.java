import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class Ex4_2_9 {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        
        DirectedCycle dc = new DirectedCycle(G);
        Topological top = new Topological(G);
        if (dc.hasCycle())
        {
            StdOut.println("Digraph has cycle");
            return;
        }
        StdOut.println("Top order: ");
        for (int v : top.order())
            StdOut.print(v + " ");
        StdOut.println();
        Queue<Integer> randomOrder = new Queue<Integer>();

        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            randomOrder.enqueue(v);
        }
        if (randomOrder.size() == 0)
        {
            StdOut.println("input vertice is empty!");
            return;
        }
        for (int v : top.order()) {
            if (v == randomOrder.peek())
                randomOrder.dequeue();
            if (randomOrder.isEmpty())
            {
                break;
            }
        }
        if (randomOrder.isEmpty())
            StdOut.println("random order is a top order!");
        else {
            StdOut.println("random order is not a top order!");
            StdOut.println("remain vertices: ");
            for (int v : randomOrder)
                StdOut.print(v + " ");
            StdOut.println();

        }

    }
}
