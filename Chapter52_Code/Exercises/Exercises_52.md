#EXERCISES

##Book Exercises

5.2.1 Draw the R-way trie that results when the keys
no is th ti fo al go pe to co to th ai of th pa
are inserted in that order into an initially empty trie (do not draw null links).

5.2.2 Draw the TST that results when the keys
no is th ti fo al go pe to co to th ai of th pa
are inserted in that order into an initially empty TST.

5.2.3 Draw the R-way trie that results when the keys
now is the time for all good people to come to the aid of
are inserted in that order into an initially empty trie (do not draw null links).

5.2.4 Draw the TST that results when the keys
now is the time for all good people to come to the aid of
are inserted in that order into an initially empty TST.

5.2.5 Develop nonrecursive versions of TrieST and TST.

5.2.6 Implement the following API, for a StringSET data type:
public class StringSET
StringSET()       *create a string set*
void add(String key)   *put key into the set*
void delete(String key) *remove key from the set*
boolean contains(String key)  *is key in the set?*
boolean isEmpty()  *is the set empty?*
int size()   *number of keys in the set*
int toString() *string representation of the set*

5.2.7 *Empty string in TSTs*. The code in TST does not handle the empty string properly. Explain the problem and suggest a correction.

5.2.8 *Ordered operations for tries*. Implement the floor(), ceil(), rank(), and select() (from our standard ordered ST API from CHAPTER 3) for TrieST.

5.2.9 *Extended operations for TSTs*. Implement keys() and the extended operations introduced in this section -- longestPrefixOf(), keysWithPrefix(), and keysThatMatch()--for TST.

5.2.10 *Size*. Implement very eager size() (that keeps in each node the number of keys in its subtree) for TrieST and TST.

5.2.11 *External one-way branching*. Add code to TrieST and TST to eliminate extenal one-way branching.

5.2.12 *Internal one-way branching*. Add code to TrieST and TST to eliminate internal one-way branching.

5.2.13 *hybrid TST with R^2-way branching at the root*. Add code to TST to do multiway branching at the first two levels, as described in the text.

5.2.14 *Unique substrings of length L*. Write a TST client that reads in text from standard input and calculates the number of unique substrings of length L that it contains. For example, if the input is cgcgggcgcg, then there are five uniqueue substrings of length 3: cgc, cgg, gcg, ggc, and ggg. Hint: Use the string method substring(i, i+L) to extract the ith substring, then insert it into a sybmol table.
Alternative solution: compute the hash of the i+1st substring using the hash of the ith substring. Test it out on the first million digits of pi or the first 10 million digits of pi.

5.2.15 *Unique substrings*. Write a TST client that reads in text from standard input and calculates the number of distinct substrings of any length. This can be done very efficiently with a suffix tree -- see CHAPTER 6.

5.2.16 *Document similarity*. Write a TST client with a static method that takes an int value L and two file names as command-line arguments and computes the L-similarity of the two documents: the Euclidean distance between the frequency vectors defined by the number of occurrences of each trigram divided by the number of trigrams. Include a static method main() that takes an int value L as command-line argument and a list of file names from standard input and prints a matrix
showing the L-similarity of all pairs of documents.

5.2.17 *Spell checking*. Write a TST client SpellChecker that takes as command-line argument the name of a file containing a dictionary of words in the English language, and then reads a string from standard input and prints out any word that is not in the dictionary. Use a string set.

5.2.18 *Whitelist*. Write a TST client that solves the whitelisting problem presented in SECTION 1.1 and revisited in SECTION 3.5

5.2.19 *Random phone numbers*. Write a TrieST client (with R = 10) that takes as command-line argument an int value N and prints N random phone numbers of the form (xxx) xxx-xxxx. Use a symbol table to avoid choosing the same number more than once. Use the file AreaCodes.txt from the booksite to avoid printing out bogus area codes.

5.2.20 *Contains prefix*. Add a method containsPrefix() to StringSET(see EXERCISE 5.2.6) that takes a string s as input and returns true if there is a string in the set that contains s as a prefix.

5.2.21 *Substring matches*. Given a list of (short) strings, your goal is to support queries where the user looks up a string s and your job is to report back all strings in the list that contain s. Design an API for this task and develop a TST client that implements your API. Hint: Insert the suffixes of each word (e.g., String, tring, ring, ing, ng, g) into the TST.

5.2.22 *Typing monkeys*. Suppose that a typing monkey creates random words by appending each of 26 possible letter with probability p to the current word and finishes the word with probability 1-26p. Write a program to estimate the frequency distribution of the lengths of words produced. If "abc" is produced more than once, count it only once.

## Web Exercises

6. **Spam blacklist**. Insert known spam email addresses into an existence table and use to blacklist spam.

7. **IP lookup by country**. Use the data file ip-to-country.csv to determine what country a given IP address is coming from. The data file has five fields (begining of IP address range, ending of IP address range, two character country code, three character country code, and country name). See The IP-to-country website. The IP addresses are non-overlapping. Such a database tool can be used for: credit card fraud detection, spam filtering, auto-selection of language on a web
   site, and web server log analysis.

8. **Inverted index of web**. Given a list of web page, create a symbol table of words contained in the web pages. Associate with each word a list of web pages in which that word appears. Write a program that reads in a list of web pages, creates the symbol table, and support single word queries by returning the list of web pages in which that query word appears.

9. **Inverted index of web**. Extend the previous exercise so that it supports multi-word queries. In this case, output the list of web pages that contain at least one occurrence of each of the query words.

10. **Symbol table with duplicates**.

11. **Password checker**. Write a program that reads in a string from the command line and a dictionary of words from standard input, and checks whether it is a "good" password. Here, assume "good" means that it (i) is at least 8 characters long, (ii) is not a word in the dictionary, (iii) is not a word in the dictionary followed by a digit 0-9 (e.g., hello5), (iv) is not two words separated by a digit (e.g., hello2world)

12. **Reverse password checker**. Modify the previous problem so that (ii)-(v) are also staisfied for reverses of words in the dictionary (e.g., olleh and olleh2world). Clever solution: insert each word and its reverse into the symbol table.

16. **Zipf's law**. Harvard linguist George Zipf observed that the frequency of the ith most common word in a English text containing N words is roughly proporitional to 1/i, where the constant of proportionality is 1+1/2+1/3+...+1/N. Test "Zipf's law by reading in a sequence of words from standard input, tabulate their frequencies, and compare against the predicted frequencies.

18. **Typing monkeys and power laws**. Repeat the previous exercise, but assume that the letters a-z occur proportional to the following probabilities, which are typical of English text.

19. **Indexing a book**. Write a program that reads in a text file from standard input and compiles an alphabetical index of which words appear on which lines, as in the following input. Ignore case and puncuation.
"""
It was the best of times,
it was the worst of times,
it was the age of wisdom,
it was the age of foolishness,

age 3-4
best 1
foolishness 4
it 1-4
of 1-4
the 1-4
times 1-2
was 1-4
wisdom 4
worst 2
"""

20. **Entropy**. We define the relative entropy of a text corpus with N words, k of which are distinct as E = 1/(N log N)*sum (p_i log(k) - log(p_i), i = 1..k) where p_i is the fraction of times that word i appears. Write a program that reads in a text corpus and prints out the relative entropy. Convert all letters to lowercase and treat punctuation marks as whitespace.

21. **Longest prefix**. True or false. The longest prefix of a binary string x that is a key in a symbol table is either the floor of x or the ceiling of x (or both if x is in the set).

*Solution*: False. The longest prefix of 1100 in {1, 10, 1011, 1111} is 1, not 1011 or 1111.
21. **Longest prefix**. True or false. The longest prefix of a binary string x that is a key in a symbol table is either the floor of x or the ceiling of x (or both if x is in the set).

*Solution*: False. The longest prefix of 1100 in {1, 10, 1011, 1111} is 1, not 1011 or 1111.


















