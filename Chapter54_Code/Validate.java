import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Validate {
    public static void main(String[] args){
        String regexp = args[0];
        String text = args[1];
        StdOut.println(text.matches(regexp));
    }
}
