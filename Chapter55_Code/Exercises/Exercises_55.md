#EXERCISES

##Book Exercises
 
5.5.1. Consider the four variable-length codes shown in the table at right. Which of the codes are prefix-free? Uniquely decodable? For those that are uniquely decodable, give the encoding of 1000000000000.

_Solution_: code4, ADDDD

5.5.2. Given a example of a uniquely decodable code that is not prefix-free.

_Answer_: Any suffix-free code is uniquely decodable.

5.5.3 Given an example of a uniquely decodable code that is not prefix free or suffix free.

_Answer_: {0011, 011, 11, 1110} or {01, 10, 011, 110}

5.5.4 Are {01, 1001, 1011, 111, 1110} and {01, 1001, 1011, 111, 1110} uniquely decodable? If not, find a string with two encodings.

_Answer_: {01, 1001, 1011, 111, 1110} is not uniquely decodable. 11101111001 can be decoded both as 1110-111-1001 and 111-01-1110-01.

5.5.5. Use RunLength on the file q128X192.bin from the booksite. How many bits are there in the compressed file?




