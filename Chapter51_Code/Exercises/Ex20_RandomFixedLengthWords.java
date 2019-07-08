import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Ex20_RandomFixedLengthWords {
    // Assuming that the alphabet includes numbers, letters and special characters
    public static String[] randomFixedLengthWords(int numberOfStrings,
            int numberOfCharacters){
        String[] Words = new String[numberOfStrings];
        int initialCharInASCIITable = (byte)'A';
        int finalCharInASCIITable = 'Z'-'A';

        for (int string = 0; string < numberOfStrings; string++){
            StringBuilder current = new StringBuilder();

            for (int character = 0; character < numberOfCharacters; character++){
                //char characterValue = (char)StdRandom.uniform('A', 'Z'-'A'+1);
                char characterValue; 
                int select = StdRandom.uniform(3);
                if (select == 0)
                    characterValue = (char)('a' + StdRandom.uniform('z'-'a'+1));
                else if (select == 1)
                    characterValue = (char)('A' + StdRandom.uniform('Z'-'A'+1));
                else
                    characterValue = (char)('0' + StdRandom.uniform('9'-'0'+1));



                //while(true){
                   // if (characterValue < 219 && characterValue > 224)
                   //     break;

                //}
                current.append(characterValue);

            }
            Words[string] = current.toString();
        }
        return Words;
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);

        String[] randomWords = Ex20_RandomFixedLengthWords.randomFixedLengthWords(N, W);
        StdOut.println("Random words: ");
        for (String w : randomWords)
            StdOut.print(w + "   ");
        StdOut.println();

    }
}
