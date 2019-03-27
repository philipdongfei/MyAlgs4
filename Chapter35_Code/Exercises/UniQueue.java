import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;
import java.util.HashSet;


public class UniQueue<Item> {
    private Queue<Item> queue;
    private HashSet<Item> existSet;

    UniQueue(){
        queue = new Queue<>();
        existSet = new HashSet<>();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public int size(){
        return queue.size();
    }
    public void enqueue(Item item){
        if (existSet.contains(item))
            return;
        queue.enqueue(item);
        existSet.add(item);
    }
    public Item dequeue(){
        Item item = queue.dequeue();
        existSet.remove(item);
        return item;
    }
    /*
    public Iterable<Item> iterator(){
        return queue.iterator();
    }
    */
}

