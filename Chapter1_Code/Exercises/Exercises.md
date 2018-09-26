# EXERCISES

1.1.1 Give the value of each of the following expressions:
    a. (0+15) / 2 = 7
    b. 2.0e-6*100000000.1 = 200.0000002
    c. true && false || true && true = true

1.1.2 Give the type and value of each of the following expressions:
    a. (1+2.236)/2 = 1.618
    b. 1+2+3+4.0 = 10.0
    c. 4.1 >= 4 -> true
    d. 1 + 2 + "3" -> error

1.1.3 Write a program that takes three integer command-line arguments and prints equal if all three are equal, and not equal otherwise.
    Compare3Int.java

1.1.4 What(if anything) is wrong with each of the following statements?
    a. if (a > b) ~~then~~ c = 0
    b. if **(** a > b **)** { c = 0; }
    c. if (a > b) c = 0;
    d. if (a > b) c = 0 **;** else b = 0;

1.1.5 Write a code fragment that prints true if the double variables x and y are both strictly between 0 and 1 and false otherwise.
(```)

    if ((x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0))
        StdOut.println("true");
    else
        StdOut.println("false");
        
(```)

1.1.6 What does the following program print?
(```)
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++)
    {
        StdOut.println(f);
        f = f + g;
        g = f - g;
    }
(```)
answer: 
0, 1, 1, 2, 3, ...

1.1.7 Give the value printed by each of the following code fragments:
answer: fordemo.java

1.1.8 What do each of the following print?
a. System.out.println('b'); -> b
b. System.out.println('b'+'c'); -> bc
c. System.out.println((char)('a'+4)); -> e
Explain each outcome.

1.1.9 Write a code fragment that puts the binary representation of a positive integer N into a String s.

