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

2.5.14 **Sort by reverse domain**. Write a data type Domain.java that represents domain names, including an approriate compareTo() method where the natural order is in order of the reverse domain name. For example, the reverse domain of cs.princeton.edu is edu.princeton.cs. This is useful for web log analysis. Write a client that reads domain names from standard input and prints the reverse domains in sorted order.

2.5.15 **Spam campaign**. To initiate an illegal spam campaign, you have a list of email addresses from various domains (the part of the email address that follows the @ symbol). To better forge the return addresses, you want to send the email from another user at the same domain. For example, you might want to forge an email from wayne@princeton.edu to rs@princeton.edu. How would you process the email list to make this an efficient task?

*Solution*. First sort by reverse domain. binary search the black domains list.

2.5.16 **Unbiased election**. In order to thwart bias against candidates whose names appear toward the end of the alphabet, California sorted the candidates appearing on its 2003 gubernatorial ballot by using the following order:
R W Q O J M V A H B S G Z X N T C I E K U P D Y F L
Create a data type California.java where this is the natural order. Write a client that sorts strings according to this ordering. Assume that each string is comprised solely of uppercase letters.

2.5.17 *Check stability*. Extend your check() method from EXERCISE 2.1.16 to call sort() for a given array and return true if sort() sorts the array in order in a stable manner, false otherwise. Do not assume that sort() is restricted to move data only with exch().

2.5.18 *Force stability*. Write a wrapper method that makes any sort stable by creating a new key type that allows you to append each key's index to the key, call sort(), then restore the original key after the sort.

2.5.19 **Kendall tau distance**. Write a program KendallTau.java that computes the Kendall tau distance between two permutations in linearithmic time.

2.5.20 *Idle time*. Suppose that a parallel machine processes N jobs. Write a program that, given the list of job start and finish times, finds the largest interval where the machine is idle and the largest interval where the machine is not idle.

2.5.21 *Multidimensional sort*. Write a Vector data type for use in having the sorting methods sort multidimensional vectors of d integers, putting the vectors in order by first component, those with equal first component in order by second component, those with equal first and second components in order by third component, and so forth.

2.5.22 *Stock market trading*. Investors place buy and sell orders for a particular stock on an electronic exchange, specifying a maximum buy or minimum sell price that they are willing to pay, and how many shares they wish to trade at that price. Develop a program that uses priority queues to match up buyers and sellers and test it through simulation. Maintain two priority queues, one for buyers and one for sellers, executing trades whenever a new order can be matched with an
existing order or orders.

TODO:
relevance:2.4 web exericse 32.

2.5.23 *Sampling for selection*. Investigate the idea of using sampling to improve selection. *Hint*: Using the median may not always be helpful.


2.5.24 **Stable priority queue**. Develop a stable priority-queue implementation StableMinPQ.java (which returns duplicate keys in the same order in which they were inserted).



2.5.25 **Points in the plane**. Write three static comparators for the Point2D.java data type, one that compares points by their x coordinate, one that compares them by their y coordinate, and one that compares them by their distance from the origin. Write two non-static comparators for the Point2D data type, one that compares them by their distance to a specified point and one that compares them by their polar angle with respect to a specified point.








