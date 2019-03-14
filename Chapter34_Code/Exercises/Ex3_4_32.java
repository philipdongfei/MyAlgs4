import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Ex3_4_32 {
    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();
        for (int i = 0; i < a.length; i++){
            StdOut.println(a[i] + " " + a[i].hashCode());
        }
    }
}
