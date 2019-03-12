import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
//import edu.princeton.cs.algs4.SequentialSearchST;
import java.util.Arrays;

public class Ex3_4_4 {

    public static void main(String[] args) {
        int[] vals = perfectHashFunction();

        if (vals != null) {
            StdOut.println("a = " + vals[0]);
            StdOut.println("M = " + vals[1]);
        }
    }
    public static int[] perfectHashFunction(){
        int[] values = new int[2];
        char[] letterVal = {'S', 'E', 'A', 'R', 'C', 'H', 
                'X', 'M', 'P', 'L'};
        for (int m = 2; m <= 100; m++) {
            for(int a = 1; a <= 1000; a++) {
                SET<Integer> set = new SET<Integer>();

                for (int i = 0; i < letterVal.length; i++){
                    int hash = hashCode(a, (int)letterVal[i], m);
                    set.add(hash);
                }
                if (set.size() == letterVal.length) {
                    StdOut.println("set size: " + set.size());
                    for (Integer h : set){
                        StdOut.println(h);
                    }
                    values[0] = a;
                    values[1] = m;
                    return values;

                }
            }
        }
        return null;

    }
    private static int hashCode(int a, int k, int m){
        return (a * k) % m;
    }
}
