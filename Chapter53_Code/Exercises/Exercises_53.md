#EXERCISES

##Book Exercises

5.3.1 Develop a brute-force substring search implementation Brute, using the same API as ALGORITHM 5.6.

5.3.2 Give the dfa[][] array for the Knuth-Morris-Pratt algorithm for the pattern A A A A A A A A A, and draw the DFA, in the style of the figures in the text.

5.3.3 Give the dfa[][] array for the Knuth-Morris-Pratt algorithm for the pattern A B R A C A D A B R A, and draw the DFA, in the style of the figures in the text.

5.3.4 Write an efficient method that takes a string txt and an integer M as arguments and returns the position of the first occurrence of M consecutive blanks in the string, txt.length if there is no such occurrence. Estimate the number of character compares used by your method, on typical text and in the worst case.

5.3.5 Develop a brute-force substring search implementation BruteForceRL that processes the pattern from right to left (a simplified version of ALGORITHM 5.7).

5.3.6 Give the right[] array computed by the constructor in ALGORITHM 5.7 for the pattern A B R A C A D A B R A.

5.3.7 Add to our brute-force implementation of substring search a count() method to count occurrences and a searchAll() method to print all occurrences.

5.3.8 Add to KMP a count() method to count occurrences and a searchAll() method to print all occurrences.

5.3.9 Add to BoyerMoore a count() method to count occurrences and a searchAll() method to print all occurrence.

5.3.10 Add to RabinKarp a count() method to count occurrences and a searchAll() method to print all occurrence.

5.3.11 Construct a worst-case example for the Boyer-Moore implementation in ALGORITHM5.7 (which demonstrates that it is not linear-time).

Solution: 
pattern: BAA
text: AAAAAAAAA
time: ~ N * M.

5.3.12 Add the code to check() in RabinKarp (ALGORITHM 5.8) that turns it into a Las Vegas algorithm (check that the pattern matches the text at the position given as argument).

5.3.13 In the Boyer-Moore implementation in ALGORITHM 5.7, show that you can set right[c] to the penultimate occurrence of c when c is the last character in the pattern.

5.3.14 Develop versions of the substring search implementations in this section that use char[] instead of String to represent the pattern and the text.

5.3.15 Design a brute-force substring search algorithm that scans the pattern from right to left.

5.3.16 Show the trace of the brute-force algorithm in the style of the figures in the text for the following pattern and text strings.

5.3.17 Draw the KMP DFA for the the following pattern strings.
a. AAAAAAB
b. AACAAAB
c. ABABABAB
d. ABAABAABAAAB
e. ABAABCABAABCB

5.3.18 Suppose that the pattern and text are random strings over an alphabet of size R (which is at least 2). Show that the expected number of character compares for the brute-force method is (N-M+1)(1-R^{-M})/(1-R^{-1}) <= 2(N-M+1).


5.3.19 Construct an example where the Boyer-Moore algorithm (with only the mismatched character heuristic) performs poorly.

**Solution**: BAA
**Text**: AAAAAAAAAA
**time**: ~N*M.

5.3.20 How would you modify the Rabin-Karp algorithm to determine whether any of a subset of k patterns (say, all of the same length) is in the text?

_Solution_: Compute the hashes of the k patterns and store the hashes in a **StringSET**.

5.3.21 How would you modify the Rabin-Karp algorithm to search for a given pattern with the additional proviso that the middle character is a "wildcard" (any text character at all can match it).

**Solution**: We would compute the hash of the pattern skipping the middle character(character at index M/2 of the pattern, where M is the pattern length).
We would then compute the text hashes skipping the middle character as well. the rest of the algorithm would be the same.


5.3.22 How would you modify the Rabin-Karp algorithm to search for an H-by-V pattern in an N-by-N text?

5.3.23 Write a program that reads characters one at a time and reports at each instant if the current string is a palindrome. Hint: Use the Rabin-Karp hashing idea.

5.3.24 _Find all occurrences_. Add a method findAll() to each of the four substring search algorithms given in the textthat returns an Iterable<Integer> that allows clients to iterate through all offsets of the pattern in the text.

5.3.25 _Streaming_. Add a search() method to KMP that takes variable of type In as argument, and searches for the pattern in the specified input stream without using any extra instance variables. Then do the same for RabinKarp.

5.3.26 _Cyclic rotation check_. Write a program that, given two strings, determines whether one is a cyclic rotation of the other, such as example and ampleex.

5.3.27 _Tandem repeat search_. A tandem repeat of a base string b in a string s is a substring of s having at least two consecutive copies b (nonoverlapping). Develop and implement a linear-time algorithm that, given two strings b and s, returns the index of the beginning of the longest tandem repeat of b in s. For example, your program should return 3 when b is abcad and s is abc_abcababcababcab_abcab.

5.3.28 _Buffering in brute-force search_. Add a search() method to your solution to EXERCISE 5.3.1 that takes an input stream (of type In) as argument and searches for the pattern in the given input stream. Note: You need to maintain a buffer that can keep at least the previous M characters in the input stream. Your chanllenge is to write efficient code to initialize, update, and clear the buffer for any input stream.

5.3.29 _Buffering in Boyer-Moore_. Add a search() method to ALGORITHM 5.7 that takes an input stream (of type In) as argument and searches for the pattern in the given input stream.

5.3.30 _Two-dimensional search_. Implement a version of the Rabin-Karp algorithm to search for patterns in two-dimensional text. Assume both pattern and text are rectangles of characters.

5.3.31 _Random patterns_. How many character compares are needed to do a substring search for a random pattern of length 100 in a given text?

_Answer_: None. The method
```
public boolean search(char[] txt)
{ return false; }

```
is quite effective for this problem, since the chances of a random pattern of length 100 appearing in any text are so low that you may consider it to be 0.

5.3.32 _Unique substrings_. Solve EXERCISE 5.2.14 using the idea behind the RAbin-Karp method.

5.3.33 _Random primes_. Implement longRandomPrime() for RabinKarp (ALGORITHM 5.8). Hint: A random n-digit number is prime with probability proportional to 1/n.

5.3.34 _Straight-line code_.

5.3.35 _Boyer-Moore in binary strings_.

















