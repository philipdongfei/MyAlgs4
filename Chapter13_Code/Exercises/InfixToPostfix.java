import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> expression = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {}
            else if (s.equals("+") || s.equals("-") || s.equals("*") 
                    || s.equals("/")){
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                String right = expression.pop();
                String left = expression.pop();

                String newVal = left + " " + right + " " + op;
                expression.push(newVal);
            } else {
                expression.push(s);
            }
        }
        StdOut.println(expression.toString());
    }
}
