import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Arrays;
import java.util.StringJoiner;
//import util.ArrayUtil;

public class Ex17_InPlaceKeyIndexedCounting {
    private class Element implements Comparable<Element> {
        String value;
        int originalIndex;

        Element(String value, int originalIndex){
            this.value = value;
            this.originalIndex = originalIndex;
        }
        @Override
        public int compareTo(Element other){
            return this.value.compareTo(other.value);
        }
    }
    public static void exchange(Element[] a, int i, int j){
            String t_v = a[i].value;
            int t_index = a[i].originalIndex;
            a[i].value = a[j].value;
            a[i].originalIndex = a[j].originalIndex;
            a[j].value = t_v;
            a[j].originalIndex = t_index;
    }
    public class LeastSignificantDigitInPlace {
        public void lsdSort(Element[] array, int stringsLength){
            int alphabetSize = 256; //

            for (int digit = stringsLength - 1; digit >= 0; digit--){
            // sort by key-indexed counting on digitTh char

            // compute frequency counts
                int[] count = new int[alphabetSize + 1];
                int[] startIndex = new int[alphabetSize + 1];

                for (int i = 0; i < array.length; i++){
                    int digitIndex = array[i].value.charAt(digit);
                    count[digitIndex + 1]++;
                    startIndex[digitIndex+1]++;
                }

                // Transform counts to indices
                for (int r = 0; r < alphabetSize; r++){
                    count[r + 1] += count[r];
                    startIndex[r + 1] += startIndex[r];
                }

                // Distribute
                for (int i = 0; i < array.length; i++){
                    // countinue placing items in the correct place until array[i] is in the correct place
                    while(true){
                        int digitIndex = array[i].value.charAt(digit);

                        // Do not move items that are already in the correct place
                        if (startIndex[digitIndex] <= i && i < count[digitIndex]){
                            break;
                        }
                        int newIndex = count[digitIndex]++;
                        exchange(array, i, newIndex);
                    }
                }

            }
        }
    }
    public class MostSignificantDigitInPlace {
        private int alphabetSize = 256;
        private final int CUTOFF = 15;

        public void msdSort(Element[] array){
            sort(array, 0, array.length-1, 0);
        }
        private void sort(Element[] array, int low, int high, int digit){
            // Do not use Insertion sort in this case to prove that the sort is not stable
            if (low > high)
                return;
            // compute frequency counts
            int[] count = new int[alphabetSize + 2];
            int[] startIndex = new int[alphabetSize + 2];

            for (int i = low; i <= high; i++){
                int digitIndex = charAt(array[i].value, digit)+2;
                count[digitIndex]++;
                startIndex[digitIndex]++;
            }

            // Transform counts to indices
            for (int r = 0; r < alphabetSize + 1; r++){
                count[r+1] += count[r];
                startIndex[r+1] += startIndex[r];
            }

            // Distribute
            for (int i = low; i <= high; i++){
                // countinue placing items in the correct place until array[i] is in the correct place.
                while (true){
                    int digitIndex = charAt(array[i].value, digit) + 1;

                    // do not move items that are already in the correct place.
                    if (startIndex[digitIndex] + low <= i && i < count[digitIndex]+low){
                        break;
                    }
                    int newIndex = count[digitIndex]++;
                    exchange(array, i, newIndex+low);
                }
            }
            // recursively sort for each character value
            for (int r = 0; r < alphabetSize; r++){
                sort(array, low + count[r], low + count[r+1] - 1, digit + 1);

            }

        }
        private int charAt(String s, int digit){
            if (digit < s.length()){
                return s.charAt(digit);
            } else {
                return -1;
            }
        }
        // Insertion sort for strings whose first digit characters are equal.
        public class InsertionSort{
            public void sort(Element[] array, int low, int high, int digit){
                // sort from array[low] to array[high], starting at the digitTh character
                for (int i = low; i <= high; i++){
                    for (int j = i; j > low && less(array[j].value, array[j-1].value, digit); j--){
                        exchange(array, j, j-1);
                    }
                }
            }
            private boolean less(String s1, String s2, int digit){
                for (int i = digit; i < Math.min(s1.length(), s2.length()); i++ ){
                    if (s1.charAt(i) < s2.charAt(i)){
                        return true;
                    } else if (s1.charAt(i) > s2.charAt(i)){
                        return false;
                    }
                }
                return s1.length() < s2.length();
            }
        }
    }

    public static void main(String[] args){
        Ex17_InPlaceKeyIndexedCounting ex17 = new Ex17_InPlaceKeyIndexedCounting();

        StdOut.println("In-place LSD tests: ");
        LeastSignificantDigitInPlace lsdInplace = 
            ex17.new LeastSignificantDigitInPlace();
        String[] a = StdIn.readAllStrings();

        Element[] arrays = new Element[a.length];
        for (int i = 0; i < a.length; i++){
            arrays[i] = ex17.new Element(a[i], i);
        }
        int stringLength1 = 7;
        lsdInplace.lsdSort(arrays, stringLength1);

        StringJoiner sortedArray = new StringJoiner(" ");

        for (Element element : arrays){
            sortedArray.add(element.value);
        }
        StdOut.println("Sorted array: " + sortedArray);

    }

}
