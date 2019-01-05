#EXERCISES

2.2.1 Give a trace, in the style of the trace given at the beginning of this section, showing how the keys A E Q S U Y E I N O S T are merged with the abstract in-place merge() method.


2.2.2 Give traces, in the style of the trace given with ALGORITHM 2.4, showing how the keys E A S Y Q U E S T I O N are sorted with top-down mergesort.

2.2.3 Answer EXERCISE 2.2.2 for bottom-up mergesort.

2.2.4 Does the abstract inplace merge produce proper output if and only if the two input subarrays are in sorted order? Prove your answer, or provide a counterexample.

**Solution**. Yes, If the subarrays are in sorted order, then the inplace merge produces proper output. If one subarray is not in sorted order, then its entries will appear in the output in the same order that they appear in the input (with entries from the other subarray intermixed).

2.2.5 Give the sequence of subarray sizes in the merges performed by both the top-down and the bottom-up mergesort algorithms, for N = 39.

Solution.

    - Top-down mergesort: 2, 3, 2, 5, 2, 3, 2, 5, 10, 2, 3, 2, 5, 2, 3, 2, 5, 10, 20, 2, 3, 2, 5, 2, 3, 2, 5, 10, 2, 3, 2, 5, 2, 2, 4, 9, 19, 39.
    - Bottom-up mergesort: 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 8, 8, 8, 8, 7, 16, 16, 32, 39. 

Code: MergeSizes.java

2.2.6 Wite a program to compute the exact value of the number of array accesses used by top-down mergesort and by bottom-up mergesort. Use your program to plot the values for N from 1 to 512, and to compare the exact values with the upper bound 6NlgN.

2.2.7 Show that the number of compares used by mergesort is monotonically increasing (C(N+1)>C(N) for all N>0).

2.2.8 Suppose that top-down mergesort is modified to skip the call on merge() whenever a[mid] <= a[mid+1]. Prove that the number of compares used for an array in sorted order is linear.

*Solution*. Since the array is already sorted, there will be no calls to merge(). When N is a power of 2, the number of compares will satifsfy the recurrence T(N) = 2T(N/2)+1, with T(1) = 0.

2.2.9 Use of a static array like aux[] is inadvisable in library software because multiple clients might use the class concurrently. Give an implementation of Merge that does not use a static array. Do not makeaux[] local to merge() (see the Q&A for this section).
*Hint*. Pass the auxiliary array as an argument to the recursive sort().



