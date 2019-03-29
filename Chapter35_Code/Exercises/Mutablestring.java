import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BST;


public class Mutablestring {
    private BST<Double, Character> bst;

    public Mutablestring(){
        bst = new BST<>();
    }
    public int size(){
        return bst.size();
    }
    public boolean isEmpty(){
        return bst.size() == 0;
    }
    public char get(int i){
        if (i < 0 || i >= bst.size())
            throw new IllegalArgumentException("Illegal Argument");
        return bst.get((double)i); 
    }
    public void insert(int i, char c){
        if (i < 0)
            throw new IllegalArgumentException("Illegal Argument");
        double pos = (Double)((double)i-1+(double)i)/2;
        bst.put((double)pos, c);

    }
    public void delete(int i){
        if (i < 0)
            throw new IllegalArgumentException("Illegal Argument");
        bst.delete((double)i);
    }
    public static void main(String[] args){
        Mutablestring mstr = new Mutablestring();
        mstr.insert(0, 't');
        mstr.insert(1, 'h');
        mstr.insert(2, 'e');
        mstr.insert(3, 's');
        mstr.insert(4, 'e');
        StdOut.println("get 2: " + mstr.get(2));
        StdOut.println();
        mstr.delete(2);
        for (int i = 0; i < mstr.size(); i++)
            StdOut.println(mstr.get(i));

    }

}
