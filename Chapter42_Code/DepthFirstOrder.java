import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class DepthFirstOrder
{
    private boolean[] marked;

    private Queue<Integer> pre;    // vertices in preorder
    private Queue<Integer> post;   // vertices in postorder
    private Stack<Integer> reversePost; // vertices in reverse postorder

    public DepthFirstOrder(Digraph G)
    {
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    public DepthFirstOrder(EdgeWeightedDigraph G){
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
        
    }
    private void dfs(Digraph G, int v)
    {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
        post.enqueue(v);
        reversePost.push(v);
    }
    private void dfs(EdgeWeightedDigraph G, int v){
        pre.enqueue(v);
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (!marked[w])
                dfs(G, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre()
    { 
        return pre;
    }
    public Iterable<Integer> post()
    { return post; }
    public Iterable<Integer> reversePost()
    { return reversePost; }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DepthFirstOrder dfo = new DepthFirstOrder(G);
        StdOut.println("pre: ");
        for (int v : dfo.pre())
            StdOut.print(v + " ");
        StdOut.println();
        StdOut.println("post: ");
        for (int v : dfo.post())
            StdOut.print(v + " ");
        StdOut.println();

    }
}
