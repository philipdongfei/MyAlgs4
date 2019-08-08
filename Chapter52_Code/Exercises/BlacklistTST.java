import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TrieSET;


public class BlacklistTST{
    public static void main(String[] args){
        TrieSET blacklist = new TrieSET();

        // read in whitelist of words
        In wl = new In(args[0]);
        while (!wl.isEmpty()){
            String word = wl.readString();
            blacklist.add(word);
        }

        StdOut.println("Done reading whitelist");
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if (!blacklist.contains(word)) 
                StdOut.print(word + " ");
        }
        StdOut.println();
    }
}
