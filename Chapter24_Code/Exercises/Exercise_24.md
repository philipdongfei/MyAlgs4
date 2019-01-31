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


##Web Exercises
1. **Best, average, and worst case of heapsort**. What's are the best case, average case, and worst case number of compares for heapsorting an array of length n?

*Solution*. If we allow duplicates, the best case is linear time (n equal keys); if we disallow duplicates, the best case is ~ n lg n compares (but the best case input is nontrivial). The average and worst case number of compares is ~2 n lg n compares. 


2.**Best and worst case of heapify**. What is the fewest and most number of compares/exchanges needed to heapify an array of n items?
*Solution*. Heapifying an array of n items in descending order requires 0 exchanges and n-1 compares. Heapifying an array of n items in ascending order requires ~n exchanges and ~2n compares.

3. **Taxicab numbers**. Find the smallest integers that can be expressed as the sum of cubes of integers in two different ways(1729), three different ways(87,539,319), four different ways(6,963,472,309,248), five different ways (48,988,659,276,962,496), and six different ways(24,153,319,581,254,312,065,344). Such integers are named Taxicab numbers after the famous Ramanujan story. The smallest integers that can be expressed as the sum of cubes of integers in seven different ways
   is currently unknown. Write a program Taxicab.java that reads in a command line parameter N and prints out all nontrivial solutions of $$a^3+b^3=c^3+d^3$$.such the a, b, c, and d, are less than or equal to N.

4. **Computational number theory**. Find all solutions to the equation a+2b^2=3c^3+4d^4 for which a, b, c, and d are less than 100,000.*Hint*: use one min heap and one max heap.

**TODO**:

5. **Interrupt handling**. When programming a real-time system that can be interrupted (e.g., by a mouse click or wireless connection), it is necessary to attend to the interrupts immediately, before proceeding with the current activity. If the inteerrupts should be handled in the same order they arrive, then a FIFO queue is the appropriate data structure. However, if different interrupts have different priorities(e.g.,), then we need a prioprity queue.

6. **Simulation of queueing networks**. M/M/1 queue for double parallel queues, etc. Difficult to analyze complex queueing networks mathematically. Instead use simulation to plot distribution of waiting times, etc. Need priority queue to determine which event to process next.

7. **Zipf distribution**. Use the result of the previous exercise(s) to sample from the Zipfian distribution with parameter s and n. The distribution can take on integer values from 1 to n, and takes on value k with probability$$1/k^s/sum_(i=1 to n)1/i^s. Example: words in Shakespeare's play Hamlet with s approximately equal to 1.

8. **Random process**. Begin with n bins, each consisting one ball. Randomly select one of the n balls and move the ball to a bin at random such that the probability that a ball is placed in a bin with m balls is m/n. What is the distribution of balls that results after many iterations? Use the random sampling method described above to make the simulation efficient.

9. **Nearest neightbors**. Given n vectors x1,x2,...,x_N of length m and another vector x of the same length, find the 20 vectors that are closest to x.

10. **Circle drawn on a piece of graph paper**. Write a program to find the radius of a circle, centered on the origin, that touches 32 points with integer x- and y- coordinates.*Hint*: look for a number than can be expressed as the sum of two squares in several different ways.
**Answer**: there are two Pythagorean triples with hypotenuse 25: 15^2+20^2=25^2, 7^2+24^2=25^2 yielding 20 such lattice points; there are 22 different Pythagorean triples with hypotenuse 5,525; this leads to 180 lattice points. 27,625 is smallest radius that touches more than 64. 154,136,450 has 36 Pythagorean triples.

11. **Perfect powers**. Write a program PerfectPower.java to print out all perfect powers that can be represented as 64-bit long integers: 4,8,9,16,25,27,... A perfect power is a number that can be written as a^b for integers a and b>=2.

12. **Floating point additions**. Add up n floating-point numbers, avoiding roundoff error. Delete smallest two: add two each other, and reinsert.

13. **First-fit for bin packing**. 17/10 OPT + 2, 11/9 OPT + 4(decreasing). Use max tournament tree in which players are N bins and value = available capacity.

*TODO*:

14. **Stack with min/max**. Design a data type that supports push, pop, size, min, and max(where min and max are the minimum and maximum items on the stack). All operations should take constant time in the worst case.

*Hint*: Associate with each stack entry the minimum and maximum items currently on the stack.

15. **Queue with min/max**. Design a data type that supports enqueue, dequeue, size, min, and max (where min and max are the minimum and maximum items on the queue). All operations should take constant amortized time.

*Hint*: do the previous exercise and simulate a queue with two stacks.

16. *2^i+5^j*. Print numbers of the form 2^i*5^j in increasing order.

17. **Min-Max heap**. Design a data structure that supports min and max in constant time, insert, delete min, and delete max in logarithmic time by putting the items in a single array of size n with the following properties:
- The array represents a complete binary tree.
- The key in a node at an even level is less than (or equal to) the keys in its subtree; the key in a node at an odd level is greater than (or equal to) the keys in its subtree.
Note that the maximum value is stored at the root and the minimum value is stored at one of the root's children.

*Solution*. Min-Max Heaps and Generalized Priority Queues.

18. **Range minimum query**. Given a sequence of n items, a range minimum query from index i to j is the index of the minimum item between i and j. Design a data structure that preprocesses the sequence of n items in linear time to support range minimum queries in logarithmic tim.
**TODO**
*Solution*.[RMQ](https://zh.wikipedia.org/wiki/%E8%8C%83%E5%9B%B4%E6%9C%80%E5%80%BC%E6%9F%A5%E8%AF%A2)

19. Prove that a complete binary tree with n codes has exactly ceiling(n/2) leaf nodes (nodes with no children).

20. **Max-oriented priority queue with min**. What is the order of growth of the running time to find a minimum key in a maximum-oriented binary heap.

*Solution*: linear--the minimum key could be in any of the ceiling(n/2)leaf nodes.

21. **Max-oriented priority queue with min**. Design a data type that supports insert and remove-the-maximum in logarithmic time along with both max an min in constant time.

22. **kth largest item greater than x**. Given a maximum oriented binary heap, design an algorithm to determine whether the kth largest item is greater than or equal to x. Your algorithm should run in time proportional to k.

*Solution*: if the key in the node is greater than or equal to x, recursively search both the left subtree and the right subtree. Stop when the number of node explored is equal to k (the answer is yes) or there are no more nodes to explore (no).

23. **kth smallest item in a min-oriented binary heap**. Design a k log k algorithm to find the kth smallest item in a min-oriented heap H containing n items.

*Solution*. Build a new min-oriented heap H'. We will not modify H. Insert the root of H into H' along with its heap index 1. Now, repeatedly delete the minimum item x in H' and insert into H' the two child of x from H. The kth item deleted from H' is the kth smallest item in H.

24. **Randomized queue**. Implement a RandomQueue so that each opeation is guarateed to take at most logarithmic time. *Hint*: can't afford array doubling. No easy way with linked lists to locate a random element in O(1) time. Instead, use a complete binary tree with explicit links.

25. **FIFO queue with random deletion**. Implement a data type that supports the following operations: insert an item, delete the item that was least recently added, and delete a random item. Each operation should take (at most) logarithmic time in the worst case.

*Solution*: Use a complete binary tree with explicit links; assign the long integer priority i to the ith item added to the data structure.

26. **Top k sums of two sorted arrays**. Given two sorted arrays a[] and b[], each of length n, find the largest k sums of the form a[i]+b[j].

*Hint*: Using a priority queue (similar to the taxicab problem), you can achieve an O(klogn) algorithm. Surprisingly, it is possible to do it in O(k) time but the algorithm is complicated.

27. **Empirical analysis of heap construction**. Empirically compare the linear-time bottom-up heap construction versus the naive linearithmic-time top-down heap construction. Be sure to compare it over a range of values of n. LaMarca and Ladner report the because of cache locality, the naive algorithm can perform better in practice than the more clever approach for large values of n (when the heap no longer fits in the cache) even though the latter performs many fewer compares and exchanges.

28. **Empirical analysis of multiway heaps**. Empirically compare the performance of 2-4- and 8-way heaps. LaMarca and Ladner suggest several optimizations, taking into account caching effects.

29, **Empirically analysis of heapsort**. Empirically compare the performance of 2-4- and 8-way heapsort. LaMarca and Ladner suggest several optimizations, taking into account caching effects. Their data indicates that an optimized (and memory-tuned) 8-way heapsort can be twice as fast as classic heapsort.

*Solution*: 27,28,29 see LaMarca and Ladner paper.

30. **Heapify by insertions**. Suppose that you build a binary heap on n keys by repeatedly inserting the next key into the binary heap. Show that the total number of compares is at most ~nlogn.

*Answer*: the number of compares is at most lg1+lg2+...+lgn=lg(n!)~nlgn.

31. **Heapify lower bound. (Gonnet and Munro)** Show that any compare-based algorithm for building a binary heap on n keys takes at least ~1.3644N in the worst case.
*Answer*: use an information theoretic argument, ala sorting lower bound. There are n~ possible heaps (permutation of the N integers) on n distinct keys, but there are many heaps that correspond to the same ordering. For example, there are two heaps(c a b and c b a) that corerspond to the 3 elements a<b<c. For a perfect heap (with n=2^h-1), there are A(h)=n!/prod((2^k-1)^(2^(h-k)), k=1..h) heaps corresponding to the n elements a[0]<a[1]<...<a[n-1]. (See Sloane sequence A05697.)
Thus, any algorithm must be able to output one of P(h)=prod((2^k-1)^(2^(h-k)),,k=1..h) possible answers. Using some fancy mathematics, you can argue that lg P(h)~1.3644n.
*Note*: The lower bound can be improved to ~3/2n(Carlsson-Chen) using an adversary argument; the best-known algorithm for the problem takes ~1.625n compares in the worst case (Gonnet and Munro).

32. **Stock exchange matching engine**. Continuous limit order book:traders continuously post bids to buy or sell stock. A limit order means that a buyer(seller) places an order to buy(sell) a specified amount of a given stock at or below) (at or above) a given price. The order book displays buy and sell orders, and ranks them by price and then by time. Matching engine matches compatible buyers and sellers; if there are multiple possible buyers, break ties by choosing
    the buyer that placed the bid earliest. Use two priority queues for each stock, one of buyers and one for sellers.
    
TODO.

33. **Random binary heap**. Suppose that you fill an array of length n with a random permutation of the integers 1 to n. What is the probability that resulting array is a minimum-oriented binary heap for n = 5 and 6?

*Solution*: 1/15 and 1/36, respectively. Here is a nice discussion of the problem.
















