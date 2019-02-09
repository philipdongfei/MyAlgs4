import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex2_5_10 {
    public static class Version implements Comparable<Version> {
        private final Integer major;
        private final Integer minor;
        private final Integer patch;

        public Version(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }
        public Version(String version) {
            String[] a = version.split("\\.");
            major = Integer.parseInt(a[0]);
            minor = Integer.parseInt(a[1]);
            patch = Integer.parseInt(a[2]);
        }
        @Override
        public String toString() {
            return String.format("%s.%s.%s", major, minor, patch);
        }

        public int compareTo(Version that) {
            if (this.major.equals(that.major) == false) {
                return Integer.compare(this.major, that.major);
            } else if (this.minor.equals(that.minor) == false) {
                return Integer.compare(this.minor, that.minor);
            } else if (this.patch.equals(that.patch) == false) {
                return Integer.compare(this.patch, that.patch);
            } else
                return 0;
        }
        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            Version that = (Version) other;
            return (this.major.equals(that.major) && this.minor.equals(that.minor) && this.patch.equals(that.patch));
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int N = a.length;
        Version[] v = new Version[N];
        for (int i = 0; i < N; i++)
        {
            Version t_v = new Version(a[i]);
            v[i] = t_v;
        }
        Arrays.sort(v, 0, N);
        for (int i = 0; i < N; i++)
            StdOut.println(v[i]);
    }
}
