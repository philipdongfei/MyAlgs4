import edu.princeton.cs.algs4.Queue;

public class SequentialSearchMultiST<Key extends Comparable<Key> , Value>
{
    private Node first;    // first node in the linked list
    private int n;
    private int Compares_N = 0;

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
    public int getCompares(){
        return Compares_N;
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
        {
            Compares_N++;
            if (key.equals(x.key))
                return x.val;    //search hit
        }
        return null;             // search miss
    }
    public Iterable<Value> getAll(Key key){
        Queue<Value> queue = new Queue<>();

        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
                queue.enqueue(x.val);
        }
        return queue;
    }
    public void put(Key key, Value val)
    {// Search for key. Update value if found; grow table if new.
        
        if (val == null) { //delete key
            for (Node x = first; x != null; x = x.next)
            {
                Compares_N++;
                if (key.equals(x.key))
                { 
                    x.val = val;
                    n--;
                }    // Search hit: update val.
            }
            return;
        }
        first = new Node(key, val, first); // Search miss: add new node.
        n++;
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
        {
            if (x.val != null)
                queue.enqueue(x.key);

        }
        return queue;
    }
}
