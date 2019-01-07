import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

public class Ex2_2_17 {
    public static class Node{
        Comparable val;
        Node next;
        Node(Comparable x) {val = x;}
    }
    public static class MergeBUN_List{
        private static int access;
        private static Comparable[] aux;   // auxiliary array for merges
        public static int getAccess(){
            return access;
        }
        private static Node getMin(Node a){
            Comparable minVal = a.val;
            Node current = a;
            Node minNode = null;
            while (current.next != null){
                if (less(current.next.val, minVal)) {
                    minNode = current;
                    minVal = current.next.val;
                }
                current = current.next;
            }
            if (minNode == null) return a;
            // Node with min value is minNode.next
            Node tmp = minNode.next.next;
            Node actualMinNode = minNode.next;
            actualMinNode.next = a;
            minNode.next = tmp;
            return actualMinNode;
        }
        public static Node sort(Node a) {
            // Get minimum node
            a = getMin(a);
            Node root = a;
            while (true) {
                Node lo = root.next;
                Node mid = lo;
                while (mid.next != null && !less(mid.next.val, mid.val)){
                    mid = mid.next;
                }
                if (mid.next == null) {
                    if (root == a) return a; //sorted
                    root = a;
                    continue;
                }
                Node hi = mid.next;
                while (hi.next != null && !less(hi.next.val, hi.val)) {
                    hi = hi.next;
                }
                merge(root, lo, mid, hi);
                if (hi.next == null) {
                    if (root == a) return a; //sorted
                    root = a;
                }else {
                    root = hi;
                }
            }
        }

    
        public static void merge(Node root, Node lo, Node mid, Node hi){
            Node curLeft = lo;
            Node curRight = mid.next;
            Node curRoot = root;
            Node stopLeft = mid.next;
            Node stopRight = hi.next;
            while (curLeft != stopLeft || curRight != stopRight) {
                if (curLeft == stopLeft) {
                    curRoot.next = curRight;
                    curRight = curRight.next;
                }else if (curRight == stopRight) {
                    curRoot.next = curLeft;
                    curLeft = curLeft.next;
                }else if (less(curLeft.val, curRight.val)) {
                    curRoot.next = curLeft;
                    curLeft = curLeft.next;
                } else {
                    curRoot.next = curRight;
                    curRight = curRight.next;
                }
                curRoot = curRoot.next;
            }
            curRoot.next = stopRight;
        }
        
        private static boolean less(Comparable v, Comparable w){
            return v.compareTo(w) < 0;
        }
        private static void show(Node first) {
            // Print the array, on a single line.
            Node item = first;
            while (item != null) {
                StdOut.print(item.val + " ");
                item = item.next;
            }
            StdOut.println();
        }
        public static boolean isSorted(Node a){
            // Test whether the array entries are in order.
            while (a.next != null){
                if (less(a.next.val, a.val)) return false;
                a = a.next;
            }
            return true;
        }
    }
        public static void main(String[] args) {
            // Read strings from standard input, sort them, and print.
            String[] a = StdIn.readAllStrings();
            Node first = null, oldfirst;
            for (int i = 0; i < a.length; i++) {
                oldfirst = first;
                first = new Node(a[i]);
                first.next = oldfirst;

            }
            MergeBUN_List.show(first);
            MergeBUN_List.sort(first);
            assert MergeBUN_List.isSorted(first);
            MergeBUN_List.show(first);
        }
}
