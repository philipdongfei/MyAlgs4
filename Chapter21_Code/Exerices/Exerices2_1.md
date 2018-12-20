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



