import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class QuickMedian3{
    private static final int CUTOFF = 3;
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sortm(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        //int j = partition(a, lo, hi); // Partition
        // a[lo] < a[lo+1] < a[hi]
        int n = hi-lo+1;
        /*
        if (n <= 1)
            return;
        else if (n == 2){
            if (less(a[hi], a[lo]))
                exch(a, lo, hi);
        } else if (n == 3)
        {
           //sort3(a, lo, hi);
            if (less(a[lo+1], a[lo])) exch(a, lo, lo+1);
            if (less(a[hi], a[lo])) exch(a, lo, hi);
            if (less(a[hi], a[lo+1])) exch(a, lo+1, hi);
           return;
        }
        */
        if (n <= CUTOFF){
            sortm(a, lo, hi);
            return;
        }
        /*
        if (less(a[lo+1], a[lo]))
            exch(a, lo, lo+1);
        if (less(a[hi] , a[lo+1])){
            if (less(a[lo], a[hi]))
                exch(a, lo+1, hi);
            else if (less(a[hi] , a[lo]))
                exch(a, lo, hi);
        }
        */
        if (less(a[lo+1], a[lo])) exch(a, lo, lo+1);
        if (less(a[hi], a[lo])) exch(a, lo, hi);
        if (less(a[hi], a[lo+1])) exch(a, lo+1, hi);
        //sort3(a, lo, hi);
        //show(a);
        int[] j = partition3(a, lo, hi);
        
        sort(a, lo, j[0]-1);
        sort(a, j[0]+1, j[1]-1);
        sort(a, j[1]+1, j[2]-1);
        sort(a, j[2]+1, hi);
    }
    private static void sort3(Comparable[] a, int lo, int hi) {
        if (less(a[lo+1], a[lo])) exch(a, lo, lo+1);
        if (less(a[hi], a[lo])) exch(a, lo, hi);
        if (less(a[hi], a[lo+1])) exch(a, lo+1, hi);

    }
    private static void sortm(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int n = hi - lo + 1;
        int m = median3(a, lo, lo+n/2, hi);
        exch(a, m, lo);
        int j = partition(a, lo, hi);
        sortm(a, lo, j-1);
        sortm(a, j+1, hi);
    }
    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i):
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }
    private static int[] partition3(Comparable[] array, int lo, int hi){
        int[] subarrays = new int[4];
        int a = lo+2, b = lo+2, 
            c = hi-1, d = hi-1;
        Comparable p = array[lo], q = array[lo+1], r = array[hi];
        while (b <= c) {
            //while (array[b] < q && b <= c) {
            while (less(array[b] , q) && b <= c) {
                //if (array[b] < p){
                if (less(array[b] , p)){
                    exch(array, a, b);
                    a++;
                }
                b++;
            }
            //while (array[c] > q && b <= c) {
            while (less(q, array[c]) && b <= c) {
                //if (array[c] > r){
                if (less(r,array[c])){
                    exch(array, c, d);
                    d--;
                }
                c--;
            }
            if (b <= c){
                //if (array[b] > r){
                  if (less(r, array[b])){
                    if (less(array[c], p)){
                        exch(array, b, a);
                        exch(array, a, c);
                        a++;
                    }else {
                        exch(array, b, c);
                    }
                    exch(array, c, d);
                    b++;
                    c--;
                    d--;
                }else {
                    if (less(array[c], p)) {
                        exch(array, b, a);
                        exch(array, a, c);
                        a++;
                    }else {
                        exch(array, b, c);
                    }
                    b++;
                    c--;
                }//if
            }//if
        }//while
        a--;b--;c++;d++;
        exch(array, lo+1, a);
        exch(array, a, b);
        a--;
        exch(array, lo, a);
        exch(array, hi, d);

        subarrays[0] = a;
        subarrays[1] = b;
        subarrays[2] = c;
        subarrays[3] = d;
        
        /*
        for (int i : subarrays)
            StdOut.print(i+" ");
        StdOut.println();
        */
        //show(array);
        
        return subarrays;
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1;    //left and right scan indices
        Comparable v = a[lo];    // partitioning item
        while (true){
            // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);     // Put v = a[j] into position
        return j;          // with a[lo..j-1]<=a[j]<=a[j+1..hi].
    }
    private static void insertionSort(Comparable[] a, int lo, int hi){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
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
            StdOut.print((a[i]) + " ");
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
