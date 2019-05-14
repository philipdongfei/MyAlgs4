import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class ShortestAncestralPath {
    private class AncestralPath {
        private int commonAncestor;
        private String VToAncestor;
        private String WToAncestor;
        AncestralPath(int commonAncestor,
                String VToAncestor, String WToAncestor) {
            this.commonAncestor = commonAncestor;
            this.VToAncestor = VToAncestor;
            this.WToAncestor = WToAncestor;
        }
        public int GetCommonAncestor(){
            return commonAncestor;
        }
        public String GetVToAncestor(){
            return VToAncestor;
        }
        public String GetWToAncestor(){
            return WToAncestor;
        }
    }
    public AncestralPath getShortestAncestralPath(Digraph digraph,
            int v, int w) {
        //StdOut.println("getShortestAncestralPath");
        DirectedCycle directedcycle = new DirectedCycle(digraph);
        if (directedcycle.hasCycle()) {
            throw new IllegalArgumentException("Digraph is not a DAG");
        }

        //StdOut.println("reverse graph");
        // Reverse graph
        Digraph reverseDigraph = digraph.reverse();
        int V = reverseDigraph.V();
        //StdOut.println("V: " + V);

        int[] distanceFromV = new int[V];
        int[] distanceFromW = new int[V];

        for (int vertex = 0; vertex < V; vertex++){
            distanceFromV[vertex] = Integer.MAX_VALUE;
            distanceFromW[vertex] = Integer.MAX_VALUE;
        }
        //StdOut.println("find begin");

        // Do a BFS from v to find all its ancestors and compute the distance from v to them
        bfs(reverseDigraph, v, distanceFromV);

        // 
        // Do a BFS from w to find all its ancestors and compute the distance from w to them
        bfs(reverseDigraph, w, distanceFromW);

        // Find the common ancestor with a shortest ancestral path
        int commonAncestorWithShortestPath = -1;
        int shortestDistance = Integer.MAX_VALUE;

        for (int vertex = 0; vertex < V;  vertex++){
            if (distanceFromV[vertex] != Integer.MAX_VALUE
                    && distanceFromW[vertex] != Integer.MAX_VALUE
                    && distanceFromV[vertex] + distanceFromW[vertex] < shortestDistance) {
                shortestDistance = distanceFromV[vertex] + distanceFromW[vertex];
                commonAncestorWithShortestPath = vertex;
                    }
        }
        //StdOut.println("find done");
        if (commonAncestorWithShortestPath == -1)
            return new AncestralPath(-1, null, null);

        // Do a BFS from v to the common ancestor to get the shortest path
        String shortestPathFromVToAncestor = bfsToGetPath(reverseDigraph, 
                v, commonAncestorWithShortestPath);
        // Do a BFS from w to the common ancestor to get the shortest path
        String shortestPathFromWToAncestor = bfsToGetPath(reverseDigraph, 
                w, commonAncestorWithShortestPath);
        return new AncestralPath(commonAncestorWithShortestPath, 
                shortestPathFromVToAncestor, shortestPathFromWToAncestor);
    }

    private void bfs(Digraph G, int source, int[] distances) {
        //StdOut.println("bfs");
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);
        distances[source] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.dequeue();

            for (int neighbor : G.adj(currentVertex)){
                distances[neighbor] = distances[currentVertex]+1;
                queue.enqueue(neighbor);
            }
        }
    }
    private String bfsToGetPath(Digraph G, int source, int target) {
        //StdOut.println("bfsToGetPath");
        int[] edgeTo = new int[G.V()];
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.dequeue();

            for (int neighbor : G.adj(currentVertex)) {
                edgeTo[neighbor] = currentVertex;
                queue.enqueue(neighbor);

                if (neighbor == target) {
                    Stack<Integer> inversePath = new Stack<>();

                    for (int v = target; v != source; v = edgeTo[v]){
                        inversePath.push(v);
                    }
                    inversePath.push(source);

                    StringBuilder path = new StringBuilder();

                    while (!inversePath.isEmpty()) {
                        int vertexInPath = inversePath.pop();

                        if (!inversePath.isEmpty()) {
                            int nextVertexInPath = inversePath.peek();
                            path.append(vertexInPath).append("->").append(nextVertexInPath);
                        }
                        if (inversePath.size() > 1) {
                            path.append(" ");
                        }
                    }
                    return path.toString();
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        int v = Integer.parseInt(args[1]);
        int w = Integer.parseInt(args[2]);

        StdOut.println(G);
        StdOut.println();
        ShortestAncestralPath shortpath = new ShortestAncestralPath();

        AncestralPath path = shortpath.getShortestAncestralPath(G, v, w);
        if (path.commonAncestor == -1)
            StdOut.println("common ancestor in G : No common ancestor found");
        else {
            StdOut.println("Common ancestor in G: " + path.GetCommonAncestor());
            StdOut.println("Path from " + v + " to ancestor: " + path.GetVToAncestor());
            StdOut.println("Path from " + w + " to ancestor: " + path.GetWToAncestor());
        }


    }
}
