import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;


public class LCAInDAG {
    private Digraph digraph;
    private int[] maxDistances;

    /**
     * 1 Find all sources in the digraph
     * 2 compute the height of all vertices (max distance from any source)
     * O(S * (V+E)) where S is the number of sources = O(VE)
     ******/
    public LCAInDAG(Digraph digraph){
        this.digraph = digraph;
        maxDistances = new int[digraph.V()];
        Bag<Integer> sources = new Bag<Integer>();

        // 1 Find hte sources in the graph
        // choise the vertexes which indegree is 0
        StdOut.println("sources: ");
        for (int v = 0; v < digraph.V(); v++){
            if (digraph.indegree(v) == 0)
            {
                StdOut.print(v + " ");
                sources.add(v);

            }
        }
        StdOut.println();
        // 2 Find the height of all vertices (the length of the longest distance from a source)
        for (int v = 0; v < digraph.V(); v++)
            maxDistances[v] = -1;

        for (int source : sources) {
            int [] distanceFromCurrentSource = new int[digraph.V()];

            for (int v = 0; v < distanceFromCurrentSource.length; v++)
                distanceFromCurrentSource[v] = Integer.MAX_VALUE;

            Queue<Integer> sourceDistanceQueue = new Queue<>();
            sourceDistanceQueue.enqueue(source);
            distanceFromCurrentSource[source] = 0;

            if (distanceFromCurrentSource[source] > maxDistances[source]){
                maxDistances[source] = distanceFromCurrentSource[source];
            }
            // compute the max distance with BFS
            while (!sourceDistanceQueue.isEmpty()) {
                int currentVertex = sourceDistanceQueue.dequeue();

                for (int neighbor : digraph.adj(currentVertex)) {
                    distanceFromCurrentSource[neighbor] = distanceFromCurrentSource[currentVertex] + 1;
                    sourceDistanceQueue.enqueue(neighbor);

                    if (distanceFromCurrentSource[neighbor] > maxDistances[neighbor])
                        maxDistances[neighbor] = distanceFromCurrentSource[neighbor];
                }
            }
        }
    }
    public int getLCA(int v, int w) {
        DirectedCycle directedcycle = new DirectedCycle(digraph);
        if (directedcycle.hasCycle()) {
            throw new IllegalArgumentException("Digraph is not a DAG");
        }
        // Reverse graph
        Digraph reverseDigraph = digraph.reverse();

        // Do a BFS from vertex1 to find all its ancestors
        SET<Integer> vAncestors = new SET<Integer>();

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int currentVertex = queue.dequeue();
            vAncestors.add(currentVertex);

            for (int neighbor : reverseDigraph.adj(currentVertex))
                queue.enqueue(neighbor);
        }

        Bag<Integer> commonAncestors = new Bag<Integer>();

        queue.enqueue(w);

        while(!queue.isEmpty()) {
            int currentVertex = queue.dequeue();
            if (vAncestors.contains(currentVertex))
                commonAncestors.add(currentVertex);

            for (int neighbor : reverseDigraph.adj(currentVertex))
                queue.enqueue(neighbor);
        }
        // Find the height of all common ancestors (the length of the longest distance from a source)
        // The common ancestor with greatest height is an LCA of v and w
        int maxDistance = -1;
        int lowestCommonAncestor = -1;
        for (int commonAncestor : commonAncestors) {
            if (maxDistances[commonAncestor] > maxDistance) {
                maxDistance = maxDistances[commonAncestor];
                lowestCommonAncestor = commonAncestor;
            }
        }

        return lowestCommonAncestor;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        int v = Integer.parseInt(args[1]);
        int w = Integer.parseInt(args[2]);

        LCAInDAG lca = new LCAInDAG(G);
        StdOut.println("Digraph G: ");
        StdOut.println(G);
        StdOut.println();
        StdOut.println("LCA of " + v + " and " + w + " is " + lca.getLCA(v, w));
    }

}
