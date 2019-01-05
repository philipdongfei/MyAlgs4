import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class FasterMerge{
    private static int access;
    private static Comparable[] aux;   // auxiliary array for merges

    public static int getAccess() {
        return access;
    }
    public static void sort(Comparable[] a) {
        access = 0;
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    
    private static void sort (Comparable[] a, int lo, int hi)
    {// Sort a[lo...hi]
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);   //Sort left half
        sort(a, mid+1, hi);  // Sort right half
        merge(a, lo, mid, hi);   // Merge results 
//        show(a);

    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        // fast merge 
        for (int i = lo; i <= mid; i++)
            aux[i] = a[i];
        for (int j = mid+1; j <= hi; j++)
            aux[j] = a[hi-j+mid+1];

        int i = lo, j = hi;
        for (int k = lo; k <= hi; k++)
            if (less(aux[j], aux[i])) a[k] = aux[j--];
            else                      a[k] = aux[i++];
        
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
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
