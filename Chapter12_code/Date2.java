import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Date2
{
    private final int value;

    public Date2(int m, int d, int y)
    {
        value = y*512+m*32+d;
    }

    public int month()
    {
        return (value/32)%16;
    }
    public int day()
    {
        return value % 32;

    }
    public int year()
    {
        return value / 512;
    }

    public String toString()
    {
        return month() + "/"+ day()
            + "/" + year();
    }

    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        Date1 date = new Date1(m, d, y);
        StdOut.println(date);
    }

}
