import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_22 {
    public static int FibonacciSearch(int[] a, int key) {
        // Fk:F(k),Fk_1:F(k-1),Fk_2:F(k-2)
        int Fk, Fk_1, Fk_2, mid, lo, hi, i;
        lo = 0;
        i = lo;
        hi = a.length - 1;
        Fk = hi - lo;
        int[] f = fibo(Fk);
        Fk = f[0];
        Fk_1 = f[1];
        while (lo <= hi) {
            //StdOut.printf("lo=%d,hi=%d\n", lo, hi);
            //StdOut.printf("Fk=%d,Fk_1=%d\n", Fk, Fk_1);
            Fk_2 = Fk-Fk_1;
            mid = lo + Fk_2; 
            if (key < a[mid]) {
                lo = i + lo;
                hi = i + lo + Fk_2;
                Fk = Fk_2;
                Fk_1 = Fk_1 - Fk_2;
            } else if (key > a[mid]) {
                lo = i + lo + Fk_2;
                hi = i + lo + Fk_2 + Fk_1; 
                Fk = Fk_1;
                Fk_1 = Fk_2;
            }else    return mid;
        }
        return -1;
    }
    public static int[] fibo(int Fk) {
        int a = 1, b = 1;
        int[] f = new int[2];
        while ((a+b) < Fk) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        f[1] = b;
        f[0] = a+b;
        return f;
    }
    public static int BinarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else        return mid;
        } 
        return -1;
    }
    public static void main(String[] args) {
        int[] a = new int[200];
        int key = 30, index = 0;
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        StdOut.println("Find "+key);
        index = FibonacciSearch(a, key); 
        StdOut.printf("fibo search index: a[%d] = %d\n", index, a[index]);
        index =BinarySearch(a, key);
        StdOut.printf("binary search index:a[%d]=%d\n", index, a[index]);
    }
}
