import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_3_7 {

    public static class Quick{
        private static int count;
        private static int count0;
        private static int count1;
        private static int count2;
    
        public static int getCount0() {return count0;}
        public static int getCount1() {return count1;}
        public static int getCount2() {return count2;}

        public static int sort(Comparable[] a) {
            StdRandom.shuffle(a); // Eliminate dependence on input.
            count = 0;
            count0 = 0;
            count1 = 0;
            count2 = 0;
            sort(a, 0, a.length-1);
            return count;
        }
        private static void sort(Comparable[] a, int lo, int hi) {
            if ((hi - lo) == 0) count0++;
            if ((hi - lo) == 1) count1++;
            if ((hi - lo) == 2) count2++;
            if (hi <= lo) return;
            int j = partition(a, lo, hi); // Partition
            sort(a, lo, j-1);
            sort(a, j+1, hi);
        }
        private static int partition(Comparable[] a, int lo, int hi) {
            // Partition into a[lo..i-1], a[i], a[i+1..hi].
            int i = lo, j = hi+1;    //left and right scan indices
            Comparable v = a[lo];    // partitioning item
            while (true){
                // Scan right, scan left, check for scan complete, and exchange.
                count++;
                while (less(a[++i], v)) {
                    count++;
                    if (i == hi) break;
    
                }
                count++;
                while (less(v, a[--j])){
                    count++;
                    if (j == lo) break;
                } 
                count++;
                if (i >= j) break;
                exch(a, i, j);
            }
            exch(a, lo, j);     // Put v = a[j] into position
            return j;          // with a[lo..j-1]<=a[j]<=a[j+1..hi].
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
    public static void main(String[] args) {
        int trials = 10000;
        StdOut.printf("%8s %8s %8s %8s \n", "n", "cnt0", "cnt1", "cnt2");
        for (int n = 100; n <= 10000; n*=10){
            double count = 0.0;
            double count0 = 0.0;
            double count1 = 0.0;
            double count2 = 0.0;
            for (int t = 0; t < trials; t++) {
                Integer[] a = new Integer[n];
                for (int i=0; i < n; i++){
                    a[i] = (1+StdRandom.uniform(trials));
                }
                count += Quick.sort(a);
                count0 += Quick.getCount0();
                count1 += Quick.getCount1();
                count2 += Quick.getCount2();
            }
            StdOut.printf("%8d %8.1f %8.1f %8.1f \n", n, count0/trials, count1/trials, count2/trials );
        }
    }
}
