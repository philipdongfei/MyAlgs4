# Exercises

1.2.1 Write a Point2D client that takes an integer value N from the command line, generates N random points in the unit square, and computes the distance separating the *closest pair* of points.


1.2.2 Write an InterVal1D client that takes an int Value N as command-line argument, reads N intervals (each defined by a pair of *double* values) from standard input, and prints all pairs that intersect.


1.2.3 Write an Interval2D client that takes command-line arguments N, min, and max and generates N random 2D intervals whose width and height are uniformly distributed between min and max in the unit square. Draw them on StdDraw and print the number of pairs of intervals that intersect and the number of intervals that are contained in one another.

1.2.4 What does the following code fragment print?

```

String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);

```

1.2.5 What does the following code fragment print?

```

String s = "Hello World";
s.toUpperCase();
s.substring(6, 11);
StdOut.println(s);

```

1.2.6 A string s is *circular rotation* of a string t if it matches when the characters are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. Detecting this condition is important in the study of genomic sequences. Write a program that checks whether two given strings s and t are circular shifts of one another. *Hint*: The solution is a one-liner with indexOf(), length(), and stirng concatenation.

1.2.7 What does the following recursive function return?

```

public staitc String mystery(String s)
{
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b)+mystery(a);
}

```

1.2.8 Suppose that a[] and b[] are each integer arrays consisting of millions of integers. What does follow code do? Is it reasonably efficient?

`int[] t = a; a = b; b = t;`

*Answer*. It swaps them. It could hardly be more efficient because it does so by copying references, so that it is not necessary to copy millions of elements.

1.2.9 Instrument *BinarySearch*(page 47) to use a Counter to count the total number of keys examined during all searches and then print the total after all searches are complete. *Hint*: Create a Counter in main() and pass it as an argument to rank().


1.2.10 Develop a class VisualCounter that allows both increment and decrement operations. Take two arguments N and max in the constructor, where N specifies the maximum number of operations and max specifies the maximum absolute value for the counter. As a side effect, create a plot showing the value of the counter each time its tally changes.


1.2.11 Develop an implementation SmartDate of our Date API that raises an exception if the date is not legal.

1.2.12 Add a method *dayOfTheWeek()* to *SmartDate* that returns a String value Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the appropriate day of the week for the date. You may assume that the date is in the 21st century.


1.2.12 Add a method *dayOfTheWeek()* to *SmartDate* that returns a String value Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the appropriate day of the week for the date. You may assume that the date is in the 21st century.


1.2.13 Using our implementation of *Date* as model(page 91), develop an implementation of Transaction.

1.2.14 Using our implementation of *equals() in Date as a model (page 103), develop implementations of equals() for Transaction.

1.2.15 *File input*. Develop a possible implementation of the static *readInts()* mehtod from In(which we use for various test clients, such as binary search on page 47) that is based on the split() method in String.

*Solution*:
```

public static int[] readInts(String name)
{
    In in = new In(name);
    String input = StdIn.readAll();
    String[] words = input.split("\\s+");
    int[] ints = new int[words.length];
    for (int i=0; i< word.length; i++)
        ints[i] = Integer.parseInt(words[i]);
    return ints;
}

```

We will consider a different implementation in **SECTION 1.3**(see page 126).

1.2.16 *Rational numbers*. Implement an immutable data type Rational for rational numbers that supports addition, subtraction, multiplication, and division.

public class Rational

________

Rational(int numerator, int denominator)
Rational plus(Rational b)    **sum of this number and b**
Rational minus(Rational b)   **difference of this number and b**
Rational times(Rational b)   **product of this number and b**
Rational divides(Rational b) **quotient of this number and b**
boolean equals(Rational that) **is this number equal to that?**
String toString()           **string representation**

You do not have to worry about testing for overflow (see EXERCISE 1.2.17), but use as instance variables two long values that represent the numerator and denominator to limit the possibility of overflow. Use Euclid's algorithm(see page 4) to ensure that the numerator and denominator never have any common factors. Include a test client that Exercises all of your methods.

1.2.17 *Robust implementation of rational numbers.* Use assertions to develop an implementation of *Rational* (see EXERCISE 1.2.16) that is immune to overflow.

1.2.18 *Variance for accumulator.* Validate that the following code, which adds the methods var() and stddev() to Accumulator, computes both the mean and variance of the numbers presented as arguments to addDataValue():

```
{code}

```
This implementation is less susceptible to roundoff error than the straightforward implementation based on saving the sum of the squares of the numbers.

1.2.19 *Parsing*. Develop the parse constructors for your Date and Transaction implementations of EXERCISE 1.2.13 that take a single String argument to specify the initialization values, using the formats given in the table below.












