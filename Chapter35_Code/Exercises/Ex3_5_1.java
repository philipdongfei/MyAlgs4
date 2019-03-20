import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;



public class Ex3_5_1 {
    public static class SET<Key extends Comparable<Key>>{
        private RedBlackBST<Key, Boolean> st;

        SET() {
            st = new RedBlackBST<>();
        }
        public boolean isEmpty(){
            return st.isEmpty();
        }
        public int size(){
            return st.size();
        }
        public boolean contains(Key key) {
            return st.contains(key);
        }
        public void add(Key key) {
            if (key == null)
                throw new IllegalArgumentException("Key cannot be null");
            st.put(key, false);
        }
        public void delete(Key key) {
            if (key == null)
                throw new IllegalArgumentException("Key cannot be null");
            if (isEmpty() || !contains(key))
                return;
            st.delete(key);
        } 
        public Key min() {
            if (isEmpty())
                return null;
            return st.min();
        }
        public Key max() {
            if (isEmpty())
                return null;
            return st.max();
        }
        public Key floor(Key key) {
            if (isEmpty())
                return null;

            return st.floor(key);
        }
        public Key ceiling(Key key) {
            if (isEmpty())
                return null;
            return st.ceiling(key);

        }
        public Key select(int index) {
            if (index < 0 || index >= size())
                throw new IllegalArgumentException("Index argument Illegal");
            return st.select(index);
        }
        public int rank(Key key) {
            if (key == null)
                throw new IllegalArgumentException("key can't be null");
            return st.rank(key); 
        }
        public void deleteMin(){
            if (isEmpty())
                return;
            st.deleteMin();

        }
        public void deleteMax(){
            if (isEmpty())
                return;
            st.deleteMax();
        }
        
        @Override
        public String toString() {
            if (isEmpty())
                return "{}";
            String strVal = "";
            for (Key key : st.keys())
                strVal += key + " ";
            return strVal;
        }
    }
    public static class HashSET<Key> {
        private LinearProbingHashST<Key, Boolean> hashst;

        HashSET(){
            hashst = new LinearProbingHashST<>();
        }
        public boolean isEmpty(){
            return hashst.isEmpty();
        }
        public int size() {
            return hashst.size();
        }
        public boolean contains(Key key) {
            return hashst.contains(key);
        }
        public void add(Key key){
            hashst.put(key, false);
        }
        public void delete(Key key) {
            hashst.delete(key);
        }
        public Iterable<Key> keys(){
            return hashst.keys();
        }
        @Override
        public String toString() {
            if (isEmpty())
                return "{}";
            String strVal = "";
            for (Key key : hashst.keys())
                strVal += key + " ";
            return strVal;
        }

    }
    public static void main(String[] args) {
        SET<String> st = new SET<String>();
        st.add("c");
        st.add("b");
        st.add("a");
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("st min: " + st.min());
        StdOut.println("st max: " + st.max());
        StdOut.println("st select 0: " + st.select(0));
        StdOut.println("st select 2: " + st.select(2));
        StdOut.println("st rank b: " + st.rank("b"));
        StdOut.println("delete a");
        st.delete("a");
        StdOut.println("st min: " + st.min());

        StdOut.println("Test HashSET");
        HashSET<String> hashst = new HashSET<String>();
        hashst.add("g");
        hashst.add("f");
        hashst.add("e");
        hashst.add("t");
        StdOut.println("hashst size: " + hashst.size());
        StdOut.println("hashst: " + hashst);
        StdOut.println("delete f");
        hashst.delete("f");
        StdOut.println("hashst: " + hashst);

    }

}
