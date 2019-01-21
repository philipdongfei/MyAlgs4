import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Ex2_4_28 {
    public static class TopM implements Comparable<TopM>{
        private final double x;
        private final double y;
        private final double z;

        public TopM(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public double distanceToOrigin() {
            return Math.sqrt(x*x+y*y+z*z);
        } 
        public int compareTo(TopM that){
            if (this.distanceToOrigin() < that.distanceToOrigin()) return -1;
            if (this.distanceToOrigin() > that.distanceToOrigin())
                return +1;
            return 0;

        }
        public String toString() {
            return distanceToOrigin()+"("+x+" "+y+" "+z+")";
        }
    }
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]); 
        double M = Math.pow(10.0, m);
        double N = Math.pow(10.0, n);
        MaxPQ<TopM> pq = new MaxPQ<TopM>((int)M+1);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(0.0, (double)M);
            double y = StdRandom.uniform(0.0, (double)M);
            double z = StdRandom.uniform(0.0, (double)M);
            pq.insert(new TopM(x, y, z));
            if (pq.size() > M)
                pq.delMax();
        }
        Stack<TopM> stack = new Stack<TopM>();
        while (!pq.isEmpty()) stack.push(pq.delMax());
        for (TopM t : stack) StdOut.println(t);
    }
}
