import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;


public class Ex3_5_2 {
    public static class SET<Key extends Comparable<Key>> {
        private SequentialSearchST<Key, Boolean> st;

        private SET(){
            st = new SequentialSearchST<>();
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
            Key min = null;
            for (Key key : st.keys())
            {
                if (min == null)
                    min = key;
                else if (min.compareTo(key) > 0)
                    min = key;
            }
            return min;
        }
        public Key max() {
            if (isEmpty())
                return null;
            Key max = null;
            for (Key key : st.keys())
            {
                if (max == null)
                    max = key;
                else if (max.compareTo(key) < 0)
                    max = key;
            }
            return max;
        }
        public void deleteMin()
        {
            if (isEmpty())
                return;
            Key min = min();
            if (min != null)
                st.delete(min);
        }
        public void deleteMax()
        {
            if (isEmpty())
                return;
            Key max = max();
            if (max != null)
                st.delete(max);
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
        st.deleteMax();
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);

    }
}
