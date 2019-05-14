import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.DigraphGenerator;
//import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;


public class ShortestDirectedCycle {
    private Stack<Integer> cycle; // directed cycle (or null if no such cycle)
    private int length;

    public ShortestDirectedCycle(Digraph G) {
        Digraph R = G.reverse();
        length = G.V() + 1;
        for (int  v = 0; v < G.V(); v++) {
            BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(R, v);
            for (int w : G.adj(v)) {
                if (bfs.hasPathTo(w) && (bfs.distTo(w) + 1) < length) {
                    length = bfs.distTo(w) + 1;
                    cycle = new Stack<Integer>();
                    for (int x : bfs.pathTo(w))
                        cycle.push(x);
                    cycle.push(v);
                }
            }
        }
    }
    public boolean hasCycle() { return cycle != null; }
    public Iterable<Integer> cycle() { return cycle; }
    public int length() { return length; }

    public static void main(String[] args) {
        Digraph G;
        if (args.length == 1) {
            In in = new In(args[0]);
            G = new Digraph(in);
        }
        else {
            return;
            /*
            int V = Integer.parseInt(args[0]);
            int E = Integer.parseInt(args[1]);
            G = DigraphGenerator.simple(V, E);
            */
        }
        ShortestDirectedCycle finder = new ShortestDirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Shortest directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("No directed cycle");
            
        }
    }

}



