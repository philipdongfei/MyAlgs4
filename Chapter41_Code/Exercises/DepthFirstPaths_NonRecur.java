import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.ArrayList;

public class DepthFirstPaths_NonRecur
{
    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo;     // last vertex on known path to this vertex
    private final int s;    // source

    public DepthFirstPaths_NonRecur(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v)
    {
        Stack<Integer> stack = new Stack<>();
        marked[v] = true;
        stack.push(v);
        Iterator<Integer>[] adjIter = (Iterator<Integer>[])new Iterator[G.V()];
        for (int i = 0; i < G.V(); i++){
            if (G.adj(i) != null){
                adjIter[i] = G.adj(i).iterator();
                /*
                ArrayList al = new ArrayList();
                for (int x : G.adj(i))
                    al.add(x);
                adjIter[i] = al.iterator();
                */
            }
        }

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            //StdOut.println("Stack peek: " + currentVertex);

            if (adjIter[currentVertex].hasNext()){
                int adjV = adjIter[currentVertex].next();
                if (!marked[adjV]) {
                    stack.push(adjV);
                    edgeTo[adjV] = currentVertex; 
                    marked[adjV] = true;
                }
            }
            else 
                stack.pop();
            //StdOut.println("Stack size: " + stack.size());
        }
        /*
        for (int w : G.adj(v))
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
        */
    }
    public boolean hasPathTo(int v)
    {
        return marked[v];
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
        DepthFirstPaths_NonRecur dfp = new DepthFirstPaths_NonRecur(G, s);
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.print(s + " to " + v + ": ");
            if (dfp.hasPathTo(v))
                for (int x : dfp.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}
