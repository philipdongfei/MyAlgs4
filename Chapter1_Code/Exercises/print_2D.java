import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class print_2D
{
    public static void main(String[] args)
    {
        boolean[][] a;
        a = new boolean[5][5];
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (j % 2 == 0)
                    a[i][j] = true;
                else
                    a[i][j] = false;

            }
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j=0; j<5; j++)
            {
                if (a[i][j])
                    StdOut.printf("a[%d][%d]:*",i,j);
                else
                    StdOut.printf("a[%d][%d]: ",i,j);
            }
            StdOut.println('\n');
        }

        

        int[] b = new int[10];
        for (int i = 0; i < 10; i++)
            b[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            b[i] = b[b[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);

        int[][] c;
        c = new int[3][4];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                c[i][j] = i+1+j;
                StdOut.printf("%d ", c[i][j]);
            }
            StdOut.println('\n');

        }   
        StdOut.println("transposition:\n");

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++)
                StdOut.printf("%d ", c[i][j]);
            StdOut.println('\n');

        }
    }

}

