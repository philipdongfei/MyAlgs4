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

1.5.12 *Quick-union with path compression*. Modify quick-union (page 224) to include *path compression*, by adding a loop to find() that links every site on the path from p to the root. Give a sequence of input pairs that causes this method to produce a path of length4. Note: the amortized cost per operation for this algorithm is known to be logarithmic.


1.5.13 *Weighted quick-union with path compression*. Modify weighted quick-union (ALGORITHM 1.5) to implement path compression, as described in EXERCISE 1.5.12. *Note*: The amortized cost per operation for this algorithm is known to be bounded by a function known as the *inverse Ackermann function* and is less than 5 for any conceivable practical value of N.

1.5.14 *Weighted quick-union by height*. Develop a UF implementation that uses the same basic strategy as weighted quick-union but keeps track of tree height and always links the shorter tree to the taller one. Prove a logarithmic upper bound on the height of the trees for N sites with your algorithm.

1.5.15 *Binomial trees*. Show that the number of nodes at each level in the worst-case trees for weighted quick-union are binomial coefficients. Compute the average depth of a node in a worst-case tree with N = 2^n nodes.

Answer: lgN = lg(2^n) = n

1.5.16 *Amortized costs plots*. Instrument your implementations from EXERCISE 1.5.7 to make amortized costs plots like those in the text.

1.5.17 *Random connections*. Develop a UF client ErdosRenyi that takes an integer value N from the command line, generates random pairs of integers between 0 and N-1, calling connected() to determine if they are connected and then union() if not (as in our development client), looping until all sites are connected, and printing the number of connections generated. Package your program as a static method count() that takes N as argument and returns the number of connections and a main()
that take N from the command line, calls count(), and prints the returned value.

1.5.17 *Random connections*. Develop a UF client ErdosRenyi that takes an integer value N from the command line, generates random pairs of integers between 0 and N-1, calling connected() to determine if they are connected and then union() if not (as in our development client), looping until all sites are connected, and printing the number of connections generated. Package your program as a static method count() that takes N as argument and returns the number of connections and a main()
that take N from the command line, calls count(), and prints the returned value.

1.5.17 *Random connections*. Develop a UF client ErdosRenyi that takes an integer value N from the command line, generates random pairs of integers between 0 and N-1, calling connected() to determine if they are connected and then union() if not (as in our development client), looping until all sites are connected, and printing the number of connections generated. Package your program as a static method count() that takes N as argument and returns the number of connections and a main()
that take N from the command line, calls count(), and prints the returned value.

```
    private class Connection
    {
        int p;
        int q;
        public Connection(int p, int q)
        { this.p = p; this.q = q; }
    }

```
1.5.17 *Random connections*. Develop a UF client ErdosRenyi that takes an integer value N from the command line, generates random pairs of integers between 0 and N-1, calling connected() to determine if they are connected and then union() if not (as in our development client), looping until all sites are connected, and printing the number of connections generated. Package your program as a static method count() that takes N as argument and returns the number of connections and a main()
that take N from the command line, calls count(), and prints the returned value.

1.5.17 *Random connections*. Develop a UF client ErdosRenyi that takes an integer value N from the command line, generates random pairs of integers between 0 and N-1, calling connected() to determine if they are connected and then union() if not (as in our development client), looping until all sites are connected, and printing the number of connections generated. Package your program as a static method count() that takes N as argument and returns the number of connections and a main()
that take N from the command line, calls count(), and prints the returned value.

1.5.18 *Random grid generator*. Write a program *RandomGrid* that takes an int value N from the command line, generates all the connections in an N-by-N grid, puts them in random order, randomly orients them (so that p q and q p are equally likesly to occur), and prints the result to standard output. To randomly order the connections, use a RandomBag(see EXERCISE 1.3.34 on page 167). To encapsulate p and q in a single object, use the Connection nested class shown below. Package your
program as two static methods: generate(), whick takes N as argument and returns an array of connections, and main(), which takes N from the command line, call geerate(), and iterates through the returned array to print the connections.

1.5.19 *Animation*. Write a RandomGrid client (see EXERCISE 1.5.18) that uses UnionFind as in our development client to check connectivity and uses StdDraw to draw the connections as they are processed.

1.5.20 *Dynamic growth*. Using linked lists or a resizing array, develop a weighted quick-union implementation that removes the restriction on needing the number of objects ahead of time. Add a method *newSite()* to the API, which returns an int identifier.

