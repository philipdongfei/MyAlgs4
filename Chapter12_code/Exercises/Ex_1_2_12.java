import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_12
{
    public static void main(String[] args)
    {
        try {
            int m = Integer.parseInt(args[0]);
            int d = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);

            SmartDate date = new SmartDate(m, d, y);
            StdOut.println(date.dayOfTheWeek());

        } catch (RuntimeException e)
        {
            System.err.println("RuntimeException: "+e.getMessage());
        }
    }
}
