import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Ex19_RandomCALicensePlates {
    public static String[] randomPlatesCA(int numberOfStrings){
        String[] plates = new String[numberOfStrings];

        for (int plate = 0; plate < numberOfStrings; plate++){
            StringBuilder current = new StringBuilder();
            //California license plates have 1 initial digit, 3 uppercase letters and 3 final digits
            int initialDigit = StdRandom.uniform(10);
            current.append(initialDigit);

            // letters
            for (int digit = 0; digit < 3; digit++){
//                char letter = (char)StdRandom.uniform(Constants.ASC_II_UPPERCASE_LETTERS_INITIAL_INDEX, Constants.ASC_II_UPPERCASE_LETTERS_FINAL_INDEX + 1);
                char letter = (char)('A' + StdRandom.uniform('Z'-'A'+1));
                current.append(letter);
            }
            // final digits
            for (int digit = 0; digit < 3; digit++){
                int digitValue = StdRandom.uniform(10);
                current.append(digitValue);
            }
            plates[plate] = current.toString();
        }
        return plates;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        String[] randomPlates = Ex19_RandomCALicensePlates.randomPlatesCA(N);

        StdOut.println("Random CA license plates: ");

        for (String s : randomPlates){
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}



