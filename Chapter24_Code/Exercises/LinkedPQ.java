

public class LinkedPQ<Key extends Comparable<Key>> {
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

}
