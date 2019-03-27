import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;


public class SparseMatrix {
    private int n;     // n-by-n matrix
    private SparseVector[] rows;  // the rows, each row is a sparse vector

    // initialize an n-by-n matrix of all 0s
    public SparseMatrix(int n) {
        this.n = n;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++)
            rows[i] = new SparseVector(n);
    }
    public void put(int i, int j, double value){
        if (i < 0 || i >= n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= n) throw new IllegalArgumentException("Illegal index");
        rows[i].put(j, value);
    }

    public double get(int i, int j) {
        if (i < 0 || i >= n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= n) throw new IllegalArgumentException("Illegal index");

        return rows[i].get(j);
    }
    //return the number of nonzero entries
    public int nnz(){
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += rows[i].nnz();
        return sum;
    }

    // return the matrix-vector product b = Ax
    public SparseVector times(SparseVector x){
        if (n != x.size()) throw new IllegalArgumentException("Dimensions disagree");
        SparseVector b = new SparseVector(n);
        for (int i = 0; i < n; i++)
            b.put(i, rows[i].dot(x));
        return b;
    }
    // return this + that
    public SparseMatrix plus(SparseMatrix that){
        if (this.n != that.n) throw new RuntimeException("Dimensions disagree");
        SparseMatrix result = new SparseMatrix(n);
        for (int i = 0; i < n; i++)
            result.rows[i] = this.rows[i].plus(that.rows[i]);
        return result;
    }
    // return a string representation
    public String toString(){
        String s = "n = " + n + ", nonzeros = " + nnz() + " ";
        for (int i = 0; i < n; i++)
            s += i + ": " + rows[i] + " ";
        return s;
    }

    public static void main(String[] args){
        SparseMatrix A = new SparseMatrix(5);
        SparseVector x = new SparseVector(5);
        A.put(0,0,1.0);
        A.put(1,1,1.0);
        A.put(2,2,1.0);
        A.put(3,3,1.0);
        A.put(4,4,1.0);
        A.put(2,4,0.3);
        x.put(0,0.75);
        x.put(2,0.11);
        StdOut.println("x    : " + x);
        StdOut.println("A    : " + A);
        StdOut.println("Ax   : " + A.times(x));
        StdOut.println("A + A: " + A.plus(A));
    }
}
