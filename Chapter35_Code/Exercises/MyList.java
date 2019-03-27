import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;


public class MyList<Item> implements Iterable<Item>
{
    private SequentialSearchST<Item, Integer> PosST;
    private RedBlackBST<Integer, Item> ItemST;
    private final Integer INITIAL_POS = 0;
    private final Integer OFFSET = 1;

    MyList(){
        PosST = new SequentialSearchST<>();
        ItemST = new RedBlackBST<>();
    }
    // add item to the front.
    public void addFront(Item item)
    {
        if (item == null)
            return;
        if (contains(item))
            delete(item);

        Integer front;
        if (isEmpty())
            front = INITIAL_POS;
        else
            front = ItemST.min() - OFFSET;
        PosST.put(item, front);
        ItemST.put(front, item);

    }
    // add item to the back.
    public void addBack(Item item)
    {
        if (item == null)
            return;
        if (contains(item))
            delete(item);

        Integer back;
        if (isEmpty())
            back = INITIAL_POS;
        else
            back = ItemST.max() + OFFSET;
        PosST.put(item, back);
        ItemST.put(back, item);
    }
    // remove from the front
    public Item deleteFront()
    {
        if (isEmpty())
            return null;
        Integer front = ItemST.min();
        Item frontItem = ItemST.get(front);
        PosST.delete(frontItem);
        ItemST.deleteMin();
        return frontItem;

    }
    // remove from the back
    public Item deleteBack()
    {
        if (isEmpty())
            return null;
        Integer back = ItemST.max();
        Item BackItem = ItemST.get(back);
        PosST.delete(BackItem);
        ItemST.deleteMax();
        return BackItem;
    }
    // remove item from the list
    public void delete(Item item)
    {
        Integer pos = PosST.get(item);
        PosST.delete(item);
        ItemST.delete(pos);

    }
    // add item as the ith in the list
    public void add(int i, Item item)
    {
        if (item == null){
            PosST.delete(ItemST.get(i));
            ItemST.delete(i);
            return;
        }
        PosST.put(item, i);
        ItemST.put(i, item);
        
    }
    // remove the ith item from the list.
    public Item delete(int i)
    {
        Item delItem = ItemST.get(i);
        PosST.delete(delItem);
        ItemST.delete(i);
        return delItem;
        
    }
    // is key in the list?
    public boolean contains(Item item)
    {
        return PosST.contains(item);

    }
    // is the list empty
    public boolean isEmpty()
    {
        return size() == 0;

    }
    // number of items in the list
    public int size()
    {
        return ItemST.size(); 
    }


    public Iterator<Item> iterator(){
        return new MyListIterator();
    }
    private class MyListIterator implements Iterator<Item>
    {
        Queue<Integer> posqueue;
        MyListIterator()
        {
            posqueue = new Queue<>();
            for (Integer p : ItemST.keys() )
                posqueue.enqueue(p);

        }
        
        public boolean hasNext()
        { return isEmpty() != true; }
        public void remove() {}
        public Item next()
        {
            Integer p = posqueue.dequeue();
            return ItemST.get(p);
        }

    }
}
