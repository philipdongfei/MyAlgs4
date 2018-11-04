import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Listingfiles
{
    private static void enumFold(String Fold, Queue<String> q) {
        if (Fold == null) return;
        q.enqueue(Fold+":");
        File foldfiles = new File(Fold);
        if (foldfiles.exists()) {
            File[] files = foldfiles.listFiles();
            if (files.length == 0)
                return;
            else {
                for (File Afile : files) {
                    if (Afile.isDirectory()){
                        enumFold(Afile.getAbsolutePath(), q);
                        
                    }else {
                        q.enqueue(Afile.getAbsolutePath());
                    }
                }
            }
        } else
            return;

    }
    public static void main(String[] args){
        String Fold = args[0];
        Queue<String> q = new Queue<String>();

        enumFold(Fold, q);

        for (String x : q)
            StdOut.println(x);

    }
}
