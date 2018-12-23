import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Font;

public class TraceInsertion{
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++)
        { // Insert a[i] among a[i-1], a[i-2],a[i-3].....
            int j;
            for (j = i; j > 0 && less(a[j],a[j-1]); j--)
                exch(a, j, j-1);
            draw(a, i, i, j);
        }
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private static void show(Comparable[] a) {
        // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static void draw(Comparable[] a, int row, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, jth + "");
        for (int i = 0; i < a.length; i++) 
        {
            if (i == jth)   StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i > ith) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i < jth) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else    StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(i, row, (String)a[i]);
        }
    }
    private static void header(Comparable[] a) {
        int n = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n/2.0, -3, "a[  ]");
        for (int i = 0; i < n; i++)
            StdDraw.text(i,-2,i+"");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3,-1.65,n-0.5,-1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i,-1,(String)a[i]);
    }
    private static void footer(Comparable[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i, n, (String)a[i]);
    }
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        // set canvas size.
        StdDraw.setCanvasSize(30*(n+3), 30*(n+3));
        StdDraw.setXscale(-3, n+1);
        StdDraw.setYscale(n+1, -3);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));
        header(a);
        sort(a);
        footer(a);
    }
}
