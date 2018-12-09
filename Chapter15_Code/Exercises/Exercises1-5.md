1.5.1 Show the contents of the id[] array and the number of times the array is accessed for each input pair when you use quick-find for the sequence 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2.

1.5.2 Do **EXERCISE 1.5.1**, but use quick-union (page 224). In addition, draw the forest of trees represented by the id[] array after each input pair is processed.

1.5.3 Do EXERCISE 1.5.1, but use weighted quick-union (page 228).

1.5.4 Show the contents of the sz[] and id[] arrays and number of array accesses for each input pair corresponding to the weighted quick-union examples in the text (both the reference input and the worst-case input).

1.5.5 Estimate the minimum amount of time (in days) that would be required for quick-find to solve a dynamic connectivity problem with 10^9 site and 10^6 input pairs, on a computer capable of executing 10^9 instructions per second. Assume that each iteration of the inner for loop requires 10 machine instructions.

1.5.6 Repeat EXERCISE 1.5.5 for weighted quick-union.

1.5.7 Develop classes *QuickUnionUF* and *QuickFindUF* that implement quick-union and quick-find, respectively.

1.5.8 Give a counterexample that shows why this intuitive implemntation of union() for quick-find is not correct.

```
public void union(int p, int q) {
    if (connected(p,q)) return;
    for (int i = 0; i < id.length; i++)
        if (id[i] == id[p]) id[i] = id[q];
    count--;
}

```
*Answer*: The value of id[p] changes to id[q] in the for loop. Thus, any object r > p with id[r] equal to id[p] will not be updated to equal id[q](because id[p] value was changed. now id[p] = id[q]).

1.5.9 Draw the tree corresponding to the id[] array depicted at right. Can this be the result of running weighted quick-union? Explain why this is impossible or give a sequence of operations that results in this array.

i    0 1 2 3 4 5 6 7 8 9
id[i]1 1 3 1 5 6 1 3 4 5

*Answer*: impossible.
id[8] is a child of id[4] -> union[4, 8];
id[4] is a child of id[5] -> id[5] must have at least 1 child before union(5,4)(has a child [union(5,9)])
id[5] is a child of id[6] -> id[6] must have at least 2 child before union(6,5)[union(6,?)]->Impossible.

1.5.10 In the weighted quick-union algorithm, suppose that we set id[find(p)] to q instead of to id[find(q)]. Would the resulting algorithm be correct?
*Answer*: Yes, but it would increase the tree height, so the performance guarantee would be invalid.

1.5.11 Implement *weighted quick-find*, where you always change the id[] entries of the smaller component to the identifier of the larger component. How does this change affect performance?



