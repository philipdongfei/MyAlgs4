import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex5_3_4 {
    public int findBlankCharacters(String txt, int mSpaces){
        StringBuilder pattern = new StringBuilder();

        for (int space = 0; space < mSpaces; space++){
            pattern.append(" ");
        }

        KMP kmp = new KMP(pattern.toString());
        return kmp.search(txt);
    }

    public static void main(String[] args){
        Ex5_3_4 ex4 = new Ex5_3_4();

        String txt = " abacada  abr   braca  brabrabracad";

        int index1 = ex4.findBlankCharacters(txt, 1);
        StdOut.println("Index 1: " + index1);

        int index2 = ex4.findBlankCharacters(txt, 2);
        StdOut.println("Index 2: " + index2);

        int index3 = ex4.findBlankCharacters(txt, 3);
        StdOut.println("Index 3: " + index3);
        
        int index4 = ex4.findBlankCharacters(txt, 4);
        StdOut.println("Index 4: " + index4);
    }
}

