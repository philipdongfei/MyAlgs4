import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SET;
import java.util.Arrays;


public class SetIntersectionAndUnion{
    public static SET<String> Intersection(SET<String> a, SET<String> b)
    {
        SET<String> c = new SET<>();
        for(String word : a)
        {
            if (b.contains(word))
                c.add(word);
        }
        return c;
    }
    public static SET<String> Union(SET<String> a, SET<String> b)
    {
        SET<String> c = new SET<>(a);
        
        for (String word : a)
        {
            if (!b.contains(word))
                c.add(word);
        }
        return c;
    }
    public static void main(String[] args)
    {
        SET<String> a = new SET<String>();
        SET<String> b = new SET<String>(), c;
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        b.add("c");
        b.add("d");
        b.add("e");
        b.add("f");
        c = Intersection(a,b);
        StdOut.println("Intersection:");
        for(String w : c)
            StdOut.println(w + " ");
        StdOut.println();
        c = Union(a,b);
        StdOut.println("Union:");
        for(String w : c)
            StdOut.println(w + " ");
        StdOut.println();

    }
}
