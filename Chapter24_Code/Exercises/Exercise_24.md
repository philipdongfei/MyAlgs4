#EXERCISES

2.4.1 Suppose that the sequence P R I O * R * * I * T * Y * * * Q U E * * * U * E (where a letter means *insert* and an asterisk means *remove the maximum*) is applied to an initially empty priority queue. Give the sequence of letters returned by the *remove the maximum* operations.

2.4.2 Criticize the following idea: To implement *find the maximum* in constant time, why not use a stack or a queue, but keep track of the maximum value inserted so far, then return that value for *find the maximum*?

*Solution*. Will need to update the maximum value from scratch after a remove-the-maximum operation.

2.4.3 Provide priority queue implementations that support insert and remove the maximum, one for each of the following underlying data structures: unordered array, ordered array, unordered linked list, and ordered linked list. Give a table of the worst-case bounds for each operation for each of your four implementations from the previous exercise.

2.4.4 Is an array that is sorted in decreasing order a max-oriented heap?

*Solution*. Yes.

2.4.5 Give the heap that results when the keys E A S Y Q U E S T I O N are inserted in that order into an initially empty max-oriented heap.

2.4.6 Using the conventions of EXERCISE 2.4.1, give the sequence of heaps produced when the operations P R I O * R * * I * T * Y * * * Q U E * * * U * E are performed on an initially empty max-oriented heap.

2.4.7 The largest item in a heap must appear in position 1, and the second largest must be in position 2 or position 3. Give the list of positions in a heap of size 31 where the kth largest (i) can appear (ii) cannot appear, for k = 2,3,4 (assuming the values to be distinct).

2.4.8 Answer the previous exercise for the kth *smallest* item.

2.4.9 Draw all of the different heaps that can be made from the five keys A B C D E, then draw all of the different heaps that can be made from the five keys A A A B B.

*Solution*. EDBAC
            BBAAA

2.4.10 Suppose that we wish to avoid wasting one position in a heap-ordered array pq[], putting the largest value in pq[0], its children in pq[1] and pq[2], and so forth, proceeding in level order. Where are the parents and children of pq[k]?

*Solution*. parent of k is (k-1)/2 
            childs of k are 2k+1, 2k+2.

2.4.11 Suppose that your application will have a huge number of *insert* operations, but only a few *remove the maximum* operations. Which priority-queue implementation do you think would be most effective: heap, unordered array, or ordered array?

*Answer*. Unordered array. Insert is constant time.

2.4.12 Suppose that your application will have a huge number of *find the maximum* operations, but a relatively small number of *insert* and *remove the maximum* operations. Which priority queue implementation do you think would be most effective: heap, unordered array, ordered array?

*Answer*. Ordered array. Find the maximum is constant time.

2.4.13 Describe a way to avoid the j < N test in sink().

*Solution*. while(2*k < N) j = 2*k;

2.4.14 What is the minimum number of items that must be exchanged during a remove the maximum operation in a heap of size N with no duplicate keys? Give a heap of size 15 for which the minimum is achieved. Answer the same questions for two and three successive *remove the maximum* operations.

*Solution*. heap: 15 14 13 6 5 11 12 4 3 2 1 8 7 9 10
1) 2
2) 5
3) 8


2.4.15 Design a linear-time certification algorithm to check whether an array pq[] is a min-oriented heap.

2.4.16 For N=32, give arrays of items that make heapsort use as many and as few compares as possible.

2.4.17 Prove that building a minimum-oriented priority queue of size k then doing N-k replace the minimum (insert followed by remove the minimum) operations leaves the k largest of the N items in the priority queue.

2.4.18 In MaxPQ, suppose that a client calls insert() with an item that is larger than all items in the queue, and then immediately calls delMax(). Assume that there are no duplicate keys. Is the resulting heap identical to the heap as it was before these operations? Answer the same question for two insert() operations (the first with a key larger than all keys in the queue and the second for a key larger than that one) followed by two delMax() operations.

*Answer*. Yes, Yes

2.4.19 Implement the constructor for MaxPQ that takes an array of items as argument, using the bottom-up heap construction method described on page 323 in the text.

2.4.20 Prove that sink-based heap construction uses at most 2N compares and at most N exchanges.

2.4.21 *Elementary data structures*. Explain how to use a priority queue to implement the stack, queue, and randomized queue data types from CHAPTER 1.

2.4.22 *Array resizing*. Add array resizing to MaxPQ, and prove bounds like those of PROPOSITION Q from array accesses, in an amortized sense.

2.4.23 *Multiway heaps*. Considering the cost of compares only, and assuming that it takes t compares to find the largest of t items, find the value of t that minimizes the coefficient of NlgN in the compare count when a t-ary heap is used in heapsort. First, assume a straightforward generalization of sink(); then, assume that Floyd's method can save one compare in the inner loop.

*TODO*.

2.4.24 *Priority queue with explicit links. Implement a priority queue using a heapordered binary tree, but use a triply linked structure instead of an array. You will need three links per node: two to traverse down the tree and one to traverse up the tree. Your implementation should guarantee logarithmic running time per operation, even if no maximum priority-queue size is known ahead of time.

2.4.25 *Computational number theory*. Write a program CubeSum.java that prints out all integers of the form a^3+b^3 where a and b are integers between 0 and N in sorted order, without using excessive space. That is, instead of computing an array of the N^2 sums and sorting them, build a minimum-oriented priority queue, initially containing (0^3,0,0), (1^3,1,0),(2^3,2,0),...(N^3,N,0). Then, while the priority queue is nonempty, *remove the smallest* item(i^3+j^3, i, j), print
it, and then, if j < N, insert the item (i^3+(j+1)^3,i,j+1). Use this program to find all distinct mintegers a, b, c ,and d between 0 and 10^6 such that a^3+b^3=c^3+d^3.


2.4.26 *Heap without exchanges*. Because the exch() primitive is used in the sink() and swim() operations, the items are loaded and stored twice as often as necessary. Give more efficient implementations that avoid this inefficiency, a la insertion sort(see EXERCISE 2.1.25).

**TODO**.


2.4.27 *Find the minimum*. Add a min() method to MaxPQ. Your implementation should use constant time and constant extra space.

*Solution*. add an extra instance variable that points to the minimum item. Update it after each call to insert(). Reset it to null if the priority queue becomes empty.

2.4.28 *Selection filter*. Write a TopM client that reads points(x, y, z) from standard input, takes a value M from the command line, and prints the M points that are closest to the origin in Euclidean distance. Estimate the running time of your client from N = 10^8 and M = 10^4;

2.4.29 *Min/max priority queue*. Design a data type that supports the following operations: insert, delete the maximum, and delete the minimum (all in logithmic time); and find the maximum and find the minimum (both in constant time). *Hint*: Use two heaps.

2.4.30 *Dynamic median-finding*. Design a data type that supports insert in logarithmic time, find the median in constant time, and delete the median in logarithmic time. *Hint*: Use a min-heap and a max-heap.

*Solution*. Keep the median key in v; use a max-oriented heap for keys less than the key of v; use a min-oriented heap for keys greater than the key of v. To insert, add the new key into the appropriate heap, replace with the key extracted from that heap.

2.4.31 *Fast insert*. Develop a compare-based implementation of the MinPQ API such that insert uses ~log log N compares and delete the minimum uses ~2log N compares. *Hint*: Use binary search on parent pointers to find the ancestor in swim().

2.4.32 *Lower bound*. Prove that it is impossible to develop a compare-based implementation of the MinPQ API such that both insert and delete the minimum guarantee to use ~NloglogN compares.
*Solution*. This would yield an nloglogn compare-based sorting algorithm(insert the n items, then repeatedly remove the minimum), violating the proposition of Sectioin 2.3.

2.4.33 *Index priority-queue implementation*. Implement the basic operations in the index priority-queue API on page 320 by modifying ALGORITHM 2.6 as follows: Change pq[] to hold indices, add an array keys[] to hold the key values, and add an array qp[] that is the inverse of pq[]--qp[] gives the position of i inpq[] (the index j such that pq[j] is i). Then modify the code in ALGORITHM 2.6 to maintain these data structures. Use the convention that qp[i] = -1 if i is not on
the queue, and include a method contains() that tests this condition. You need to modify the helper methods exch() and less() but not sink() or swim().


2.4.34 *Index priority-queue implementation(additional operations)*. Add minIndex(), change(), and delete() to your implementation of EXERCISE 2.4.33.

2.4.35 *Sampling from a discrete probability distribution*. Write a class Sample with a constructor that takes an array p[] of double values as argument and supports the following two operations: random()-return an index i with probability p[i]/T (where T is the sum of the numbers in p[])--and change(i, v)--change the value of p[i] to v. *Hint*: Use a complete binary tree where each node has implied weight p[i]. Store in each node the cumulative weight of all the nodes
in its subtree. To generate a random index, pick a random number between 0 and T and use the cumulative weights to determine which branch of the subtree to explore. When updating p[i], change all of the weights of the nodes on the path from the root to i. Avoid explicit pointers, as we do for heaps.










