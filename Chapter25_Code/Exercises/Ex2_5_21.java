import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex2_5_21 {
    public static class Vector implements Comparable<Vector>{
        private int[] v;
        private final int d;

        public Vector(int dv, int[] vv) {
            v = new int[dv];
            for (int i = 0; i < dv; i++)
            {
                this.v[i] = vv[i];
            }
            this.d = dv;
        }
        @Override
        public String toString() {
            String temp = "";
            for (int i = 0; i < d; i++)
                temp += String.format("%d ", v[i]);
            return temp;
        }
        public int compareTo(Vector that) {
            for (int i = 0; i < d; i++) {
                if (this.v[i] < that.v[i])
                    return -1;
                else if (this.v[i] > that.v[i])
                    return +1;
            }
            return 0;
        }
        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            Vector that = (Vector) other;
            for (int i = 0; i < d; i++){
                if (this.v[i] != that.v[i])
                    return false;
            }
            return true;
        }
/*
        public static void main(String[] args) {
            Vector[] a = new Vector[5];
            int[] v1 = {1,2,5,2};
            a[0] = new Vector(4, v1);
            int[] v2 = {1,2,1,3};
            a[1] = new Vector(4, v2);
            int[] v3 = {0,8,1,7};
            a[2] = new Vector(4, v3);
            int[] v4 = {8,0,1,2};
            a[3] = new Vector(4, v4);
            int[] v5 = {5,7,3,1};
            a[4] = new Vector(4, v5);

            Arrays.sort(a);
            for (int i = 0; i < 5; i++)
                StdOut.println(a[i]);
        }
        */
    }
        public static void main(String[] args) {
            Vector[] a = new Vector[5];
            int[] v1 = {1,2,5,2};
            a[0] = new Vector(4, v1);
            int[] v2 = {1,2,1,3};
            a[1] = new Vector(4, v2);
            int[] v3 = {0,8,1,7};
            a[2] = new Vector(4, v3);
            int[] v4 = {8,0,1,2};
            a[3] = new Vector(4, v4);
            int[] v5 = {5,7,3,1};
            a[4] = new Vector(4, v5);

            Arrays.sort(a);
            for (int i = 0; i < 5; i++)
                StdOut.println(a[i]);
        }
}
