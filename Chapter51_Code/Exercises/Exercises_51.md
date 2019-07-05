#EXERCISES

##Book Exercises

5.1.1 Develop a sort implementation that counts the number of different key values, then uses a symbol table to apply key-indexed counting to sort the array.(This method is not for use when the number of different key values is large.)

*Solution:* KeyIndexCounting.java

5.1.2 Give a trace for LSD string sort for the keys.
no is th ti fo al go pe to co to th ai of th pa

5.1.3 Give a trace of MSD string sort for the keys.
no is th ti fo al go pe to co to th ai of th pa

5.1.4 Give a trace of 3-way string quicksort for the keys
no is th ti fo al go pe to co to th ai of th pa

5.1.5 Give a trace for MSD string sort for the keys

now is the time for all good peaple to come to the aid of

5.1.6 Give a trace of 3-way string quicksort for the keys

now is the time for all good peaple to come to the aid of

5.1.7 Develop an implementation of key-indexed counting that makes use of an array of Queue objects.

5.1.8 Give the number of characters examined by MSD string sort and 3-way string quicksort for a file of N keys a, aa, aaa, aaaa, aaaaa,...

5.1.9 Develop an implementation of LSD string sort that works for variable-length strings.

5.1.10 What is the total number of characters examined by 3-way string quicksort when sorting N fixed-length strings (all of length W), in the worst case?

N*W

5.1.11 *Queue sort*. Implement MSD string sorting using queues, as follows: Keep one queue for each bin. On a first pass through the items to be sorted, insert each item into the appropriate queue, according to its leading character value. Then, sort the sublists and stitch together all the queues to make a sorted whole. Note that this method does not involve keeping the count[] arrays within the recursive method.

5.1.12 *Alphabet*. Develop an implementation of the Alphabet API that is given on page 698 and use it to develop LSD and MSD sorts for general alphabets.

5.1.13 *Hybrid sort*. Investigate the idea of using standard MSD string sort for large arrays, in order to get the advantage of multiway partitioning, and 3-way string quicksort for smaller arrays, in order to avoid the negative effects of large numbers of empty bins.

5.1.14 *Array sort*. Develop a method that uses 3-way string quicksort for keys that are arrays of int values.

5.1.15 *Sublinear sort*. Develop a sort implementation for int values that makes two passes through the array to do an LSD sort on the leading 16 bits of the keys, then does an insertion sort.

5.1.16 *Linked-list sort*. Develop a sort implementation that takes a linked list of nodes with String key values as argument and rearranges the nodes so that they appear in sorted order (returning a link to the node with the smallest key). Use 3-way string quicksort.

5.1.17 *In-place key-indexed counting*. Develop a version of key-indexed counting that uses only a constant amount of extra space. Prove that your version is stable or provide a counterexample.

##Exercises(web)
1. **Frequency counts**. Read in a list of strings and print out their frequency counts. Algorithm: read strings into an array, 3-way radix quicksort them, and compute their frequency counts. Bonus speedup: compute the counts during the 3-way partitioning. Disadvantage: uses space to store all the strings. Alternate: TST.


2. **Sorting uniformly distributed data**. Given N random real numbers from [0, 1], consider the following algorithm for sorting them: Partition [0, 1] into N equally spaced sub-intervals. Rearrange (ala cumulative counts) the N elements so that each element is in its appropriate bucket. Insertion sort the elements in each bucket (or equivalently, just insertioin sort the whole file). That is. MSD radix sort for one level, then cutoff to insertion sort. [Try to do
   in-place?]

*Solution*: It will take O(N) time in total on average. Let n_i be the number of elements in bucket i. The expected time to insertion sort all of the buckets in O(n) since E[sum_i(n_i)^2] <= 2n.

3. Given an array of N decimal integers of different lengths, describe how to sort them in O(N+K) time, where K is the total number of digits overall all the N integers.

4. **American flag sort**. (in-place key-indexed counting) Given an array with N distinct values between 0 and R-1, rearrange them in ascending order in linear time and with O(R) extra space. Leads to an (essentially) in-place string sort.

*Hint*: compute the count[] array, which tells you where the keys need to go. Scan over the input array. Take the first key, find the bin in which it belong, and swap it into place (updating the corresponding count[] entry.) Repeat with the second key, but be careful to skip over keys already known to be where they belong.

##WebExercises

1. **2-sum**. Given an array a[] of N 64-bit integers and a target value T, determine whether there are two distinct integers i and j such that a[i] + a[j] equals T. Your algorithm should run in linear time in the worst case.

*Solution*. Radix sort the array in linear time. Scan a pointer i from left to right and a pointer j from right to left: consider a[i]+a[j]. If it is bigger than T, advance the j pointer; if it is smaller than T, advance the i pointer; if it is equal to T, we have found the desired indices.

Note that the array of integers can be radix sorted in linear time and constant extra space using the advanced radix sorting algorithm of Franceschini, Muthukrishnan, and Patrascu.

2. **Binary search in a sorted array of strings**. Implement a version of binary search for sorted arrays of strings that keeps track of how many characters are known to be in common between the query string and the lo and hi endpoints. Use this information to avoid character compares during binary search. Compare the performance of this algorithm with a version that calls compareTo(). (The compareTo() approach has the advantage that it doesn't need to make calls to charAt() because it is implemented as an instance method of the String data type).


















