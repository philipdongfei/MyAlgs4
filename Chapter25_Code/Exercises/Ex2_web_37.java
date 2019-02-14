import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Date;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_web_37 {
    public static class StrNumber implements Comparable<StrNumber> {
        private final String Number;  //

        public StrNumber(String num) {
            this.Number = num;
        }
        @Override
        public String toString() {
            return Number; 
        }

        public int compareTo(StrNumber that) {
            return String.format("%s%s", that.Number, this.Number).compareTo(String.format("%s%s", this.Number, that.Number)); 
        }

    }
    public static void main(String[] args) {
        StrNumber[] a = new StrNumber[4];
        a[0] = new StrNumber("123");
        a[1] = new StrNumber("12");
        a[2] = new StrNumber("96");
        a[3] = new StrNumber("921");

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }
}
