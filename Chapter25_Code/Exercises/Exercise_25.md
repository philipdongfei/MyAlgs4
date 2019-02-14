#EXERCISES

##Book Exercises

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

2.5.26 *Simple polygon*. Given N points in the plane, draw a simple polygon with N points as vertices. *Hint*: Find the point p with the smallest y coordinate, breaking ties with the smallest x coordinate. Connect the points in increasing order of the polar angle they make with p.

2.5.27 (web)**Interval 1D data type**. Write three static comparators for Interval1D.java, one that compares intervals by their left endpoint, one that compares intervals by their right endpoint, and one that compares intervals by their length.


2.5.27 (book) *Sorting parallel arrays*. When sorting parallel arrays, it is useful to have a version fo a sorting routine that returns a permutation, say index[], of the indices in sorted order. Add a method indirectSort() to Insertion that takes an array of Comparable objects a[] as argument, but instead of rearranging the entries of a[] returns an integer array index[] so that a[index[0]] through a[index[N-1]] are the items in ascending order.

2.5.28 **Sort files by name**. Write a program FileSorter.java that takes the name of a directory as a command line input and prints out all of the files in the current directory, sorted by filename. *Hint*. use the java.io.File data type.

2.5.29 *Sort files by size and date of last modification*. Write comparators for the type File to order by increasing/decreasing order of file size, ascending/descending order of file name, and ascending/descending order of last modification date. Use these comparators in a program LS that takes a command-line argument and lists the files in the current directory according to a specified order, e.g., "-t" to sort by timestamp. Support multiple flags to break ties.
Be sure to use a stable sort.

2.5.30 *Boerner's theorem*. True or false: If you sort each column of a matrix, then sort each row, the columns are still sorted. Justify your answer.
*Answer*: True.

2.5.31 (web) **Distinct values**. Write a program Distinct.java that takes integers M, N and T as command-line arguments, then uses the code given in the text to perform T trials of the following experiment: Generate N random int values between 0 and M-1 and count the number of distinct values generated. Run your program for T=10 and N = 10^3, 10^4, 10^5, and 10^6, with M=1/2N, N and 2N. Probalility theory says that the number of distinct values should be about M(1-e^e(-alpha)),
where alpha = N/M--print a table to help your confirm that your experiments validate this formula.



##Web Exercises

1. **Counter data type**. Modify Counter.java so that it implements the Comparable interface, comparing counters by tally.

2. **Grade data type**. Write a progarm Grade.java to represent a data type for grades(A, B+, etc.). It should implement the Comparable interface using the natural ordering on grades by GPA.

3. **Student data type**. Write an data type Student.java that represents a student in a college course. Each student should have a login (String), a section number (integer), and a grade (Grade);

4. **Case insensitive order**. Write a code fragment to read in a sequence of strings and sort them in ascending order, ignoring case.

5. **Case insensitive comparator**. Implement your own version of the comparator String.CASE_INSENSITIVE_ORDER.

```
public class CaseInsensitive iimplements Comparator<String> {
    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}

```
6. **Descending order string comparator**. implement a comparator that sorts string in descending order instead of ascending order.

```
public class Descending implements Comparator<String> {
    public int compare(String a, String b) {
        return b.compareToIgnoreCase(a);
    }
}

```
Alternatively, you can use Collections.reverseOrder(). It returns a Comparator that imposes the reverse of the natural ordering of objects that implement the Comparable interface.


7. **Sorting strings from non-English alphabets**. Write a program to sort strings according to non-English alphabets, for accents, umlauts and pre-composed character like ch in Spanish.
*Hint*: Use Java's java.text.Collator API. For example in UNICODE, Rico occurs lexicographically before Real, but in French, Real occurs first.

```

import java.util.Arrays;
import java.text.Collator;
...
Arrays.sort(words, Collator.getInstance(Locale.FRENCH));

```

8. **Smith's rule**. The following problem arises in supply chain management. You have a bunch of jobs to schedule on a single machine. (Give example.) Job j requires p[j] units of processing time. Job j has a positive weight w[j] which represents its relative importance - think of it as the inventory cost of storing the raw materials for job j for 1 unit of time. If job j finishes being processed at time t, then it costs t*w[j] dollars. The goal is to sequence the jobs so as to
   minimize the sum of the weighted completion times of each job. Write a program SmithsRule.java that reads in a command line parameter N and a list of N jobs specified by their processing time p[j] and their weight w[j], and output an optimal sequence in which to process their jobs. *Hint*: Use Smith's rule: Schedule the jobs in order of their ratio of processing time to weight. This greedy rule turns out to be optimal.

TODO: Smith's rule (greedy rule).

9. **Rhyming words**. For your poetry class, you would like to tabulate a list of rhyming words. A crude way to accomplish this task is as follows: 
- Read in a dictionary of words into an array of strings.
- Reverse the letters in each word, e.g., confound becomes dnuofnoc.
- Sort the resulting array of words.
- Reverse the letters in each word back to their original state.
Now the word confound will be next to words like astound and compound. Write a program Rhymer.java that reads in a sequence of words from standard input and prints them out in the order specified above.
Now repeat, but use a customized Comparator that sorts lexicographically from right-to-left.

10. **Mode**. Give an O(N log N) algorithm of computing the mode (value that occurs most frequently) of a sequence of N integers.
TODO
11. **Closest 1d pair**. Given a sequence of N real numbers, find the pair of integers that are closest in value. Give a O(N log N) algorithm.
TODO

12. **Farthest 1d pair**. Given a sequence of N real numbers, find the pair of integers that are farthest apart in value. Give a O(N) algorithm.

TODO
13. **Sorting with many duplicates**. Suppose you have a sequence of N elements, with at most log N distinct ones. Describe how to sort them in O(N log log N) time.

TODO

14. **Nearly sorted**. Given an array of N elements, each which is at most k positions from its target position, devise an algorithm that sorts in O(N log k) time.

TODO

15. **Sorting a linked list**. Given a singly linked list of N elements, how could you sort it in guaranteed O(N log N) time, stably, and with O(1) extra space?

TODO

16. **Goofysort (Jim Huggins)**. Argue that Goofy.java sorts the array in ascending order. What is the best-case running time of as a function of the number of items to be sorted N? What is the worst-case running time of as a function of the number of items to be sorted N?

17. **Feel-good interval**. Given an array of N nongegative integers (representing a person's emotional value on each day), the happiness in an interval is the sum of the values in that interval multiplied by the samllest integer in that interval. Design an O(N log N) divide-and-conquer algorithm to find the happiest interval.

*Solution*. Here's amergesort style solution.
- Divide the elements in the middle: a[1..m-1], a[m], a[m+1..r]
- Recursively compute the optimal interval entirely in the left half
- Recursively compute the optimal interval entirely in the right half
- Compute the optimal interval containing a[m]
- Return the best of the three intervals
The key step for efficiency is computing the optimal interval containing a[m] in linear time. Here's a greedy solution: If the optimal interval containing a[m] contains one element, it is simply a[m]. If it contains more than one element, it must contain the larger of a[m-1] and a[m+1], so add this to the interval. Repeat, etc. Return the best interval of any size constructed by this process.

TODO:

18. **Equality detector**. Suppose that you have N elements and you want to determine if at least N/2 are equal. Assume the only operation on the elements you can perform is equality testing. Design an algorithm that performs O(N log N) equality tests to find a representative element if it exists. *Hint*: divide-and-conquer. Note: can also do in O(N) tests.

TODO:

19. **Maxima**. Given a set of n points in the plane, point(xi, yi) dominates (xj, yj) if xi > xj and yi > yj. A maxima is a point that is not dominated by any other point in the set. Devise an O(n log n) algorithm to find all maxima. Application: on x-axis is space efficiency, on y-axis is time efficiency. Maxima are useful algorithms. Hint: sort in ascending order according to x-coordinate; scan from right to left, recording the highest y-value seen so far and mark these as maxima.

TODO:

20. **Min and max**. Given an array of N elements, find the min and max using as few compares as possible. Brute force: find the max(N-1 compares),  then find the min of the remaining elements (N-2 compares).

*Solution 1*. Divide and conquer: find min and max in each half(2T(N/2) compares), return min of 2 and max of 2 (2 compares). T(1) = 0, T(2) = 1, T(N)=2T(N/2)+2. Recurrence solution: T(N) = ceil(3N/2)-2.

*Solution 2*. Divide the elements into pairs and compare two elements in each pair. Put the smallest elements in A and the largest in B. If n is odd, put element n in both A and B. This requires floor(n/2) comparisions. Now directly compute the minimum in A(ceil(n/2)-1 comparisons) and the maximum in B (ceil(N/2)-1) comparisons. [In fact, this is best possible.] 

21. **Sorting by reversals**.[Mihai Patrascu](http://people.csail.mit.edu/mip/probs.html) Given an arraya[1..n], sort using the following type operation: pick two indices i and j and reverse the elements in a[i..j]. This operation costs j-i+1. Goal: O(nlog^2 n).

TODO:

22. **L1 norm**. There are N circuit elements in the plane. You need to run a special wire (parallel to the x-axis) across the circuit. Each circuit element must be connected to the special wire. Where should you put the special wire? *Hint*: median minimizes L1 norm.

TODO:

23. **Median given two sorted arrays**. Given two sorted arrays of size N1 and N2, find the meidan of all elements in O(log N) time where N = N1+N2. or find the kth overall largest in O(log k).

24. **Three nearby numbers in an arrays**. Given a floating-point array a[], design a linearithmic algorithm to find three distinct integers i, j, and k such that |a[i]-a[j]|+|a[j]-a[k]|+|a[k]-a[i]| is minimum.
*Hint*: if a[i]<=a[j]<=a[k], then |a[i]-a[j]|+|a[j]-a[k]|+|a[k]-a[i]| = 2(a[k]-a[i]).

TODO:

25. **Three nearby numbers in three arrays**. Given three floating-point arrays a[], b[], and c[], design a linearithmic algorithm to find three integers i, j, and k such that |a[i]-b[j]|+|b[j]-c[k]|+|c[k]-a[i]| is minimum.

TODO:

26. **Minimum dot product**. Given two vectors of the same length, find a permutation of the two vectors such that the dot product of the two vectors is as small as possible.

27. **Two-sum**. Given an array of N integers, design a linearithmic algorithm to find a pair of integers whose sum is closest to zero.
*Solution*: sort by absolute value--the best pair is now adjacent.


28. **3-sum in quadratic time**. The 3-sum problem is to find, in an array of integers, the triple whose sum is closest to zero. Describe an algorithm for this problem that uses linear space and quadratic time.

*Hint*: solve the following subproblem. Given a sorted list of N integers and a target integer x, determine in linear time the two whose sum is closest to x.

29. **Bandwidth**. Given intervals with bandwidth requirements, find the maximum bandwidth requirement (and the interval for which that maximum is reuqired).

*Solution*. Sort the intervals by start time; insert the intervals into PQ in this order, but using the ending time as the key. Before inserting the next interval, compare its start time to ending time of the minimum interval on the PQ: if it is greater, delete the minimum interval on the PQ. Always keep track of the cumulative bandwidth on the PQ.

30. **Time stamps**. Given N time stamps when file is reuqested from web server, find largest interval of time at which no file arrives.
*Solution*: sort by time stamp. Scan sorted list to identify maximum gap. (Same as idle time.)

31. **Ticket ranges**. Given a list of ticket seats of the form A1, A2, A11, A10, B7, B9, B8, B3, find the largest non-empty block of adjacent seats, e.g., A3-A9.(Same as idle time.)

*Solution*: sort by seat's NO.

32. **Decimal dominant**. Given an array with N comparable keys, design an algorithm to check if there is a value that appears more than N/10 times. Your algorithm should run in expected linear time.

*Solution*: Use quickselect to find the N/10th largest value; check if it is a dominant; check if it is a dominant; if not, recur in the subarray with 9N/10 values. Alternatively, use 9 counters.

33. **Local min and max**. Given N distinct comparable items, rearrange them so that each internal item is either greater than both items right before and after it or less than both items right before and after it .

*Hint*: sort and interleave the first and second halves.

34. **h-index**. Given an array of N positive integers, its h-index is the largest integer h such that there are at least h entries in the array greater than or equal to h. Design an algorithm to compute the h-index of an array.

*Hint*: median or quicksort-like partitioning and ivide-and-conquer.

35. **Software version number**. Define a comparator that compares two version numbers (Such as 1.2.32 and 1.2.5) chronologically. Assume that the version number is a string composed of only decimal digits and . character. The. character separates fields; it is not a decimal point.

36. **Stable selection sort**. What modifications do you need to do make selection sort stable?

*Solution*: first, when finding the minimum remaining key, always choose the leftmost entry; second, instead of moving the minimum key to the front with one exchange, move all elements to its left that are large one position to the right.

37. **Largest number**. Given n positive integers, concatenate them so that they form the largest number. For example, if the numbers are 123, 12, 96, and 921, then result should be 9692112312.

*Solution*: Define a comparator that compares two numbers by concatenating them together in either order (e.g. for 96 and 921, compare 96921 vs. 92196) and seeing which string is lexcographically largest.

38. **Largest number**. Given three arrays A, B, and C, each of length n, determine ther number of triples with a in A, b in B, and c in C are there such that a < b < c?

