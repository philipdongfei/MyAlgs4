import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class Ex5_3_15 {
    public class BruteForceRL {
        private String pattern;
        private int patternLength;

        BruteForceRL(String pattern){
            this.pattern = pattern;
            patternLength = pattern.length();
        }
        public int search(String text){
            int textLength = text.length();

            for (int textIndex = 0; textIndex <= textLength - patternLength; textIndex++)
            {
                int patternIndex;
                for (patternIndex = patternLength - 1; patternIndex >= 0;
                        patternIndex--)
                {
                    if (text.charAt(textIndex + patternIndex) != pattern.charAt(patternIndex))
                    {
                        break;
                    }
                }
                if (patternIndex == -1)
                    return textIndex;
            }
            return textLength;
        }
    }
    public static void main(String[] args){
        Ex5_3_15 ex15 = new Ex5_3_15();

        String text = "abacadabrabracabracadabrabrabracad";
        String pattern = "abracadabra";

        BruteForceRL bt = ex15.new BruteForceRL(pattern);
        int index = bt.search(text);
        StdOut.println("Index: " + index + " Expected: 14");
    }

}
