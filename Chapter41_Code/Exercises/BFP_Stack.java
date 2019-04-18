import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;
import java.lang.Math;


public class BFP_Stack 
{
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo;  // last vertex on known path to this vertex
    private int[] distTo; // number of edges shortest s-v path
    private final int s;   // source

    public BFP_Stack(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }
    private void bfs(Graph G, int s)
    {
        
        //Queue<Integer> queue = new Queue<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int v  = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[s] = 0;
        marked[s] = true;   // Mark the source
        //queue.enqueue(s);   // and put it on the queue.
        st.push(s);
        while (!st.isEmpty())
        {
            //int v = queue.dequeue(); // Remove next vertex from the queue
            int v = st.pop();
            for (int w : G.adj(v))
            {
                if (!marked[w])    // for every unmarked adjacent vertex
                {
                    edgeTo[w] = v; // save last edge on a shortest path,
                    distTo[w] = distTo[v] + 1;//adj(v) = v + 1
                    marked[w] = true;  // mark it because path is known,
                    //queue.enqueue(w);  // and add it to the queue.
                }
            }
        }
    }
    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BFP_Stack bfp = new BFP_Stack(G, s);
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.print(s + " to " + v + ": ");
            if (bfp.hasPathTo(v))
                for (int x : bfp.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.println(s + " to " + v + " the shortest path:" + bfp.distTo(v));
        }
    }
}
