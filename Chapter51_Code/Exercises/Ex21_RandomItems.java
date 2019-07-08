import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Ex21_RandomItems {
    public static String[] randomItems(int numberOfStrings, char[] givenValues){
        String[] items = new String[numberOfStrings];

        String[] fourCharacterFixedStrings = 
            Ex20_RandomFixedLengthWords.randomFixedLengthWords(10, 4);
        String[] tenCharacterFixedStrings = 
            Ex20_RandomFixedLengthWords.randomFixedLengthWords(50, 10);
        for (int string = 0; string < numberOfStrings; string++){
            StringBuilder current = new StringBuilder();

            // 4-character field
            int random4CharacterStringIndex = StdRandom.uniform(fourCharacterFixedStrings.length);
            current.append(fourCharacterFixedStrings[random4CharacterStringIndex]);

            // 10-character field
            int random10CharacterStringIndex = StdRandom.uniform(tenCharacterFixedStrings.length);
            current.append(tenCharacterFixedStrings[random10CharacterStringIndex]);
            // 1-character field
            int givenValueId = StdRandom.uniform(2);
            current.append(givenValues[givenValueId]);

            // Variable 4 to 15 characters field
            int variableLengthFieldSize = StdRandom.uniform(4, 15+1);

            for (int character = 0; character < variableLengthFieldSize; character++){
                char characterValue;
                int isUpperCaseLetter = StdRandom.uniform(2);

                if (isUpperCaseLetter == 0){
                    characterValue = (char)('a' + StdRandom.uniform('z'-'a'+1));
                } else {
                    characterValue = (char)('A' + StdRandom.uniform('Z'-'A'+1));
                }
                current.append(characterValue);
            }
            items[string] = current.toString();
        }
        return items;
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        char[] givenValues = {'A', 'B'};

        String[] randomItems = Ex21_RandomItems.randomItems(N, givenValues);
        StdOut.println("Random items: ");
        for (String item : randomItems){
            StdOut.println(item);
        }
        StdOut.println();
    }

}
