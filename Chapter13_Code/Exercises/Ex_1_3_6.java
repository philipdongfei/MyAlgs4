import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Ex_1_3_6
{
    public static void Reverse(Queue<String> q)
    {
        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

    }

    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            q.enqueue(item);
        }
        Reverse(q);
        for (String s : q)
            StdOut.print(s+" ");
        StdOut.println();

    }

}
