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



