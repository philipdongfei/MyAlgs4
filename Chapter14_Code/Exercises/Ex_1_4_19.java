import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_4_19 {
    public static int[] localMinimum(int[][] a) {
        int lo = 0; 
        int hi = a.length - 1;
        int mid = lo + (hi - lo) / 2;
        int midc = mid;
        while (hi >= lo) {
            int[] min = localMinimum(a, mid, 0, a.length-1);
            if (min[0] >= 0) return min;
            else {
                if (a[mid-1][midc] < a[mid+1][midc]) hi = mid-1;
                else        lo = mid + 1;
                mid = lo + (hi - lo) / 2;
            }
        }
        return new int[]{-1, -1};
    }
    public static int[] localMinimum(int[][] a, int row, int lo, int hi) {
        int[] fail = {-1,-1};
        int mid = lo + (hi-lo)/2;
        if (lo > hi) return fail;
        if ((row == 0 || a[row-1][mid] > a[row][mid])&&
            (row == a.length-1 || a[row+1][mid] > a[row][mid]) &&
            (mid == 0    || a[row][mid-1] > a[row][mid]) &&
            (mid == a.length-1 || a[row][mid+1]>a[row][mid])) return new int[]{row, mid};
        if (a[row][mid-1] < a[row][mid+1]) return localMinimum(a, row, lo, mid-1);
        else    return localMinimum(a, row, mid+1, hi);
    }
    public static void main(String[] args){
        int n = 100;
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                nums[i][j] = StdRandom.uniform(0, 100);
            }
        }
        int[] min = localMinimum(nums);
        if (min[0] > 0) {
            StdOut.printf("nums[%d][%d] = %d\n", min[0], min[1], nums[min[0]][min[1]]);
        if (min[0]+1<nums.length-1)
            StdOut.printf("nums[%d][%d] = %d\n", min[0]+1,min[1],nums[min[0]+1][min[1]]);
        if (min[1]+1 < nums.length-1)
            StdOut.printf("nums[%d][%d] = %d\n", min[0],min[1]+1, nums[min[0]][min[1]+1]);
        if (min[0]-1>=0)
            StdOut.printf("nums[%d][%d] = %d\n", min[0]-1,min[1],nums[min[0]-1][min[1]]);
        if (min[1]-1>=0)
            StdOut.printf("nums[%d][%d] = %d\n", min[0],min[1]-1,nums[min[0]][min[1]-1]);

        }else
            StdOut.printf("Fail\n");
    }
}

