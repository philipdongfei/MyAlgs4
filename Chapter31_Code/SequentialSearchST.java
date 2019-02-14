import edu.princeton.cs.algs4.Queue;


public class SequentialSearchST<Key, Value>
{
    private Node first;    // first node in the linked list
    private int n;

    private class Node
    {// linked-list node
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public Value get(Key key)
    {// Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;    //search hit
        return null;             // search miss
    }
    public void put(Key key, Value val)
    {// Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
            { x.val = val; return; }    // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
    }
    boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    void delete(Key key) {
        put(key, null);
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}

