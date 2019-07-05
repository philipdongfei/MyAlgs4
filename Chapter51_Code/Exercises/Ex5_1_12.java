import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Arrays;
import java.util.StringJoiner;

public class Ex5_1_12 {
    public interface AlphabetAPI {
        char toChar(int index); // convert index to corresponding alphabet char
        int toIndex(char c); //convert character to an index between 0 and R-1
        boolean contains(char c); //is character in the alphabet?
        int R();  // radix(number of characters in alphabet)
        int lgR(); // number of bits to represent an index
        int[] toIndices(String s);//
        String toChars(int[] indices);// convert base-R integer to string over this alphabet
    
    }
    
    public class Alphabet implements AlphabetAPI {
        private SeparateChainingHashST<Character, Integer> charToIndexMap;
        private char[] indexToChar;
        private int size;
    
        public Alphabet(String s){
            indexToChar = s.toCharArray();
            Arrays.sort(indexToChar);
            size = indexToChar.length;
    
            charToIndexMap = new SeparateChainingHashST<>();
            for (int i = 0; i < indexToChar.length; i++)
                charToIndexMap.put(indexToChar[i], i);
        }
        public char toChar(int index){
            if (index < 0 || index >= R())
                throw new IllegalArgumentException("Index must be between 0 and " + (R()-1));
            return indexToChar[index];
        }
        public int toIndex(char c){
            if (!contains(c))
                throw new IllegalArgumentException("Character " + c + " is not");
            return charToIndexMap.get(c);
        }
        public boolean contains(char c){
            return charToIndexMap.contains(c);
        }
        public int R(){
            return size;
        }
        public int lgR(){
            return (int)(Math.log(size)/Math.log(2));
        }
        public int[] toIndices(String s){
            int[] indices = new int[s.length()];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++)
                indices[i] = toIndex(chars[i]);
            return indices;
        }
        public String toChars(int[] indices){
            StringBuilder chars = new StringBuilder();
            for (int i = 0; i < indices.length; i++)
                chars.append(toChar(indices[i]));
            return chars.toString();
        }
    }
    public class LSDGeneralAlphabet {
        public void lsdSort(AlphabetAPI alphabet, String[] a, int stringsLength){
            int alphabetSize = alphabet.R();
            String[] auxArray = new String[a.length];

            for (int digit = stringsLength-1; digit >= 0; digit--){
                // sort by key-indexed couting on digitTh char
                // compute frequency counts
                int[] count = new int[alphabetSize + 1];
                for (int i = 0; i < a.length; i++){
                    int index = alphabet.toIndex(a[i].charAt(digit));
                    count[index + 1]++;
                }
                // Transform counts to indices
                for (int r = 0; r < alphabetSize; r++){
                    count[r+1] += count[r];
                }
                // Distribute
                for (int i = 0; i < a.length; i++){
                    int index = alphabet.toIndex(a[i].charAt(digit));
                    int indexInAux = count[index]++;
                    auxArray[indexInAux] = a[i];
                }
                // copy back
                for (int i = 0; i < a.length; i++)
                    a[i] = auxArray[i];
            }
        }
    }
    public class MSDGeneralAlphabet {
        private int alphabetSize;
        private final int CUTOFF = 15;
        private String[] aux;

        private AlphabetAPI alphabet;

        public void msdSort(AlphabetAPI alphabet, String[] a){
            alphabetSize = alphabet.R();
            this.alphabet = alphabet;

            aux = new String[a.length];
            sort(a, 0, a.length-1, 0);
        }
        private void sort(String[] a, int low, int high, int digit){
            // sort from low to high, starting at the digitTh character
            if (high <= low + CUTOFF){
                insertion(a, low, high, digit);
                return;
            }
            // compute frequency counts
            int[] count = new int[alphabetSize + 2];
            for (int i = low; i <= high; i++){
                int index = charAt(a[i], digit) + 2;
                count[index]++;
            }
            // Transform counts to indices
            for (int r = 0; r < alphabetSize + 1; r++){
                count[r+1] += count[r];
            }
            //distribute
            for (int i = low; i <= high; i++){
                int index = charAt(a[i], digit) + 1;
                int indexInAux = count[index]++;
                aux[indexInAux] = a[i];
            }
            // copy back
            for (int i = low; i <= high; i++){
                a[i] = aux[i-low];
            }
            // Recursively sort for each character value
            for (int r = 0; r < alphabetSize; r++)
                sort(a, low+count[r], low+count[r+1]-1, digit+1);
        }
        private int charAt(String s, int digit){
            if (digit < s.length()){
                return alphabet.toIndex(s.charAt(digit));

            } else {
                return -1;
            }
        }

        // insertion sort a[lo..hi], starting at dth character
        private void insertion(String[] a, int lo, int hi, int d)
        {
            for (int i = 0; i <= hi; i++)
                for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                    exch(a, j, j-1);
        }

        // exchange a[i] and a[j]
        private void exch(String[] a, int i, int j){
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        // is v less than w, starting at character d
        private boolean less(String v, String w, int d){
            // assert v.substring(0, d).equals(w.substring(0, d));
            for (int i = d; i < Math.min(v.length(), w.length()); i++){
                if (v.charAt(i) < w.charAt(i)) return true;
                if (v.charAt(i) > w.charAt(i)) return false;
            }
            return v.length() < w.length();
        }
    }
    public static void main(String[] args){
        Ex5_1_12 ex12 = new Ex5_1_12();

        String alphabetTable = "3ABDFJLMQRSWacdeghijklmnorstuwy";
        AlphabetAPI alphabet = ex12.new Alphabet(alphabetTable);

        StdOut.println("test:");
        char c1 = alphabet.toChar(0);
        StdOut.println("c1 = " + c1);
        char c2 = alphabet.toChar(10);
        StdOut.println("c2 = " + c2);
        StdOut.println();
        StdOut.println("Contains R: " + alphabet.contains('R'));
        StdOut.println("Contains Z: " + alphabet.contains('Z'));
        StdOut.println();

        String[] a = StdIn.readAllStrings();
        StdOut.println("lsd sort: ");
        String alphabetTable1 = "0123456789ACEGIJHKLOPRTVWYZ";
        AlphabetAPI alphabet1 = ex12.new Alphabet(alphabetTable1);

        LSDGeneralAlphabet lsd = ex12.new LSDGeneralAlphabet();
        int len = 7;
        lsd.lsdSort(alphabet1, a, len);
        StringJoiner sortedArray = new StringJoiner(" ");
        
        for (String s : a){
            sortedArray.add(s);
        }
        StdOut.println(sortedArray);
        StdOut.println();
        /*
        StdOut.println("msd sort: ");
        MSDGeneralAlphabet msd = ex12.new MSDGeneralAlphabet();
        msd.msdSort(alphabet1, a);
        StringJoiner sortedArray = new StringJoiner(" ");
        
        for (String s : a){
            sortedArray.add(s);
        }
        StdOut.println(sortedArray);
        StdOut.println();
        */





    }

}
