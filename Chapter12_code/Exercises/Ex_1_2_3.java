import edu.princeton.cs.algs4.*;
import java.util.*;


public class Ex_1_2_3
{

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);

        double min = Math.min(a,b);
        double max = Math.max(a,b);
        Interval1D xinterval = new Interval1D(min, max);
        Interval1D yinterval = new Interval1D(min, max);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.006);

        for(int t = 0; t < N; )
        {
            a = StdRandom.random();
            b = StdRandom.random();

            double xlo = Math.min(a,b);
            double xhi = Math.max(a,b);
            a = StdRandom.random();
            b = StdRandom.random();
            double ylo = Math.min(a,b);
            double yhi = Math.max(a,b);
            Point2D plo = new Point2D(xlo, ylo);
            Point2D phi = new Point2D(xhi, yhi);


            if (box.contains(plo) && box.contains(phi))
            {
                Interval1D xinter = new Interval1D(xlo, xhi);
                Interval1D yinter = new Interval1D(ylo, yhi);
                Interval2D subbox = new Interval2D(xinter, yinter);
                subbox.draw();
                ++t;
            }
        }
    }
}
