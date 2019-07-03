import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;


public class MSD {
    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;
    private static final int CUTOFF = 15;
    
    private static int R = 256; // radix
    private static final int M = 10; // cutoff for small subarrays
    private static String[] aux; // auxiliary array for distribution

    private MSD(){}

    private static int charAt(String s, int d){
        if (d < s.length()) 
            return s.charAt(d);
        else
            return -1;
    }
    public static void sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d){
        // Sort from a[lo] to a[hi], starting at the dth character.
        if (hi <= lo + M)
        {
            //StdOut.println("insertion: " + lo + ", " + hi);
            //Insertion.sort(a, lo, hi); 
            insertion(a, lo, hi, d);
            return;
        }
        StdOut.println("sort(a, " + lo + ", " + hi + ")");
        int[] count = new int[R+2]; // Compute frequency counts
        
        for (int i = lo; i <= hi; i++)
        {
            int c = charAt(a[i], d);
            count[c+2]++;
         //   StdOut.println("c = " + c + ", " + count[c+2]);
        } 
        /*
        for (int i = 0; i < (R+2); i++)
            StdOut.println("i = " + i + "," + count[i]);
        StdOut.println("Transform counts: ");
        */
        for (int r = 0; r < R+1; r++) //Transform counts to indices
        {
            count[r+1] += count[r];
            /*
            if (count[r+1] > 0)
                StdOut.println("count[" + (r+1) + "] = " + count[r+1]);
            */

        }
        
        //StdOut.println("Distribute: ");
        for (int i = lo; i <= hi; i++) // Distribute.
        {
            int c = charAt(a[i], d);
         //   StdOut.println("aux[" + count[c+1]+1 + "]=" + a[i]);
            aux[count[c + 1]++] = a[i];

        }
        //StdOut.println("Copy back: ");
        for (int i = lo; i <= hi; i++) // Copy back
        {
            a[i] = aux[i-lo];
            
            //StdOut.println("i = " + i + ", aux[" + (i-lo) + "] = " + aux[i-lo]);

        }
        //StdOut.println("Recursively sort");
        // Recursively sort for each character value.
        for (int r = 0; r < R; r++)
        {
            int l = lo + count[r];
            int h = lo + count[r+1] - 1;
            
            //StdOut.println("r = " + r + ":  sort(a, " + l + ", " + h + ", " + (d+1) +  ")");
            sort(a, lo+count[r], lo+count[r+1]-1, d+1);

        }
        //StdOut.println();

    }
    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[] a, int lo, int hi, int d)
    {
        for (int i = 0; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d){
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++){
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    public static void sort(int[] a){
        int n = a.length;
        int[] aux = new int[n];
        sort(a, 0, n-1, 0, aux);
    }

    private static void sort(int[] a, int lo, int hi, int d, int[] aux){
        if (hi <= lo + CUTOFF){
            insertion(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+1];
        int mask = R - 1; //0xFF
        int shift = BITS_PER_INT - BITS_PER_BYTE*d - BITS_PER_BYTE;
        for(int i = lo; i <= hi; i++){
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }

        for (int r = 0; r < R; r++)
            count[r+1] += count[r];
        //distribute
        for (int i = lo; i <= hi; i++){
            int c = (a[i] >> shift) & mask;
            aux[count[c]++] = a[i];
        }
        //copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i-lo];
        // no more bits
        if (d == 4) return;

        // recursively sort for each character
        if (count[0] > 0)
            sort(a, lo, lo + count[0] - 1, d+1, aux);
        for (int r = 0; r < R; r++)
            if (count[r+1] > count[r])
                sort(a, lo+count[r], lo+count[r+1]-1, d+1, aux);
    }
    private static void insertion(int[] a, int lo, int hi, int d){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && a[j] < a[j-1]; j--)
                exch(a, j, j-1);
    }
    private static void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    

    public static void main(String[] args){
        StdOut.println("String sort: ");
        String[] a = StdIn.readAllStrings();
        int N = a.length;
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
        StdOut.println();

        sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
        /*
        StdOut.println("int sort: ");
        int[] b = StdIn.readAllInts();
        int N = b.length;
        sort(b);
        for (int i = 0; i < N; i++)
            StdOut.println(b[i]);
            */
    }
}
