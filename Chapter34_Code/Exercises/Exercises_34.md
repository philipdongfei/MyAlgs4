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



## WEB EXERCISES

1. Suppose we wish to repeatedly search a linked list of length N elements, each of which contains a very long string key. How might we take advantage of the hash value when searching the list for an element with a given key?

*Solution*: precompute the hash value of each string in the list. When searching for a key t, compare its hash value to the hash value of a string s. Only compare the string s and t if their hash values are equal.

2. Implement hashcode() and equals() for the following data type. Be careful since it is likely that many of the points will have small integers for x, y, and z.
```
public class Point2D {
    private final int x, y;
    ...
}
```
*Answer*: one solution would to make the first 16 bits of the hash code be the xor of the first 16 bits of x and the last 16 bits of y, and make the last 16 bits of the hash code be the xor of the last 16 bits of x and the first 16 bits of y. Thus, if x and y are only 16 bits or less, the hashCode values will be different for different points.

3. What is wrong with the following implementation of equals() for points?
```
public boolean equals(Point q){
    return x == q.x && y == q.y;
}
```
Wrong signature for equals(). It is an overloaded version of equals(), but it does not override the one inherited from Object. This will break any code that uses Point with HashSet. This is one of the more common gotchas (along with neglecting to override hashCode() when you override equals()).

4. What will the following code fragment print?
```
import java.util.HashMap;
import java.util.GregorianCalendar;

HashMap st = new HashMap();
GregorianCalendar x = new GregorianCalendar(1969, 21, 7);
GregorianCalendar y = new GregorianCalendar(1969, 4, 12);
GregorianCalendar z = new GregorianCalendar(1969, 21, 7);
st.put(x, "human in space");
x.set(1961, 4, 12);
System.out.println(st.get(x));
System.out.println(st.get(y));
System.out.println(st.get(z));

```
It will print false, false, false. The date 7/21/1969 is inserted onto the hash table, but is subsequently changed to 4/12/1961 while the value is in the hash table. Thus, although the date 4/12/1961 is in the hash table, when searching for x or y, we will look in the wrong bucket and won't find it. We won't find z either since there the date 7/21/1969 is no longer a key in the hash table.
This illustrates why it is good practice to use only immutable types for keys in hash tables. The Java designers probably should have made GregorianCalendar an immutable object to avoid the potential for problems like this.

5. **Password checker**. Write a program that reads in a string from the command line and a dictionary of words from standard input, and checks whether is a "good" password. Here, assume "good" means that it (i) is at least 8 characters long, (ii) is not a word in the dictionary, (iii) is not a word in the dictionary followed by a digit 0-9(e.g., hello5), (iv) is not two words separated by a digit(e.g., hello2word).

6. **Reverse password checker**. Modify the previous problem so that (ii)-(v) are also satisfied for reverses of words in the dictionary (e.g., olleh and olleh2world). Clever solution: insert each word and its reverse into the symbol table.

7. **Mirroring a web site**. Use hashing to figure out which files need to be updated to mirror web site.

*Solution*: check whether is the different of the file's hashcode.

8. **Birthday paradox**. Suppose your music jukebox plays songs from your library of 4000 songs at random (with replacement). How long do you expect to wait until you hear a song played for the second time?


9. **Bloom filter**. Support insert, exists. Use less space by allowing some false positives. Application: ISP caches web pages (especially large images, video); client requests URL; server needs to quickly determine wheter page is in the cache. 
*Solution*: maintain one bit array of size N = 8M (M = #elements to insert). Choose k independent hash functions from 0 to N-1.

10. **CRC-32**. Another application of hashing is computing checksums to verify the integerity of some data file. To compute the checksum of a strings,
```
import java.util.zip.CRC32;

CRC32 checksum = new CRC32();
checksum.update(s.getBytes());
System.out.println(checksum.getValue());

```

11. **Perfect hashing**. See also GNU utility gperf.

12. **Cryptographically secure hash functions**. SHA-1 and MD5. Can compute it by converting string to bytes, or when reading in bytes 1 at a time. Program OneWay.java illustrates how to use a java.secruity.MessageDigest Object.

13. **Fingerprinting**. Hash Function (e.g., MD5 and SHA-1) are also useful for verifying the integrity of a file. Hash the file to a short string, transmit the string with the file, if the hash of the transmitted file differs from the hash value then the data was corrupted.

14. **Cuckoo hashing**. Maximum load with uniform hashing is log n / log log n. Improve to log log n by choosing least loaded of two. (Only improves to log log n / log d if choose least loaded of d.) cuckoo hasing achieves constant average time insertion and constant worst-case search: each item has two possible slots. Put in either of two available slots if empty; if not, eject another item in one of the two slots and move to its other slot (and recur). "The name derives from the
    behavior of some species of cuckoo, where the mother bird pushes eggs out of another bird's nest to lay her own." Rehash everything if you get into a relocation cycle.

15. **Covariant equals**. CovariantPhoneNumber.java implements a covariant equals method.

16. **Last come, first served linear probing**. Modify LinearProbingHashST.java so that each item is inserted where it arrives; if the cell is already occupied, then that item moves one entry to the right (where the rule is repeated).

17. **Robin Hood linear probing**. Modify LinearProbingHashST.java so that when an item probes a cell that is already occupied, the item (of the two) with the larger current displacement gets the cell and the other item is moved one entry to the right (where the rule is repeated).

18. **Indifference graph**. Given V points on the real line, its indifference graph is the graph formed by adding a vertex for each point and an edge between two vertices if and only if the distance between the two corresponding points is strictly less than one. Design an algorithm (under the uniform hashing assumption) to compute the indifference graph of a set of V points in time proportional to V + E.

*Solution*. Round each real number down to the nearest integer and use a hash table to identify all points that round to the same integer. Now, for each point p, use the hash table to find all points that round to an integer within one of the rounded value of p and add an edge(p,q) for each pair of points whose distance is less than one. See this reference for an explanation as to why this takes linear time.








