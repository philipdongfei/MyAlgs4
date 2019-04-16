import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.SymbolGraph;
//import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.DepthFirstPaths;


public class DegreesOfSeparationDFS {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        if (!sg.contains(source)){
            StdOut.println(source + " not in database.");
            return;
        }
        int s = sg.index(source);
        DepthFirstPaths_NonRecur bfs = new DepthFirstPaths_NonRecur(G, s);

        StdOut.println("Query: ");
        while (!StdIn.isEmpty()){
            String sink = StdIn.readLine();
            if (sg.contains(sink)){
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)){
                        StdOut.println("  " + sg.name(v));
                    }
                }
                else{
                    StdOut.println("Not connected");
                }
            }
            else {
                StdOut.println("  Not in database.");
            }
        }
    }
}
