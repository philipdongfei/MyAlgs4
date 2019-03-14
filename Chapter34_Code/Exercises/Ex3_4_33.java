import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.lang.Math;

public class Ex3_4_33 {
    public static int hashCode(String key) {
        int hash = 0;
        int skip = Math.max(1,key.length()/8);
        StdOut.println("skip: "+skip);
        for (int i = 0; i < key.length(); i += skip)
            hash = (hash * 37) + key.charAt(i);
        return hash;
    }
    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();
        for (int i = 0; i < a.length; i++){
            StdOut.println(a[i] + " " + hashCode(a[i]));
        }
    }
}
