import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;


public class SPT {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            StdOut.println(name + " " + time);
            jobs[i] = new Job(name, time);
        }
        // sort jobs
        Arrays.sort(jobs);

        for (int i = 0; i < n; i++)
            StdOut.println(jobs[i]);
    }
}
