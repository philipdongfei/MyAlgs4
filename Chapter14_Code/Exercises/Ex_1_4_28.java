import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_28<Item>{
    private Queue<Item> q;
    private int N;
    public Ex_1_4_28(){
        q = new Queue<Item>();
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(Item item){
        q.enqueue(item);
        N++;
    }
    public Item pop() {
        int length = q.size();
        if (length == 0)
            return null;
        for (int i=0; i<length-1; i++)
            q.enqueue(q.dequeue());
        Item item = q.dequeue();
        N--;
        return item;
    }
    public static void main(String[] args){
        Ex_1_4_28<String> s = new Ex_1_4_28<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
