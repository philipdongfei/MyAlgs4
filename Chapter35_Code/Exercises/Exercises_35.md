#EXERCISES

##Book Exercises

3.5.1 Implement SET and HashSET as "wrapper class" clients of ST and HashST, respectively (provide dummy values and ignore them).

3.5.2 Develop a SET implementation SequentialSearchSET by starting with the code for SequentialSearchSET and eliminating all of the code involving values.

3.5.3 Develop a SET implementation BinarySearchSET by starting with the code for BinarySearchSET and eliminating all of the code involving values.

3.5.4 Develop classes HashSTint and HashSTdouble for maintaining sets of keys of primitive int and double types, respectively. (Convert generics to primitive types in the code of LinearProbingHashST.)

3.5.5 Develop classes STint and STdouble for maintaining ordered symbol tables where keys are primitive int and double types, respectively. (Convert generics to primitive types in the code of RedBlackBST.) Test your solution with a version of SparseVector as a client.

3.5.6 Develop classes HashSETint and HashSETdouble for maintaining sets of keys of primitive int and double types, respectively. (Eliminate code involving values in your solution to EXERCISE 3.5.4.)

3.5.7 Develop classes SETint and SETdouble for maintaining ordered sets of keys of primitive int and double types, respectively.(Eliminate code involving values in your solution to EXERCISE 3.5.5.)

3.5.8 Modify LinearProbingHashST to keep duplicate keys in the table. Return any value associated with the given key for get(), and remove all items in the table that have keys equal to the given key for delete().

3.5.9 Modify BST to keep duplicate keys in the tree. Return any value associated with the given key for get(), and remove all nodes in the tree that have keys equal to the given key for delete().

3.5.10 Modify RedBlackBST to keep duplicate keys in the tree. Return any value associated with the given key for get(), and remove all nodes in the tree that have keys equal to the given key for delete().

3.5.11 Develop a MultiSET class that is like SET, but allows equal keys and thus implements a mathematical *multiset*.

3.5.12 Modify LookupCSV to associate with each key all values that appear in a key-value pair with that key in the input (not just the most recent, as in the associative-array abstraction).

3.5.13 Modify LookupCSV to make a program RangeLookupCSV that takes two key values from the standard input and prints all key-value pairs in the .csv file such that the key falls with the range specified.

3.5.14 Develop and test a static method invert() that takes as argument an ST<String, Bag<String>> and produces as return value the inverse of the given symbol table (a symbol table of the same type).

3.5.15 Write a program that takes a string on standard input and an integer k as command-line argument and puts on standard output a sorted list of k-grams found in the string, each followed by its index in the string.

3.5.16 Add a method sum() to SparseVector that takes a SparseVector as argument and returns a SparseVector that is the term-by-term sum of this vector and the argument vector. *Note*: You need delete() (and special attention to precision) to handle the case where an entry becomes 0.

3.5.17 *Mathematical sets*. Your goal is to develop an implementation of the following API MathSET for processing (mutable) mathematical sets:

Use a symbol table. *Extra credit*: Represent sets with arrays of boolean values.

3.5.18 *Multisets*. After referring to EXERCISES 3.5.2 and 3.5.3 and the previous exercise, develop APIs MultiHashSET and MultiSET for multisets (sets that can have equal keys) and implementations SeparateChainingMultiSET and BinarySearchMultiSET for multisets and ordered multisets, respectively.

3.5.19 *Equal keys in symbol tables*. Consider the API multiST (unordered or ordered) to be tha same as our symbol-table APIs defined on page 363 and page 366, but with equal keys allowed, so that the semantics of get() is to return any value associated with the given key, and we add a new method
```
Iterable<Value> getAll(Key key);
```
that returns all values associated with the given key. Using our code for SeparateChainingST and BinarySearchST as a starting point, develop implementations SeparateChainingMultiST and BinarySearchMultiST for these APIs.

3.5.20 *Concordance.* Write an ST client Concordance that puts on standard output a concordance of the strings in the standard input stream (see page 498).

3.5.21 *Inverted concordance*. Write a program InvertedConcordance that takes a concordance on standard input and puts the original string on standard output stream.Note: This computation is associated with a famous story having to do with the Dead Sea Scrolls. The team that discovered the original tablets enforced a secrecy rule that essentially resulted in their making public only a concordance. After a while, other researcher figured out how to invert the concordance, and the
full text was eventually made public.

3.5.22 *Fully indexed CSV.* Implement an ST client FullLookupCSV that builds an array of ST objects (one for each field), with a test client that allows the user to specify the key and value fields in each query.

3.5.23 *Sparse matrices*. Develop an API and an implementation for sparse 2D matrices. Support matrix addition and matrix multiplication. Include constructors for row and column vectors.

3.5.24 *Non-overlapping interval search*. Given a list of non-overlapping intervals of items, write a function that takes an item as argument and determines in which, if any, interval that item lies. For example, if the items are integers and the intervals are 1643-2033, 5532-7643,8999-10332,5666653-5669321, then the query point 9122 lies in the third interval and 8122 lies in no interval.

3.5.25 *Registrar scheduling*. The registrar at a prominent northeastern University recently scheduled an instructor to tach two different classes at the same exact time. Help the registrar prevent future mistakes by describing a method to check for such conflicts. For simplicity, assume all classes run for 50 minutes starting at 9:00, 10:00, 11:00, 1:00,2:00,or 3:00.

3.5.26 *LRU cache*. Create a data structure supports the following operatings: access and remove. Theaccess operation inserts the item onto the data structure if it's not already present. The remove operation deletes and returns the item that was least recently accessed. Hint: Maintain the items in order of access in a doubly linked list, along with pointers to the first and last nodes. Use a symbol table with keys = items, values = location in linked list. When you
access an element, delete it from the linked list and reinsert it at the beginning. When you remove an element, delete it from the end and remove it from the symbol table.

3.5.27 *List*. Develop an implementation of the following API:
public class List<Item> implements Iterable<Item>

*Hint*: Use two symbol tables, one to find the ith item in the list efficiently, and the other to efficiently search by item. (Java's java.util.List interface contains methods like these but does not supply any implementation that efficiently suports all operations.)

TODO: Not test.

3.5.28 *UniQueue*. Create a data type that is a queue, except that an element may only be inserted the queue once. Use an existence symbol table to keep track of all elements that have ever been inserted and ignore requests to re-insert such items.

3.5.29 *Symbol table with random access*. Create a data type that supports inserting a key-value pair, searching for a key and returning the associated value, and deleting and returning a random key. *Hint*: Combine a symbol table and a randomized queue.

##Web Exercises

1. Modify FrequencyCount to read in a text file (comprised of UNICODE characters) and print out the alphabet size (number of distinct characters) and a table of characters and their frequencies, sorted in descending order of frequency.

2. **Set intersection and union.** Given two sets of strings, write a code fragment that computes a third set that contains those strings that appear in both sets (or either set). *Hint*: iterate over the elements in one set and check if they're in the other set.

3. **Bidirectional symbol tables**. Support put(key, value) and getByKey(key) or getByValue(value). Use two symbol tables behind the scenes. Ex: DNS and reverse DNS.

4. **Highlighting browser hyperlinks**. With each visited website, maintain the last time the site was visited so that you only hightlight those sites that have been visited within the past month.

5. **Frequency symbol table.** Write an abstract data type FrequencyTable.java that supports the following operations: hit(Key), and count(Key). The hit operation increments the number of times the string appears by one. The count operation returns the number of times the given string appears, possibly 0. Applications: web counter, web log analyzer, musci jukebox that counts number of times each song has been played...

6. **Non-overlapping interval search**. Given a list of non-overlapping intervals of integers(or dates), write a function that takes an integer argument and determines in which if any interval that values lies, e.g., if the intervals are 1643-2033, 5532-7643,8999-10332, 5666653-5669321,then the query point 9122 lies in the third interval and 8122 lies in no interval.

same of book exercise 3.5.24

7. **Registrar scheduling**. The Registrar at a prominent northeastern University recently scheduled an instructor to teach two different classes at the same exact time. Help the Registrar prevent future mistakes by secribing a method to check for such conflicts. For simiplicity, assume all classes run for 50 minutes starting at 9,10,11,1,2,or 3.

same of book exercise 3.5.25

8. **List**. Implement the following list operatiions: size(), addFront(item), addBack(item), delFront(item), delBack(item), contains(item), delete(item), add(i,item), delete(i),iterator(). All operations should be efficient (logarithmic). Hint: use two symbol tables, one to find the ith element in the list efficiently, and the other to efficiently search by item. Java's List interface contains these methods, but does not supply any implementation that supports all ops efficiently.

same of book exercise 3.5.27

9. **Indirect PQ**. Write a program IndirectPQ.java that implements an indirect PQ(priority queue).




























