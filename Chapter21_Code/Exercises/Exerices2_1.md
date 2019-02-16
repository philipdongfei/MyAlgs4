#EXERCISES

2.1.1 Show, in the style of the example trace with ALGORITHM 2.1, how selection sort sorts the array **E A S Y Q U E S T I O N**

2.1.2 What is the maximum number of exchanges involving any particular element during selection sort? What is the average number of exchanges involving an element?

2.1.3 Give an example of an array of N items that maximizes the number of times the test a[j] < a[min] succeeds (and, therefore, min gets updated) during the operation of selection sort (ALGORITHM 2.1)

*solution*: 9 8 7 6 5 4 3 2 1 0

2.1.4 Show, in the style of the example trace with ALGORITHM 2.2, how insertion sort sorts the array **E A S Y Q U E S T I O N**.

2.1.5 For each of the two conditions in the inner for loop in insertion sort (ALGORITHM 2.2), describe an array of N items where that condition is always false when the loop terminates.

2.1.6 Which method runs faster for an array with all keys identical, selection sort or insertion sort?

*Solution*: Insertion sort runs in linear time when all keys are equal.

2.1.7 which method runs faster for an array in reverse order, selection sort or insertion sort?

*Solution*: Selection sort

2.1.8 Suppose that we use insertion sort on a randomly ordered array where elements have only one of three values. Is the running time linear, quadratic, or something in between?

*Solution*: Quadratic

2.1.9 Show, in the Style of the example trace with ALGORITHM 2.3, how shellsort sorts the array **E A S Y S H E L L S O R T Q U E S T I O N**.

2.1.10 Why not use selection sort for h-sorting in shellsort?

*Solution*. Insertion sort is faster on inputs that are partially-sorted.

2.1.11 Implement a version of shellsort that keeps the increment sequence in an array, rather than computing it.

2.1.12 Instrument shellsort to print the number of compares divided by the array size for each increment. Write a test client that tests the hypothesis that this number is a small constant, by sorting arrays of random Double values, using array sizes that are increasing powers of 10, starting at 100.

2.1.13 *Deck sort*. Explain how you would put a deck of cards in order by suit (in the order spades, hearts, clubs, diamonds) and by rank within each suit, with the restriction that the cards must be laid out face down in a row, and the only allowed operations are to check the values of two cards and to exchange two cards (keeping them face down).

*Solution* Assign a value of (s*13+4) to each card,where:
s = 0 if spades, 
    1 if hearts,
    2 if clubs,
    3 if diamonds.
r = rank of card (1 to 13)
then shellsort as usual.

2.1.14 *Dequeue sort*. Explain how you would sort a deck of cards, with the restriction that the only allowed operations are to look at the values of the top two cards, to exchange the top two cards, and to move the top card to the bottom of the deck.

*Solution*:
```
repeat the following until no swaps are made:
    counting from i = 1 to n - 1, inclusive:
        if the top two cards are out of order, swap them.
        move the top card of the deck to the bottom.
    then, move the top card of the deck to the bottom.// put max card to bottom.

```

2.1.15 *Expensive exchange*. A clerk at a shipping company is charged with the task of rearranging a number of large crates in order of the time they are to be shipped out.Thus, the cost of compares is very low (just look at the labels) relative to the cost of exchanges (move the crates). The warehouse is nearly full--there is extra space sufficient to hold any one of the crates, but not two. What sorting method should the clerk use?

*Solution*. Use selction sort because it minimizes the number of exchagnes.

2.1.16 *Certification*. Write a check() method that calls sort() for a given array and returns true if sort() puts the array in order and leaves the same set of objects in the array as were there initially, false otherwise. Do not assume that sort() is restricted to move data only with exch(). You may use Arrays.sort() and assume that it is correct.

2.1.17 *Animation*. Add code to Insertion and Selection to make them draw the array contents as vertical bars like the visual traces in this section, redrawing the bars after each pass, to produce an animated effect, ending in a "sorted" picture where the bars appear in order of the height. *Hint*: Use a client like the one in the text that generates random Double values, insert calls to show() as appropriate in the sort code, and implement a show() method that clears
the canvas and draws the bars.

2.1.18 *Visual trace*. Modify your solution to the previous exercise to make Insertion and Selection produce visual traces such as those depicted in this selction. *Hint*: Judicious use of setYscale() makes this problem easy. *Extra credit*: Add the code necessary to produce red and gray color accents such as those in our figures.

2.1.19 *shellsort worst case*. Construct an array of 100 elements containing the numbers 1 through 100 for which shellsort, with the increments 1 4 13 40, uses as large a number of compares as you can find.

2.1.20 *shellsort best case*. What is the best case for shellsort? Justify your answer.

2.1.21 *Comparable transactions*. Using our code for Date (page 247) as a model, expand your implementation of Transaction (EXERCISE 1.2.13) so that it implements Comparable, such that transactions are kept in order by amount.

*Solution*:
```
public class Transaction implements Comparable<Transaction>
{
    ...
    private final double amount;
    ...
    public int compareTo(Transaction that)
    {
        if (this.amount > that.amount) return +1;
        if (this.amount < that.amount) return -1;
        return 0;
    }
    ...
}

```

2.1.22 *Transaction sort test client*. Write a class SortTransactions that consists of a static method main() that reads a sequence of transactions from standard input, sorts them, and prints the result on standard output (see EXERCISE 1.3.17).

*Solution*:
```
public class SortTransactions
{
    public static Transaction[] readTransactions()
    { // See Ex 1.3.17 }
    public static void main(String[] args)
    {
        Transaction[] transactions = readTransactions();
        Shell.sort(transactions);
        for (Transaction t : transactions)
            StdOut.println(t);
    }

}

```

2.1.23 *Deck sort*. Ask a few friends to sort a deck of cards (see EXERCISE 2.1.13). Observe them carefully and write down the method(s) that they use.

2.1.24 *Insertion sort with sentinel*. Develop an implementation of insertion sort that eliminates the j>0 test in the inner loop by first putting the smallest item into position. Use *SortCompare* to evaluate the effectiveness of doing so. Note: It is often possible to avoid an index-out-of-bounds test in this way--the element that enables the test to be eliminated is known as a *sentinel*.

2.1.25 *Insertion sort without exchanges*. Develop an implementation of insertion sort that moves larger elements to the right one position with one array access per entry, rather than using exch(). Use SortCompare to evaluate the effectiveness of doing so.

##Web Exercises

1. **Sorting networks**. Write a program Sort3.java with three if statements (and no loops) that reads in three integers a, b, and c from the command line and prints them out in ascending order.

```
if (a > b) swap a and b
if (a > c) swap a and c
if (b > c) swap b and c

```

2. **Oblivious sorting network**. Convince yourself that the following code fragment rearranges the integers stored in the variables A, B, C, and D so that A<=B<=C<=D.

```
if (A > B) {t = A; A = B; B = t;}
if (B > C) {t = B; B = C; C = t;}
if (A > B) {t = A; A = B; B = t;}
if (C > D) {t = C; C = D; D = t;}
if (B > C) {t = B; B = C; C = t;}
if (A > B) {t = A; A = B; B = t;}
if (D > E) {t = D; D = E; E = t;}
if (C > D) {t = C; C = D; D = t;}
if (B > C) {t = B; B = C; C = t;}
if (A > B) {t = A; A = B; B = t;}

```
Devise a sequence of statements that would sort 5 integers. How many if statements does your program use?

3. *Optimal oblivious sorting networks*. Create a program that sorts four integers using only 5 if statements, and one that sorts five integers using only 9 if statements of the type above? Oblivious sorting networks are useful for implementing sorting algorithms in hardware. How can you check that your program works for all inputs?

*Answer*: Sort4.java Sort5.java
The 0-1 principle says that you can verify the correctness of a (deterministic) sorting network by checking whether it correctly sorts an input that is a sequence of 0s and 1s. Thus, to check that sort5.java works, you only need to test it on the 2^5 = 32 possible inputs of 0s and 1s.


4.**Optimal oblivious sorting (challenging)**. Find an optimal sorting network for 6, 7, and 8 inputs, using 12, 16, and 19 if statements of the form in the previous problem, respectively.

Answer: Sort6.java is the solution for sorting 6 items. 

5. **Optimal non-oblivious sorting**. Write a program that sorts 5 inputs using only 7 comparisons. Hint: First compare the first two numbers, the second two numbers, and the larger of the two groups, and label them so that a < b < d and c < d. Second, insert the remaining item e into its proper place in the chain a < b < d by first comparing against b, then either a or d depending on the outcome. Third, insert c into the proper place in the chain involving a, b, d, and e in the
   same manner that you inserted e (with the knowledge that c < d). This uses 3 (first step) + 2 (second step) + 2 (third step) = 7 comparisons. This method was first discovered by H. B. Demuth in 1956. 


14. **Binary insertion sort**. Develop an implementation BinaryInsertion.java of insertion sort that uses binary search to find the insertion point j for entry a[i] and then shifts all of the entries a[j] to a[i-1] over one position to the right. The number of compares to sort an array of length n should be ~ n lg n in the worst case. Note that the number of array accesses will still be quadratic in the worst case. Use SortCompare.java to evaluate the effectiveness of doing so. 


