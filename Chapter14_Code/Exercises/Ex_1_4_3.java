import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;



public class Ex_1_4_3 //DoublingTest
{
    private static double prex = 0, prey = 0;
    public static double timeTrial(int N)
    {  // Timer ThreeSum.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];
        double tm;
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        tm = timer.elapsedTime();
        if (N >= 1000 && N <= 8000){
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(prex, prey, (double)N/1000, tm);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(prex*Math.log(prex), prey*Math.log(prey),
                    ((double)N/1000)*Math.log((double)N/1000),
                    tm*Math.log(tm));

            prex = (double)N/1000;
            prey = tm;
        }


        return tm;
        
    }
    public static void main(String[] args)
    {// Print table of runnint times.
        int X = 8, Y = 25;
        StdDraw.setXscale(0, X);
        StdDraw.setYscale(0, Y);
        StdDraw.setPenRadius(.01);
        for (int N = 250; true; N += N)
        { // Print time for problem size N.
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
