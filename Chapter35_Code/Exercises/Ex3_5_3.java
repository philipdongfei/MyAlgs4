import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdOut;


public class Ex3_5_3 {
    public static class SET<Key extends Comparable<Key>> {
        private BinarySearchST<Key, Boolean> st;

        private SET(){
            st = new BinarySearchST<>();
        }
        public boolean isEmpty(){
            return st.isEmpty();
        }
        public int size(){
            return st.size();
        }
        public void add(Key key) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.put(key, false);
        }
        public void delete(Key key) {
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            st.delete(key);

        }
        public boolean contains(Key key){
            if (key == null)
                throw new IllegalArgumentException("argument key is null");
            return st.contains(key);
        }
        public Key min() {
            if (isEmpty())
                return null;
            Key min = st.min();
            return min;
        }
        public Key max() {
            if (isEmpty())
                return null;
            Key max = st.max();
            return max;
        }
        public void deleteMin()
        {
            if (isEmpty())
                return;
            st.deleteMin();
        }
        public void deleteMax()
        {
            if (isEmpty())
                return;
            st.deleteMax();
        }
        public Key select(int k){
            if (isEmpty())
                return null;
            if (k < 0 || k >= st.size())
                throw new IllegalArgumentException("argument k is illegal");
            return st.select(k);
        }
        public Key floor(Key key){
            if (key == null) throw new IllegalArgumentException("argument to floor() is null");
            return st.floor(key);
        }
        public Key ceiling(Key key){
            if (key == null)
                throw new IllegalArgumentException("argument to ceiling is null");
            return st.ceiling(key);
        }

        @Override
        public String toString() {
            if (isEmpty())
                return "{}";
            String strFormat = "";
            for (Key key : st.keys())
            {
                strFormat += key + " ";
            }
            return strFormat;
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
        StdOut.println("delete b");
        st.delete("b");
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("delete max:");
        StdOut.println("st floor b: " + st.floor("b"));
        StdOut.println("st ceiling b: " + st.ceiling("b"));
        st.deleteMax();
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);

    }
}
