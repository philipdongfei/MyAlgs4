import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_1_16_selection{

public static class Selection{
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        StdOut.printf(" i ");
        show(a);
        int N = a.length;    // array length
        for (int i = 0; i < N; i++)
        {   // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
            StdOut.printf("%2d ", i);
            show(a);
        }
    }
    public static boolean check(Comparable[] init, Comparable[] a){
        int i = 0;
        Comparable[] b = new Comparable[init.length];
        for (i = 0; i < init.length; i++)
            b[i] = init[i];
        Arrays.sort(b);
        if (init.length != a.length)
            return false;
        for(i = 0; i < init.length; i++) 
        {
            StdOut.println(b[i]+" "+a[i]);
            if (b[i].compareTo(a[i]) != 0) 
                return false;
        }
        return true;
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
    /*
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
    public static void ShowTrace(String[] a) {
        sort(a);
        assert isSorted(a);
        show(a);

    }
    */
}
public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    String[] init = new String[a.length];
    for (int i = 0; i < a.length; i++)
        init[i] = a[i];

    //Selection select_sort = new Selection();    
    Selection.sort(a);
    StdOut.println("Check sort: "+Selection.check(init, a));

}

}
