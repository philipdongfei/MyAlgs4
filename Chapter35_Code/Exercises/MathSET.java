import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SET;
import java.util.Arrays;


public class MathSET<Key extends Comparable<Key>>
{
    private SET<Key> st;
    private SET<Key> universest;

    Key[] universe;

    MathSET(Key[] universe){
        this.universe = universe;
        st = new SET<Key>();
        universest = new SET<Key>();
        for (Key key : universe)
            this.universest.add(key);
    }

    public void add(Key key){
        st.add(key);

    }

    public MathSET<Key> complement()
    {
        MathSET<Key> complement = new MathSET<>(this.universe);

        for (Key key : this.universe){
            if (!st.contains(key))
                complement.add(key);
        }
        return complement;
    }

    public void union(MathSET<Key> a)
    {
        for (Key key : a.st){
            if (!contains(key))
                add(key);
        }

    }
    public void intersection(MathSET<Key> a)
    {
        for (Key key : st)
        {
            if (!a.contains(key))
                delete(key);

        }

    }
    public void delete(Key key)
    {
        if (key == null) throw new IllegalArgumentException(
                "key cann't be null"
                );
        st.delete(key);

    }
    public boolean contains(Key key)
    {
        return st.contains(key);

    }
    public boolean isEmpty()
    {
        return st.isEmpty();

    }
    public int size()
    {
        return st.size();

    }
    @Override
    public String toString()
    {
        return st.toString();

    }
    public static void main(String[] args){
        Integer[] universe = {0,1,2,3,4,5,6,7,8,9};
        MathSET<Integer> mathset = new MathSET<>(universe);

        mathset.add(0);
        mathset.add(2);
        mathset.add(4);
        mathset.add(6);

        StdOut.println("Keys in mathset:");
        StdOut.println(mathset);
        StdOut.println("Expected: {0,2,4,6}");

        StdOut.println("Size: " + mathset.size());
        StdOut.println("isEmpty: " + mathset.isEmpty());
        StdOut.println("Contains 4: " + mathset.contains(4));
        StdOut.println("Contains 9: " + mathset.contains(9));

        StdOut.println("Delete 6");
        mathset.delete(6);
        StdOut.println(mathset);

        MathSET<Integer> mathsetUnion = new MathSET<Integer>(universe);
        mathsetUnion.add(6);
        mathsetUnion.add(8);
        mathsetUnion.add(9);

        mathset.union(mathsetUnion);

        StdOut.println("Union with {6,8,9}");
        StdOut.println(mathset);

        MathSET<Integer> complement = mathset.complement();
        StdOut.println("Complement:");
        StdOut.println(complement);


    }

}
