import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_10
{
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        while (!StdIn.isEmpty()) {
        // Read token, push if operator.
            String s = StdIn.readString();
            if (s.equals("("))      ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
            // pop, evaluate, and push result if token if ")".
                String op = ops.pop();
                String v = vals.pop();
                String subexp = "";
                if (op.equals("+"))    subexp = vals.pop() + " " + v + " "  + "+";
                else if (op.equals("-"))    subexp = vals.pop() + " " + v + " "+ "-";
                else if (op.equals("*"))    subexp = vals.pop() + " " + v + " " + "*";
                else if (op.equals("/"))    subexp = vals.pop() + " " + v + " " + "/";
                vals.push(subexp);
            } // Token not operator or parent: push double value.
            else vals.push(s);
            
        }
        StdOut.println(vals.pop());
    }
}
