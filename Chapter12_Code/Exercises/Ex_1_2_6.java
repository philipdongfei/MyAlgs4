import edu.princeton.cs.algs4.*;
import java.util.*;

public class Ex_1_2_6
{
    public static boolean CheckCR(String s1, String s2)
    {
        boolean isCR = false;
        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 == length2)
        {
            for(int i = 0; i < length1; i++)
            {
                String sub1 = s1.substring(0,i+1);
                String sub2 = s2.substring(length2-sub1.length(),length2);
                //StdOut.println(sub1);
                //StdOut.println(sub2);
                if (sub1.equals(sub2))
                {
                    sub1 = s1.substring(i+1,length1);
                    sub2 = s2.substring(0, length2-(i+1));
                    //StdOut.println(sub1);
                    //StdOut.println(sub2);
                    if (sub1.equals(sub2))
                        isCR = true;
                }
            }
        }
        return isCR;
    }

    public static void main(String[] args)
    {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";

        StdOut.printf("%s and %s is Circular Rotation: ",s2,s1);
        StdOut.println(CheckCR(s2,s1));
        
    }
}
