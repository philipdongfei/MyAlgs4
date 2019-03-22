import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

public class SparseVector
{
    private ST<Integer, Double> st;

    public SparseVector()
    { this.st = new ST<Integer, Double>(); }
    public int size()
    { return st.size(); }
    public void put(int i, double x)
    { 
        if (st == null) throw new IllegalArgumentException("st is null");
        if (i < 0) throw new IllegalArgumentException("Illegal index");
        st.put(i, x); 
    }
    public double get(int i)
    {
        if (!st.contains(i)) return 0.0;
        else return st.get(i);
    }
    public double dot(double[] that)
    {
        double sum = 0.0;
        for (int i : st.keys())
            sum += that[i]*this.get(i);
        return sum;
    }
    @Override
    public String toString()
    {
        StringBuilder s= new StringBuilder();
        for (int i : st.keys()){
            s.append("(" + i + ", " + st.get(i) + ") ");
        }
        return s.toString();

    }
    
    public void delete(int key)
    {
        st.delete(key);
    }
    public Iterable<Integer> keys()
    {
        Queue<Integer> queue = new Queue<Integer>();
        for (int i : st.keys())
            queue.enqueue(i);
        return queue;
    }
    public SparseVector sum(SparseVector that)
    {
        if (that.size() == 0)
            return this;
        SET<Integer> setIndex = new SET<Integer>();
        for(int i : this.st.keys())
            setIndex.add(i);
        for(int i : that.st.keys())
            setIndex.add(i);
        for(int i : setIndex)
        {
            double sum = this.get(i) + that.get(i);
            if (sum != 0)
                put(i, sum);
            else
                delete(i);

        }
        return this;
    }
    public static void main(String[] args)
    {
        int N = 5;
        SparseVector[] a;
        a = new SparseVector[N];
        for (int i = 0; i < N; i++)
            a[i] = new SparseVector();
        SparseVector[] c;
        c = new SparseVector[N];
        for (int i = 0; i < N; i++)
            c[i] = new SparseVector();
        double[] x = new double[N];
        double[] b = new double[N];

        a[0].put(1, 0.9);
        a[1].put(2, 0.36);
        a[1].put(3, 0.36);
        a[1].put(4, 0.18);
        a[2].put(3, 0.9);
        a[3].put(0, 0.9);
        a[4].put(0, 0.47);
        a[4].put(2, 0.47);
        c[0].put(3, 0.3);
        c[1].put(2, -0.36);
        c[1].put(3, 0.36);

        x[0] = 0.05;
        x[1] = 0.04;
        x[2] = 0.36;
        x[3] = 0.37;
        x[4] = 0.19;

        for (int i = 0; i < N; i++)
            b[i] = a[i].dot(x);

        for (double v : b)
            StdOut.printf("%.3f\n", v);
        StdOut.println();
        StdOut.println("a[0] + c[0]:");
        StdOut.println(a[0]);
        StdOut.println(c[0]);
        a[0].sum(c[0]);
        StdOut.println(a[0]);
        StdOut.println("a[1] + c[1]:");
        StdOut.println(a[1]);
        StdOut.println(c[1]);
        a[1].sum(c[1]);
        StdOut.println(a[1]);

    }
}
