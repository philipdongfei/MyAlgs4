import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;


public class StrongComponent {
    private boolean[] marked;
    public Queue<SET<Integer>> getAllStrongComponents(Digraph digraph) {
        Queue<SET<Integer>> strongComponents = new Queue<SET<Integer>>();
        marked = new boolean[digraph.V()];

        // for every vertex that is not yet in a strong component, compute its strong component
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]){
                SET<Integer> strongComponent = getStrongComponent(digraph,
                        v);
                strongComponents.enqueue(strongComponent);
            }
        }
        return strongComponents;

    }
    private SET<Integer> getStrongComponent(Digraph digraph, int source) {
        SET<Integer> strongComponent = new SET<>();
        strongComponent.add(source);

        // Find vertices reachable from the source vertex
        SET<Integer> verticesReachableFromSource = new SET<>();
        dfsFromSource(digraph, verticesReachableFromSource, source);

        SET<Integer> verticesThatCannotReachSource = new SET<>();

        // Find vertices that can reach the source vertex
        for (int vertexReachableFromSource : verticesReachableFromSource) {
            if (vertexReachableFromSource == source)
                continue;
            SET<Integer> visited = new SET<Integer>();
            boolean canReachStrongComponent = dfsToReachStrongComponent(digraph, visited, vertexReachableFromSource,
                    strongComponent, verticesThatCannotReachSource);

            // vertices in the intersection of the two sets are in the strong component
            if (canReachStrongComponent)
                strongComponent.add(vertexReachableFromSource);
            else
            {
                for (int s : visited)
                    verticesThatCannotReachSource.add(s);
            }
        }
        return strongComponent;
    }
    private void dfsFromSource(Digraph digraph, SET<Integer> verticesReached, int vertex) {
        verticesReached.add(vertex);
        marked[vertex] = true;
        for (int neighbor : digraph.adj(vertex)){
            if (!marked[neighbor])
                dfsFromSource(digraph, verticesReached, neighbor);
        }
    }

    private boolean dfsToReachStrongComponent(Digraph digraph, SET<Integer> visited, int vertex, SET<Integer> currentStrongComponent, SET<Integer> verticesThatCannotReachSource) {
        if (marked[vertex])
            return true;

        visited.add(vertex);

        for (int neighbor : digraph.adj(vertex)) {
            if (!visited.contains(neighbor)
                    && !marked[neighbor]
                    && !verticesThatCannotReachSource.contains(neighbor)) {
                boolean reachable = dfsToReachStrongComponent(digraph, visited, neighbor, currentStrongComponent,  verticesThatCannotReachSource);
                if (reachable)
                    return true;
                    }

        }
        return false;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        int v = Integer.parseInt(args[1]);

        StrongComponent SC = new StrongComponent();
        Queue<SET<Integer>> queue = SC.getAllStrongComponents(G);
        StdOut.println("Strong Components: ");
        while (!queue.isEmpty()) {
            for (int vertex : queue.dequeue())
                StdOut.print(vertex + " ");
            StdOut.println();
        }
        StdOut.println();


    }

}
