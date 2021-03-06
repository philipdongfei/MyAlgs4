#EXERCISES

##BOOK EXERCISES

3.3.1 Draw the 2-3 tree that results when you insert the keys E A S Y Q U T I O N in that order into an initially empty tree.

3.3.2 Draw the 2-3 tree that results when you insert the keys Y L P M X H C R A E S in that order into an initially empty tree.

3.3.3 Find an insertion order for the keys S E A R C H X M that leads to a 2-3 tree of height 1.
 
 *Solution*: E R A C H S X M

 3.3.4 Prove that the height of a 2-3 tree with N keys is between ~floor(log_3 N) $\approx$ .63 lgN (for a tree that is all 3-nodes) and ~floor(lgN) (for a tree that is all 2-nodes).

 3.3.5 The figure at right shows all the *structurally different* 2-3 trees with N keys, for N from 1 up to 6 (ignore the order of the substrees). Draw all the stucturally different trees for N=7,8,9,and 10.

 3.3.6 Find the probability that each of the 2-3 trees in EXERCISE 3.3.5 is the result of the insertion of N random distinct keys into an initially empty tree.

3.3.7 Draw diagrams like the one at the top of page 428 for the other five cases in the diagram at the bottom of that page.

3.3.8 Show all possible ways that one might represent a 4-node with three 2-nodes bound together with red links (not necessarily left-leaning).

3.3.9 Which of the following are red-black BSTs?

*Solution*: iii and iv only. i is not balanced, ii is not in symmetric order or balanced.

3.3.10 Draw the red-black BST that results when you insert items with the keys E A S Y Q U T I O N in that order into an initilly empty tree.

3.3.11 Draw the red-black BST that results when you insert items with the keys Y L P M X H C R A E S in that order into an initially empty tree.

3.3.12 Draw the red-black BST that results after each transformation (color flip or rotation) during the insertion of P for our standard indexing client.

3.3.13 True or false: If you insert keys in increasing order into a red-black BST, the tree height is monotonically increasing.

*Solution*: True. See the next question.

3.3.14 Draw the red-black BST that results when you insert letters A throught k in order into an initially empty red-black BST. Then, describe what happens in general when red-black BSTs are built by inserting keys in ascending order.

3.3.15 Anser the previous two questions for the case when the keys are inserted in descending order.

*Solution*: false.

3.3.16 Show the result of inserting n into the red-black BST drawn at right (only the search path is shown, and you need to include only these nodes in your answer).

3.3.17 Generate two random 16-node red-black BSTs. Draw them with the (unbalanced) BSTs build with the same keys.

TODO: 

3.3.18 Draw all the structurally different red-black BSTs with N keys, for N from 2 up to 10 (see EXERCISE 3.3.5).

3.3.19 With 1 bit per node for color, we can represent 2-,3-,and 4-nodes. How many bits per node would we need to represent 5-,6-,7-,and 8-nodes with a binary tree?

3.3.20 Compute the internal path length in a perfectly balanced BST of N nodes, when N is a power of 2 minus 1.

*Solution*: Internal path length = \sum_{i=0}^{h} 2^i * i;

3.3.21 Create a test client TestRB.java, based on your solution to EXERCISE 3.2.10.

3.3.22 Find a sequence of keys to insert into a BST and into a red-black BST such that the height of the BST is less than the height of the red-black BST, or prove that no such sequence is possible.

*Answer*: 5 1 10 15 6 0.

3.3.23 *2-3 trees without balance restriction*. Develop an implementation of the basic symbol-table API that uses 2-3 trees that are not necessarily balanced as the underlying data structure. Allow 3-nodes to lean either way. Hook the new node onto the bottom with a black link when inserting into a 3-node at the bottom. Run experiments to develop a hypothesis estimating the average path length in a tree build from N random insertions.

3.3.24 *Worst case for red-black BSTs*. Show how to construct a red-black BST demonstrating that, in the worst case, almost all the paths from the root to a null link in a red-black BST of N nodes are a length 2 lg N.

*Answer*: insert order: root, left, right, left.left, right.left, left.right, right.right....etc.

3.3.25 *Top-down 2-3-4 trees*. Develop an implementation of the basic symbol-table API that uses balanced 2-3-4 trees as the underlying data structure, using the red-black representation and the insertion method described in the text, where 4-nodes are split by flipping colors on the way down the search path and balancing on the way up.

3.3.26 *Single top-down pass*. Develop a modified version of your solution to EXERCISE 3.3.25 that does not use recursion. Complete all the work splitting and balancing 4-nodes (and balanceing 3-nodes) on the way down the tree, finishing with an insertion at the bottom.

TODO:

3.3.27 *Allow right-leaning red links*. Develop a modified version of your solution to EXERCISE 3.3.25 that allows right-leaning red links in the tree.

3.3.28 *Bottom-up 2-3-4 trees*. Develop an implementation of the basic symbol-table API that uses balanced 2-3-4 trees as the underlying data structure, using the red-black representation and a bottom-up insertion method based on the same recursive approach as ALGORITHM 3.4. Your insertion method should split only the sequence of 4-nodes (if any) on the bottom of the search path.

3.3.29 *Optimal storage*. Modify RedBlackBST so that it does not use any extra storage for the color bit, based on the following trick: To color a node red, swap its two links. Then, to test whether a node is red, test whether its left child is larger than its right child. You have to modify the compares to accommodate the possible link swap, and this trick replaces bit compares with key compares that are presumably more expensive, but it shows that the bit in the nodes
can be eliminated, if necessary.

3.3.30 *Software caching*. Modify RedBlackBST to keep the most recently accessed Node in an instance variable so that it can be accessed in constant time if the next put() or get() uses the same key (see EXERCISES 3.1.25).

3.3.31 *Tree drawing*. Add a method draw() to RedBlackBST that draws red-black BST figures in the style of the text (see EXERCISE 3.2.38)

3.3.32 *AVL trees*. An AVL tree is a BST where the height of every node and that of its sibling differ by at most 1. (The oldest balanced tree algorithms are based on using rotations to maintain height balance in AVL trees.) Show that coloring red links that go from nodes of even height to nodes of odd height in an AVL tree gives a (perfectly balanced) 2-3-4 tree, where red links are not necessarilyleft-leaning. *Extra credit*: Develop an implementation of the symbol-table API
that uses this as the underlying data structure. One approach is to keep a height field in each node, using rotations after the recursive calls to adjust the height as necessary; another is to use the red-black representation and use methods like moveRedLeft() and moveRedRight() in EXERCISE 3.3.39 and EXERCISE 3.3.40.

TODO:

3.3.33 **Certification**. Add to RedBlackBST.java a method is23() to check that no node is connected two red links and that there are no right-leaning red links. Add a method isBalanced() to check that all paths from the root to a null link have the same number of black links. Combine these methods with isBST() to create a method isRedBlackBST() that checks that the tree is a BST and that it satisfies these two conditions.

3.3.34 *All 2-3 tree*. Write code to generate all structurally different 2-3 trees of height 2, 3, and 4. There are 2,7,and 122 such trees, respectively. (Hint: Use a symbol table)

TODO:

3.3.35 *2-3 trees*. Write a program TwoThreeST.java that uses two node types to implement 2-3 search trees directly.

TODO:

3.3.36 *2-3-4-5-6-7-8 trees*. Describe algorithms for search and insertion in balanced 2-3-4-5-6-7-8 search trees.

TODO:

3.3.37 *Memoryless*. Show that red-black BSTs are not memoryless: for example, if you insert a key that is smaller than all the keys in the tree and then immediately delete the minimum, you may get a different tree.

*Answer*: 

3.3.38 *Fundamental theorem of rotations*. Show that any BST can be transformed into any other BST on the same set of keys by a sequence of left and right rotation.

*Solution sketch*: rotate the smallest key in the first BST to the root along the leftward spine; then recur with the resulting right subtree until you have a tree of height N (with every left link null). Do the same with the second BST. Remark: it is unknown whether there exists a polynomial-time algorithm for determining the minimum number of rotations needed to transform one BST into the other (even though the rotation distance is at most 2N-6 for BSTs with at least 11
nodes).

3.3.39 **Delete the minimum**. Implement the deleteMin() operation for RedBlackBST.java by maintaining the correspondence with the transformations given in the text for moving down the left spine of the tree while maintaining the invariant that current node is not a 2-node.

3.3.40 **Delete the maximum**. Implement the deleteMax() operation for RedBlackBST.java. Note that the transformations involved differ slightly from those in the previous exercise because red links are left-leaning.

3.3.41. **Delete**. Implement the delete() operation for RedBlackBST.java, combining the methods of the previous two exercises with the delete() operation for BSTs.

##WEB EXERCISES
1. Given a sorted sequence of keys, describe how to construct a red-black BST that contains them in linear time.

2. Supose that you do a search in a red-black BST that terminates unsuccessfully after following 20 links from the root. Fill in the blanks below with the best (integer) bounds that you can infer from this fact about any unsuccessful search
- Must follow at least    links from the root
- Need follow at most     links from the root

3. With 1 bit per node we can represent 2-, 3-, and 4-nodes. How many bits would we need to represent 5-,6-,7-,and 8-nodes.

2 bits

4. **Substring reversing**. Given a string of length N, support the following operations: select(i) = get the ith character, and reverse(i, j) = reverse the substring from i to j.

*Solution sketch*. Maintain the string in a balanced search tree, where each node records the subtree count and a reverse bit (that interchanges the role of the left and right children if there are an odd number of reverse bits on the path from the root to the node). To implement select(i), do a binary search starting at the root, using the subtree counts and reverse bits. To implement reverse(i, j), split the BST at select(i) and select(j) to from three BSTs,
reverse the bit of the middle BST, and join them back together using a join operation. Maintain the subtree counts and reverse bits when rotating.

5. **Memory of a BST**. What is the memory usage of a BST and RedBlackBST and TreeMap?

*Problem*: don't use classmexer.jar

6. **Randomized BST**. Program RandomizedBST.java implements a randomized BST, including deletion. Expected O(log N) performance per operations. Expectation depends only on the randomness in the algorithm, it does not depend on the input distribution. Must store subtree count field in each node; generates O(log N) random numbers per insert.

*Proposition*: Tree has same distribution as if the keys were inserted in random order.


7. **Join**. Write a function that takes two randomized BSTs as input and returns a third randomized BST which contains the union of the elements in the two BSTs. Assume no duplicates.

8. **Splay BST**. Program SplayBST.java implements a splay tree.

9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.
9. Randomized queue. Implement a RandomizedQueue.java so that all operations take logarithmic time in the worst case.

10. **Red-black** BST with many updates. When performing a put() with a key that is already in a red-black BST, our RedBlackBST.java performs many unnecessary calls to isRed() and size(). Optimize the code so that these calls are skipped in such situations.









