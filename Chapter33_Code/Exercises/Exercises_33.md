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




