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
1. **Frequency counts**. 















