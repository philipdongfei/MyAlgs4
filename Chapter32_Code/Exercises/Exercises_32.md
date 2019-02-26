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

