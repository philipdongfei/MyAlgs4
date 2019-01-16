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


