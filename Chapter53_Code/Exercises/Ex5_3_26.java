import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex5_3_26 {
    public boolean isCyclicRoatation(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        String concatenatedString = str1 + str1;
        RabinKarp rk = new RabinKarp(str2, true);
        return rk.search(concatenatedString) != concatenatedString.length();
    }

    public static void main(String[] args){
        Ex5_3_26 ex26 = new Ex5_3_26();
        String str1 = args[0];
        String str2 = args[1];
        boolean check1 = ex26.isCyclicRoatation(str1, str2); 
        StdOut.println(str1+str1);
        StdOut.println(str2);
        StdOut.println("Check: " + check1);
    }
}
