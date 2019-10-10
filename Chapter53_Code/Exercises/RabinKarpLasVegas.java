import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class RabinKarpLasVegas extends RabinKarp {
    RabinKarpLasVegas(String pattern) {
        super(pattern, false);
    }
    @Override
    protected boolean check(String text, int textIndex){
        for (int patternIndex = 0; patternIndex < M; patternIndex++){
            if (pat.charAt(patternIndex) != text.charAt(textIndex + patternIndex)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String pat = args[0];
        String txt = args[1];
        RabinKarpLasVegas rklv = new RabinKarpLasVegas(pat);
        int index1 = rklv.search(txt);
        StdOut.println("Index 1: " + index1 + " Excepted: 12");

    }
}
