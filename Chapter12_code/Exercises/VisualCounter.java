import edu.princeton.cs.algs4.*;
import java.util.*;


public class VisualCounter
{

    private final String name;
    private int count;
    private int N;
    private int max;

    public VisualCounter(String id, int NOper, int MaxVal)
    {
        name = id;
        N = NOper;
        max = MaxVal;

    }
    public void increment()
    { 
        if (N > 0 &&  Math.abs(count) < max)
            count++; 
    }
    public void decrement()
    { 
        if (N > 0 &&  Math.abs(count) < max)
            count--; 
    }
    public int tally()
    {
        return count;
    }
    public String toString()
    {
        return count+" "+name;
    }
}
