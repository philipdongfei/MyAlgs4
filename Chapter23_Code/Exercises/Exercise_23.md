#EXERCISES

2.3.1 Show, in the style of the trace given with partition(), how that method patitions the array E A S Y Q U E S T I O N.

2.3.2 Show, in the style of the quicksort trace given in this secion, how quicksort sorts the array E A S Y Q U E S T I O N (for the purposes of this exercise, ignore the initial shuffle);

2.3.3 What is the maximum number of times during the execution of Quick.sort() that the largest item can be exchanged, for an array of length N?

*Solution*. lg(N)

2.3.4 Suppose that the initial random shuffle is omitted. Give six arrays of ten elements for which Quick.sort() uses the worst-case number of compares.

2.3.5 Give a code fragment that sorts an array that is known to consist of items having just two distinct keys.
*Solution*. Sort2distinct.java

2.3.6 Write a program to compute the exact value of C_N, and compare the exact value with the approximation 2NlnN, for N = 100, 1000, 10000.

2.3.7 Find the expected number of subarrays of size 0, 1, and 2 when quicksort is used to sort an array of N items with distinct keys. If you are mathematically inclined, do the math; if not, run some experiments to develop hypotheses.

2.3.8 About how many compares will Quick.sort() make when sorting an array of N items that are all equal?
*Solution*. ~NlgN compares. Each partition will divide the array in half, plus or minus one.

2.3.9 Explain what happens when Quick.sort() is run on an array having items with just two distinct keys, and then explain what happens when it is run on an array having just three distinct keys.

2.3.10 *Chebyshev's inequality* says that the probability that a random variable is more than k standard deviations away from the mean is less than 1/k^2. For N=1 million, use Chebyshev's inequality to bound the probability that the number of compares used by quicksort is more than 100 billion(.1N^2).

2.3.11 Suppose that we scan over items with keys equal to the partitioning item's key instead of stopping the scans when we encounter them. Show that the running time of this version of quicksort is quadratic for all arrays with just a constant number of distinct keys.

2.3.12 Show, in the style of the trace given with the code, how the entropy-optimal sort first partitions the array B A B A B A B A C A D A B R A.

2.3.13 What is the recursive depth of quicksort, in the best, worst, and average cases? This is the size of the stack that the system needs to keep track of the recursive calls. See EXERCISE 2.3.20 for a way to guarantee that the recursive depth is loarithmic in the worst case.

2.3.14 Prove that when running quicksort on an array with N distinct items, the probability of comparing the ith and jth largest items is 2/(j-i). Then use this result to prove PROPOSITION K.

2.3.15 *Nuts and bolts*.(G.J.E.Rawlins) You have a mixed pile of N nuts and N bolts and need to quickly find the corresponding pairs of nuts and bolts. Each nut matches exactly one bolt, and each bolt matches exactly one nut. By fitting a nut and bolt together, you can see which is bigger, but it is not possible to directly compare two nuts or two bolts. Give an efficient method for solving the problem.

*Hint*. customize quicksort to the problem. Side note: only a very complicated deterministic O(N log N) algorithm is known for this problem.
put a Nut on the first,use quicksort way to search, when find the matched bolts, put the another Nut on the first, use quicksort way to search again.

2.3.16 *Best case*. Write a program that produces a best-case array (with no duplicates) for sort() in ALGORITHM 2.5: an array of N items with distinct keys having the property that every partition will produce subarrays that differ in size by at most 1 (the same subarray sizes that would happen for an array of N equal keys). (For the purposes of this exercise, ignore the initial shuffle.)

*The following exercises describe variants of quicksort. Each of them calls for an implementation, but naturally you will also want to use SortCompare for experiments to evaluate the effectiveness of each suggested modification.*

*Solution*. QuickBest.java.

2.3.17 *Sentinels*. Modify the code in ALGORITHM 2.5 to remove both bounds checks in the inner while loops. The test against the left end of the subarray is redundant since the partitioning item acts as a sentinel (v is never less than a[lo]). to enable removal of the other test, put an item whose key is the largest in the whole array into a[length-1] just after the shuffle. This item will never move (except possibly to be swapped with an item having the same key) and will serve as a
sentinel in all subarrays involving the end of the array. *Note*:When sorting interior subarrays, the leftmost entry in the subarray to the right serves as a sentinel for the right end of the subarray.

2.3.18 *Median-of-3 partitioning*. Add median-of-3 partitioning to quicksort, as described in the text (see page 296). Run doubling tests to determine the effectiveness of the change.

2.3.19 *Median-of-5 partitioning*. Implement a quicksort based on partitioning on the median of a random sample of five items from the subarray. Put the items of the sample at the appropriate ends of the array so that only the median participates in partitioning. Run doubling tests to determine the effectiveness of the change, in comparision both to the standard algorithm and to median-of-3 partitioning (see the previous exercise). *Extra credit*: Devise a median-of-5
algorithm that uses fewer than seven compares on any input.

2.3.20 *Nonrecursive quicksort*. Implement a nonrecursive version of quicksort based on a main loop where a subarray is popped from a stack to be partitioned, and the resulting subarrays are pushed onto the stack. *Note*: Push the largest of the subarrays onto the stack first, which guarantees that the stack will have at most lg N entries.

**TODO**.

2.3.21 *Lower bound for sorting with equal keys*. Complete the first part of the proof of PROPOSITION M by following the logic in the proof of PROPOSITION I and using the observation that there are N!/f1!f2!...fk! different ways to arrange keys with k different values, where the ith value appears with frequency fi(=Npi, in the notation of PROPOSITION M), with f1+...+fk = N.

2.3.22 *Java system sort*. Add to your implementation from EXERCISE 2.3.22 code to use the Tukey ninther to compute the partitioning item-choose three sets of three items, take the median of each, then use the median of the three medians as the partitioning item. Also, add a cutoff to insertion sort for small subarrays.















