#EXERCISES

1.4.1 Show that the number of different triples that can be chosen from N items is precisely N(N-1)(N-2)/6. *Hint*: Use mathematical induction.

**Answer**:$y_k$ 

$$ C_N^3 = \frac{N!}{3!(N-3)!} $$

1.4.2 Modify **ThreeSum** to work properly even when the *int* values are so large that adding two of them might cause overflow.

1.4.3 Modify **DoublingTest** to use StdDraw to produce plots like the standard and log-log plots int the text, rescaling as necessary so that the plot always fills a substantial portion of the window.

1.4.4 Develop a table like the one on page 181 for TwoSum.

1.4.5 Give tilde approximations for the following quantities:

a. N + 1 ~ N
b. 1 + 1/N ~ ln(N)
c. (1 + 1/N)(1+2/N) ~ (lnN)^2
d. 2N^3-15N^2+N ~ N^3
e. lg(2N)/lgN 
f. lg(N2+1)/lgN
g. N^100/2^N

1.4.6 Give the order of growth (as a function of N) of the running times of each of the following code fragments:

a.
```

int sum = 0;
for (int n = N; n > 0; n /= 2)
    for (int i = 0; i < n; i++)
        sum++;

```

b.
```
int sum = 0; 
for (int i = 1; i < N; i *= 2)
    for (int j = 0; j < 1; j++)
        sum++;

```
c.
```
int sum = 0; 
for (int i = 1; i < N; i *= 2)
    for (int j = 0; j < N; j++)
        sum++;
```
*Answer*: linear(N+N/2+N/4+...); linear(1+2+4+8+...);linearithmic(the outer loop loops lg N times).


1.4.7 Analyze *ThreeSum* under a cost model that counts arithmetic operations (and comparisions) involving the input numbers.

p182, Cost model.

1.4.8 Write a program to determine the number pairs of values in an input file that are equal. If your first try is quadratic, think again and use Arrays.sort() to develop a linearithmic solution.

1.4.9 Give a formula to predict the running time of a program for a problem of size N when doubling experiments have shown that the doubling factor is $2^b and the running time for problems of size $N_0 is T.

*Answer*: T(N) = \frac{T}{N_0^blgN_0}N^blgN

1.4.10 Modify binary search so that it always returns the element with the smallest index that matches the search element (and still guarantees logarithmic running time).

1.4.11 Add an instance method *howMany()* to *StaticSETofInts*(page 99) that finds the number of occurrences of a given key in time proportional to log N in the worst case.


1.4.12 Write a program that, given two sorted arrays of N int values, prints all elements that appear in both arrays, in sorted order. The running time of your program should be proportional to N in the worst case.

1.4.13 Using the assumptions develped in the text, give the amount of memory needed to represent an object of each of the following types:

- a. Accumulator
- b. Transaction
- c. FixedCapacityStackOfStrings with capacity C and N entries
- d. Point2D
- e. Interval1D
- f. Interval2D
- g. Double

*Answer*:


1.4.14 *4-sum*. Develop an algorithm for the 4-sum problem.

1.4.15 *Faster 3-sum*. As a warmup, develop an implementation **TwoSumFaster** that uses a *linear* algorithm to count the pairs that sum to zero after the array is sorted (instead of the binary-search-based linearithmic algorithm). Then apply a similar idea to develop a quadratic algorithm for the 3-sum problem.

1.4.16 *Closest pair (in one dimension).* Write a program that, given an array a[] of N double values, finds a *closest pair*: two values whose difference is no greater than the the difference of any other pair (in absolute value). The running time of your program should be linearithmic in the worst case.

1.4.17 *Farthest pair (in one dimension)*. Write a program that, given an array a[] of N *double* values, finds a *farthest pair*: two values whose difference is no smaller than the difference of any other pair (in absolute value). The running time of your program should be linear in the worst case.

1.4.18 **Local minimum of an array**. Write a program that, given an array a[] of N **distinct**(if not, linear) integers, finds a local minimum: an index i such that both a[i] < a[i-1] and a[i] < a[i+1] (assuming the neighboring entry is bounds). Your program should use ~2lgN compares in the worst case.

*Answer*: Examine the middle value a[N/2] and its two neighbors a[N/2-1] and a[N/2+1]. If a[N/2] is a local minimum, stop; otherwise search in the half with smaller neighbor.

**solution**:
Use a divide-and-conquer algorithm. Let m = n/2, and examine the value A[m] (that is, the element in the middle of the array).

Case 1: A[m−1] < A[m]. Then the left half of the array must contain a local minimum, so recurse on the left half. We can show this by contradiction: assume that A[i] is not a local minimum for each 0 ≤ i < m. Then A[m−1] is not a local minimum, which implies that A[m−2] < A[m−1]. Similarly, A[m −3] < A[m −2]. Continuing in this fashion, we obtain A[0] < A[1]. But then A[0] is a local minimum, contrary to our initial assumption.

Case 2: A[m + 1] > A[m]. Then the right half of the array must contain a local minimum, so recurse on the right half. This is symmetrical to Case 1.

Case 3: A[m − 1] > A[m] and A[m + 1] < A[m]. Then A[m] is a local minimum, so return it. The running time recurrence is T(n) = T(n/2) + Θ(1), which yields T(n) = Θ(log n).

[Solution Web](https://www.geeksforgeeks.org/find-local-minima-array/)

1.4.19 *Local minimum of a matrix*. Given an N-by-N array a[] of $N^2 **distinct** integers, design an algorithm that runs in time proportional to N to find a *local minimum*: a pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1], a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1]. The running time of your program should be proportional to N in the worst case.

*Hint*: Find the minimum entry in row N/2, say a[N/2][j]. Check its two vertical neighbors a[N/2-1][j] and a[N/2+1][j]. Recur in the half with the samller neighbor. In that half, find the minimum entry in column N/2.


**No To Do**.

1.4.20 *Bitonic search*. An array is *bitonic* if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of N distinct int values, determines whether a given integer is in the array. Your program should use ~3lgN compares in the worst case.

[Solution Web](https://www.geeksforgeeks.org/find-element-bitonic-array/)







