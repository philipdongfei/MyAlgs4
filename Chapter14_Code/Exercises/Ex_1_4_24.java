import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_24 {
    private long N;
    private long F;
    private long broken = 0;

    public Ex_1_4_24(long n, long f) {
        N = n;
        F = f;
    }

    //break: true, no break: false
    private boolean toss(long floor) {
        if (floor >= F) return true;
        return false;
    }
    public long findFloorN() {
        long lo = 0;
        long hi = N;
        long prev = 0;
        while (hi >= lo) {
            long mid = lo + (hi - lo)/2;
            if (toss(mid)) {
                hi = mid - 1;
                prev = mid;
            }
            else        lo = mid + 1;
        }
        return prev;
    }
    public long findFloorF() {
        long lo = 0, hi = 1, prev = 0;
        while (toss(hi) == false)
            hi *= 2;
        lo = hi / 2;
        while (hi >= lo) {
            long mid = lo + (hi - lo) / 2;
            if (toss(mid)) {
                hi = mid - 1;
                prev = mid;
            }
            else        lo = mid + 1;
        }
        return prev;
    }
    public static void main(String[] args) {
        Ex_1_4_24 e = new Ex_1_4_24(20000000, 2000);
        StdOut.println("Find floor for lg N time: "+e.findFloorN());
        StdOut.println("Find floor for ~2lg F time: "+e.findFloorF());
    }
}
