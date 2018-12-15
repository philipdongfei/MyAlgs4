import java.util.*;
import edu.princeton.cs.algs4.*;

public class Ex_1_1_35
{
    private static int SIDES = 6;

    private static double[] getExact()
    {
        double[] dist = new double[2*SIDES+1];

        for(int i=1; i<=SIDES; i++)
            for(int j=1; j<=SIDES; j++)
                dist[i+j] += 1.0;

        for (int k=2; k<=2*SIDES; k++)
            dist[k] /= SIDES*SIDES;

        return dist;
    }

    public static double[] getExerim(int n)
    {
        double[] dist = new double[2*SIDES+1];

        for (int i=0; i<n; i++)
            dist[throwDice()]++;

        for(int k=2; k<=2*SIDES; k++)
            dist[k]/=n;

        return dist;
    }

    public static int throwDice()
    {
        return StdRandom.uniform(1, SIDES+1) + StdRandom.uniform(1, SIDES+1);
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);

        double[] exact = getExact();

        for (int i=2; i<=2*SIDES; i++)
            StdOut.printf("%7d",i);
        StdOut.println();

        for (int i=2; i<=2*SIDES; i++)
            StdOut.printf("%7.3f", exact[i]);
        StdOut.println();

        double[] experim = getExerim(n);

        for (int i=2; i<=2*SIDES; i++)
            StdOut.printf("%7.3f", experim[i]);
        StdOut.println();

        // Empirical results match exact ones to 3 decimal places when
        // n >= 10,000,000 (< 1 sec.)
    }
}
