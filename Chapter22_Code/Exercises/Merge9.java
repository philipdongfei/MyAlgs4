import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Merge9{
    private static int access;
    //private static Comparable[] aux;   // auxiliary array for merges

    public static int getAccess() {
        return access;
    }
    public static void sort(Comparable[] a) {
        access = 0;
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    private static void sort (Comparable[] a, Comparable[] aux, int lo, int hi)
    {// Sort a[lo...hi]
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);   //Sort left half
        sort(a, aux, mid+1, hi);  // Sort right half
        merge(a, aux, lo, mid, hi);   // Merge results 
//        show(a);

    }
    public static void merge(Comparable[] a, Comparable[] aux,  int lo, int mid, int hi){
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)  //Copy a[lo..hi] to aux[lo..hi]
        {
            access += 2;
            aux[k] = a[k];

        } 
        for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
        {
            if (i > mid)  {
                access += 2;
                a[k] = aux[j++];

            }   
            else if (j > hi)           {
                access += 2;
                a[k] = aux[i++];

            } 
            else if (less(aux[j], aux[i])) {
                access += 2;
                a[k] = aux[j++];
                access += 2;

            }
            else {
                access += 2;
                a[k] = aux[i++];

            }                   
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
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
