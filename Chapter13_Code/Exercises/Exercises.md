# EXERCISES 

1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.

1.3.2 Give the output printed by java Stack for the input

  *it was - the best - of times - - - it was - the - -*


1.3.3 Suppose that a client performs an intermixed sequence of (stack) *push* and *pop* operations. The push operations put the integers 0 through 9 in order onto the stack; the pop operations print out the return values. Which of the following sequence(s) could *not* occur?

- a. 4 3 2 1 0 9 8 7 6 5
- b. 4 6 8 7 5 3 2 9 *0 1*
- c. 2 5 6 7 4 8 9 3 1 0
- d. 4 3 2 1 0 5 6 7 8 9
- e. 1 2 3 4 5 6 9 8 7 0
- f. 0 4 6 5 3 8 *1 7* 2 9
- g. 1 4 7 9 8 6 5 3 *0 2*
- h. 2 1 4 3 6 5 8 7 9 0
 
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

- a. 0 1 2 3 4 5 6 7 8 9
- b. 4 6 8 7 5 3 2 9 0 1
- c. 2 5 6 7 4 8 9 3 1 0
- d. 4 3 2 1 0 5 6 7 8 9

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


1.3.27 Write a method *max()* that takes a reference to the first node in a linked list as argument and returns the value of the maximum key in the list. Assume that all keys are positive integers, and return 0 if the list is empty. 

Answer: Queue2.java

1.3.28 Develop a recursive solution to the previous question.

Answer: Queue2.java

1.3.29 Write a Queue implementation that uses a *circular* linked list, which is the same as linked list except that no links are *null* and the value of last.next is first whenever the list is not empty. Keep only one Node instance variable (last).

Answer: Queue3.java

1.3.30 Write a function that takes the first Node in a linked list as argument and (destructively) reverses the list, returning the first Node in the result.

*Iterative solution*: To accomplish this task, we maintain references to three consecutive nodes in the linked list, *reverse*, *first* and *second*. At each iteration, we extract the node *first* from the original linked list and insert it at the beginning of the reversed list. We maintain the invariant the *first* is the first node of what's left of the original list, *second* is the second node of what's left of the original list, and *reverse* is the first node of the
resulting reversed list.

```
    public Node reverse(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

```
When writing code involving linked lists, we must always be careful to properly handle the exceptional cases (when the linked list is empty, when the list has only one or two nodes) and the boundary cases (dealing with the first or last items). This is usually much trickier than handling the normal cases.

*Recursive solution*: Assuming the linked list has N nodes, we recursively reverse the last N-1 nodes, and then carefully append the first node to the end.

```
    public Node reverse(Node first)
    {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }

```
*Answer*: Queue2.java

1.3.31 Implement a nested class *DoubleNode* for building doubly-linked lists, where each node contains a reference to the item preceding it and the item following it in the list (*null* if there is no such item). Then implement static methods for the following tasks: *insert* at the beginning, insert at the end, remove from the beginning, remove from the end, insert before a given node, insert after a given node, and remove a given node.

1.3.32 *Seque*. A stack-ended queue or *steque* is a data type that supports *push*, *pop*, and *enqueue*. Articulate an API for this ADT. Develop a linked-list-based implementation.

1.3.33 *Deque*. A double-ended queue or *deque* (pronounced "deck") is like a stack or a queue but supports adding and removing items at both ends. A deque stores a collection of items and supports the following API:

public class Deque<Item> implements Iterable<Item>
----------------------
Deque()                 *create an empty deque*
boolean isEmpty()       *is the deque empty?*
int size()              *number of items in the deque*
void pushLeft(Item item)    *add an item to the left end*
void pushRight(Item item)   *add an item to the right end*
Item popLeft()          *remove an item from the left end*
Item popRight()         *remove an item from the right end*

**API for a generic double-ended queue**

Write a class **Deque** that uses a doubly-linked list to implement list API and a class **ResizingArrayDeque** that uses a resizing array.

1.3.34 *Random bag*. A *random bag* stores a collection of items and supports the following API:

public class RandomBag<Item> implements Iterable<Item>
----------------------------------------------
RandomBag()                 *create an empty random bag*
boolean isEmpty()           *is the bag empty?*
int size()                  *number of items in the bag*
void add(Item item)         *add an item*
**API for a generic random bag**

Write a class RandomBag that implements this API. Note that this API is the same as for Bag, except for the adjective random, which indicates that the iteration should provide the items in random order (all N! permutations equally likely, for each iterator). 
*Hint*: Put the items in an array and randomize their order in the iterator's constructor.

1.3.35 *Random queue*. A *random queue* stores a collection of items and supports the following API:

public class RandomQueue<Item>
------------------------------
RandomQueue()           *create an empty random queue*
boolean isEmpty()       *is the queue empty?*
void enqueue(Item item) *add an item*
Item dequeue()          *remove and return a random item
                        (sample without replacement)*
Item sample()           *return a random item, but do not remove
                        (sample with replacement)*
**API for a generic random queue**

Write a class *RandomQueue* that implements this API. *Hint*: Use an array representation (with resizing). To remove an item, swap one at a random position (indexed 0 through N-1) with the one at the last position (index N-1). Then delete and return the last object, as in *ResizingArrayStack*. Write a client that deals bridge hands (13 cards each) using *RandomQueue<Card>*.


1.3.34 Random bag. A random bag stores a collection of items and supports the following API:

public class RandomBag<Item> implements Iterable<Item>

RandomBag()                 *create an empty random bag*
boolean isEmpty()           *is the bag empty?*
int size()                  *number of items in the bag*
void add(Item item)         *add an item*

**API for a generic random bag**

Write a class RandomBag that implements this API. Note that this API is the same as for Bag, except for the adjective random, which indicates that the iteration should provide the items in random order (all N! permutations equally likely, for each iterator). Hint: put the items in an array and randomize their order in the iterator's constructor.

1.3.35 *Random queue*. A *random queue* stores a collection of items and supports the following API:

public class RandomQueue<Item>

-----
RandomQueue()               *create an empty random queue*
boolean isEmpty()           *is the queue empty?*
void enqueue(Item item)     *add an item*
Item dequeue()              *remove and return a random item
                            (sample without replacement)*
Item sample()               *return a random item, but do not remove
                            (sample with replacement)
**API for a generic random queue**

Write a class *RandomQueue* that implements this API. *Hint*: Use an array representation (with resizing). To remove an item, swap one at a random position (indexed 0 through N-1) with the one at the last position (index N-1). Then delete and return the last object, as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each) using RandomQueue<Card>.


1.3.36 *Random iterator*. Write an iterator for RandomQueue<Item> from the previous exercise that return the items in random order.

1.3.37 *Josephus problem*. In the Josephus problem from antiquity, N people are in dire straits and agree to the following strategy to reduce the population. They arrange themselves in a circle (at positions numbered from 0 to N-1) and proceed around the circle, eliminating every Mth person until only one person is left. Legend has it that Josephus figured out where to sit to avoid being eliminated. Write a Queue client Josephus that takes N and M from the command line and prints out
the order in which people are eliminated (and thus would show Josephus where to sit in the circle).

% java Josephus 7 2
1 3 5 0 4 2 6

1.3.38 *Delete Kth element*. Implement a class that supports the following API:

public class GeneralizedQueue<Item>

GeneralizedQueue()          *create an empty queue*
boolean isEmpty()           *is the queue empty?*
void insert(Item x)         *add an item*
Item delete(int k)          *delete and return the Kth least recently inserted item*

**API for a generic generalized queue**

First, develop an implementation that uses an array implementation, and then develop one that usese a linked-list implementation. Note: the algorithms and data structures that we introduce in **CHAPTER 3** make it possible to develop an implementation that can guarantee that both insert() and delete() take time prortional to the logarithm of the number of items in the queue--see EXERCISE 3.5.27.

1.3.39 *Ring buffer*. A ring buffer, or circular queue, is a FIFO data structure of a fixed size N. It is useful for transferring data between asynchronous processes or for storing log files. when the buffer is empty, the consumer waits until data is deposited; when the buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and an implementation that uses an array representation (with circular wrap-around).

1.3.40 *Move-to-front*. Read in a sequence of characters from standard input and maintain the characters in a linked list with no duplicates. When you read in a previously unseen character, insert it at the front of the list. When you read in a duplicate character, delete it from the list and reinsert it at the beginning. Name your program **MoveToFront**: it implements the well-known *move-to-front* strategy, which is useful for caching, data compression, and many other
applications where items that have been recently accessed are more likely to be reaccessed.

1.3.41 *Copy a queue*. Create a new constructor so that
'Queue<Item> r = new Queue<Item>(q);'
makes r a reference to a new and independent copy of the queue q. You should be able to push and pop from either q or r without influencing the other. *Hint*: Delete all of the elements from q and add these elements to both q and r.

*Answer*: Queue2.java

1.3.42 *Copy a stack*. Create a new constructor for the linked-list implementation of Stack so that
'Stack<Item> t = new Stack<Item>(s);'
makes t a reference to a new and independent copy of the stack s.

*Answer*: Stack42.java

1.3.43 *Listing files*. A folder is a list of files and folders. Write a program that takes the name of a folder as a command-line argument and prints out all of the files contained in that folder, with the contents of each folder recursively listed (indented) under that folder's name. *Hint*: Use a queue, and see java.io.File.

1.3.44 *Text editor buffer*. Develop a data type for a buffer in a text editor that implements the following API:

public class Buffer

Buffer()                    *create an empty buffer*
void insert(char c)         *insert c at the cursor position*
char delete()               *delete and return the character at the cursor*
void left(int k)            *move the cursor k positions to the left*
void right(int k)           *move the cursor k positions to the right*
int size()                  *number of characters in the buffer*

**API for a text buffer**
*Hint*: Use two stacks.

1.3.45 *Stack generability*. Suppose that we have a sequence of intermixed push and pop operations as with our test stack client, where the integers 0, 1, ..., N-1 in that order (push idrectives) are intermixed with N minus signs (pop directives). Devise an algorithm that determines whether the intermixed sequence causes the stack to underflow. (You may use only an amount of space independent of N--you cannot store the integers in a data structure.) Devise a linear-time algorithm that
determines whether a given permutation can be generated as output by our test client (depending on where the pop idrectives occur).

*Solution*: The stack does not overflow unless there exists an integer k such that the first k pop operations occur before the first k push operations. if a given permutation can be generated, it is uniquely generated as follows: if the next integer in the output permutation is in the top of the stack, pop it; otherwise, push it onto the stack.

1.3.46 *Forbididen triple for stack generability*. Prove that a permutation can be generated by a stack (as in the previous question) if and only if it has no forbidden triple (a, b, c) such that a < b < c with c first, a second, and b third (possibly with other intervening integers between c and a and between a and b).

*Partial solution*: Suppose that there is a forbidden trip(a, b, c). Item c is popped before a and b, but a and b are pushed before c. Thus, when c is pushed, both a and b are on the stack. Therefore, a cannot be popped before b.

1.3.47 *Catenable queues, stacks, or steques*. Add an extra operation *catenation* that (destructively) concatenates two queues, stacks, or steques (**see EXERCISE 1.3.32**). *Hint*: Use a circular linked list, maintaining a pointer to the last item.

1.3.48 *Two stacks with a deque*. Implement two stacks with a single deque so that each operation takes a constant number of deque operations(see EXERCISE 1.3.33).

1.3.49 *Queue with three stacks*. Implement a queue with three stacks so that each queue operation takes a constant(worst-case) number of stack operations. *Warning*: high degree of difficulty.

1.3.50 *Fail-fast iterator*. Modify the iterator code in Stack to immediately throw a java.util.ConcurrentModificationException if the client modifies the collection (via push() or pop()) during iteration.

*Solution*: Maintain a counter that counts the number of push() and pop() operations. When creating an iterator, store this value as an iterator instance variable. Before each call to hasNext() and next(), check that this value has not changed since constructioin of the iterator; if has, throw an exception.

1.3.51 **Expression evaluation with precedence**. Write a program EvaluateDeluxe.java that extends Evaluate.java to handle expressions that are not fully parenthesized, using the standard precedence order for the operators+,-,*, and /.



























