

public class LinkedMinPQ<Key extends Comparable<Key>> {
    private class Node {
        int N;
        Key data;
        Node parent, left, right;
        public Node(Key data, int N){
            this.data = data;
            this.N = N;
        }
    }
    private Node root;
    private Node lastInserted;

    public int size(Node x){
        if (x == null) return 0;
        return x.N;
    }
    private void swim(Node x) {
        if (x == null) return;
        if (x.parent == null) return; // root.
        if (less(x.data, x.parent.data)) {
            swapNodeData(x, x.parent);
            swim(x.parent);
        }
    }
    private void sink(Node x) {
        if (x == null) return;
        Node swapNode;
        if (x.left == null && x.right == null) 
            return;
        else if (x.left == null) {
            swapNode = x.right;
            if (greater(x.data, swapNode.data))
                swapNodeData(swapNode, x);
        } else if (x.right == null) {
            swapNode = x.left;
            if (greater(x.data, swapNode.data))
                swapNodeData(swapNode, x);
        } else {
            if (greater(x.left.data, x.right.data))
                swapNode = x.right;
            else
                swapNode = x.left;
            if (greater(x.data, swapNode.data)){
                swapNodeData(swapNode, x);
                sink(swapNode);
            }
        }
    }
    private void swapNodeData(Node x, Node y) {
        Key temp = x.data;
        x.data = y.data;
        y.data = temp;
    }
    private Node insert(Node x, Key data) {
        if (x == null){
            lastInserted = new Node(data, 1);
            return lastInserted;
        }
        // compare left and right sizes see where to go.
        int leftsize = size(x.left);
        int rightsize = size(x.right);

        if (leftsize <= rightsize) {
            // go to left.
            Node inserted = insert(x.left, data);
            x.left = inserted;
            inserted.parent = x;
        } else {
            // go to right.
            Node inserted = insert(x.right, data);
            x.right = inserted;
            inserted.parent = x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node resetLastInserted(Node x) {
        if (x == null) return null;
        if (x.left == null && x.right == null) return x;
        if (size(x.right) < size(x.left)) return resetLastInserted(x.left);
        else    return resetLastInserted(x.right);
    }

    public void insert(Key data) {
        root = insert(root, data);
        swim(lastInserted);
    }
    public Key max() {
        if (root == null) return null;
        return root.data;
    }
    public Key delMin() {
        if (size() == 1) {
            Key ret = root.data;
            root = null;
            return ret;
        }
        swapNodeData(root, lastInserted);
        Node lastInsParent = lastInserted.parent;
        Key lastInsData = lastInserted.data;
        if (lastInserted == lastInsParent.left)
            lastInsParent.left = null;
        else
            lastInsParent.right = null;
        Node traverser = lastInserted;
        while (traverser != null){
            traverser.N--;
            traverser = traverser.parent;
        }
        lastInserted = resetLastInserted(root);
        sink(root);
        return lastInsData;
    }
    public int size() {
        return size(root);
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
}
