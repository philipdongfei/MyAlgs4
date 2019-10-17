import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex5_3_27 {
    public class KnuthMorrisPrattTandemRepeat {
        private String pattern;
        private int[][] dfa;
        private int baseStringLength;
        private int tandemRepeat;

        public KnuthMorrisPrattTandemRepeat(String baseString, String text)
        {
            if (baseString == null || baseString.length() == 0){
                throw new IllegalArgumentException("Invalid base string");
            }
            if (text == null){
                throw new IllegalArgumentException("invalid text");
            }

            // Create the Knuth-Morris-Pratt DFA for k concatenated copies of baseString, where k = textLength / baseStringLength.
            StringBuilder pattern = new StringBuilder();
            int maxNumberOfRepeats = text.length() / baseString.length();

            for (int repeat = 0; repeat < maxNumberOfRepeats; repeat++){
                pattern.append(baseString);
            }
            this.pattern = pattern.toString();
            int patternLength = pattern.length();
            int alphabetSize = 256;
            baseStringLength = baseString.length();
            tandemRepeat = -1;

            dfa = new int[alphabetSize][patternLength];
            dfa[pattern.charAt(0)][0] = 1;

            int restartState = 0;

            for (int patternIndex = 1; patternIndex < patternLength; patternIndex++)
            {
                // compute dfa[][patternIndex]
                for (int currentChar = 0; currentChar < alphabetSize; currentChar++)
                {
                    dfa[currentChar][patternIndex] = dfa[currentChar][restartState]; //copy mismatch cases
                }
                dfa[pattern.charAt(patternIndex)][patternIndex] = patternIndex + 1;// Set match case.
                restartState = dfa[pattern.charAt(patternIndex)][restartState]; // update restart state

            }
            computeTandemRepeat(text);
        }

        private void computeTandemRepeat(String text)
        {
            int textIndex;
            int patternIndex;

            // A tandem repeat is composed of at least 2 consecutive occurrences of the base string.
            // If 1 occurrence were enough, we would initialize maxPatternIndexMatched with 0.
            int maxPatternIndexMatched = baseStringLength;

            StdOut.println("text: " + text);
            StdOut.println("pattern: " + pattern);
            for (textIndex = 0, patternIndex = 0; textIndex < text.length() && patternIndex < pattern.length(); textIndex++){
                patternIndex = dfa[text.charAt(textIndex)][patternIndex];
                if (patternIndex % baseStringLength == 0 && patternIndex > maxPatternIndexMatched) {
                    StdOut.println("textIndex: " + textIndex);
                    StdOut.println("patternIndex: "+patternIndex);
                    tandemRepeat = textIndex - patternIndex + 1;
                    maxPatternIndexMatched = patternIndex;
                }
            }
        }
        public int findTandemRepeat(){
            return tandemRepeat;
        }
    }

    public static void main(String[] args){
        Ex5_3_27 ex27 = new Ex5_3_27();

        String baseString = args[0];
        String text = args[1];

        KnuthMorrisPrattTandemRepeat check = ex27.new KnuthMorrisPrattTandemRepeat(baseString, text);
        int tandemRepeat = check.findTandemRepeat();
        StdOut.println("Tandem repeat: " + tandemRepeat );
    }
}
