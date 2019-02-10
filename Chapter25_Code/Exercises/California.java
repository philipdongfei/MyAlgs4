import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.Comparator;


public class California {
    public static final Comparator<String> CANDIDATE_ORDER = 
        new CandidateComparator();

    private static class CandidateComparator implements Comparator<String> {
        private static String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
        public int compare(String a, String b) {
            int n = Math.min(a.length(), b.length());
            for (int i = 0; i < n; i++) {
                int aindex = order.indexOf(a.charAt(i));
                int bindex = order.indexOf(b.charAt(i));
                if      (aindex < bindex) return -1;
                else if (aindex > bindex) return +1;
            }
            return a.length() - b.length();
        }
    }

    public static void main(String[] args) {
        String[] candiates = StdIn.readAll().toUpperCase().split("\\n+");
        int n = candiates.length;
        Arrays.sort(candiates, California.CANDIDATE_ORDER);
        for (int i = 0; i < n; i++)
            StdOut.println(candiates[i]);
    }
}
