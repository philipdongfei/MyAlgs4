import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_11
{
    public static void main(String[] args)
    {
        Stack<Double> vals = new Stack<Double>();
        Double left, right, value;

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("+"))
            {
                right = vals.pop();
                left = vals.pop();
                value = left + right;
                vals.push(value);
            } else if (s.equals("-"))
            {
                right = vals.pop();
                left = vals.pop();
                value = left - right;
                vals.push(value);
            } else if (s.equals("*"))
            {
                right = vals.pop();
                left = vals.pop();
                value = left * right;
                vals.push(value);
            } else if (s.equals("/"))
            {
                right = vals.pop();
                left = vals.pop();
                value = left / right;
                vals.push(value);
            }        
            else vals.push(Double.parseDouble(s));


        }
        StdOut.println(vals.pop());
    }
}
