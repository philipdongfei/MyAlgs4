import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_20 {
    public static int ascendingBinarySearch(int[] arr, int lo,
            int hi, int key)
    {
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) hi = mid - 1;
            else        lo = mid + 1;
        }
        return mid;
    }

    public static int descendingBinarySearch(int[] arr, int lo, 
            int hi, int key)
    {
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) hi = mid + 1;
            else        lo = mid - 1;
        }
        return mid;

    }
    public static int findBitonicPoint(int[] arr, int l, int r) {
        int mid, n; 
        mid = (r + l)/2;
        n = arr.length;
        if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            return mid;
        else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1])
            mid = findBitonicPoint(arr, mid, r);
        else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1])
            mid = findBitonicPoint(arr, 1, mid);
        return mid;
    }

    public static int searchBitnoic(int[] arr, int key, int index) {
        int n = arr.length;
        if (key > arr[index])
            return -1;
        else if (key == arr[index])
            return index;
        else {
            int temp = ascendingBinarySearch(arr, 0, index - 1, key);
            if (temp != -1)
                return temp;
            return descendingBinarySearch(arr, index + 1, n - 1, key);
        }
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int key = Integer.parseInt(args[1]);
        int n = a.length, l = 0, r, index = 0;
        r = n - 1;
        index = findBitonicPoint(a, l, r);

        int x = searchBitnoic(a, key, index);
        if (x == -1)
            StdOut.println("Element not found");
        else
            StdOut.println("Element Found at index " + x);

    }
}
