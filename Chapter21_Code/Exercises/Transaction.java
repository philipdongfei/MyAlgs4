import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.Comparator;

public class Transaction implements Comparable<Transaction>
{

    private String who;
    private SmartDate when;
    //private double amount;
    private final double amount;

    Transaction(String who1, SmartDate when1, double amount1) {
        if (Double.isNaN(amount1) || Double.isInfinite(amount1))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        who = who1;
        when = when1;
        amount = amount1;
    }

    Transaction(String trans)
    {
        String[] fields = trans.split("\\s+");
        who = fields[0];
        when = new SmartDate(fields[1]);
        amount = Double.parseDouble(fields[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }
    public int compareTo(Transaction that)
    {
        if (this.amount > that.amount) return +1;
        if (this.amount < that.amount) return -1;
        return 0;
    }

    public String who(){
        return who;
    }
    public SmartDate when(){
        return when;
    }
    public double amount(){
        return amount;
    }

    @Override
    public String toString()
    {
        //return when() + " " + who()
        //    + " " + amount();
        return String.format("%-10s %10s %8.2f", who, when, amount);
        
    }

    public boolean equals(Object x)
    {
        if (this == x) 
            { return true;}
        if (x == null) 
            { return false;}
        if (this.getClass() != x.getClass())
            { return false;}
        Transaction that = (Transaction) x;
        if (!this.who.equals(that.who))    
            { return false;}
        if (!this.when.equals(that.when)) 
            { return false;}
        if (this.amount != that.amount) 
            { return false;}
        return true;
    }

    public static int[] readDates() {
        Queue<Character> q = new Queue<Character>();

        while (!StdIn.isEmpty()){
            q.enqueue(StdIn.readChar());
        }

        int N = q.size();
        int[] a = new int[3];
        String temp = "";
        int k = 0;

        for (int i = 0; i < N; i++) {
            char c = q.dequeue();
            if (c == '/') {
                a[k] = Integer.parseInt(temp);
                k += 1;
                temp = "";
            } else {
                temp += c;
            }
        }
        a[k] = Integer.parseInt(temp);

        return a;
    }
    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
    }
    public static class WhoOrder implements Comparator<Transaction>{
        @Override
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }
    public static class WhenOrder implements Comparator<Transaction>{
        @Override
        public int compare(Transaction v, Transaction w){
            return v.when.compareTo(w.when);
        }
    }
    public static class HowMuchOrder implements Comparator<Transaction>{
        @Override
        public int compare(Transaction v, Transaction w){
            return Double.compare(v.amount, w.amount);
        }
    }

    
    public static void main(String[] args) {
        /*
        int[] d = readDates();
        Transaction t1 = new Transaction("Tom", new SmartDate(d[0], d[1], d[2]), 3000);
        
        Transaction t = new Transaction("Tom", new SmartDate(5,11,2018),
                2000);
        StdOut.println(t);
        //Transaction t1 = new Transaction("Tom", new SmartDate(8,11,2018),
        //        3000);
        Transaction t2 = new Transaction("Tom", new SmartDate(8,12,2018),
                3000);
        StdOut.println(t1);
        StdOut.println(t2);
        if (t1.equals(t2))
            StdOut.println("t1 equals t2");
        else
            StdOut.println("t1 not equals t2");
        */
        Transaction[] a = new Transaction[4];
        a[0] = new Transaction("Turing  6/17/1990   644.08");
        a[1] = new Transaction("Tarjan  3/26/2002   4121.85");
        a[2] = new Transaction("knuth   6/14/1999   288.34");
        a[3] = new Transaction("Dijkstra    8/22/2007   2678.40");

        StdOut.println("Unsorted");
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        StdOut.println("Sorted by date");
        Arrays.sort(a, new Transaction.WhenOrder());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        StdOut.println("Sorted by customer");
        Arrays.sort(a, new Transaction.WhoOrder());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
        StdOut.println("Sorted by amount");
        Arrays.sort(a, new Transaction.HowMuchOrder());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

    }
}
