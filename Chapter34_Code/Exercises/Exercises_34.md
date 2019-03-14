#EXERCISES


##Book

3.4.1 Insert the keys E A S Y Q U T I O N in that order into an initially empty table of M = 5 lists, using separate chaining. Use the hash function 11 k % M to transform the kth letter of the alphabet into a table index.

3.4.2 Develop an alternate implementation of SeparateChainingHashST that directly uses the linked-list code from SequentialSearchST.

3.4.3 Modify your implementation of the previous exercise to include an integer field for each key-value pair that is set to the number of entries in the table at the time that pair is inserted. Then implement a method that deletes all keys (and associated values) for which the field is greater than a given integer k. Note: This extra functionality is useful in implementing the symbol table for a compiler.

3.4.4 Write a program to find values of a and M, with M as small as possible, such that the hash function(a * k) % M for transforming the kth letter of the alphabet into a table index produced distinct values(no collisions) for the keys S E A R C H X M P L. The result is known as a perfect hash function.

3.4.5 Is the following implementation of hashCode() legal?
```
public int hashCode(){
    return 17;
}

```
*Solution*: Yes, but it would cause all keys to hash to the same spot, which would lead to poor performance.

3.4.6 Suppose that keys are t-bit integers. For a modular hash function with prime M, prove that each key bit has the property that there exist two keys differing only in that bit that have different hash values.

3.4.7 Consider the idea of implementing modular hashing for integer keys with the code (a * k) % M, where a is an arbitrary fixed prime. Does this change mix up the bits sufficiently well that you can use nonprime M?

*Solution*: yes.

3.4.8 How many empty lists do you expect to see when you insert N keys into a hash table with SeparateChaingHashST, for N=10,10^2,10^3,10^4,10^5,and 10^6? *Hint*: See EXERCISE 2.5.31.

*Solution*: M(1-e^{-\alpha}), \aplpha = N/M

3.4.9 Implement an eager delete() method for SeparateChainingHashST.

3.4.10 Insert the keys E A S Y Q U T I O N in that order into an initially empty table of size M = 16 using linear probing. Use the hash function ll k % M to transform the kth letter of the alphabet into a table index. Redo this exercise for M = 10.

3.4.11 Give the contents of a linear-probing hash table that results when you insert the keys E A S Y Q U T I O N in that order into an initially empty table of initial size M = 4 that is expanded with doubling whenever half full. Use the hash function ll k % M to transform the kth letter of the alphabet into a table index.

3.4.12 Suppose that the keys A through G, with the hash values given below, are inserted in some order into an initially empty table of size 7 using a linear-probing table (with no resizing for this problem). Which of the following could not possibly result from inserting these keys?

Give the minimum and the maximum number of probes that could be required to build a table of size 7 with these keys, and an insertion order that justifies your answer.

3.4.13 Which of the following scenarios leads to expected linear running time for a random search hit in a linear-probing hash table?
 
*Answer*: a, c.

3.4.14 Answer the previous question for search miss, assuming the search key is equally likely to hash to each table position.

*Answer*: In the worst case all keys hash to the same index.

3.4.15 How many compares could it take, in the worst case, to insert N keys into an initially empty table, using linear probing with array resizing?

*Answer*: (5N^2+6N)/8

3.4.16 Suppose that a linear-probing table of size 10^6 is half full, with occupied positions chosen at random. Estimate the probability that all positions with indices divisible by 100 are occupied.

*Answer*: $$ P(k \text{ successes })= \frac{\binom{K}{k}\binom{N-K}{n-k}}{\binom{N}{n}}$$

$$ P(10000 \text{ occupied slots })= \frac{\binom{10000}{10000}\binom{10^6-10000}{500000-10000}}{\binom{10^6}{500000}}$$

3.4.17 Show the result of using the delete() method on page 471 to delete C from the table resulting from using LinearProbingHashST with our standard indexing client(show on page 469).

3.4.18 Add a constructor to SeparateChainingHashST that gives the client the ability to specify the average number of probes to be tolerated for searches. Use array resizing to keep the average list size less than the specified value, and use the technique described on page 478 to ensure that the modulus for hash() is prime.

3.4.19 Implement keys() for SeparateChainingHashSt and LinearProbingHashST.

3.4.20 Added a method to LinearProbingHashST that computes the average cost of a search hit in the table, assuming that each key in the table is equally likely to be sought.

3.4.21 Add a method to LinearProbingHashST that computes the average cost of a search miss in the table, assuming a random hash function. *Note*: You do not have to compute any hash functions to solve this problem.

3.4.22 Implement hashCode() for various types: Point2D, Interval, Interval2D, and Date.

3.4.23 Consider modular hashing for string keys with R = 256 and M = 255. show that this is a bad choice because any permutation of letters within a string hashes to the same value.


3.4.23 Consider modular hashing for string keys with R = 256 and M = 255. show that this is a bad choice because any permutation of letters within a string hashes to the same value.

3.4.24 Analyze the space usage of separate chaining, linear probing, and BSTs for double keys. Present your results in a table like the one on page 476.

3.4.25  *Hash cache*. Modify Transactino on page 462 to maintain an instance variable hash, so that hashCode() can save the hash value the first time it is called for each object and does not have to recompute it on subsequent calls. Note: This idea works only for immutable types.

3.4.26 *Lazy delete for linear probing*. Add to LinearProbingHashST a delete() method that deletes a key_value pair by setting the value to null (but not removing the key) and later removing the pair from the table in resize(). Your primary challenge is to decide when to call resize(). Note: You should overwrite the null value if a subsequent put() operation associates a new value with the key. Make sure that your program takes into account the number of such tombstone items,
as well as the number of empty positions, in making the decision whether to expend or contract the table.

3.4.27 *Double probing*. Modify SeparateChainingHashST to use a second hash function and pick the shorter of the two lists. Give a trace of the process of inserting the keys E A S Y Q U T I O N in that order into an initially empty table of size M = 3 using the function 11 k % M (for the kth letter) as the first hash function and the function 17 k % M (for the kth letter) as the second hash function. Give the average number of probes for random search hit and search miss in this
table.

**TO DO**:

3.4.28 *Double hashing*. Modify LinearProbingHashST to use a second hash function to define the probe sequence. Specifically, replace (i + 1) % M (both occurrences) by (i + k) % M where k is a nonzero key-dependent integer that is relatively prime to M. *Note*: You may meet the last condition by assuming that M is prime. Give a trace of the process of inserting the keys E A S Y Q U T I O N in that order into an initially empty table of size M = 11, using the hash
functions described in the previous exercise. Give the average number of probes for random search hit and search miss in this table.

**TO DO**:


3.4.29 *Deletion*. Implement an eager delete() method for the methods described in each of the previous two exercises.

**TO DO**:

3.4.30 *Chi-square statistic*. Add a method to SeparateChainingST to compute the $\chi^2$ statistic for the hash table. With N keys and table size M, this number is defined by the equation
$$\chi^2 = (M/N)((f_0 - N/M)^2 + (f_1 - N/M)^2 + ...(f_{M-1} - N/M)^2)$$
where f_i is the number of keys with hash value i. This statistic is one way of checking our assumption that the hash function produces random values. If so, this statistic, for N>cM, should be between $$M - \sqrt{M}$$ and $$M + \sqrt{M}$$ with probability 1 - 1/c.

3.4.31 *Cuckoo hashing**. Develop a symbol-table implementation that maintains two hash tables and two hash functions. Any given key is in one of the tables, but not both. When inserting a new key, hash to one of the tables; if the table position is occupied, replace the key with the new key and hash the old key into the other table (again kicking out a key that might reside there). If this process cycles, restart. Keep the tables less than half full. This method uses a constant
number of equality tests in the worst case for search(trivial) and amortized constant time for insert.

3.4.32 **Hash attack**. Find 2^N strings, each of length N, that have the same hashCode() value, supposing the hashCode() implementation for string(as specified in the Java standard) is the following:
```
public int hashCode(){
  int hash = 0;
  for (int i = 0; i < length(); i++)
    hash = (hash * 31) + charAt(i);
  return hash;
}
```
*Solution*: It is easy to verify that "Aa" and "BB" hash to the same hashCode() value (2112). Now, any string of length 2N that is formed by concatenating these two strings together in any order (e.g., BBBBBB, AaAaAa, BBAaBB, AaBBBB) will hash to the same value. Here is a list of 10000 strings with the same hash value.

3.4.33 **Bad hash function**. Consider the following hashCode() implementation for String, which was used in early versions of Java:
```
public int hashCode(){
  int hash = 0;
  int skip = Math.max(1, length()/8);
  for (int i = 0; i < length(); i+=skip)
    hash = (hash*37) + charAt(i);
  return hash;
}
```

Explain why you think the designers chose this implementation and then why you think it was abandoned in favor of the one in the previous exercise.

*Solution*: This was done in the hopes of computing the hash function more quickly. Indeed, the hash values were computed more quickly, but it became more likely that many strings hashed to the same values. This resulted in a significant degradation in performance on many real-world inputs(e.g., long URLs) which all hashed to the same value, e.g., http://www.cs.princeton.edu/algs4/34hash/*****java.html.











