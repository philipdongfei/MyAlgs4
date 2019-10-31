#EXERCISES

##Book Exercises

5.4.1. Given regular expressions that describe all strings that contain
- Exactly four consecutive As
- No more than four consecutive As
- At least one occurrence of four consecutive As

_Solution_: 
1. A{4} | A{4}[^Ae].* | .*[^Ae]A{4} | .*[^Ae]A{4}[^Ae], 
2. [^A{5}]A{0-4}[^A{5}]*, 
3. .*(AAAA)+.*, 

5.4.2. Give a brief English description of each of the following RE's:
a. .*
b. A.*A | A
c. .*ABBABBA.*
d. .*A.*A.*A.*A.*

5.4.3. What is the maximum number of different strings that can be described by a regular expression with M _or_ operators and no closure operators (parentheses and concatenation are allowed)?


5.4.4. Draw the NFA corresponding to the pattern (((A|B)* | CD* | EFG)*)*. 

5.4.5. Draw the digraph of $\varepsilon$-transitions for the NFA from EXERCISE 5.5.4.

5.4.6. Given the sets of states reachable by your NFA from EXERCISE 5.4.4 after each character match and susbsequent $\varepsilon$-transitions for input A B B A C E F G E F G C A A B.

5.4.7. Modify the GREP client on page 804 to be a client GREPmatch the encloses the pattern in parentheses but does not add .* before and after the pattern, so that it prints out only those lines that are strings in the language described by the given RE. Given the result of typing each of the following commands:

a. % java GREPmatch "(A|B)(C|D)" < tinyL.txt
b. % java GREPmatch "A(B|C)*D" < tinyL.txt
c. % java GREPmatch "(A*B|AC)D" < tinyL.txt

5.4.8. Write a regular expression for each of the following sets of binary strings:
a. Contains at least three consecutive 1s : (0|1)*(111)+(0|1)*
b. Contains the substring 110 : (0|1)*110(0|1)*
c. Contains the substring 1101100 : (0|1)*1101100(0|1)*
d. Does not contain the substring 110 : (0|10)*1*

5.4.9. Write a regular expression for binary strings with at least two 0s but not consecutive 0s.
 
_Solution_: 1*011*0(10?)* 
or
1*01+0(10?)*

An explanation of it should be: First skip al the ones that start your expression with the 1* subpattern, so you get to the first 0, then skip at least one 1, and all the 1s following it (with subpattern 1+) up to the second 0, so we have just matched the minimum length string that matches you regular language. Once here, all the rest is optional, we need to repeat any number of times the pattern 1 with an optional trailing 0 (as in 10?), or there should be two consecutive 0s.
You can check it in this demo, that contains all the possible strings from 1 to 8 characters, and the matching or not of them.


5.4.10. Write a regular expression for each of the following sets of binary strings:

a. Has at least 3 characters, and the third character is 0
b. Number of 0s is a multiple of 3
c. Starts and ends with the same character
d. Odd length
e. Starts with 0 and has odd length, or starts with 1 and has even length 
f. Length is at least 1 and at most 3

_Solution_:
a. (0|1)(0|1)0(0|1)*
b. 1*|(1*01*01*01*)*
c. 1(0|1)*1 | 0(0|1)*0 | 0 | 1
d. (0|1)((0|1)(0|1))*
e. 0((0|1)(0|1))* | 1(0|1)((0|1)(0|1))*
f. (0|1) | (0|1)(0|1) | (0|1)(0|1)(0|1)

5.4.11. For each of the following regular expressions, indicate how many bitstrings of length exactly 1000 match:
a. 0(0|1)*1
b. 0*101*
c. (1|01)*

_Solution_: 
a. 2^998
b. 999
c. 501


5.4.12. Write a Java regular expression for each of the following:
a. Phone numbers, such as (609) 555-1234
b. Social Security numbers, such as 123-45-6789
c. Dates, such as December 31, 1999
d. IP addresses of the form a.b.c.d where each letter can represent one , two or three digits, such as 196.266.155.241
e. License plates that start with four digits and end with two uppercase letters.

_Solution_:
a. \([0-9]{3}\) [0-9]{3}-[0-9]{4}
b. [0-9]{3}-[0-9]{2}-[0-9]{4}
c. (January|February|March|April|May|June|July|August|September|October|November|December) ([1-9]|(1|2)[0-9]|3(0|1)), [0-9]{4}
d. ([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])(\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])){3}
e. [0-9]{4}*[A-Z]{2}

5.4.13 _Challenging REs_. Construct an RE that describes each of the following sets of strings over the binary alphabet:
a. All strings except 11 or 111
b. Strings with 1 in every odd-number bit position
c. Strings with at least two 0s and at most one 1
d. Strings with no two consecutive 1s

5.4.14. _Binary divisibility_. Construct an RE that describes all binary strings that when interpreted as binary number are
a. Divisible by 2
b. Divisible by 3
c. Divisible by 123

_Solution_: 
a. (0|1)*0
b. (0|1(01*0)*1)*
c. 

5.4.15. _One-level REs_. Construct a Java RE that describes the set of strings that are legal REs over the binary alphabet, but with no occurrence of parentheses within parentheses. For example, (0.*1)* or (1.*0)* is in this language, but (1(0 or 1)1)* is not.

5.4.16. _Multiway or_. Add multiway or to NFA. Your code should produce the machine drawn below for the pattern (.*AB((C|D|E)F)*G).

5.4.17. _Wildcard_(\.). Add to NFA the capability to handle wildcards.

5.4.18 _One or more_. Add to NFA the capability to handle the + closure operator.

5.4.19. _Specified set_. Add to NFA the capability to handle specified-set descriptors.

5.4.20. _Range_. Add to NFA the capability to handle range descriptors.

5.4.21. _Complement_. Add to NFA the capability to handle complement descriptors.

5.4.22. _Proof_. Develop a version of NFA that prints a proof that a given string is in the language recognized by the NFA (a sequence of state transitions that ends in the accept state).


















