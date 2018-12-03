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

1.4.21 *Binary search on distinct values*. Develop an implementation of binary search for **StaticSETofInts**(see page 98) where the running time of contains() is guaranteed to be ~lgR, where R is the number of different integers in the array given as argument to the constructor.

1.4.22 *Binary search with only addition and substraction.* [Mihai Patrascu] Write a program that, given an array of N distinct int values in ascending order, determines whether a given integer is in the array. You may use only additions and substractions and a constant amout of extra memory. The running time of your program should be proportional to log N in the worst case.

**Answer**: Instead of searching based on powers of two (binary search), use Fibonacci numbers (which also grow exponentially). Maintain the current search range to be the interval[i, i+F_k] and keep $F_k and $F_k-1 in two variables. At each step compute $F_k-2 via substraction, check element i+$F_k-2, and update the current range to either [i, i+$F_k-2] or [i+$F_k-2, i+$F_k-2+$F_k-1].

1.4.23 *Binary search for a fraction*. Devise a method that uses a logarithmic number of queries of the form *Is the number less than x*? to find a rational number p/q such that 0 < p < q < N. *Hint*: Two fractions with denominators less than N cannot differ by more than 1/$N^2.


1.4.23 **Binary search with duplicates**. Modify binary search so that it always returns the smallest(largest) index of a key of an item matching the search key.

1.4.24 **Throwing eggs from a building**. Suppose that you have an N-story building and plenty of eggs. Suppose also that an egg is broken if it is thrown off floor F or higher, and unbroken otherwise. First, devise a strategy to determine the value of F such that the number of broken eggs is ~lg N when eggs is ~lg N throws, then find a way to reduce the cost to ~2lgF when N is much larger than F.

1.4.25 **Throwing two eggs from a building**. Consider the previous question, but now suppose you only have two eggs, and your cost model is the number of throws. Devise a strategy to determine F such that the number of throws is at most 2 sqrt(N), then find a way to reduce the cost to ~csqrt(F) for some constant c.

1.4.26 *3-collinearity*. Suppose that you have an algorithm that takes as input N distinct points in the plane and can return the number of triples that fall on the same line. Show that you can use this algorithm to solve the 3-sum problem. *Strong hint*: Use algebra to show that (a,a^3), (b, b^3),and (c,c^3) are collinear if and only if a+b+c = 0.

1.4.27 *Queue with two stack*. Implement a queue with two stacks so that each queue operation takes a constant amortized number of stack operation. *Hint*: If you push elements onto a stack and then pop them all, they appear in reverse order. If you repeat this process, they're now back in order.

1.4.28 *Stack with a queue*. Implement a stack with a single queue so that each stack operations takes a linear number of queue operations. *Hint*: to delete an item, get all of the elements on the queue one at a time, and put them at the end, except for the last one which you should delete and return. (This solution is admittedly very inefficient.)

1.4.29 *Steque with two stacks*. Implement a steque with two stacks so that each steque operation (see EXERCISE 1.3.32) takes a constant amortized number of stack operations.

1.4.30 *Deque with a stack and a steque*. Implement a deque with a stack and a steque (see EXERCISE 1.3.32) so that each deque operation takes a constant amortized number of stack and steque operations.

1.4.31 *Deque with three stacks*. Implement a deque with three stacks so that each deque operation takes a constant amortized number of stack operations.

1.4.32 *Amortized analysis*. Prove that, starting from an empty stack, the number of array accesses used by any sequence of M operations in the resizing array implementation of Stack is proportional to M.

1.4.33 *Memory requirements on a 32-bit machine.* Give the memory requirements for Integer, Date, Counter, int[], double[], double[][], String, Node, and Stack (linked-list representation) for a 32-bit machine. Assume that references are 4 bytes, object overhead is 8 bytes, and padding is to a multiple of 4 bytes.

1.4.34 *Hot or cold*. Your goal is to guess a secret integer between 1 and N. You repeatedly guess integers between 1 and N. After each guess you learn if your guess equals the secret integer (and the game stops). Otherwise, you learn if the guess is hotter (closer to) or colder (farther from) the secret number than your previous guess. Design an algorithm that finds the secret number in at most ~2lgN guesses. Then design an algorithm that finds the secret number in at most ~1lgN
guesses.

*Hint*: use binary search for the first part. For the second part, first design an algorithm that solves the problem in ~ 1 lg N guesses assuming you are permitted to guess integers in the range -N to 2N.

*Answer*: We still need to prove that our guess will always fall in between [-N,2N].
By recurrence, suppose that c (our previous guess) is in [a-(a+b), b+(a+b)] = [-b, a+2b]
Then d = a+b-c <= a+b-(-b) <= (a+2b) and d = a+b-c >= a+b-(a+2b) >= -b
Initial case: a = 1, b = N, c = 1, c is indeed in [-b, a+2*b]

1.4.35 *Time costs for pushdown stacks*. Justify the entries in the table below, which shows typical time costs for various pushdown stack implementations, using a cost model that counts both *data references* (references to data pushed onto the stack, either an array reference or a reference to an object's instance variable) and *object created*.

data structure         item type      data references    objects created
linked list             int                 2N               N
                        Integer             3N              2N
resizing array          int                 ~5N             lgN
                        Integer             ~5N             ~N

1.4.36 *Space usage for pushdown stacks. Justify the entries in the table below, which show typical space usage for various pushdown stack implementations. Use a static nested class for linked-list nodes to avoid the non-static nested class overhead.

data structure         item type        space usage for N int values(bytes)
linked list             int                 ~32N
                        Integer             ~56N
resizing array          int             between ~4N and ~16N
                        Integer         between ~32N and ~56N

1.4.37 *Autoboxing performance penalty*. Run experiments to determine the performance penalty on your machine for using autoboxing and auto-unboxing. Develop an implementation **FixedCapacityStackOfInts** and use a client such as **DoublingRatio** to compare its performance with the generic **FixedCapacityStack<Integer>**, for a large number of push() and pop() operation.

1.4.38 *Naive 3-sum implementation*. Runexperiments to evaluate the following implementation of the inner loop of ThreeSum:
```
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            for (int k = 0; k < N; k++)
                if (i < j && j < k)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
                
```
Do so by developing a version of DoublingTest that computes the ratio of the running times of this program and ThreeSum.

1.4.39 *Improved accuracy for doubling test*. Modify DoublingRatio to take a second command-line argument that specifies the number of calls to make to timeTrial() for each value of N. Run your program for 10, 100, and 1,000 trials and comment on the precision of the results.

1.4.40 *3-sum for random values*. Formulate and validate a hypothesis describing the number of triples of N random int values that sum to 0. If you are skilled in mathematical analysis, develop an appropriate mathematical model for this problem, where the values are uniformly distributed between - M and M, where M is not small.

1.4.41 *Running times*. Estimate the amount of time it would take to run *TwoSumFast, TwoSum, ThreeSumFast and ThreeSum on your computer to solve the problems for a file of 1 million numbers. Use *DoublingRaton* to do so.

1.4.42 *Problem sizes*. Estimate the size of the largest value of P for which you can run *TwoSumFast, TwoSum, ThreeSumFast,* and *ThreeSum* on your computer to solve the problems for a file of 2^p thousand numbers. Use *DoublingRatio* to do so.

1.4.43 *Resizing arrays versus linked lists*. Run experiments to validate the hypothesis that resizing arrays are faster than linked lists for stacks (see EXERCISE 1.4.35 and EXERCISE 1.4.36). do so by developing a version of DoublingRatio that computes the ratio of the running times of the two programs.

1.4.44 *Birthday problem*. Write a program that takes an integer N from the command line and uses StdRandom.uniform() to generate a random sequence of integers between 0 and N-1. Run experiments to validate the hypothesis that the number of integers generated before the first repeated value is found is ~sqrt(pi*N/2).

1.4.45 *Coupon collector problem*. Generating random integers as in the previous exercise, run experiments to validate the hypothesis that the number of integers generated before all possible values are generated is ~NH_N.

























