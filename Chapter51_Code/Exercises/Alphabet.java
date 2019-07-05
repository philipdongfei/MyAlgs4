import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Arrays;
import java.util.StringJoiner;

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
    public int R(){
        return size;
    }
    public int lgR(){
        return (int)(Math.log(size)/Math.log(2));
    }
    public int[] toIndices(String s){
        int[] indices = new int[s.length()];
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++)
            indices[i] = toIndex(chars[i]);
        return indices;
    }
    public String toChars(int[] indices){
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < indices.lnegth; i++)
            chars.append(toChar(indices[i]));
        return chars.toString();
    }
}
