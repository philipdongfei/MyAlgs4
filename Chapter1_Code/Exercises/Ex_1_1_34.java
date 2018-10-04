import java.util.*;
import edu.princeton.cs.algs4.*;

public class Ex_1_1_34
{
    public static void main(String[] args)
    {
        double res = 0.0, max = 0, min = 1;
        int cnt = 0;
        List<Double> list = new ArrayList<>();

        while (!StdIn.isEmpty())
        {
            res = StdIn.readDouble();

            list.add(res);
            if (res > max)
                max = res;
            if (res < min)
                min = res;
        }
        Double[] newArray = list.toArray(new Double[list.size()]);
        Arrays.sort(newArray);
        
        for (int i=0; i<newArray.length; i++)
            StdOut.println(newArray[i]+" ");
        StdOut.printf("max=%f\n", max);
        StdOut.printf("min=%f\n", min);
    }

}
