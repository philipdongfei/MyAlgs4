import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class Ex5_3_7 extends Ex1_Brute{
    Ex5_3_7(String pat){
        super(pat);
    }
    
    public static void main(String[] args){

        String pat = args[0];
        String txt = args[1];
        Ex5_3_7 ex7 = new Ex5_3_7(pat);
        int count = ex7.count(txt);
        StdOut.println("count: " + count);
        Iterable<Integer> indexes = ex7.searchAll(txt);
        for (int index : indexes)
            StdOut.print(index + ", ");
        StdOut.println();
    }
}
