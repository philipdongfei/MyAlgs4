#EXERCISES

##Book Exercises
 
5.5.1. Consider the four variable-length codes shown in the table at right. Which of the codes are prefix-free? Uniquely decodable? For those that are uniquely decodable, give the encoding of 1000000000000.

_Solution_: code4, ADDDD

5.5.2. Given a example of a uniquely decodable code that is not prefix-free.

_Answer_: Any suffix-free code is uniquely decodable.

5.5.3. Given an example of a uniquely decodable code that is not prefix free or suffix free.

_Answer_: {0011, 011, 11, 1110} or {01, 10, 011, 110}

5.5.4. Are {01, 1001, 1011, 111, 1110} and {01, 1001, 1011, 111, 1110} uniquely decodable? If not, find a string with two encodings.

_Answer_: {01, 1001, 1011, 111, 1110} is not uniquely decodable. 11101111001 can be decoded both as 1110-111-1001 and 111-01-1110-01.

5.5.5. Use RunLength on the file q128X192.bin from the booksite. How many bits are there in the compressed file?

5.5.6. How many bits are needed to encode N copies of the symbol a (as a function of N)? N copies of the sequence abc?

5.5.7. Give the result of encoding the strings a, aa, aaa, aaaa, ...(Strings consisting of N a's) with run-length, Huffman, and LZW encoding. What is the compression ratio as a function of N?

5.5.8. Give the result of encoding the strings ab, abab, ababab, abababab, ...(Strings consisting of N a's) with run-length, Huffman, and LZW encoding. What is the compression ratio as a function of N?

5.5.9. Estimate the compression ration achieved by run-length, Huffman, and LZW encoding for a random ASCII string of length N (all characters equally likely at each position, independently).

5.5.10. In the style of the figure in the text, show the Huffman coding tree construction process when you use Huffman for the string "it was the age of foolishness". How many bits does the compressed bitstream require?

5.5.11. What is the Huffman code for a string whose characters are all from a two-character alphabet? Give an example showing the maximum number of bits that could be used in a Huffman code for an N-charcter string whose characters are all from a two-character alphabet.

5.5.12. Suppose that all of the symbol probabilities are negative powers of 2. Describe the Huffman code.

5.5.13. Suppose that all of the symbol frequencies are equal. Describe the Huffman code.

5.5.14. Suppose that the frequencies of the occurrence of all the characters to be encoded are different. It the Huffman encoding tree unique?

5.5.15. Huffman coding could be extended in a straightforward way to encode in 2-bit characters (using 4-way trees). What would be the main advantage and the main disadvantage of doing so?

5.5.16. What is the LZW encoding of the following inputs?
a. T O B E O R N O T T O B E
b. Y A B B A D A B B A D A B B A D O O
c. A A A A A A A A A A A A A A A A A A A A A

5.5.17. Characterize the tricky situation in LZW coding.

_Solution_: Whenever it encounters cScSc, where c is a symbol and S is a string, cS is in the dictionary already but csc is not.

5.5.18. Let F_k be the kth Fibonacci number. Consider N symbols, where the kth symbol has frequency F_k. Note that F_1+F_2+...+F_N = F_{N+2}-1.Describe the Huffman code. 
_Hint_: The longest codeword has length N-1.
 
a 1 0000
b 1 0001
c 2 001
d 3 01
e 5 1


5.5.19. Show that there are at least 2^{N-1} different Huffman codes corresponding to a given set of N symbols.

5.5.20. Give a Huffman code where the frequency of 0s in the output is much, much higher than the frequency of 1s.
_Answer_: If the character A occurs 1 million times and the character B occurs once, the codeword for A will be 0 and the codeword for B will be 1.

5.5.21. Prove that the two longest codewords in a Huffman code have the same length.

5.5.22 Prove the following fact about Huffman codes: If the frequency of symbol i is strictly larger than the frequency of symbol j, then the length of the codeword for symbol i is less than or equal to the length of the codeword for symbol j.

5.5.23. What would be the result of breaking up a Huffman-encoded string into five-bit characters and Huffman-encodeing that string?

5.5.24. In the style of the figures in the text, show the encoding trie and the compression and expansion processes when LZW is used for the string
**it was the best of times it was the worst of times**

5.5.25. _Fixed length width code_. Implement a class RLE that uses fixed-length encoding, to compress ASCII bytestreams using relatively few different characters, including the code as part of the encoded bitstream. Add code to compress() to make a string alpha with all the distinct characters in the message and use it to make an Alphabet for use in compress(), prepend alpha (8-bit encoding plus its length) to the compressed bitstream, then add code to expand() to
read the alphabet before expansion.

5.5.26. _Rebuilding the LZW dictionary_. Modify LZW to empty the dictionary and start over when it is full. This approach is recommended in some applications because it better adapts to changes in the general character of the input.

5.5.27. _Long repeats_. Estimate the compression ratio achieved by run-length, Huffman, and LZW encoding for a string of length 2N formed by concatenating _two copies_ of a random ASCII string of length N (see EXERCISES 5.5.9), under any assumptions that you think are reasonable.

##Web Exercises



1. 

2. Given an example of a uniquely-decodable code that is not prefix free.
_Solution_: Any suffix-free code is uniquely decodable, e.g., {0, 01}.

3. Given an example of a uniquely-decodable code that is not prefix free or suffix free.

_Solution_: {0011, 011, 11, 1110} or {01, 10, 011, 110}.

4.

5. **Test for uniquely decodability**. Implement the Sardinas-Patterson algorithm for testing whether a set of codewords is uniquely decodable:
Add all of the codewords to a set. Examine all pairs of codewords to see if any one is a prefix of another, if so, extract the dangling suffix(i.e., the part of the longer string that is not a prefix of the shorter one). If the dangling suffix is a codeword, then the code is not uniquely decodable; otherwise, add the dangling suffix to the list (provided it is not already there). Repeat this process with the larger list until there are no remaining new dangling suffix.

The algorithm is finite because all dangling suffixes added to the list are suffixes of a finite set of codewords, and a dangling suffix can be added at most once.
- {0, 01, 11}. The  codeword 0 is a prefix of 01, so add the dangling suffix 1. {0, 01, 11, 1}. The codeword 0 is a prefix of 01, but the dangling suffix 1 is already in the list; the codeword 1 is a prefix of 11, but the dangling suffix 1 is already in the list. There are no other dangling suffixes, so conclude that the set is uniquely decodable.
- {0, 01, 10}. The codeword 0 is a prefix of 01, so add the dangling suffix 1 to the list. {0, 01, 10, 1}. The codeword 1 is a prefix of 10, but the dangling suffix 0 is a codewords. So, conclude that the code is not uniquely decodable.

6. **Kraft-McMillian inequality**. 


