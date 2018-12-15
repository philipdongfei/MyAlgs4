import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_11
{
    public static void main(String[] args)
    {
        try {
            SmartDate date = new SmartDate(1, 32, 1999);

        } catch (RuntimeException e)
        {
            System.err.println("RuntimeException: "+e.getMessage());
        }
    }
}
