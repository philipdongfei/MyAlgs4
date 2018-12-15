import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_10
{
    public static void main(String[] args)
    {
        VisualCounter vcounter = new VisualCounter("test", 4, 5);

        for (int i = 0; i < 10; i++)
        {
                //vcounter.increment();
                vcounter.decrement();
        }

        StdOut.println(vcounter);
    }
}
