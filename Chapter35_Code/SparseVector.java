import edu.princeton.cs.algs4.ST;
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
    public static void main(String[] args)
    {
        int N = 5;
        SparseVector[] a;
        a = new SparseVector[N];
        for (int i = 0; i < N; i++)
            a[i] = new SparseVector();
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

        x[0] = 0.05;
        x[1] = 0.04;
        x[2] = 0.36;
        x[3] = 0.37;
        x[4] = 0.19;

        for (int i = 0; i < N; i++)
            b[i] = a[i].dot(x);

        for (double v : b)
            StdOut.printf("%.3f\n", v);
    }
}
