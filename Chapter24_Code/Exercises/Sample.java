import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class Sample {

    private class Node {
        double weight;
        double cumulativeWeight;
        public Node(){
            weight = 0;
            cumulativeWeight = 0;
        }
    }
    public class PValue {
        int index;
        double proValue;
        public PValue(){
            index = -1;
            proValue = 0;
        }
    }
    double[] p;
    double[] pp;  // probability p[i]/T
    double   T;   // total probability

    public Sample(double[] p) {
        int n = p.length;
        this.p = new double[n];
        T = 0;
        for (int i = 0; i < n; i++){
            this.p[i] = p[i];
            T += p[i];
        }
        for (int i = 0; i < n; i++) {
            this.pp[i] = p[i]/T;
        }

    }

    public PValue random() {
        PValue pv;


        return pv;
    } 

    public void change(int i, double v) {

    }

}
