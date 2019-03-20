import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;

public class Ex3_5_6 {
    public static class HashSETint{
        private int keysSize;  //
        private int Size = 16;
        private int[] keys;
        HashSETint(){
            keys = new int[Size];
            for (int i = 0; i < keys.length; i++)
                keys[i] = -1;
        }
        private void resize(int cap)
        {
            int[] t;
            t = new int[cap];
            for (int i = 0; i < Size; i++)
                t[i] = keys[i];
            keys = t;
            Size = cap;
        }
        public int size()
        {
            return keysSize;
        }
        public boolean isEmpty()
        {
            return size() == 0;
        }
        private int hash(int x)
        {
            return (Integer.valueOf(x).hashCode() & 0x7fffffff) % Size;
        }
        public void add(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            if (keysSize >= Size/2) resize(2*Size);
            int i;
            for (i = hash(x); keys[i] != -1; i = (i+1)%Size)
                if (keys[i] == x) { return; }
            keys[i] = x;
            keysSize++;
        }
        public void delete(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            if (!contains(x)) return;
            int i = hash(x);
            while (x != keys[i])
                i = (i + 1) % Size;
            keys[i] = -1;
            i = (i + 1) % Size;
            while (keys[i] != -1)
            {
                int keyToRedo = keys[i];
                keys[i] = -1;
                keysSize--;
                add(keyToRedo);
                i = (i + 1) % Size;

            }
            keysSize--;
            if (keysSize > 0 && keysSize == Size/8) resize(Size/2);

        }
        public boolean contains(int x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            for(int i = hash(x); keys[i] != -1; i = (i+1) % Size)
                if (keys[i] == x)
                    return true;
            return false;
        }
        @Override
        public String toString()
        {
            if (isEmpty())
                return "{}";
            String strV = "";
            for (int x : keys)
            {
                if (x != -1)
                    strV += x + " ";
            }

            return strV;
        }
        
    }
    public static class HashSETdouble{
        private int keysSize;  //
        private int Size = 16;
        private double[] keys;
        HashSETdouble(){
            keys = new double[Size];
            for (int i = 0; i < keys.length; i++)
                keys[i] = -1.0;
        }
        private void resize(int cap)
        {
            double[] t;
            t = new double[cap];
            for (int i = 0; i < Size; i++)
                t[i] = keys[i];
            keys = t;
            Size = cap;
        }
        public int size()
        {
            return keysSize;
        }
        public boolean isEmpty()
        {
            return size() == 0;
        }
        private int hash(double x)
        {
            return (Double.valueOf(x).hashCode() & 0x7fffffff) % Size;
        }
        public void add(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            if (keysSize >= Size/2) resize(2*Size);
            int i;
            for (i = hash(x); keys[i] != -1; i = (i+1)%Size)
                if (keys[i] == x) { return; }
            keys[i] = x;
            keysSize++;
        }
        public void delete(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            if (!contains(x)) return;
            int i = hash(x);
            while (x != keys[i])
                i = (i + 1) % Size;
            keys[i] = -1;
            i = (i + 1) % Size;
            while (keys[i] != -1)
            {
                double keyToRedo = keys[i];
                keys[i] = -1;
                keysSize--;
                add(keyToRedo);
                i = (i + 1) % Size;
            }
            keysSize--;
            if (keysSize > 0 && keysSize == Size/8) resize(Size/2);

        }
        public boolean contains(double x)
        {
            if (x < 0)
                throw new IllegalArgumentException("x is illegal");
            for(int i = hash(x); keys[i] != -1; i = (i+1) % Size)
                if (keys[i] == x)
                    return true;
            return false;
        }
        @Override
        public String toString()
        {
            if (isEmpty())
                return "{}";
            String strV = "";
            for (double x : keys)
            {
                if (x != -1)
                    strV += x + " ";
            }

            return strV;
        }
    }
    public static void main(String[] args)
    {
        HashSETint st = new HashSETint();
        st.add(1);
        st.add(3);
        st.add(4);
        StdOut.println("st size: " + st.size());
        StdOut.println("st: " + st);
        StdOut.println("st is contains 4: " + st.contains(4));
        HashSETdouble st1 = new HashSETdouble();
        st1.add(0.1);
        st1.add(0.3);
        st1.add(1.4);
        StdOut.println("st1 size: " + st1.size());
        StdOut.println("st1: " + st1);
        StdOut.println("st1 is contains 0.4: " + st1.contains(0.4));

    }

}
