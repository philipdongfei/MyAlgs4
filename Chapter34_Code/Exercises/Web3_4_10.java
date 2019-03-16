import java.util.zip.CRC32;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Web3_4_10 {
    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();

        CRC32 checksum = new CRC32();
        for (int i = 0; i < a.length; i++)
        {
            checksum.update(a[i].getBytes());
            StdOut.println(a[i] + " " + checksum.getValue());
        }
    }
}

