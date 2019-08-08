import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//import Ex5_2_6;

public class Ex20_ContainsPrefix{
    public static void main(String[] args){
        Ex5_2_6.StringSET st = new Ex5_2_6().new StringSET();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.add(key);
        }
        String prefix = args[0];
        StdOut.println("Contains prefix "+ prefix + ": " + st.containsPrefix(prefix));

    }
}
