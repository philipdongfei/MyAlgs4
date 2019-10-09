import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class BruteForceRL {
    private String pat;

    BruteForceRL(String pat){
        this.pat = pat;
    }

    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        int j;

        for (int i = 0; i <= N-M; i++){
            for (j = M - 1; j >= 0; j--){
                if (pat.charAt(j) != txt.charAt(i + j)){
                    break;
                }
            }
            if (j == -1) return i;
        }
        return M;
    }
    public static void main(String[] args){
        String pat = args[0];
        String txt = args[1];
        BruteForceRL bf = new BruteForceRL(pat);
        StdOut.println("text: " + txt);
        int offset = bf.search(txt);
        StdOut.println("pattern: " + pat);
        StdOut.println("offset: " + offset);
        StdOut.println(txt);
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);

    }
}
