import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BinaryInsertion {

    // This class should not be instantiated.
    private BinaryInsertion() {}
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted.
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // binary search to determine index j at which to insert a[i]
            Comparable v = a[i];
            int lo = 0, hi = i;
            while (lo < hi){
                int mid = lo + (hi - lo) / 2;
                if (less(v, a[mid])) hi = mid;
                else                 lo = mid + 1;
            }
            // insetion sort with "half exchanges"
            // insert a[i] at index j and shift a[j], ...,a[i-1] to right)
            for (int j = i; j > lo; --j)
                a[j] = a[j-1];
            a[lo] = v;
        }
        assert isSorted(a, 0, n-1);
    }
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++){
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();
        BinaryInsertion.sort(a);
        show(a);
    }

}
