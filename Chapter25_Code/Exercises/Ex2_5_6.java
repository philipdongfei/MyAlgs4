import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex2_5_6 {

    // Return minimum index
    static int minIndex(int a[], int i, int j) {
        if (i == j)
            return i;
        // Find minimum of remaining elements
        int k = minIndex(a, i+1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k]) ? i : k;
    }

    // Recursive selection sort. n is size of a[] and index
    // is index of starting element.
    static void recurSelectionSort(int a[], int n, int index) {
        // Return when starting and size are same.
        if (index == n)
            return;
        // calling minimum index function for minimum index.
        int k = minIndex(a, index, n-1);

        // Swapping when index nd minimum index are not same.
        if (k != index) {
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function.
        recurSelectionSort(a, n, index+1);
    }

    // Driver method.
    public static void main(String args[]) {
        int arr[] = {3, 1, 5, 2, 7, 0, 9, 10};

        // Calling function.
        recurSelectionSort(arr, arr.length, 0);

        // printing sorted array.
        for (int i = 0; i < arr.length; i++)
            StdOut.print(arr[i]+" ");
        StdOut.println();
    }
}
