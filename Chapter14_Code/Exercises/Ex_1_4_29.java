import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_29<Item> {
    private Stack<Item> inS;
    private  Stack<Item> outS;
    private int N;

    public Ex_1_4_29() {
        inS = new Stack<Item>();
        outS = new Stack<Item>();
        N = 0;
    }
    public boolean isEmpty() {return N == 0;}
    public int size()    { return N; }
    private void update_in(){
        while(outS.isEmpty() == false)
            inS.push(outS.pop());

    }

    public void push(Item item){
        update_in();
        inS.push(item);
        N++;
    }
    public Item pop() {
        if (isEmpty() == true) return null;
        if (inS.isEmpty() == true && outS.isEmpty() == false)
            update_in();
        Item item  = outS.pop();
        N--;
        return item;
    }
    public void enqueue(Item item) {
       if (isEmpty() == true) inS.push(item);
       else {
           while (inS.isEmpty() == false) {
                outS.push(inS.pop());
            }
            outS.push(item);
       }
       N++;
    }


}
