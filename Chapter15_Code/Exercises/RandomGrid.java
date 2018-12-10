import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import java.util.Arrays;
import java.lang.Math;

public class RandomGrid{
    public class Connection{
        private int p;
        private int q;
        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
        public Connection[] generate(int n){

        }
    }


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RandomGrid grid = new RandomGrid();
        Connection[] cons = grid.generate(N);
        for (Connect con : cons)
            StdOut.println(con.p + " " + con.q);
    }
}
