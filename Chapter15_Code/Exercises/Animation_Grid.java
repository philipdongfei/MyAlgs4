import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;
import java.lang.Math;


public class Animation_Grid {

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        RandomGrid grid = new RandomGrid();
        RandomGrid.Connection[] cons = grid.generate(N);
        StdOut.println("cons size: "+cons.length);
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N);
        StdDraw.setPenColor(200,0,0);
        //StdDraw.setPenRadius(0.5);
        
        UF uf = new UF(N*N);
        int i = 1;
        for (RandomGrid.Connection con : cons){
            int p = con.p;
            int q = con.q;
            StdOut.println(i+":"+p + " " + q);
            p--;
            q--;
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            int x1 = (p)/N;
            int y1 = (p)%N;
            int x2 = (q)/N;
            int y2 = (q)%N;
            StdOut.println(x1+","+y1+"->"+x2+","+y2);
            StdDraw.point(x2,y2);
            StdDraw.point(x1,y1);
            StdDraw.line(x1,y1,x2,y2);
            i++;
        }
        StdOut.println(uf.count() + " components");
        
    }
}
