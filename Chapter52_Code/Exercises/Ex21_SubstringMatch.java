import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import java.util.StringJoiner;

public class Ex21_SubstringMatch {
    public interface SubstringMatchAPI{
        void putAllSuffixes(String key);
        Iterable<String> keysWithSubstring(String substring);
    }
    public class SubstringMatch implements SubstringMatchAPI {
        private TST<String> tst;
        SubstringMatch(Queue<String> strings){
            tst = new TST<>();
            for (String s : strings){
                putAllSuffixes(s);
            }
        }
        @Override
        public void putAllSuffixes(String key){
            if (key == null)
                throw new IllegalArgumentException("key cannot be null");
            for (int i = 0; i < key.length(); i++){
                String suffix = key.substring(i, key.length());
                tst.put(suffix, key);
            }
        }
        @Override
        public Iterable<String> keysWithSubstring(String substring){
            SET<String> uniqueKeysWithSubstring = new SET<>();
            for (String key : tst.keysWithPrefix(substring)){
                uniqueKeysWithSubstring.add(key);
            }
            Queue<String> queue = new Queue<>();
            for (String k : uniqueKeysWithSubstring)
                queue.enqueue(k);
            return queue;
        }
    }

    public static void main(String[] args){
        Queue<String>  q = new Queue<>();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            q.enqueue(key);
        }
        SubstringMatch match = new Ex21_SubstringMatch().new SubstringMatch(q);
        String sub = args[0];
        StdOut.println("Keys with substring " + sub);
        StringJoiner keysWithSubstring = new StringJoiner(" ");

        for (String key : match.keysWithSubstring(sub)){
            keysWithSubstring.add(key);
        }
        StdOut.println(keysWithSubstring.toString());


    }
}
