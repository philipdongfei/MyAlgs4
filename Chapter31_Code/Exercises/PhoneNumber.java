import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.HashSet;


public final class PhoneNumber {
    private final int area; // area
    private final int exch; // exchange
    private final int ext;  // extension

    public PhoneNumber(int area, int exch, int ext) {
        this.area = area;
        this.exch = exch;
        this.ext = ext;
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        PhoneNumber that = (PhoneNumber) other;
        return (this.area == that.area) && (this.exch == that.exch) &&
            (this.ext == that.ext);
    }
    @Override
    public String toString() {
        return String.format("(%3d) %03d-%04d", area, exch, ext);
    }
    @Override
    public int hashCode() {
        return 31 * (area + 31 * exch) + ext;
    }
    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 555, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("c = " + c);
        StdOut.println("d = " + d);
        StdOut.println("e = " + e);

        HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
        set.add(a);
        set.add(b);
        set.add(c);
        StdOut.println("Added a, b, and c");
        StdOut.println("contains a: " + set.contains(a));
        StdOut.println("contains b: " + set.contains(b));
        StdOut.println("contains c: " + set.contains(c));
        StdOut.println("contains d: " + set.contains(d));
        StdOut.println("contains e: " + set.contains(e));
        StdOut.println("b == e: " + (b == e));
        StdOut.println("b.equals(e):" + (b.equals(e)));

    }
}

