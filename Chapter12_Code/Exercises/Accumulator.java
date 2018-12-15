import edu.princeton.cs.algs4.*;
import java.util.*;

public class Accumulator
{
    private double m;
    private double s;
    private int N;
    public void addDataValue(double x)
    {
        N++;
        s = s + 1.0*(N-1)/N*(x-m)*(x-m);
        m = m+(x-m)/N;
    }
    public double mean()
    { return m; }
    public double var()
    { return s/(N-1); }
    public double stddev()
    { return Math.sqrt(this.var()); }

    public String toString()
    {
        return "Mean ("+N+"values):"+String.format("%7.5f",mean())+"\n"
            +"Variance: "+var()+"\n"+"Standard Deviation:"+stddev();

    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);

    }
}
