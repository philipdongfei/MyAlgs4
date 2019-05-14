import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import java.util.Iterator;


public class NonrecursiveDirectedCycle {
    private Stack<Integer> cycle;

    public NonrecursiveDirectedCycle(Digraph G) {
        int[] edgeTo = new int[G.V()];
        boolean[] marked = new boolean[G.V()];
        boolean[] onStack = new boolean[G.V()];
        Stack<Integer> stack = new Stack<Integer>();

        Iterator<Integer>[] adj = (Iterator<Integer>[])new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++)
            adj[v] = G.adj(v).iterator();

        for (int s = 0; s < G.V(); s++){
            if (!marked[s]){
                onStack[s] = true;
                marked[s] = true;
                stack.push(s);
                while (!stack.isEmpty()){
                    int v = stack.peek();
                    if (adj[v].hasNext()){
                        int w = adj[v].next();
                        if (!marked[w]){
                            marked[w] = true;
                            edgeTo[w] = v;
                            stack.push(w);
                            onStack[w] = true;
                        }
                        else if (onStack[w]){
                            cycle = new Stack<Integer>();
                            for (int x = v; x != w; x = edgeTo[x]){
                                cycle.push(x);
                            }
                            cycle.push(w);
                            cycle.push(v);
                            assert check();
                            return;
                        }
                    }
                    else {
                        int vCopy = stack.pop();
                        assert v == vCopy;
                        onStack[v] = false;
                    }
                }
            }
        }
    }
    public boolean hasCycle(){
        return cycle != null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
    private boolean check(){
        if (hasCycle()){
            int first = -1, last = -1;
            for (int v : cycle()){
                if (first == -1) first = v;
                last = v;
            }
            if (first != last){
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        NonrecursiveDirectedCycle finder = new 
            NonrecursiveDirectedCycle(G);
        if (finder.hasCycle()){
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()){
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("No directed cycle");
        }
    }
}
