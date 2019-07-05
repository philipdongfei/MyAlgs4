import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Arrays;
import java.util.StringJoiner;

public class SublinearSort {
    public void sort(int[] a) {
        String[] bits = new String[a.length];
        int bitsArrayIndex = 0;

        //Transform all int values to 32 bits
        for (int value : a){
            String binary = getBinaryStringWithInverseLeadingBit(value);
            bits[bitsArrayIndex++] = binary;
        }
        // sort 16 leading bits (from 15 to 0)
        int initialDigitToSortInLSD = 15;
        lsdSort(bits, initialDigitToSortInLSD);

        // sort 16 trailing bits with insertion sort
        Insertion.sort(bits);
        // Transform bits to int values
        for (int i = 0; i < a.length; i++){
            a[i] = getIntFromBinaryStringWithInverseLeadingBit(bits[i]);
        }
    }
    private void lsdSort(String[] bits, int initialDigit){
        int alphabetSize = 2; // Binary digits
        String[] aux = new String[bits.length];
        for (int digit = initialDigit; digit >= 0; digit--){
            // compute frequency counts
            int[] count = new int[alphabetSize + 1];
            for (int i = 0; i < bits.length; i++){
                int bitValue = Character.getNumericValue(bits[i].charAt(digit));
                count[bitValue + 1]++;
            }

            // Transform counts to indices
            for (int r = 0; r < alphabetSize; r++){
                count[r+1] += count[r];
            }
            // Distribute
            for (int i = 0; i < bits.length; i++){
                int bitValue = Character.getNumericValue(bits[i].charAt(digit));
                int indexInAuxArray = count[bitValue]++;
                aux[indexInAuxArray] = bits[i];
            }
            // copy back
            for (int i = 0; i < bits.length; i++)
                bits[i] = aux[i];
        }
    }
    private String getBinaryStringWithInverseLeadingBit(int value){
        StringBuilder binary = new StringBuilder();
        binary.append(Integer.toBinaryString(value));

        int zeroesToPadLeft = 31 - binary.length();
        for (int i = 0; i < zeroesToPadLeft; i++){
            binary.insert(0, "0");
        }
        // The first bit represents if the number is positive (0) or negative (1)
        // It exists if the number is negative, but must be added if it is not.
        // Here we invert the leading bit value so that during the sort, negative values have a lower position
        // than positive values.
        if (value >= 0){
            binary.insert(0, "1");
            
        } else {
            binary.replace(0, 1, "0");
        }
        return binary.toString();
    }
    private int getIntFromBinaryStringWithInverseLeadingBit(String bits){
        int value = 0;
        int bitIndex = 0;
        for (int digit = bits.length() - 1; digit >= 1; digit--){
            if (bits.charAt(digit) == '1'){
                value += Math.pow(2, bitIndex);
            }
            bitIndex++;
        }
        // leading bit is inverted
        boolean isNegativeValue = bits.charAt(0) == '0';
        if (isNegativeValue)
            value -= Math.pow(2, 31);
        return value;
    }

    public static void main(String[] args){
        SublinearSort sort = new SublinearSort();
        int[] array = {
            2147483647,
            1893288285,
            87997899,
            -30,
            2032847926,
            1000,
            0
        };
        sort.sort(array);
        StringJoiner str = new StringJoiner(", ");
        for (int v : array){
            str.add(String.valueOf(v));
        }
        StdOut.println("Sort: " + str);
    }


}
