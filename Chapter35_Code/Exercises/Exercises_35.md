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









