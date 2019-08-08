import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.StringJoiner;
import util.Constants;


public class Ex22_TypingMonkeys {
    public double[] getFrequencyDistribution(int numberOfWords, double probability){
        int wordsGenerated = 0;
        SeparateChainingHashST<Integer, Integer> frequencyMap = new SeparateChainingHashST<>();
        int maxWordLength = 0;

        Ex5_2_6.StringSET wordsGeneratedStringSet = new Ex5_2_6().new StringSET();

        while (wordsGenerated < numberOfWords){
            StringBuilder currentWord = new StringBuilder();

            while (true){
                double currentProbability = StdRandom.uniform();
                int characterIndexToAppend = (int)(currentProbability/ probability);

                // valid characters are in the range[0,25]
                // finish probability 1-26p(except 26)
                boolean shouldFinishWord = characterIndexToAppend >= 26;


                if (shouldFinishWord){
                    String word = currentWord.toString();
                    if (wordsGeneratedStringSet.contains(word)){
                        // word was already generated, so we do not count it
                        break;
                    } else {
                        wordsGeneratedStringSet.add(word);
                    }
                    wordsGenerated++;

                    int currentWordLength = currentWord.length();
                    if (currentWordLength > maxWordLength){
                        maxWordLength = currentWordLength;
                    }

                    int frequencyCount = 0;
                    if (frequencyMap.contains(currentWordLength)){
                        frequencyCount = frequencyMap.get(currentWordLength);
                    }
                    frequencyCount++;
                    frequencyMap.put(currentWordLength, frequencyCount);
                    break;
                }
                int nextCharacterIndex = Constants.ASC_II_UPPERCASE_LETTERS_INITIAL_INDEX + characterIndexToAppend;
                currentWord.append((char)nextCharacterIndex);
            }
        }
        double[] frequencies = new double[maxWordLength + 1];
        for (int wordLength : frequencyMap.keys()){
            double wordLengthFrequency = frequencyMap.get(wordLength)/(double)numberOfWords;
            frequencies[wordLength] = wordLengthFrequency;
        }
        return frequencies;
    }
    public static void main(String[] args){
        double probability = Double.parseDouble(args[0]);
        int numberOfWords = Integer.parseInt(args[1]);

        if (probability >= 0.03846)
            throw new IllegalArgumentException("Probability must be less than 0.03846(1/26)");
        double[] frequencies = new Ex22_TypingMonkeys().getFrequencyDistribution(numberOfWords, probability);
        StdOut.println("Frequency distribution estimate\n");
        for (int i = 0; i < frequencies.length; i++){
            StdOut.printf("%12s %.3f\n", "length " + i + ": ", frequencies[i]);
        }
    }
}

