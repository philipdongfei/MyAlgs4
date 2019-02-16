import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_1_17b {

public static class Insertion{
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
//        StdOut.print(" i ");
//        show(a);
        int N = a.length;
        boolean[] touched = new boolean[N];
        for (int i = 1; i < N; i++)
        { // Insert a[i] among a[i-1], a[i-2],a[i-3].....
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--)
            {
                exch(a, j, j-1);
                touched[j] = true;
                touched[j-1] = true;
            }
            
            StdOut.printf("%02d ", i);
            showdraw(a, i, touched, 0);
 //           show(a);
        }
        StdOut.println();
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
    public static void showdraw(Comparable[] a, int current, boolean[] touched, int xindex) {
        double dx = 1.0/a.length;
        double x = 0;
        StdDraw.clear();
        StdDraw.setPenColor(0,0,0);
        for (int i = 0; i < a.length; i++) {
            if (i == current)
                StdDraw.setPenColor(224,0,0);
            else if (!touched[i])
                StdDraw.setPenColor(192,192,192);
            else
                StdDraw.setPenColor(0,0,0);
            StdDraw.filledRectangle(x + dx/2, (Double)a[i]/2,dx/4, (Double)a[i]/2);
            x += dx;
        }
        StdDraw.show();
        StdDraw.pause(100);
    }
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
    public static void main(String[] args) {
        // setup draw
        int width = 800;
        int heigh = 600;
        StdDraw.setCanvasSize(width, heigh);
        StdDraw.setScale();
        StdDraw.enableDoubleBuffering();

        //Array 
        int n = 80;
        Double[] a = new Double[n];

        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.0, 1.0);
        Insertion.sort(a);

     }

}
