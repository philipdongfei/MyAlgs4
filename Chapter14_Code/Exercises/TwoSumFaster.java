import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumFaster{
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;

        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++)
            h.put(a[i], i);
        int cnt = 0;
        for (int i = 0; i < N; i++)
        {
            if (h.get(-a[i]) != null && h.get(-a[i]) > i)
                cnt++;
        }
        return cnt;
    }


    public static void main(String[] args){
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
