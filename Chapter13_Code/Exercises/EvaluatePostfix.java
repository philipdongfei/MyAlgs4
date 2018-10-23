import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<String> vals = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")){
                Double right = Double.parseDouble(vals.pop());
                Double left = Double.parseDouble(vals.pop());
                Double val = left + right;
                vals.push(val + "");
            } else if (s.equals("-")) {
                Double right = Double.parseDouble(vals.pop());
                Double left = Double.parseDouble(vals.pop());
                Double val = left - right;
                vals.push(val + "");

            } else if (s.equals("*")) {
                Double right = Double.parseDouble(vals.pop());
                Double left = Double.parseDouble(vals.pop());
                Double val = left * right;
                vals.push(val + "");
            } else if (s.equals("/")) {
                Double right = Double.parseDouble(vals.pop());
                Double left = Double.parseDouble(vals.pop());
                Double val = left / right;
                vals.push(val + "");
            }
            else vals.push(s);

        }
        StdOut.println(vals.pop());
    }
}
