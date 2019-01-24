import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class PerfectPower implements Comparable<PerfectPower> {
    private final long value;
    private final int a;
    private final int b;

    public PerfectPower(int a, int b) {
        this.value = power(a, b);
        this.a = a;
        this.b = b;
    }

    // brute force exponentation suffices.
    public static long power(int a, int b) {
        long pow = 1;
        for (int i = 0; i < b; i++)
            pow *= a;
        return pow;
    }
    public int compareTo(PerfectPower that) {
        if (this.value < that.value) return -1;
        else if (this.value > that.value) return +1;
        else        return 0;
    }
    public String toString() {
        return value+" = "+a+"^"+b;
    }

    public static void main(String[] args) {
        int x = 2;
        if (args.length == 1) x = Integer.parseInt(args[0]);

        int n = 62;
        // initialize priority queue
        MinPQ<PerfectPower> pq = new MinPQ<PerfectPower>(n);

        // maximum power representable as a long is 2^26
        for (int b = x; b <= n; b++)
            pq.insert(new PerfectPower(2, b));
        // find smallest power, print out, and update
        while (!pq.isEmpty()){
            PerfectPower p = pq.delMin();
            StdOut.println(p);

            // add next perfect power if it doesn't overflow a long.
            if (Math.pow(p.a+1, p.b) < Long.MAX_VALUE)
                pq.insert(new PerfectPower(p.a+1, p.b));
        }
    }
}
