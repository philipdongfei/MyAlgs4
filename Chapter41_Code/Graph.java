import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;


public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;    // number of vertices
    private int E;          // number of edges
    private Bag<Integer>[] adj;  // adjacency lists

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++){
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++){
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }
    public Graph(In in, String sp) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++){
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            in.readLine();
            while (in.hasNextLine()) {
                String[] vertices = in.readLine().split(sp);

                StdOut.println(vertices[0]);
                int s = Integer.parseInt(vertices[0]);
                validateVertex(s);
                for (int i = 1; i < vertices.length; i++)
                {
                    int a = Integer.parseInt(vertices[i]);
                    validateVertex(a);
                    addEdge(s, a);
                }

            }
            if (this.E != E)
                throw new IllegalArgumentException("input E error!");
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]){
                reverse.push(w);
            }
            for (int w : reverse){
                adj[v].add(w);
            }
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    private void validateVertex(int v){
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        /*
         * for Ex4.1.5
        if (v == w || hasEdge(v, w)){
            throw new IllegalArgumentException("v " + v + " and w " + w + " is self-loop or parallel");

        }
        */
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        for (int e : adj[v])
            if (e == w)
                return true;
        return false;
    }
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(v + ": ");
            for (int w : adj[v]){
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public boolean isEulerian() {
        boolean Euler = true;
        for (int v = 0; v < V; v++){
            StdOut.println("v " + v + " degree: " + adj[v].size());
            if ((adj[v].size()) % 2 != 0)
            {
                Euler = false;
                break;
            }

        }
        return Euler;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in, " ");
        StdOut.println(G);
        StdOut.println("Eulerian cycle: " + G.isEulerian());
        /*
        StdOut.println("has edge between 0 and 1: " + G.hasEdge(0, 1));
        StdOut.println("has edge between 0 and 3: " + G.hasEdge(0, 3));
        //G.addEdge(0,0);
        G.addEdge(0,2);
        */

    }
} 
