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

2.5.10 Create a data type Version that represents a software version number, such as 115.1.1, 115.10.1, 115.10.2. Implement the Comparable interface so that 115.1.1 is less than 115.10.1, and so forth.


2.5.11 One way to describe the result of a sorting algorithm is to specify a permutation p[] of the numbers 0 to a.length-1, such that p[i] specifies where the key originally in a [i] ends up. Give the permutations that describe the results of insertion sort, selection sort, shellsort, mergesort, quicksort, and heapsort for an array of severn equal keys.

2.5.12 *Scheduling*. Write a program SPT.java that reads job names and processing times from standard input and prints a schedule that minimizes average completion time using the shortest processing time frist rule, as described on page 349.

2.5.13 *Load balancing*. Write a program LPT.java that takes an integer M as a command-line argument, reads job names and processing times from standard input and prints a schedule assigning the jobs to M processors that approximately minimizes the time when the last job completes using the longest processing time first rule, as described on page 349.

*Remark*. The resulting solution is guarateed to be within 33% of the best possible (actually 4/3-1/(3N)).



