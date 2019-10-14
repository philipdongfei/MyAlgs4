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










