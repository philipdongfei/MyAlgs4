import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Ex18_RandomDecimalKeys {
    public static String[] randomDecimalKeys(int numberOfStrings, 
            int numberOfDigits){
        String[] number = new String[numberOfStrings];
        for (int string = 0; string < numberOfStrings; string++){
            StringBuilder current = new StringBuilder();

            for (int digit = 0; digit < numberOfDigits; digit++){
                int digitValue = StdRandom.uniform(10);
                current.append(digitValue);
            }
            number[string] = current.toString();
        }
        return number;
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);

        String[] random = Ex18_RandomDecimalKeys.randomDecimalKeys(N, W);
        StdOut.println("Random generated: ");

        for(String s : random){
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
