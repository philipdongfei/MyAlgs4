/**************
 * jobsPC.txt in algs4-data is wrong.
 * jobsPC.txt in book is right.
 * %more jobsPC.txt
 * 10
 * 41.0 1 7 9
 * 51.0 2
 * 50.0
 * 36.0
 * 38.0
 * 45.0
 * 21.0 3 8
 * 32.0 3 8
 * 32.0 2
 * 29.0 4 6
 ****/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class CPM
{
    public static void main(String[] args)
    {
        int N = StdIn.readInt(); StdIn.readLine();
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(2*N+2);
        int s = 2*N, t = 2*N+1;
        for (int i = 0; i < N; i++)
        {
            String[] a = StdIn.readLine().split("\\s+");
            //StdOut.print(a[0] + " ");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i+N, duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i+N, t, 0.0));
            for(int j = 1; j < a.length; j++)
            {
            //    StdOut.print(a[j] + " ");
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i+N, successor, 0.0));
            }
            //StdOut.println();
        }
        AcyclicLP lp = new AcyclicLP(G, s);
        StdOut.println("Start times: ");
        for (int i = 0; i < N; i++)
            StdOut.printf("%4d: %5.1f\n", i, lp.distTo(i));
        StdOut.printf("Finish time: %5.1f\n", lp.distTo(t));
    }

}
