#EXERCISES

2.5.1 Consider the following implementation of the *compareTo()* method for *String*. How does the third line help with efficiency?

```
public int compareTo(String t) {
    String s = this;
    if (s == t) return 0; // this line
    int n = Math.min(s.length(), t.length());
    for (int i = 0; i < n; i++) {
        if (s.charAt(i) < t.charAt(i)) return -1;
        else if (s.charAt(i) > t.charAt(i)) return +1;
    }
    return s.length() - t.length();
}

```
*Solution*: it avoid directly comparing individual characters if s and t are references to the same string.

2.5.2 Write a program that reads a list of words from standard input and prints all two-word compound words in the list. For example, if after, thought, and afterthought are in the list, then afterthought is a compound word.

2.5.3 Criticize the following implementation of a class intended to represent customer account balances. Why is compareTo() a flawed implementation of the Comparable interface?

```
public class Customer implements Comparable<Customer> {
    private String name;
    private double balance;

    public int compareTo(Customer that) {
        if (this.balance < that.balance - 0.005) return -1;
        if (this.balance > that.balance + 0.005) return +1;
        return 0;
    }
}

```
*Solution*: it violates the *Comparable* contract. It is possible that a.compareTo(b) and b.compareTo(c) are both 0, but a.compareTo(c) is positive (or negative).

2.5.4 Implement a method String[] dedup(String[] a) that returns the objects in a[] in sorted order, with duplicates removed.

2.5.5 Explain why selection sort is not stable.

*Solution*. It exchanges nonadjacent elements. On the example below, the first B gets swapped to the right of the second B (B2 B1).

i   min 0   1   2
0   2   B1  B2  A
1   1   A   B2  B1
2   2   A   B2  B1
        A   B2  B1

2.5.6 Implement a recursive version of select().
1. First part that is already sorted.
2. Second part that is yet to be sorted.

2.5.7 About how many compares are required, on the average, to find the smallest of N items using select()?

2.5.8 Write a program Frequency.java that reads strings from standard input and prints the number of times each string occurs, in descending order of frequency.


2.5.9 Develop a data type that allows you to write a client that can sort a file such as the one shown at right.

