import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Font;

public class TraceShell{
    private static int line = 0;
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1,4,13,40,121,364,1093
        while (h >= 1)
        {  // h-sort the array.
            for (int i = h; i < N; i++){
                // Insert a[i] among a[i-h],a[i-2*h],a[i-3*h]....
                int j = 0;
                for (j = i; j >= h && less(a[j],a[j-h]); j -= h)
                    exch(a,j,j-h);
                draw(a, h, i, j);
                line++;
            }
            h = h/3;
            footer(a);
            line++;
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
    private static void draw(Comparable[] a, int h, int ith, int jth){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-3.75, line, h + "");
        StdDraw.text(-2.50, line, ith+"");
        StdDraw.text(-1.25, line, jth+"");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)    StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i > ith)   StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i < jth) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if ((i % h) == (jth % h)) 
                StdDraw.setPenColor(StdDraw.BLACK);
            else    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.text(i, line, (String)a[i]);
        }
    }
    private static void header(Comparable[] a) {
        int n = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n/2.0, -3, "a[ ]");
        for (int i = 0; i < n; i++)
            StdDraw.text(i, -2, i+"");
        StdDraw.text(-3.75, -2, "h");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-4, -1.65, n-0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, -1, (String)a[i]);

    }
    private static void footer(Comparable[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i, line, (String)a[i]);
    }
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        int rows = 0;
        int h = 1;
        while (h < n/3) {
            rows += (n-h+1);
            h = 3*h + 1;
        }
        rows += (n - h + 1);

        StdDraw.setCanvasSize(30*(n+3), 30*(rows+3));
        StdDraw.setXscale(-4, n+1);
        StdDraw.setYscale(rows, -4);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));
        header(a);
        sort(a);
    }
}
