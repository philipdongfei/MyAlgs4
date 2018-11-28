import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.lang.Math;

public class Ex_1_4_25 {
    private long N;
    private long F;
    private long broken = 0;

    public Ex_1_4_25(long n, long f) {
        N = n;
        F = f;
    }

    //break: true, no break: false
    private boolean toss(long floor) {
        if (floor >= F) return true;
        return false;
    }
    public long findFloorN(){
        long step = (long)Math.sqrt(N);
        long floor = step;
        while (toss(floor) == false) floor += step;
        floor -= step;
        while (toss(floor) == false) floor++;
        return floor;
    }
    public long findFloorF() {
        long floor = 2;
        while (toss(floor) == false) floor *= floor;
        floor = (long)Math.sqrt(floor) - 1;
        while (toss(floor) == false) floor++;
        return floor;
    }
    public static void main(String[] args) {
        Ex_1_4_25 e = new Ex_1_4_25(20000000, 2000);
        StdOut.println("Find floor for lg N time: "+e.findFloorN());
        StdOut.println("Find floor for ~2lg F time: "+e.findFloorF());
    }
    
}
