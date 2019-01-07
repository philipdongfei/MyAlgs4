import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class MergeList {
    Node head = null;
    static class Node{
        Comparable val;
        Node next;
        Node(Comparable val) {
            this.val = val;
        }
    }
    Node sortedMerge(Node a, Node b){
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (less(a.val, b.val)){
            result = a;
            result.next = sortedMerge(a.next, b);
        }else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    Node mergeSort(Node h){
        // Base case: if head is null.
        if (h == null || h.next == null)
            return h;

        // get the middle of the list.
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        // set the next of middle node to null.
        middle.next = null;
        //Apply mergeSort on left list.
        Node left = mergeSort(h);

        // Apply mergeSort on right list.
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists.
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    // Utility function to get the middle of linked list.
    Node getMiddle(Node h){
        // base case 
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node.
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;

    }
    void push(Comparable new_data) {
        Node new_node = new Node(new_data);

        // link the old list off the new node
        new_node.next = head;
        // move the head to point to the new node.
        head = new_node;
    }
    // Utility function to print the linked list
    void printList(Node headref) {
        while (headref != null) {
            StdOut.print(headref.val + " ");
            headref = headref.next;
        }
        StdOut.println();
    }
        public static void main(String[] args) {
            // Read strings from standard input, sort them, and print.
            String[] a = StdIn.readAllStrings();
            MergeList ml = new MergeList();
            for (int i = 0; i < a.length; i++) {
                ml.push(a[i]);

            }
            ml.printList(ml.head);
            ml.head = ml.mergeSort(ml.head);
            ml.printList(ml.head);
        }
}
