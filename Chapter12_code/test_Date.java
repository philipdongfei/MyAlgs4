import edu.princeton.cs.algs4.*;
import java.util.*;

public class test_Date
{
    public static void main(String[] args)
    {
        Date a = new Date(12,31,1999);
        Date b = new Date(1,1,2011);
        a = b;
    
        StdOut.println(a);
    }

}
