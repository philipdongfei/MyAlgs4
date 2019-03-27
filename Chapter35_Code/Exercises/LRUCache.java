import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class LRUCache<Item>
{
    private DoubleList<Item> DoubleLinkedList;
    private SeparateChainingHashST<Item, DoubleNode<Item>> st;

    public LRUCache(){
        DoubleLinkedList = new DoubleList<>();
        st = new SeparateChainingHashST<>();
    }
    public int size(){
        return DoubleLinkedList.size();
    }
    public void access(Item item){
        if (st.contains(item)){
            StdOut.println("st contain " + item);
            DoubleNode itemNode = st.get(item);
            if (item != null)
            StdOut.println("itemNode not null");
            else
            StdOut.println("itemNode is not null");

            DoubleLinkedList.removeNode(itemNode);

        }
        DoubleNode newNode = DoubleLinkedList.insertFirstAndreturnNode(item);
        st.put(item, newNode);
        
    }

    public Item remove(){
        Item removeItem = DoubleLinkedList.removeLast();
        StdOut.println("remove doublelist last "+removeItem);
        if (removeItem != null)
            st.delete(removeItem);
        return removeItem;
    }
    public static void main(String[] args){
        LRUCache<Integer> lrcCache = new LRUCache<>();

        lrcCache.access(1);
        lrcCache.access(2);
        lrcCache.access(3);
        lrcCache.access(4);
        lrcCache.access(5);
        lrcCache.access(7);
        lrcCache.access(8);

        StdOut.println("size: " + lrcCache.size());
        StdOut.println("remove: " + lrcCache.remove());
        StdOut.println("remove: " + lrcCache.remove());

        StdOut.println("access 3");
        lrcCache.access(3);
        StdOut.println("remove: " + lrcCache.remove());
        StdOut.println("size: " + lrcCache.size());


    }
}

