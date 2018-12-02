import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_30<Item> {
    private Stack<Item> s;
    private Steque<Item> sq;
    int N;

    public Ex_1_4_30(){
        s = new Stack<Item>();
        sq = new Steque<Item>();
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public int size()   { return N; }

    public void pushLeft(Item item) {
        if (isEmpty() == true) sq.push(item);
        else {
            sq.enqueue(item);
        }
        N++;
    }
    public void pushRight(Item item) {
        sq.push(item);
        N++;

    }
    public Item popLeft() {
        if (isEmpty() == true) return null;
        Item item;
        while (sq.isEmpty() == false)
            s.push(sq.pop());
        item = s.pop();
        while (s.isEmpty() == false)
            sq.push(s.pop());
        N--;
        return item;
    }
    public Item popRight() {
        if (isEmpty() == true ) return null;
        Item item = sq.pop();
        return item;
    }

}
