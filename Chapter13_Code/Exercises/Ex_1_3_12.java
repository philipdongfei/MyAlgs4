import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_12
{
    public static void main(String[] args){
        Stack<String> oldStk = new Stack<String>();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            oldStk.push(s);
        }
        Stack<String> newStk = copy(oldStk);

        StdOut.println(newStk);
    }

    public static Stack<String> copy(Stack<String> oldStack) {
        Stack<String> newStack = new Stack<String>();
        for (String s : oldStack)
            newStack.push(s);

        return newStack;
    }
}

