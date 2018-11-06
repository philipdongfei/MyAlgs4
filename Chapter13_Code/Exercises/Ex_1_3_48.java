import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Ex_1_3_48<Item> {
    private Deque<Item> dq = new Deque<Item>();

    private int LN;
    private int RN;

    public Ex_1_3_48() {
        LN = 0;
        RN = 0;
    }
    public boolean isEmpty() { return (LN + RN) == 0; }
    public int size() { return LN + RN; }

    public void pushLStack(Item item){
        dq.pushLeft(item);
        LN++;
    }
    public void pushRStack(Item item) {
        dq.pushRight(item);
        RN++;
    }
    public Item popLStack(){
        if (LN == 0) throw new RuntimeException("Left stack is empty");
        Item item = dq.popLeft();
        LN--;
        return item;
    }
    public Item popRStack() {
        if (RN == 0) throw new RuntimeException("Right stack is empty");
        Item item = dq.popRight();
        RN--;
        return item;
    }

    public static void main(String[] args) {


    }
}
