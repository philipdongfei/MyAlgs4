import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex2_5_9 {
    public static class DJIVolume implements Comparable<DJIVolume>{
        private final String date;
        private final Long vol;

        public DJIVolume(String date, long vol) {
            this.date = date;
            this.vol = vol;
        }
    
        @Override
        public String toString() {
            return String.format("%-10s    %-15s", date, vol.toString());
        }
        public int compareTo(DJIVolume that) {
            return Long.compare(this.vol, that.vol);
        }
        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            DJIVolume that = (DJIVolume) other;
            return (this.vol == that.vol && (this.date.equals(that.date)));
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Queue<DJIVolume> q = new Queue<DJIVolume>();
        StdOut.println("input");
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] dv = line.split("\\s+");
            Long lvol = Long.parseLong(dv[1], 10);
            StdOut.println(dv[0] + " " + dv[1]);
            DJIVolume v = new DJIVolume(dv[0], lvol);
            q.enqueue(v);
            n++;
        }

        StdOut.println("output");

        DJIVolume[] volumes = new DJIVolume[n];
        for (int i = 0; i < n; i++)
            volumes[i] = q.dequeue();
        Arrays.sort(volumes, 0, n);
        for (int i = n-1; i >= 0; i--)
            StdOut.println(volumes[i]);
    }
}
