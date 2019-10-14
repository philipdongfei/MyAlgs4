import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class Ex5_3_14 {
    private interface SubstringSearchCharArray {
        int search(char[] text);
        int count(char[] text);
        Iterable<Integer> findAll(char[] text);
    }

    public class BruteForceSubstring implements SubstringSearchCharArray {
        private char[] pattern;
        private int patternLength;

        public BruteForceSubstring(char[] pattern){
            this.pattern = pattern;
            patternLength = pattern.length;
        }
        public int search(char[] text){
            return searchFromIndex(text, 0);
        }
        private int searchFromIndex(char[] text, int textStartIndex){
            int textLength = text.length;

            for (int textIndex = textStartIndex; textIndex <= textLength - patternLength; textIndex++) {
                int patternIndex;

                for (patternIndex = 0; patternIndex < patternLength; patternIndex++)
                {
                    if (text[textIndex + patternIndex] != pattern[patternIndex]) {
                        break;
                    }
                }
                if (patternIndex == patternLength){
                    return textIndex; //found
                }
            }
            return textLength; // not found
        }

        public int search2(char[] text){
            int textLength = text.length;

            int textIndex;
            int patternIndex;
            for (textIndex = 0, patternIndex = 0; textIndex < textLength && patternIndex < patternLength; textIndex++)
            {
                if (text[textIndex] == pattern[patternIndex]){
                    patternIndex++;
                } else {
                    textIndex -= patternIndex;
                    patternIndex = 0;
                }
            }
            if (patternIndex == patternLength){
                return textIndex - patternLength; // found
            } else {
                return textLength; // not found;
            }
        }

        public int count(char[] text){
            int count = 0;

            int occurrenceIndex = searchFromIndex(text, 0);

            while (occurrenceIndex != text.length){
                count++;
                occurrenceIndex = searchFromIndex(text, occurrenceIndex + 1);

            }
            return count;
        }
        public Iterable<Integer> findAll(char[] text){
            Queue<Integer> offsets = new Queue<>();

            int occurrenceIndex = searchFromIndex(text, 0);

            while (occurrenceIndex != text.length){
                offsets.enqueue(occurrenceIndex);
                occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
            }
            return offsets;
        }
    }

    public class KMPSubstring implements SubstringSearchCharArray {
        private char[] pattern;
        private int[][] dfa; //

        public KMPSubstring(char[] pattern){
            if (pattern == null || pattern.length == 0){
                throw new IllegalArgumentException("Invalid pattern");
            }

            this.pattern = pattern;

            int patternLength = pattern.length;
            int alphabetSize = 256;

            dfa = new int[alphabetSize][patternLength];
            dfa[pattern[0]][0] = 1;

            int restartState = 0;

            for (int patternIndex = 1; patternIndex < patternLength; patternIndex++){
                for (int currentChar = 0; currentChar < alphabetSize; currentChar++){
                    dfa[currentChar][patternIndex] = patternIndex + 1;
                    restartState = dfa[pattern[patternIndex]][restartState];
                }
            }
        }

        public int search(char[] text){
            return searchFromIndex(text, 0);
        }

        private int searchFromIndex(char[] text, int textStartIndex){
            int textIndex;
            int patternIndex;
            int textLength = text.length;
            int patternLength = pattern.length;

            for (textIndex = textStartIndex, patternIndex = 0;
                    textIndex < textLength && patternIndex < patternLength; textIndex++)
            {
                patternIndex = dfa[text[textIndex]][patternIndex];
            }
            if (patternIndex == patternLength){
                return textIndex - patternLength;
            } else {
                return textLength;
            }
        }

        public int count(char[] text){
            int count = 0;
            int occurrenceIndex = searchFromIndex(text, 0);

            while (occurrenceIndex != text.length){
                count++;
                occurrenceIndex = searchFromIndex(text, occurrenceIndex+1);
            }
            return count;
        }

        public Iterable<Integer> findAll(char[] text){
            Queue<Integer> offsets = new Queue<>();

            int occurrenceIndex = searchFromIndex(text, 0);

            while (occurrenceIndex != text.length){
                offsets.enqueue(occurrenceIndex);
                occurrenceIndex = searchFromIndex(text,
                        occurrenceIndex + 1);
            }
            return offsets;
        }
    }

    public static void main(String[] args){
        Ex5_3_14 ex14 = new Ex5_3_14();

        StdOut.println("*** Bruteforce implementation tests ***");
        ex14.test(0);
        StdOut.println("*** Knuth Morris Pratt tests ***");
        ex14.test(1);
    }
    private void test(int MethodId){
        String text = "abcdrenetestreneabdreneabcdd";
        char[] textCharArray = text.toCharArray();

        char[] pattern1 = {'r', 'e', 'n', 'e'};

        SubstringSearchCharArray sub1 = createSubstringSearchCharArray(MethodId, pattern1);

        if (sub1 == null)
            return;

        int search1 = sub1.search(textCharArray);
        StdOut.println("Index 1: " + search1 + " Excepted: 4");
    }

    private SubstringSearchCharArray createSubstringSearchCharArray(int MethodId, char[] pattern){
        SubstringSearchCharArray sub = null;

        switch(MethodId){
            case 0:
                sub = new BruteForceSubstring(pattern);
                break;
            case 1:
                sub = new KMPSubstring(pattern);
                break;
            case 2:
                break;
            case 3:
                break;
            default: 
                break;
        }
        return sub;
    }
}
