import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex4_1_21 {
    public static void main(String[] args)
    {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source))
        { return; }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty())
        {
            String nominee = StdIn.readLine();
            if (sg.contains(nominee))
            {
                int t = sg.index(nominee);
                int Number = bfs.distTo(t)/2;
                StdOut.println("Number: " + Number);
            }
        }

    }
}
