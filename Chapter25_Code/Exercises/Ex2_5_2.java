import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex2_5_2 {
    private static String[] compoundWords(String[] a) {
        Arrays.sort(a);
        Queue<String> q = new Queue<String>();
        String prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].length() > prev.length() &&
                    a[i].substring(0, prev.length()).equals(prev)) 
            {
                String nextsub = a[i].substring(prev.length());
                if (nextsub.compareTo(prev) > 0) {
                    if (binarysearch(nextsub, a, i+1, a.length-1) != -1)
                        q.enqueue(a[i]);

                } else {
                    if ((i-2) >= 0) {
                        if (binarysearch(nextsub, a, 0, i-2) != -1)
                            q.enqueue(a[i]);
                    }
                }
            }
            prev = a[i];
        }
        String[] compound = new String[q.size()];
        for (int i=0; i < compound.length; i++)
            compound[i] = q.dequeue();
        return compound;
    }
    private static int binarysearch(String key, String[] a, int lo, int hi)
    {
        while (lo <= hi ) {
            int mid = lo + (hi - lo)/2;
            if (key.compareTo(a[mid]) < 0) hi = mid - 1;
            else if (key.compareTo(a[mid]) > 0) lo = mid + 1;
            else    return mid;
        }
        return -1;

    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        String[] compound = compoundWords(a);
        for (String sub: compound) {
            StdOut.println(sub);
        }
    }
}
