import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;

public class Ex3_5_4 {
    public static class HashSTint{
        private LinearProbingHashST<Integer, Boolean> st;
        HashSTint(){
            st = new LinearProbingHashST<>();
        }
        public int size()
        {
            return st.size();
        }
        public boolean isEmpty()
        {
            return st.isEmpty();
        }
        public void add(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            st.put(x, false);
        }
        public void delete(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            st.delete(x);

        }
        public boolean contains(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            return st.contains(x);
        }
        @Override
        public String toString()
        {
            if (isEmpty())
                return "{}";
            String strV = "";
            for (int x : st.keys())
            {
                strV += x + " ";
            }

            return strV;
        }
        
    }
    public static class HashSTdouble{
        private LinearProbingHashST<Double, Boolean> st;
        HashSTdouble(){
            st = new LinearProbingHashST<>();
        }
        public int size()
        {
            return st.size();
        }
        public boolean isEmpty()
        {
            return st.isEmpty();
        }
        public void add(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            st.put(x, false);
        }
        public void delete(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            st.delete(x);

        }
        public boolean contains(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            return st.contains(x);
        }
        @Override
        public String toString()
        {
            if (isEmpty())
                return "{}";
            String strV = "";
            for (double x : st.keys())
            {
                strV += x + " ";
            }

            return strV;
        }
    }
    public static void main(String[] args)
    {
        HashSTint st = new HashSTint();
        st.add(1);
        st.add(3);
        st.add(4);
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("st is contains 4: " + st.contains(4));
        HashSTdouble st1 = new HashSTdouble();
        st1.add(0.1);
        st1.add(0.3);
        st1.add(1.4);
        StdOut.println("st1 size: " + st1.size());
        StdOut.println("st1: " + st1);
        StdOut.println("st1 is contains 0.4: " + st1.contains(0.4));

    }

}
