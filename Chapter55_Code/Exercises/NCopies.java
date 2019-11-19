import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Random; 
import java.nio.charset.Charset;


public class NCopies {
    private NCopies(){};

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int argsLen = args.length;
        StringBuilder out = new StringBuilder("");
        
        if (argsLen == 1)
        {
            byte[] array = new byte[256];
            new Random().nextBytes(array);

            String randomString = new String(array, Charset.forName("UTF-8"));
            //StdOut.println(randomString.length());
            //for (int i = 0; i < randomString.length(); i++)
            while (N > 0)
            {
                int k = StdRandom.uniform(randomString.length());
                char ch = randomString.charAt(k);
                if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                        && (N > 0)){
                    out.append(ch);
                    N--;
                }
            }

        }
        else if (argsLen == 2)
        {
            String str = args[1];
            for (int i = 0; i < N; i++)
                out.append(str);
        }

        StdOut.print(out);
    } 
}

