import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_4_43 {
    public static class DoublingRatio{
        private static final int MAXIMUM_INTEGER = 1000000;
        private DoublingRatio(){}
        public static double timeTrial(int n, int runs, String type) {
            Stopwatch timer = new Stopwatch();
            if (type == "list"){
                Stack<Integer> s = new Stack<Integer>();
                while (--runs >= 0) {
                    for (int i = 0; i < n; i++)
                        s.push(i);
                    while (!s.isEmpty())
                        s.pop();
                }
            }else {
                ResizingArrayStack<Integer> s = new ResizingArrayStack<Integer>();
                while (--runs >= 0){
                    for (int i = 0; i < n; i++)
                        s.push(i);
                    while (!s.isEmpty())
                        s.pop();
                }
            }
            return timer.elapsedTime();
        }
    }
    public static void main(String[] args) {
        int init = 1000;
        int runs = 1000;
        StdOut.printf("%7s %5s %5s %10s\n", "size", "list", "array", "list/array");
        for (int n = init; true; n += n) {
            double time_list = DoublingRatio.timeTrial(n, runs, "list");
            double time_array = DoublingRatio.timeTrial(n, runs, "array");
            StdOut.printf("%7d %5.1f %5.1f %10.1f\n", n, time_list, time_array, time_list/time_array);
        }
    }
}
