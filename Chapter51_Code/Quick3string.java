import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdRandom;
import java.util.StringJoiner;

public class Quick3string {
    private static int charAt(String s, int d){
        if (d < s.length()) return s.charAt(d);
        else                return -1;
    }
    public static void sort(String[] a){
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);
    }
    private static void sort(String[] a, int lo, int hi, int d){
        if (hi <= lo) return;
        //StdOut.println("sort: lo=" + lo + ", hi=" + hi);
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt)
        {
            //StdOut.println("i="+i+",gt="+gt);
            //StdOut.println("a[i]="+a[i]+",v="+v);
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else    i++;
        }
        /*StdOut.println("--------------------");
        for (int j = lo; j < hi; j++)
            StdOut.print(a[j] + " ");
        StdOut.println("\n--------------------");
        */
        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }

    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(int[][] a){
        // StdRandom.shuffle(a[]);
        sort(a, 0, a.length-1, 0);

    }

    private static void sort(int[][] a, int lo, int hi, int d){
        if (hi <= lo)
            return;
        int lt = lo, gt = hi;
        int v = valueAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt){
            int t = valueAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else  i++;
        }
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }
    private static int valueAt(int[] a, int index){
        if (index < a.length)
            return a[index];
        else
            return Integer.MIN_VALUE;
    }
    private static void exch(int[][] a, int i, int j){
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        // read in the strings from standard input
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // sort the strings
        sort(a);

        // print the results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);

        // sort int[][]
        int[] a1 = {10, 999, 1, 9, 5};
        int[] a2 = {10, 999, 2, 10, 5};
        int[] a3 = {1, 70, 2, 10, 5, 90};
        int[] a4 = {15};
        int[] a5 = {20, 10};
        int[] a6 = {20, 10, 1};
        int[] a7 = {20, 10, 0};
        int[] a8 = {20, 10, -10};

        int[][] aa = {a1, a2, a3, a4, a5, a6, a7, a8};

        sort(aa);

        StringJoiner sortedArrays = new StringJoiner("\n");

        for (int[] suba : aa){
            StringJoiner sortedArray = new StringJoiner(", ");
            for (int v : suba){
                sortedArray.add(String.valueOf(v));
            }
            sortedArrays.add(sortedArray.toString());
        }
        StdOut.println("Sorted: ");
        StdOut.println(sortedArrays);

        
    }
}
