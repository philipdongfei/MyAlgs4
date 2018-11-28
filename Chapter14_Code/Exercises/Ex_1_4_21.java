import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_21{
    private int[] a;
    private int[] b;
    public Ex_1_4_21(int[] keys) {
        a = new int[keys.length];
        for (int i= 0; i < keys.length; i++)
            a[i] = keys[i];
        Arrays.sort(a);
        b = new int[keys.length];
        b[0] = a[0];
        int j = 1;
        for (int i = 1; i < a.length; i++)
            if (a[i] != b[j-1]) b[j++] = a[i];
    }
    public boolean contains(int key)
    {
        return myrank(key) != -1;
    }
    private int myrank(int key) {
        int lo = 0;
        int hi = b.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (key < b[mid]) hi = mid - 1;
            else if (key > b[mid]) lo = mid + 1;
            else    return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] w = in.readAllInts();
        Ex_1_4_21 set = new Ex_1_4_21(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (set.contains(key) == false)
                StdOut.println(key);
        }

    }
}
