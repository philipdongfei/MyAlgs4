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

```
    if ((x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0))
        StdOut.println("true");
    else
        StdOut.println("false");
```

1.1.6 What does the following program print?

```
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++)
    {
        StdOut.println(f);
        f = f + g;
        g = f - g;
    }
```
    **answer:0, 1, 1, 2, 3**

1.1.7 Give the value printed by each of the following code fragments:

answer: fordemo.java

1.1.8 What do each of the following print?

    a. System.out.println('b'); -> b
    b. System.out.println('b'+'c'); -> bc
    c. System.out.println((char)('a'+4)); -> e
    Explain each outcome.

1.1.9 Write a code fragment that puts the binary representation of a positive integer N into a String s.

```
    String s = "";
    for (int n = N; n > 0; n /= 2)
        s = (n % 2) + s;

```

```

    String s = "";
    int n = N;
    do {
         s = (n % 2) + s;
    }while((n /= 2) > 0);

```

1.1.10 What is wrong with the following code fragment?

```

    int [] a;
    for (int i = 0; i < 10; i++)
        a[i] = i * i;

```
*solution*: It does not allocate memory for a[] with new. This code results in a *variable a might not have been initialized* compile-time error.

1.1.11 Write a code frament that prints the contents of a two-dimensional boolean array, using * to represent true and a space to represent false. Include row and column numbers.

```
    boolean[][] a;
    a = new boolean[N][M];

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (a[N][M])
                StdOut.printf("%d:%d:*", i, j);
            else
                StdOut.printf("%d:%d: ", i, j);
        }
        StdOut.println('\n');
    }


```

1.1.12 What does the following code fragment print?

```

    int[] a = new int[10];
    for (int i = 0; i < 10; i++)
        a[i] = 9 - i;
    for (int i = 0; i < 10; i++)
        a[i] = a[a[i]];
    for (int i = 0; i < 10; i++)
        System.out.println(i);

```

0 1 2 3 4 5 6 7 8 9

1.1.13 Write a code fragment to print the transposition (rows and columns changed) of a two-deimensional array with M rows and N columns.


```
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++)
                StdOut.printf("%d ", a[i][j]);
            StdOut.println('\n');
        }

```

1.1.14 Write a static method lg() that takes an int value N as argument and returns the largest int not larger that base-2 logarithm of N. Do not use Math.

```
    public static int Mylg(int N)
    {
        int res = 0;
        int n = N;
        do {
           if (n/2 > 0)
               ++res;
        }while((n /= 2) > 0);

        return res;
    }

```

1.1.15 Write a static method histogram() that takes an array[] of int values and an integer M as arguments and returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array. If the values in a[] are all between 0 and M-1, the sum of the values in the returned array should be equal to a.length.

```

    public static int[] histogram(int[] a, int M)
    {
        int[] res;
        res = new int[M];
        for (int i = 0; i < M; i++)
            res[i] = 0;

        int Len = a.length;

        for (int i = 0; i < Len; i++)
        {
            if (i < M)
                ++res[i];
        }
        return res;
    }


```

1.1.16 Give the value of exR1(6):

```

    public static String exR1(int n)
    {
        int (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
```
311361142246

1.1.17 Criticize the following recursive function:

```

public static String exR2(int n)
{
    String s = exR2(n-3) + n + exR2(n-2) + n;
    if (n <= 0) return "";
    return s;
}

```

*Answer*: The base case will never be reached. A call to exR2(3) will result in calls to exR2(0), exR2(-3), exR2(-6), and so forth until a *StackOverflowError* occurs.

1.1.18 Consider the following recursive function:

```

public static int mystery(int a, int b)
{
    if (b == 0) return 0;
    if (b % 2 == 0) return mystery(a+a, b/2);
    return mystery(a+a, b/2) + a;
}

```
what are the values of **mystery(2,25)** and **mystery(3,11)**? Given positive integers a and b, describe what value **mystery(a, b) computes. Answer the same question, but replace+with * and replace **return 0** with **return 1**.

1.1.20 Write a recursive static method that computes the value of ln(N!)



