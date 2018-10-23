import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Transaction
{
    private String who;
    private SmartDate when;
    private double amount;

    Transaction(String who1, SmartDate when1, double amount1) {
        who = who1;
        when = when1;
        amount = amount1;
    }

    Transaction(String trans)
    {
        String[] fields = trans.split(" ");
        who = fields[0];
        when = new SmartDate(fields[1]);
        amount = Double.parseDouble(fields[2]);
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

    public String toString()
    {
        return when() + " " + who()
            + " " + amount();
        
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

    
    public static void main(String[] args) {

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

    }
}
