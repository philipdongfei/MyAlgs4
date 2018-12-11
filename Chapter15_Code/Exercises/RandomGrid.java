import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import java.util.Arrays;
import java.lang.Math;

public class RandomGrid{
    public static class Connection{
        int p;
        int q;
        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    public static Connection[] generate(int n){
        RandomBag<Connection> b = new RandomBag<Connection>();
        int m = n * n;
        for (int i = 1; i <= m ; i++) {
            // try to connect to right neighbor
            if (i % n > 0){
                int orient = StdRandom.uniform(2);
                if (orient == 0) b.add(new Connection(i, i+1));
                else             b.add(new Connection(i+1, i));
            }
            // try to connect bottom neighbor
            if (m - i >= n) {
                int orient = StdRandom.uniform(2);
                if (orient == 0) b.add(new Connection(i, i+n));
                else             b.add(new Connection(i+n, i));
            }
        }

        Connection[] cons = new Connection[b.size()];
        int i = 0;
        for (Connection con : b){
            cons[i++] = con;
        }
        return cons;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RandomGrid grid = new RandomGrid();
        Connection[] cons = generate(N);
        StdOut.println("cons size: "+cons.length);
        int i = 1;
        for (Connection con : cons){
            StdOut.println(i + ": "+ con.p + " " + con.q);
            i++;
        }
        
    }
}
