import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex5_1_9 {
    public class LSDVariableLength {
        public void lsdSort(String[] array){
            if (array == null || array.length == 0)
                return;
            int alphabetSize = 256;
            String[] aux = new String[array.length];
            int maxStringLength = getMaxStringLength(array);
            for (int digit = maxStringLength-1; digit >= 0; digit--){
                // sort by key-indexed counting on digthTh char
                // compute frequency counts
                int count[] = new int[alphabetSize+1];
                for (int i = 0; i < array.length; i++){
                    int digitIndex = charAt(array[i], digit);
                    count[digitIndex + 1]++;
                }
                // Transform counts to indices
                for (int r = 0; r < alphabetSize; r++)
                    count[r+1] += count[r];
                // Distribute
                for (int i = 0; i < array.length; i++){
                    int digitIndex = charAt(array[i], digit);
                    int indexInAuxArray = count[digitIndex]++;
                    aux[indexInAuxArray] = array[i];
                }
                // copy back
                for (int i = 0; i < array.length; i++)
                    array[i] = aux[i];
            }
        }
        private int getMaxStringLength(String[] str){
            int maxLength = -1;
            for (String s : str){
                if (s.length() > maxLength)
                    maxLength = s.length();
            }
            return maxLength;
        }
        // if digit is non-existent, return 0, which is the smallest value possible
        private int charAt(String str, int digit){
            if (digit < str.length()){
                return str.charAt(digit);
            } else {
                return 0;
            }

        }
    }
    public static void main(String[] args){
        LSDVariableLength lsd = new Ex5_1_9().new LSDVariableLength();
        String[] a = StdIn.readAllStrings();
        for(String s : a)
            StdOut.print(s + " ");
        lsd.lsdSort(a);
        StdOut.println("sort: ");
        for(String s : a)
            StdOut.print(s + " ");
        StdOut.println();
    }
}
