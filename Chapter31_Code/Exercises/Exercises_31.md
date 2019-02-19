#EXERCISES

3.1.1 Write a client program GPA.java that creates a symbol table mapping letter grades to numerical scores, as in the table below, then reads from standard input a list of letter grades and computes and prints the GPA (the average of the numerical scores of the corresponding grades).

A+     A       A-      B+      B       B-      C+      C    C-   D     F
4.33   4.00    3.67    3.33    3.00    2.67    2.33    2.00 1.67 1.00  0.00

3.1.2 Develop a symbol-table implementation ArrayST that uses an (unordered) array as the underlying data structure to implement our basic symbol table API.

3.1.3 Develop a symbol-table implementation OrderedSequentialSearchST that uses an ordered linked list as the underlying data structure to implement our ordered symbol-table API.

3.1.4 Develop Time and Event ADTs that allow processing of data as in the example illustrated on page 367.

3.1.5 Implement size(), delete(), and keys() for SequentialSearchST.

3.1.6 Give the number of calls to put() and get() issued by FrequencyCounter, as a function of the number W of words and the number D of distinct words in the input.

3.1.7 What is the average number of distinct keys that FrequencyCounter will find among N random nonnegative integers less than 1,000, for N=10, 10^2, 10^3, 10^4, 10^5, and 10^6?

3.1.8 What is the most frequently used word of ten letters or more in *Tale of Two Cities*?

3.1.9 Add code to FrequencyCounter to keep track of the last call to put(). Print the last word inserted and the number of words that were processed in the input stream prior to this insertion. Run your program for tale.txt with length cutoffs 1, 8, and 10.

3.1.10 Give a trace of the process of inserting the keys E A S Y Q U E S T I O N into an initially empty table using SequentialSearchST. How many compares are involved?

*Answer*: compares: 120.

3.1.11 Give a trace of the process of inserting the keys E A S Y Q U E S T I O N into an initially empty table using BinarySearchST. How many compares are involved?


3.1.12 Modify BinarySearchST to maintain one array of Item objects that contain keys and values, rather than two parallel arrays. Add a constructor that takes an array of Item values as argument and uses mergesort to sort the array.

3.1.13 Which of the symbol-table implementations in this section would you use for an application that does 10^3 put() operations and 10^6 get() operations, randomly intermixed? Justify your answer.

*Solution*: BinarySearchST(average-case cost.Search hit: lgN, insert: N); 

3.1.14 Which of the symbol-table implementations in this section would you use for an application that does 10^6 put() operations and 10^3 get() operations, randomly intermixed? Justify your answer.

*Solution*:SequentialSearchST (average-case cost.Search hit: N/2, insert: N) 

3.1.15  Assume that searches are 1,000 times more frequent than insertions for a BinarySearchST client. Estimate the percentage of the total time that is devoted to insertions, when the number of searches is 10^3, 10^6, and 10^9.

*Solution*: search hit: lg N, average-case cost: N

3.1.16 Implement the delete() method for BinarySearchST.
3.1.17 Implement the floor() method for BinarySearchST.
3.1.18 Prove that the rank() method in BinarySearchST is correct.

3.1.19 Modify FrequencyCounter to print all of the values having the highest frequency of occurrence, not just one of them. *Hint*: Use a Queue.

3.1.20 Complete the proof of PROPOSITION B (show that it holds for all values of N). 
*Hint*: Start by showing that C(N) is monotonic: C(N) <= C(N+1) for all N > 0.

*Solution*: [Master theorem](https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms))

3.1.21 *Memory usage*. Compare the memory usage of BinarySearchST with that of SequentialSearchST for N key-value pairs, under the assumptions described in SECTION 1.4. Do not count the memory for the keys and values themselves, but do count references to them. For BinarySearchST, assume the array resizing is used, so that the array is between 25 percent and 100 percent full.

3.1.22 *Self-organizing search*. A self-organizing search algorithm is one that rearranges items to make those that are accessed frequently likely to be found early in the search. Modify your search implementation for EXERCISE 3.1.2 to perform the following action on every search hit: move the key-value pair found to the beginning of the list, moving all pairs between the beginning of the list and the vacated position to the right one position. This procedure is called the
*move-to-front* heuristic.
*Solution*: MTF_ArrayST.java

3.1.23 *Analysis of binary search*. Prove that the maximum number of compares used for a binary search in a table of size N is precisely the number of bits in the binary representation of N, because the operation of shifting 1 bit to the right converts the binary representation of N into the binary representation of floor(N/2).

3.1.24 *Interpolation search*. Suppose that arithmetic operations are allowed on keys (for example, they may be Double or Integer values). Write a version of binary search that mimics the process of looking near the beginning of a dictionary when the word begins with a letter near the beginning of the alphabet. Specifically, if k_x is the key value sought, k_lo is the key value of the first key in the table, and k_hi is the key value of the last key in the table, look first
floor((k_x - k_lo)/(k_hi - k_lo))-way through the table, not halfway. Test your implementation against BinarySearchST for FrequencyCounter using SearchCompare.

3.1.25 *Software caching*. Since the default implementation of contains() calls get(), the inner loop of FrequencyCounter
```
if (!st.contains(word)) st.put(word, 1);
else                    st.put(word, st.get(word) + 1);

```
leads to two or three searches for the same key. To enable clear client code like this without sacrificing efficiency, we can use a tecknique known as *software caching*, where we save the location of the most recently accessed key in an instance variable. Modify SequentialSearchST and BinarySearchST to take advantage of this idea.

*Solution*: remember the last get the value to local variable.

3.1.26 *Frequency count from a dictionary*. Modify FrequencyCounter to take the name of a dictionary file as its argument, count frequencies of the words from standard input that are also in that file, and print two tables of the words with their frequencies, one sorted by frequency, the other sorted in the order found in the dictionary file.

3.1.27 *Small tables*. Suppose that a BinarySearchST client has S search operations and N distinct keys. Give the order of growth of S such that the cost of building the table is the same as the cost of all the searches.

3.1.28 *Ordered insertions*. Modify BinarySearchST so that inserting a key that is larger than all keys in the table takes constant time (so that building a table by calling put() for keys that are in order takes linear time).

3.1.29 *Test Client*. Write a test client TestBinarySearchST.java for use in testing the implementations of min(), max(), floor(), ceiling(), select(), rank(), deleteMin(), deleteMax(), and keys().

3.1.30 *Certification*. Add assert statements to BinarySearchST.java to check algorithm invariants and data structure integrity after every insertion and deleteion. For example, every index i should always be equal to rank(select(i)) and the array should always be in order.

##Web Exercises

1. **Phone number data type**. Write a data type PhoneNumber.java that implements US phone numbers. include an equals() method.

2. **Student data type**. Write a data type Student.java that implements a student with a name and section. include an equals() method.









