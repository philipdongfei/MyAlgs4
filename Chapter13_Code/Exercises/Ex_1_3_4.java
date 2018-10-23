import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Ex_1_3_4
{
    public static void main(String[] args)
    {
        Stack<Character> ops = new Stack<Character>();
        boolean match = true;
        Character temp;

        while (!StdIn.isEmpty())
        { // Read token, push if operator.
            Character s = StdIn.readChar();
            if (s == ('(')) {
                ops.push(s);
                //StdOut.println(s);

            }   
            else if (s == ('[')) 
            {
                ops.push(s);
                //StdOut.println(s);

            }
            else if (s == ('{')){
                ops.push(s);
                //StdOut.println(s);

            } 
            else if (s == (')')) {
                temp = ops.pop();
                //StdOut.printf("%c %c\n", temp, s);
                if (!(temp == '('))
                    match = false;
                //StdOut.println(match);

            }
            else if (s == ('}')) {
                temp = ops.pop();
                //StdOut.printf("%s %s\n", temp, s);
                if (!(temp == '{'))
                    match = false;
                    //StdOut.println(match);

            }else if (s == (']'))
            {
                temp = ops.pop();
                //StdOut.printf("%s %s\n", temp, s);
                if (!(temp=='['))
                    match = false;
                 //   StdOut.println(match);
            }
        }
        StdOut.println(match);
    }
}
