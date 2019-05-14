import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;


public class HamiltonianPathInDAGs {

    public static void main(String[] args) {
        String filename = args[0];
        //String separator = args[1];
        //SymbolDigraph sg = new SymbolDigraph(filename, separator);
    
        //Digraph G = sg.G();
        Digraph G = new Digraph(new In(filename));
        StdOut.println("G.V() " + G.V());
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
                break;
        }
        if (hasEdgeToNextVertex)
            StdOut.println("Has Hamiltonian path in DAGs");
        else
            StdOut.println("Has not Hamiltonian path in DAGs");

    } 
}
