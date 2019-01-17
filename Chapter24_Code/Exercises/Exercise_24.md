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






