import edu.princeton.cs.algs4.*;
import java.util.*;

public class Rational
{
    private long numerator;
    private long denominator;


    Rational(long num, long denom)
    {
        if (denom == 0)
            throw new RuntimeException("can't set denominator to zero");
        else {
            assert num < Long.MAX_VALUE && num > Long.MIN_VALUE : "numerator overflow";
            assert denom < Long.MAX_VALUE && denom > Long.MIN_VALUE : "denominator overflow";
            long x = gcd(num, denom);
            numerator = num / x;
            denominator = denom / x;
        }

    }

    private static long gcd(long p, long q)
    {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }
    public Rational plus(Rational b) {
        long n = this.numerator*b.denominator + this.denominator*b.numerator;
        long d = this.denominator*b.denominator;
        long x = gcd(n, d);
        n = n/x;
        d = d/x;
        return new Rational(n,d);
    }

    public Rational minus(Rational b){
        long n = this.numerator*b.denominator - this.denominator*b.numerator;
        long d = this.denominator*b.denominator;
        long x = gcd(n, d);
        n = n/x;
        d = d/x;
        return new Rational(n,d);

    }

    public Rational times(Rational b){
        long n = this.numerator*b.numerator;
        long d = this.denominator*b.denominator;
        long x = gcd(n,d);
        n = n/x;
        d = d/x;
        return new Rational(n,d);
    }

    public Rational divides(Rational b) {
        if (b.numerator == 0)
            throw new RuntimeException("divides by zero");
        else {
            long n = this.numerator*b.denominator;
            long d = this.denominator*b.numerator;
            long x = gcd(n,d);
            n = n/x;
            d = d/x;
            return new Rational(n,d);

        }
    }
    public boolean equals(Rational that) {
        return this.numerator*that.denominator == this.denominator*that.numerator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        long nu1 = Long.parseLong(args[0]);
        long de1 = Long.parseLong(args[1]);
        long nu2 = Long.parseLong(args[2]);
        long de2 = Long.parseLong(args[3]);

        Rational r1 = new Rational(nu1,de1);
        Rational r2 = new Rational(nu2,de2);

        StdOut.println("r1: "+r1);
        StdOut.println("r2: "+r2);
        StdOut.println("r1+r2: "+r1.plus(r2));
        StdOut.println("r1-r2: "+r1.minus(r2));
        StdOut.println("r1*r2: "+r1.times(r2));
        StdOut.println("r1/r2: "+r1.divides(r2));
        StdOut.println("r1 equals r2: "+r1.equals(r2));

    }


}

