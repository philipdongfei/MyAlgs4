import java.util.Arrays;
import java.lang.Math;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_4_11 
{
    private int[] a;
    private int[] rate = new int[25];
    private int[] failrate = new int[25];

    public Ex_1_4_11(int[] keys)
    {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
        for (int j = 0; j < 25; j++)
        {
            rate[j] = 0;
            failrate[j] = 0;
        }

    }
    public int getRate(int index) {
        return rate[index];
    }
    public int getfailRate(int index) {
        return failrate[index];
    }
    public int howMany(int key) {

        Stopwatch timer = new Stopwatch();
        int lo = 0, count = 0;
        int hi = a.length -1;

        while (lo <= hi)
        {
            int mid = lo+(hi-lo)/2;
            if (key < a[mid]) hi = mid -1;
            else if (key > a[mid]) lo = mid + 1;
            else   {
                /*
                //StdOut.println("find key: "+count);
                if (count <= 24)
                    rate[count]++;
                    */
                return mid; 
            } 
            count++;
        }
        /*
        //StdOut.println("key not find: "+count);
        StdOut.println("N="+count+" time: "+timer.elapsedTime());
        
        if (count <= 24)
            failrate[count]++;
         */   
        return -1;
    } 
    public boolean contains(int key)
    { return rank(key) != -1;  }

    private int rank(int key)
    {// Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            // Key is in a[lo..hi] or not present.
            int mid = lo+(hi-lo)/2;
            if (key < a[mid]) hi = mid-1;
            else if (key > a[mid]) lo = mid + 1;
            else    return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int N = 250, nCount = 0;
        double prev = 0;
        In in = new In(args[0]);
        int[] w = in.readAllInts();
        Ex_1_4_11 set = new Ex_1_4_11(w);
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            nCount++;
            /*
            if (!set.contains(key))
                StdOut.println(key);
            */
            int result = set.howMany(key);
            if (nCount == N/2)
                prev = timer.elapsedTime();
            if (nCount == 2*N)
            {
                double time = timer.elapsedTime();
                StdOut.printf("%6d %7.1f ", nCount, time);
                if (prev > 0)
                    StdOut.printf("%5.1f\n", time/prev);
                prev = time;
                N *= 2;
            }
        }
        StdOut.println("w length: "+w.length);
        StdOut.println("lg(w.length): "+Math.log(w.length));
        /*
        for (int i = 1; i < 25; i++)
        {
            StdOut.println("rate["+i+"]="+set.getRate(i));
        }
        for (int j = 1; j < 25; j++)
        {
            StdOut.println("failrate["+j+"]="+set.getfailRate(j));
        }
        */
    }
}


