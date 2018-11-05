import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Buffer {
    private Stack<Character> LStack; 
    private Stack<Character> RStack;
    private int N;

    public Buffer() {
        N = 0;
        LStack = new Stack<Character>();
        RStack = new Stack<Character>();
    }
    public int size() { return N; }

    public void insert(char c){
        //if (c == null) throw new RuntimeException("c is null");
        //StdOut.println("insert "+c);
        LStack.push(c);
        N++;
    }
    public char delete() {
        if (RStack.isEmpty()) throw new RuntimeException("the cursor point null ");
        Character c = RStack.pop();
        N--;
        return c;
    }
    public void left(int k) {
        if (k > LStack.size()) throw new RuntimeException("k is overflow");
        //StdOut.println("left k= "+k);
        for (int i = 0; i < k; i++) {
            char ch = (char)LStack.pop();
            //StdOut.println("left: "+ ch);
            RStack.push(ch);
        }
    }
    public void right(int k) {
        if (k > RStack.size()) throw new RuntimeException("k is overflow");
        for (int i = 0; i < k; i++){
            LStack.push(RStack.pop());
        }
    }
    public String toString(){
        while (!LStack.isEmpty())
        {
            RStack.push(LStack.pop());
        }
        StringBuilder s = new StringBuilder();
        while (!RStack.isEmpty()) {
            s.append(RStack.pop() + " ");
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Buffer b = new Buffer();

        for (int i = 0; i < 10; i++){
            b.insert((char)(i + '0'));
        }

        //StdOut.println(b);
        b.left(5);
        StdOut.println(b.delete());
        b.right(2);
        StdOut.println(b.delete());
        StdOut.println(b);

    }
    
}
