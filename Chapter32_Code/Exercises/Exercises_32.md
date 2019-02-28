#EXERCISES

##BOOK

3.2.1 Draw the BST that results when you insert the keys E A S Y Q U E S T I O N, in that order (associating the value i with the ith key, as per the convention in the text) into an initially empty tree. How many compares are needed to build the tree?

*Answer*: compares 28.

3.2.2 Inserting the keys in the order A X C S E R H into an initially empty BST gives a worst-case tree where every node has one null link, except one at the bottom, which has two null links. Give five other orderings of the these keys that produce worst-case trees.

A C E H R S X
X S R H E C A
X A S C R E H
X A S C R H E
A X C S E H R

3.2.3 Give five orderings of the keys A X C S E R H that, when inesrted into an initially empty BST, produce the best-case tree.

*Solution*: Any sequence that insert H first; C before A and E; S before R and X.

3.2.4 Suppose that a certain BST has keys that are integers between 1 and 10, and we search 5. Which sequence below cannot be the sequence of keys examined?

*Answer*: d. 2,7,3,8,4,5.

3.2.5 Suppose that we have an estimate ahead of time of how often search keys are to be accessed in a BST, and the freedom to insert them in any order that we desire. Should the keys be inserted into the tree in increasing order, decreasing order of likely frequency of access, or some other order? Explain your answer.

*Answer*: decreasing order. the keys with high frequency near the root.

3.2.6 Add to BST.java a method height() that computes the height of the tree. Develop two implementations: recursive method (which takes linear time and space proportional to the height), and method like size() that adds a field to each node in the tree (and takes linear space and constant time per query).

3.2.7 Add to BST a recursive method avgCompares() that computes the average number of compares required by a random search hit in a given BST (the internal path length of the tree divided by its size, plus one). Develop two implementations: a recursive method (which takes linear time and space proportional to the height), and a method like size() that adds a field to each node in the tree (and takes linear space and constant time per query).

*Meaning*: To get the average number of compares for a BST, you must sum the number of compareisons to find every node given that the length of search for every node is equal to internal path to that node + 1. Finally to get the average value you must divide the sum by the total number of nodes. So it is just the average length of a node search.

3.2.8 Write a static method optCompares() that takes an integer argument N and computes the number of compares required by a random search hit in an optimal (perfectly balanced) BST, where all the null links are on the same level if the number of links is a power of 2 or on one of two levels otherwise.

3.2.9 Draw all the different BST shapes that can result when N keys are inserted into an initially empty tree, for N = 2,3,4,5,and 6.

3.2.10 Write a test client TestBST.java for use in testing the implementations of min(), max(), floor(), ceiling(), select(), rank(), deleteMin(), deleteMax(), and keys() that are given in the text.

3.2.11 How many binary tree shapes of N nodes are there with height N? How many different ways are there to insert N distinct keys into an initially empty BST that result in a tree of height N?

3.2.12 Develop a BST implementation that omits rank() and select() and does not use a count filed in Node.

3.2.13 Give nonrecursive implementations of get() and put() for BST.
*Partial solution*: Here is an implementation of get():
```
public Value get(Key key)
{
    Node x = root;
    while (x != null)
    {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) x = x.left;
        else if (cmp > 0) x = x.right;
    }
    return null;
}
```
The implementation of put() is more complicated because of the need to save a pointer to the parent node to link in the new node at the bottom. Also, you need a separate pass to check whether the key is already in the table because of the need to update the counts. Since there are many more searches than inserts in performance-critical implementations, using this code for get() is justified; the corresponding change for put() might not be noticed.

3.2.14 Give nonrecursive implementaions of min(), max(), floor(), ceiling(), rank(), and select().

3.2.15 Give the sequences of nodes examined when the methods in BST are used to compute each of the following quantities for the tree drawn at right;

a. floor("Q")  
b. select(5)
c. ceiling("Q")
d. rank("J")
e. size("D", "T")
f. keys("D", "T")

3.2.16 Define the *external path length* of a tree to be the sum of the number of nodes on the paths from the root to all null links. Prove that the difference between the external and internal path lengths in any binary tree with N nodes is 2N (see PROPOSITION C).
[Internal Path Length](http://mathworld.wolfram.com/InternalPathLength.html)
[External Path Length](http://mathworld.wolfram.com/ExternalPathLength.html)

E = I + 2N 
where N is the number of internal nodes.

3.2.17 Draw the sequence of BSTs that results when you delete the keys from the tree of EXERCISE 3.2.1, one by one, in the order they were inserted.

3.2.18 Draw the sequence of BSTs that results when you delete the keys from the tree of EXERCISE 3.2.1, one by one, in alphabetical order.

3.2.19 Draw the sequence of BSTs that results when you delete the keys from the tree of EXERCISE 3.2.1, one by one, by successively deleting the key at the root.

3.2.20 Prove that the running time of the two-argument keys() in a BST with N nodes is at most proportional to the tree height plus the number of keys in the range.

*Answer*: TODO

3.2.21 Add a BST method randomKey() that returns a random key from the symbol table in time proportional to the tree height, in the worst case.

3.2.22 Prove that if a node in a BST has two children, its successor has no left child and its predecessor has no right child.

*Solution*: [Predecessor & Successor](https://algorithms.tutorialhorizon.com/inorder-predecessor-and-successor-in-binary-search-tree/)
When you do the inorder traversal of a binary tree, the neighbors of given node are called **Predecessor**(the node lies behind of given node) and **Successor** (the node lies ahead of given node).

3.2.23 Is delete() commutative? (Does deleting x, then y give the same result as deleting y, then x?).

*Answer*: No.
   A
B     D
     C
delete A B and B A is different result.

3.2.24 Prove that no compare-based algorithm can build a BST using fewer than lg(N!)~NlgN compares.

*Answer*: one insert, compares lg1, lg2,... lgN = lg(N!).
          one insert, ~ lgN, N * lgN ~ NlgN.


3.2.25 Write a program PerfectBalance.java that inserts a set of keys into an initially empty BST such that the tree produced is equivalent to binary search, in the sense that the sequence of compares done in the search for any key in the BST is the same as the sequence of compares used by binary search for the same set of keys.

*Hint*: Put the median at the root and recursively build the left and right subtree.

3.2.26 *Exact probabilities*. Find the probability that each of the trees in EXERCISE 3.2.9 is the result of inserting N random distinct elements into an initially empty tree.

3.2.27 *Memory usage*. Compare the memory usage of BST with the memory usage of BinarySearchST and SequentialSearchST for N key-value pairs, under the assumptions described in SECTION 1.4 (see EXERCISE 3.1.21). Do not count the memory for the keys and values themselves, but do count references to them. Then draw a diagram that depicts the precise memory usage of a BST with String keys and Integer values (such as the ones built by FrequencyCounter), and then estimate the
memory usage (in bytes) for the BST build when FrequencyCounter uses BST for *Tale of Two Cites*.

3.2.28 *Software caching*. Modify BST to keep the most recently accessed Node in an instance variable so that it can be accessed in constant time if the next put() or get() uses the same key (see EXERCISE 3.1.25).

3.2.29 *Binary tree check*. Write a recursive method isBinaryTree() that takes a Node as argument and returns true if the subtree count field N is consistent in the data structure rooted at that node, false otherwise. *Note*: This check also ensures that the data structure has no cycles and is therefore a binary tree(!).

3.2.30 *Order check*. Write a recursive method isOrdered() that takes a Node and two keys min and max as arguments and return true if all the keys in the tree are between min and max; min and max are indeed the smallest and largest keys in the tree, respectively; and the BST ordering property holds for all keys in the tree; false otherwise.

3.2.31 *Equal key check*. Write a method hasNoDuplicates() that takes a Node as argument and returns true if there are no equal keys in the binary tree rooted at the argument node, false otherwise. Assume that the test of the previous exercise has passed.

3.2.32 **Certification**. Write a method isBST() in BST.java that takes a Node as argument and returns true if the argument node is the root of a binary search tree, false otherwise.
*Hint*: This task is also more difficult than it might seem, because the order in which you call the methods in the previous three exercises is important.
```
private boolean isBST()
{
    if (!isBinaryTree(root)) return false;
    if (!isOrdered(root, min(), max())) return false;
    if (!hasNoDuplicates(root)) return false;
    return true;
}

```
3.2.32 **Subtree count check**. Write a recursive method isSizeConsistent() in BST.java that takes a Node as argument and returns true if the subtree count field N is consistent in the data structure rooted at that node, false otherwise.

3.2.33 **Select/rank check**. Write a method isRankConsistent() in BST.java that checks, for all i from 0 to size()-1, whether i is equal to rank(select(i)) and, for all keys in the BST, whether key is equal to select(rank(key)).

3.2.34 *Threading*. Your goal is to support an extended API ThreadedST that supports the following additional operations in constant time:
```
    Key next(Key key)   // key that follows key (null if key is the max)
    Key prev(Key key)   // key that precedes key (null if key is the min)
```

To do so, add fields pred and succ to Node that contain links to the predecessor and successor nodes, and modify put(), deleteMin(), deleteMax(), and delete() to maintain these fields.

3.2.35 *Refined analysis*. Refine the mathematical model to better explain the experimental results in the table given in the text. Specifically, show that the average number of compares for a successful search in a tree built from random keys approaches the limit 2 ln N + 2y - 3 = 1.39 lg N - 1.85 as N increases, where y = .57721... is Euler's constant. *Hint*: Referring to the quicksort analysis in SECTION 2.3, use the fact that the integral of 1/x approaches ln N + y.

3.2.36 *Iterator*. Is it possible to write a nonrecursive version of keys() that uses space proportional to the tree height (independent of the number of keys in the range)?

3.2.37 *Level-order traversal*. Write a method printLevel() that takes a Node as argument and prints the keys in the subtree rooted at that node in level order (in order of their distance from the root, with nodes on each level in order from left to right). *Hint*: Use a Queue. 

3.2.38 *Tree drawing*. Add a method draw() to BST that draws BST figures in the style of the text. *Hint*: Use instance variables to hold node coordinates, and use a recursive method to set the values of these variables.


## Web Exercises

1. **The great tree-list recursion problem**. A binary search tree and a circular doubly linked list are conceptually built from the same type of nodes - a data field and two references to other nodes. Given a binary search tree, rearrange the references so that it becomes a circular doubly-linked list (in sorted order). Nick Parlante describles this as [one of the neatest recursive pointer problems ever devised](http://cslibrary.stanford.edu/109/TreeListRecursion.html). *Hint*: create a circularly linked list A from the left subtree, a circularly linked list B from the right subtree, and make the root a one node circularly linked list. Them merge the three lists.


2. **BST reconstruction**. Given the preorder traversal of a BST (not include null nodes), reconstruct the tree.

*Hint*: Preorder(Root, Left, Right).
Inorder(Left, Root, Right).
Postorder(Left, Right, Root).

TODO: ??? no Inorder traversal.


3. True or false. Given a BST, let x be a leaf node, and let y be its parent. Then either(i) the key of y is the smallest key in the BST larger than the key of x or (ii) the key of y is the largest key in the BST smaller than the key of x.
*Answer*: true.

4. True or false. Let x be a BST node. The next largest key (successor of x) can be found by traversing up the tree toward the root until encountering a n ode with a nonempty right subtree (possibly x itself); then finding the minimum key in the right subtree (by following its rightmost path).
*Answer*: true.

5. **Tree traversal with constant extra memory**. Describe how to perform an inorder tree traversal with constant extra memory (e.g., no function call stack). *Hint*: on the way down the tree, make the child node point back to the parent (and reverse it on the way up the tree).

6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.
6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.
6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.
6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.
6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.
6. **Reverse a BST**. Given a standard BST (where each key is greater than the keys in its left subtree and smaller than the keys in its right subtree), design a linear-time algorithm to transform it into a reverse BST (where each key is smaller than the keys in its left subtree and greater than the keys in its right subtree). The resulting tree shape should be symmetric to the original one.

```
void reverseBST(Node x) 
{
    if (x == null) return;
    if (x.left != null)
    {
        reverseBST(x.left);
    }
    if (x.right != null)
    {
        reverseBST(x.right);
    }
    Node t_right = x.right;
    x.right = x.left;
    x.left = t_right;
    
}
```

7. **Level-order traversal reconstruction of a BST**. Give a sequence of keys, design a linear-time algorithm to determine whether it is the level-order traversal of some BST (and construct the BST itself).

TODO: 


8. **Find two swapped keys in a BST**. Give a BST in which two keys in two nodes have been swapped, find the two keys.
*Solution*. Consider the inorder traversal a[] of the BST. There are two cases to consider. Suppose there is only one index p such that a[p] > a[p+1]. Then swap the keys a[p] and a[p+1]. Otherwise, there are two indices p and q such a[p] > a[p+1] and a[q] > a[q+1]. Let's assume p < q. Then, swap the keys a[p] and a[q+1].


