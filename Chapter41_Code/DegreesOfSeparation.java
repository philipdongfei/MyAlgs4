import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Calendar;


public class DegreesOfSeparation
{
    public static void main(String[] args)
    {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        int yearOld = Integer.parseInt(args[3]);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        StdOut.println("currentYear: " + currentYear);

        if (!sg.contains(source))
        { StdOut.println(source + " not in database."); return; }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (!StdIn.isEmpty())
        {
            String sink = StdIn.readLine();
            int movieYear = Integer.parseInt(sink.substring(sink.length()-5, sink.length()-1));

            StdOut.println("movieYear: " + movieYear);
            if (currentYear - movieYear > yearOld){
                StdOut.println("Ignoring old movie");
                continue;
            }
            if (sg.contains(sink))
            {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v : bfs.pathTo(t))
                        StdOut.println("   " + sg.name(v));
                else StdOut.println("Not connected");
            }
            else StdOut.println("Not in database.");
        }
    }
}
