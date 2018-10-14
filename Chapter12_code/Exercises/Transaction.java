import edu.princeton.cs.algs4.*;
import java.util.*;

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
        when = new Date(fields[1]);
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
            {StdOut.println("1"); return true;}
        if (x == null) 
            {StdOut.println("2"); return false;}
        if (this.getClass() != x.getClass())
            {StdOut.println("3"); return false;}
        Transaction that = (Transaction) x;
        if (!this.who.equals(that.who))    
            {StdOut.println("4"); return false;}
        if (!this.when.equals(that.when)) 
            {StdOut.println("5"); return false;}
        if (this.amount != that.amount) 
            {StdOut.println("6"); return false;}
        return true;
    }

    public static void main(String[] args) {
        Transaction t = new Transaction("Tom", new SmartDate(5,11,2018),
                2000);
        StdOut.println(t);
        Transaction t1 = new Transaction("Tom", new SmartDate(8,11,2018),
                3000);
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
