import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_18{
    public static int localMinimum(int[] nums) {
        return localMinimum(nums, 0, nums.length - 1);
    }

    public static int localMinimum(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (mid == 0)   return nums[mid] < nums[mid+1] ? mid : -1;
        if (mid == nums.length-1) return nums[mid] < nums[mid-1] ? mid : -1;
        if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return mid;
        if (nums[mid-1] < nums[mid+1]) return localMinimum(nums, lo, mid-1);
        else    return localMinimum(nums, mid+1, hi);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int i = localMinimum(a);
        if (i == 0) StdOut.printf("%d: [%d, %d\n", i, a[i], a[i+1]);
        else if (i == a.length-1) StdOut.printf("%d: %d, %d ]\n", i, a[i-1], a[i]);
        else  StdOut.printf("%d: %d, %d, %d\n", i, a[i-1], a[i], a[i+1]);

    }
}

