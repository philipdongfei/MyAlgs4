import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_1
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double xlo = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);

        Interval1D xinterval = new Interval1D(xlo, xlo+.5);
        Interval1D yinterval = new Interval1D(ylo, ylo+.5);
        Interval2D square = new Interval2D(xinterval, yinterval);
        square.draw();

        Point2D[] points = new Point2D[N];
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.006);
        
        int t = 0;
        int n = N;
        while(N > 0)
        {
            double x = StdRandom.random();
            double y = StdRandom.random();
            points[t] = new Point2D(x,y);
            if (square.contains(points[t]))
            {
                StdOut.println(points[t]);
                --N;
                StdOut.printf("N=%d\n", N);
                points[t].draw();
                ++t;

            }
        }

        double min = 10;
        for (int i=0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                double dx = points[i].x() - points[j].x();
                double dy = points[i].y() - points[j].y();
                double dis = Math.sqrt(dx*dx+dy*dy);
                if (dis < min)
                    min = dis;

            }
        }
        
        //StdOut.println("mindis="+min);
        StdOut.printf("mindis = %.10f\n", min);


    }
}
