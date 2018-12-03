import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_37 {
    public static class FixedCapacityStackOfInts{
        private int[] a;
        private int N;

        public FixedCapacityStackOfInts(int cap) {
            a = new int[cap];
            N = 0;
        }
        public boolean isEmpty() { return N == 0; }
        public int size()    { return N; }

        public void push(int item) {
            a[N++] = item;
        }
        public int pop() {
            return a[--N];
        }
    }

    public static class FixedCapacityStack<Item> {
        private Item[] a;
        private int N;

        public FixedCapacityStack(int cap){
            a = (Item[])new Object[cap];
            N = 0;
        }
        public boolean isEmpty() { return N == 0;}
        public int size() { return N; }

        public void push(Item item) {
            a[N++] = item;
        }
        public Item pop() {
            return a[--N];
        }
    }

    public static void main(String[] args) {
        int size = 100000;
        int runs = 10000;
        FixedCapacityStackOfInts s1 = new FixedCapacityStackOfInts(size);
        FixedCapacityStack<Integer> s2 = new FixedCapacityStack<Integer>(size);

        Stopwatch s = new Stopwatch();
        for (int i = 0; i < runs; i++) {
            for (int j = 0; j < size; j++) {
                s1.push(j);
            }
            while (s1.isEmpty() == false) {
                s1.pop();
            }
        }
        StdOut.printf("%26s: %6.3f\n", "FixedCapacityStackOfInts", s.elapsedTime());

        s = new Stopwatch();
        for (int i = 0; i < runs; i++) {
            for (int j = 0; j < size; j++) {
                s2.push(j);
            }
            while (s2.isEmpty() == false) {
                s2.pop();
            }
        }
        StdOut.printf("%26s: %6.3f\n", "FixedCapacityStack", s.elapsedTime());

    }
}
