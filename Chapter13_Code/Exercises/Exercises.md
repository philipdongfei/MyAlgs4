# EXERCISES 

1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.

1.3.2 Give the output printed by java Stack for the input

  *it was - the best - of times - - - it was - the - -*


1.3.3 Suppose that a client performs an intermixed sequence of (stack) *push* and *pop* operations. The push operations put the integers 0 through 9 in order onto the stack; the pop operations print out the return values. Which of the following sequence(s) could *not* occur?

a. 4 3 2 1 0 9 8 7 6 5
b. 4 6 8 7 5 3 2 9 *0 1*
c. 2 5 6 7 4 8 9 3 1 0
d. 4 3 2 1 0 5 6 7 8 9
e. 1 2 3 4 5 6 9 8 7 0
f. 0 4 6 5 3 8 *1 7* 2 9
g. 1 4 7 9 8 6 5 3 *0 2*
h. 2 1 4 3 6 5 8 7 9 0
 
1.3.4 Write a stack client  Parenteses that reads in a text stream from standard input and uses a stack to determine whether its parentheses are properly balanced. For example, your program should print true for [()]{}{[()()]()} and false for [(]).   

1.3.5 What does the following code fragment print when N is 50? Give a high-level description of what it does when presented with a positive integer N.

```

Stack<Integer> stack = new Stack<Integer>();
while (N > 0)
{
    Stack.push(N % 2);
    N = N / 2;
}
for (int d : stack) StdOut.print(d);
StdOut.println();

```
*Answer*: Prints the binary representation of N (110010 when N is 50).

1.3.6 What does the following code fragment do to the queue q?

```

Stack<String> stack = new Stack<String>();
while (!q.isEmpty())
    stack.push(q.dequeue());
while (!stack.isEmpty())
    q.enqueue<stack.pop());

```


1.3.7 Add a method *peek()* to Stack that returns the most recently inserted item on the stack (without popping it).

Answer: Stack.java

1.3.8 Give the contents and size of the array for DoublingStackOfString with the input

    *it was - the best - of times - - - it was - the - -*

1.3.9 Write a program that takes from standard input an expression without left parentheses and prints the equivalent infix expression with the parentheses inserted. For example, give the input: 

    `1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )`
your program should print
    ` ( ( 1 + 2 ) * ((3 - 4) * ( 5 - 6 )))`

1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.

1.3.11 Write a program *EvaluatePostfix* that takes a postfix expression from standard input, evaluates it, and prints the value. (Piping the output of your program from the previous exercise to this program gives equivalent behavior to *Evaluate*.)

1.3.12 Write an iterable **Stack** *client* that has a static method *copy()* that takes a stack of strings as argument and returns a copy of the stack. *Note*: This ability is a prime example of the value of having an iterator, because it allows development of such functionality without changing the basic API.

1.3.13 Suppose that a client performs an intermixed sequence of (queue) *enqueue* and *dequeue* operations. The enqueue operations put the integers 0 through 9 in order onto the queue; the dequeue operations print out the return value. Which of the following sequence(s) could *not* occur?

a. 0 1 2 3 4 5 6 7 8 9
b. 4 6 8 7 5 3 2 9 0 1
c. 2 5 6 7 4 8 9 3 1 0
d. 4 3 2 1 0 5 6 7 8 9

1.3.14 Develop a class **ResizingArrayQueueOfStrings** that implements the queue abstraction with a fixed-size array, and then extend your implementation to use array resizing to remove the size restriction.

1.3.15 Write a *Queue* client that takes a command-line argument k and prints the Kth from the last string found on standard input (assuming that standard input has *k* or more strings).

1.3.16 Using **readints()** on page 126 as a model, write a static method **readDates()** for Date that reads dates from standard input in the format specified in the table on page 119 and returns an array containing them.


1.3.17 Do **EXERCISE** 1.3.16 for Transaction.


1.3.18 Suppose x is a linked-list node and not the last node on the list. What is the effect of the following code fragment?

    `x.next = x.next.next;`

*Answer*: Deletes from the list the node immediately following x.

1.3.19 Give a code fragment that removes the last node in a linked list whose first node is *first*.

```
if (N == 0)
    return;
else if (N == 1)
{
    first = null;
    last = null;
    N--;
} else {
    Item item = first;
    if (item->next)
    {
        while(item->next->next != null) {
            item = item->next;
        }
        item->next = null;
        N--;
    }
}

```
*Answer*: Queue2.java

1.3.20 Write a method delete() that take an int argument k and deletes the Kth element in a linked list, if it exists.

1.3.21 Write a method find() that takes a linked list and a string key as arguments and returns true if some node in the list has key as its item field, false otherwise.

1.3.22 Suppose that x is a linked list Node. What does the following code fragment do?

```
    t.next = x.next;
    x.next = t;

```
*Answer*: Inserts node t immediately after node x.

1.3.23 Why does the following code fragment not do the same thing as in the previous question?

```
    x.next = t;
    t.next = x.next;

```
*Answer*: When it comes time to update t.next, x.next is no longer the original node following x, but is instead t itself!

1.3.24 Write a method *removeAfter()* that takes a linked-list *Node* as argument and removes the node following the given one (and does nothing if the argument or the next field in the argument node is null).

*Answer*: QUEUE2.java

1.3.25 Wite a method *insertAfter()* that takes two linked-list *Node* arguments and inserts the second after the first on its list (and does nothing if either argument is null).

1.3.26 Write a method *remove()* that takes a linked list and a string *key* as arguments and removes all of the nodes in the list that have key as its item field.













