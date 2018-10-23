import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_9
{
    public static void main(String[] args)
    {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        while (!StdIn.isEmpty())
        {// Read token, push if operator.
            String s = StdIn.readString();
            if (s.equals("+"))  ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")"))
            {// 
                String op = ops.pop();
                String v = vals.pop();
                String subexpre;
                subexpre = "( " + vals.pop()+ " " + op + " "  + v + " )";
                vals.push(subexpre);
            }
            else
                vals.push(s);
        }
        StdOut.println(vals.pop());
    }
}
