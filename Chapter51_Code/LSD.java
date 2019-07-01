import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class LSD {
    private static final int BITS_PER_BYTE = 8;

    private LSD() {}

    public static void sort(String[] a, int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for(int d = w-1; d >= 0; d--){
            // sort by key-indexed counting on dth char.
            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d)+1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void sort(int[] a) {
        final int BITS = 32; // each int is 32bits
        final int R = 1 << BITS_PER_BYTE; // each bytes is 0 and 255
        final int MASK = R-1; // 0xFF
        final int w = BITS / BITS_PER_BYTE;// each int is 4 bytes

        int N = a.length;
        int[] aux = new int[N];

        for (int d = 0; d < w; d++) {
            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++){
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w-1){
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }
            // move data
            for (int i = 0; i < N; i++){
                int c = (a[i] >> BITS_PER_BYTE*d)&MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();
        int N = a.length;

        // check that strings have fixed length
        int w = a[0].length();
        for (int i = 0; i < N; i++)
            assert a[i].length() == w : "Strings must have fixed length";

        // sort the strings
        sort(a, w);

        // print results
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
