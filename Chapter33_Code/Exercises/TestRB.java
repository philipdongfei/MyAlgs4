import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;


public class TestRB {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();

        for (int i = 0; i < a.length; i++)
            st.put(a[i], i);
        StdOut.println("size = " + st.size());
        StdOut.println("min = " + st.min());
        StdOut.println("max = " + st.max());
        StdOut.println();

    }

}
