import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_2_21{
    public static class Merge{
        // This class should not be instantiated.
        private Merge() {}

        // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo .. hi]
        private static void merge(Comparable[] a, Comparable[] aux, 
                int lo, int mid, int hi) {
            // precondition: a[lo..mid] and a[mid+1..hi] are sorted subarrays.
            assert isSorted(a, lo, mid);
            assert isSorted(a, mid+1, hi);

            // copy to aux[].
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            // merge back to a[]
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if  (i > mid)   a[k] = aux[j++];
                else if (j > hi)    a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else    a[k] = aux[i++];
            }

            // postcondition: a[lo .. hi] is sorted
            assert isSorted(a, lo, hi);
        }
        // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
        private static void sort(Comparable[] a, Comparable[] aux,
                int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid+1, hi);
            merge(a, aux, lo, mid, hi);
        }

        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];
            sort(a, aux, 0, a.length-1);
            assert isSorted(a);
        }
        /*
         * Helper sorting function.
         */
        // is v < w?
        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        /* 
         * Check if array is sorted - useful for debugging.
         */
        private static boolean isSorted(Comparable[] a) {
            return isSorted(a, 0, a.length-1);
        }
        private static boolean isSorted(Comparable[] a, int lo, int hi) {
            for (int i = lo+1; i <= hi; i++)
                if (less(a[i], a[i-1])) return false;
            return true;
        }
        // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi].
        private static void merge(Comparable[] a, int[] index, int[] aux,
                int lo, int mid, int hi) {
            // copy to aux[]
            for (int k = lo; k <= hi; k++) {
                aux[k] = index[k];
            }
            // merge back to a[].
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid)   index[k] = aux[j++];
                else if (j > hi)   index[k] = aux[i++];
                else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
                else    index[k] = aux[i++];
            }
        }
        public static int[] indexSort(Comparable[] a) {
            int n = a.length;
            int[] index = new int[n];
            for (int i = 0; i < n; i++)
                index[i] = i;
            int[] aux = new int[n];
            sort(a, index, aux, 0, n-1);
            return index;
        }
        //mergesort a[lo..hi] using auxiliary array aux[lo..hi]
        private static void sort(Comparable[] a, int[] index, int[] aux, 
                int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo)/2;
            sort (a, index, aux, lo, mid);
            sort(a, index, aux, mid+1, hi);
            merge(a, index, aux, lo, mid, hi);
        }
        // print array to standard output.
        private static void show(Comparable[] a) {
            for (int i = 0; i < a.length; i++)
                StdOut.println(a[i]);
        }

        public static void main(String[] args) {
            String[] a = StdIn.readAllStrings();
            int[] indexSort = Merge.indexSort(a);
            for (int i : indexSort)
                StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }
    public static void main(String[] args) {

        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        int[] indexSort0 = Merge.indexSort(a);
        In in1 = new In(args[1]);
        String[] b = in1.readAllStrings();
        int[] indexSort1 = Merge.indexSort(b);
        In in2 = new In(args[2]);
        String[] c = in2.readAllStrings();
        int[] indexSort2 = Merge.indexSort(c);

        boolean bflag = false;
        int ia = 0, ib = 0, ic = 0;
        while (ia < a.length && ib < b.length) {
            if (a[indexSort0[ia]].compareTo(b[indexSort1[ib]]) > 0)
                ib++;
            else if (a[indexSort0[ia]].compareTo(b[indexSort1[ib]]) < 0)
                ia++;
            else {
                while (ic < c.length && c[indexSort2[ic]].compareTo(a[indexSort0[ia]]) < 0) ic++;
                if (ic != c.length){
                    if (c[indexSort2[ic]].compareTo(a[indexSort0[ia]]) == 0)
                    {bflag = true; break;}
                

                } 
                ia++;
            }
            if (bflag == true)
                break;
            ic = 0;
        }
        //StdOut.println(ic);
        //StdOut.println(indexSort2[ic]);
        StdOut.println(c[indexSort2[ic]]);
    }
}
