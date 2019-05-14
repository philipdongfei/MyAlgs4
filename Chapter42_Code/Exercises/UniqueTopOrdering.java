import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;

public class UniqueTopOrdering {
    public static boolean hasUniqueTopOrdering(Digraph G) {

        Topological top = new Topological(G);

        Integer[] order = new Integer[G.V()];
        int index = 0;
        for (int v : top.order())
        {
            order[index++] = v;
            StdOut.print(v + " ");

        }
        StdOut.println();

        boolean hasEdgeToNextVertex = false;
        for (int i = 0; i < (order.length - 1); i++) {
            hasEdgeToNextVertex = false;
            StdOut.println(order[i] + " adj: ");
            for (int neighbor : G.adj(order[i])){
                StdOut.println(neighbor);
                if (neighbor == order[i+1]) {
                    hasEdgeToNextVertex = true;
                    break;
                }
            }
            if (!hasEdgeToNextVertex)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {

        String filename = args[0];
        Digraph G = new Digraph(new In(filename));
        StdOut.println("G.V() " + G.V());
        StdOut.println("Has Topological Ordering: " + hasUniqueTopOrdering(G));
    
    }
}
