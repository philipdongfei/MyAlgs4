import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Heap;
import java.util.Arrays;

public class Ex2_5_11 {
    public static class Pair implements Comparable<Pair> {
        private final Integer value;
        private final Integer index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int compareTo(Pair that) {
            return Integer.compare(this.value , that.value);
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", index, value);
        }
    }
    public static void main(String[] args) {
        int N = 10;
        Pair[] p = new Pair[N];
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Insertion.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Selection.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Shell.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Merge.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Quick.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
        for (int i = 0; i < N; i++)
            p[i] = new Pair(0, i);
        Heap.sort(p);
        for (int i = 0; i < N; i++)
            StdOut.print(p[i]+" ");
        StdOut.println();
    }
}
