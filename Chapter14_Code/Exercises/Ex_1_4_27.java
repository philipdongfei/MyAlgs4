import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_27<Item>{
    private Stack<Item> inS1;
    private Stack<Item> outS2;
    private int N;
    public Ex_1_4_27(){
        inS1 = new Stack<Item>();
        outS2 = new Stack<Item>();
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public int size()     {return N;}

    public void enqueue(Item item) {
        inS1.push(item);
        N++;
    }
    public Item dequeue() {
        while(inS1.isEmpty() == false) {
            outS2.push(inS1.pop());
        }
        Item item = outS2.pop();
        N--;
        return item;
    }
    public static void main(String[] args){
        Ex_1_4_27<String> q = new Ex_1_4_27<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
