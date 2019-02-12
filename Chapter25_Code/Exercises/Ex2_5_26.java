import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;

public class Ex2_5_26{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x,y);
            points[i].draw();
        }

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);
        Arrays.sort(points);

        Point2D p = new Point2D(points[0].x(), points[0].y());
        Point2D[] polarPoints = new Point2D[n-1];
        for (int i = 1; i < n; i++)
            polarPoints[i-1] = points[i];
        Arrays.sort(polarPoints, p.polarOrder());

        p.drawTo(polarPoints[0]);
        StdDraw.show();
        StdDraw.pause(100);
        for (int i = 0; i < (n-2); i++) {
            polarPoints[i].drawTo(polarPoints[i+1]);
            StdDraw.show();
            StdDraw.pause(100);
        }
        polarPoints[n-2].drawTo(p);
        StdDraw.show();
        StdDraw.pause(100);
    }

} 
