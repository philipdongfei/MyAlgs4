import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.StringJoiner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Ex5_2_6 {
    public interface StringSETAPI {
        void add(String key);
        void delete(String key);
        boolean contains(String key);
        boolean isEmpty();
        int size();
        String toString();
    } 

    public class StringSET implements StringSETAPI {
        private class Node {
            private SeparateChainingHashST<Character, Node> next =
                new SeparateChainingHashST<>();
            boolean isKey;
        }

        private Node root = new Node();
        private int size;

        @Override
        public int size(){
            return size;
        }
        @Override
        public boolean isEmpty(){
            return size() == 0;
        }

        @Override
        public boolean contains(String key){
            if (key == null){
                throw new IllegalArgumentException("key cannot be null");
            }
            return contains(root, key, 0);
        }
        private boolean contains(Node node, String key, int digit){
            if (node == null){
                return false;
            }
            if (digit == key.length()){
                return node.isKey;
            }

            char nextChar  = key.charAt(digit);

            if (node.next.contains(nextChar)){
                return contains(node.next.get(nextChar),
                        key, digit + 1);
            } else {
                return false;
            }
        }
        @Override
        public void add(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            if (contains(key)){
                return;
            }
            root = add(root, key, 0);
            size++;
        }

        private Node add(Node node, String key, int digit){
            if (node == null){
                node = new Node();
            }
            if (digit == key.length()){
                node.isKey = true;
                return node;
            }
            char nextChar = key.charAt(digit);

            Node nextNode = add(node.next.get(nextChar), key, 
                    digit+1);
            node.next.put(nextChar, nextNode);
            return node;
        }
        @Override
        public void delete(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            if (!contains(key)){
                return;
            }
            root = delete(root, key, 0);
            size--;
        }

        private Node delete(Node node, String key, int digit){
            if (digit == key.length()){
                node.isKey = false;
            } else {
                char nextChar = key.charAt(digit);
                Node childNode = delete(node.next.get(nextChar),
                        key, digit+1);
                node.next.put(nextChar, childNode);
            }
            if (node.isKey || node.next.size() > 0){
                return node;
            }
            return null;
        }

        // O(n lg n) due to sort - the hash map in the nodes saves memory,
        // but does not necessarily store subsets in order.
        // So a sort is required to return the keys in order.
        public Iterable<String> keys(){
            List<String> keys = new ArrayList<>();
            keys(root, new StringBuilder(), keys);

            Collections.sort(keys);
            return keys;
        }


        private void keys(Node node, StringBuilder prefix, List<String> keys){
            if (node == null){
                return;
            }
            if (node.isKey){
                keys.add(prefix.toString());
            }
            for (Character character : node.next.keys()){
                keys(node.next.get(character), new StringBuilder(prefix).append(character), keys);
            }
        }
        @Override
        public String toString(){
            StringJoiner keys = new StringJoiner(", ");
            for(String key : keys()){
                keys.add(key);
            }
            return "{" + keys.toString() + "}";
        }
    }

    public static void main(String[] args){
        StringSET st = new Ex5_2_6().new StringSET();

        StdOut.println("Is string set empty: " + st.isEmpty());
        StdOut.println("\nSize: " + st.size());
        StdOut.println("\nToString: \n" + st);

        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.add(key);
        }
        StdOut.println("Is string set empty: " + st.isEmpty());
        StdOut.println("\nSize: " + st.size());
        StdOut.println("\nToString: \n" + st);

        // Adding a key that already exists
        st.add("Algorithms");
        StdOut.println("\nSize: " + st.size());
        st.delete("Algorithms");
        StdOut.println("\nContains key Algorithms(after delete): " + 
                st.contains("Algorithms"));

        st.delete("Re");
        StdOut.println("\nContains key Re (after delete): " + 
                st.contains("Re"));
        StdOut.println("\nSize: " + st.size());

        StdOut.println("\nToString: \n" + st);

    }
    

}
