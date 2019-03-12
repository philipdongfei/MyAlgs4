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


