import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class MoveToFront {
    public static void main(String[] args) {
        List<Integer> lst = new List<Integer>();

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (!lst.contains(key)) 
                lst.prepend(key);
            else {
                lst.remove(key);
                lst.prepend(key);
            }
        }
        StdOut.println(lst);
    }

}
