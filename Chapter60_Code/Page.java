import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.SET;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Page<Key extends Comparable<Key>> implements PageInterface<Key> {
    private class PageValue {
        private PageInterface<Key> childPage;
        PageValue(PageInterface<Key> childPage){
            this.childPage = childPage;
        }
    }
    private BinarySearchST<Key, PageValue> biSearchST;
    private boolean isOpen;
    private boolean isExternal;
    private boolean verbose;

    // Reference to pages in memory on the system
    private SET<PageInterface> pagesInMemory;
    private int maxNumberOfNodes;

    Page(boolean bottom, int maxNumberOfNodes, SET<PageInterface> pagesInMemory) {
        if (maxNumberOfNodes % 2 != 0 || maxNumberOfNodes == 2){
            throw new IllegalArgumentException("Max number of nodes must be divisible by 2 and higher than 2");
        }
        biSearchST = new BinarySearchST<>();
        this.pagesInMemory = pagesInMemory;
        this.maxNumberOfNodes = maxNumberOfNodes;
        isExternal = bottom;
        verbose = true;
        open();
    }
    
    Page(boolean bottom) {
        if (maxNumberOfNodes % 2 != 0 || maxNumberOfNodes == 2){
            throw new IllegalArgumentException("Max number of nodes must be divisible by 2 and higher than 2");
        }
        biSearchST = new BinarySearchST<>();
        this.pagesInMemory = new SET<>();
        this.maxNumberOfNodes = 1000;
        isExternal = bottom;
        verbose = true;
        open();
    }
    private void open(){
        pagesInMemory.add(this);
        isOpen = true;
    }
    @Override
    public void close(){
        StringJoiner pageContent = new StringJoiner(" ");

        for (Key key : keys()){
            pageContent.add(String.valueOf(key));
        }

        if (verbose){
            StdOut.println("Page content: " + pageContent.toString());

        }
        pagesInMemory.delete(this);
        isOpen = false;
    }

    @Override
    public PageInterface<Key> getPage(Key key){
        PageValue pageValue = biSearchST.get(key);

        if (pageValue != null){
            return pageValue.childPage;
        } else {
            return null;
        }
    }

    @Override
    public void add(Key key){
        if (!isExternal()){
            throw new IllegalArgumentException("Cannot add key directly to an internal page");
        }

        // External pages do not point to any page
        biSearchST.put(key, new PageValue(null));
    }
    @Override
    public void add(PageInterface<Key> page){
        Key minKey = ((Page<Key>) page).biSearchST.min();
        biSearchST.put(minKey, new PageValue(page));
    }

    @Override
    public boolean isExternal(){
        return isExternal;
    }
    @Override
    public boolean contains(Key key){
        if (!isExternal()){
            throw new IllegalArgumentException("Cannot check contains directly on an internal page");
        }
        return biSearchST.contains(key);
    }
    @Override
    public PageInterface<Key> next(Key key){
        if (!isExternal()){
            throw new IllegalArgumentException("Cannot check contains directly on an external page");
        }
        Key nextKey = biSearchST.floor(key);
        if (nextKey == null)
            return null;
        return biSearchST.get(nextKey).childPage;

    }

    @Override
    public boolean isFull(){
        return biSearchST.size() == maxNumberOfNodes;
    }

    @Override
    public PageInterface<Key> split(){
        List<Key> keysToMove = new ArrayList<>();
        int middleRank = biSearchST.size() / 2;

        for (int index = middleRank; index < biSearchST.size(); index++){
            Key keyToMove = biSearchST.select(index);
            keysToMove.add(keyToMove);
        }
        PageInterface<Key> newPage = new Page<>(isExternal, maxNumberOfNodes, pagesInMemory);

        for (Key key : keysToMove){
            PageInterface<Key> pageLink = biSearchST.get(key).childPage;
            biSearchST.delete(key);

            if (!isExternal()){
                newPage.add(pageLink);
            } else {
                newPage.add(key);
            }
        }
        return newPage;
    }

    @Override
    public Iterable<Key> keys(){
        return biSearchST.keys();
    }

    @Override
    public int getMaxNumberOfNodes(){
        return maxNumberOfNodes;
    }
    @Override
    public void setVerbose(boolean verbose){
        this.verbose = verbose;
    }


}
