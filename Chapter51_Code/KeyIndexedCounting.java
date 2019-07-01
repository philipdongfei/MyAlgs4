/********
 * java KeyIndexedCounting KeyIndexed.txt " +"
 *
 *****/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class KeyIndexedCounting {
    public static class Item {
        private final String NEWLINE = System.getProperty("line.separator");
        private String name;
        private int key;
        Item(String name, int key){
            this.name = name;
            this.key = key;
        }
        public int key(){
            return key;
        }
        public String toString(){
            StringBuilder s = new StringBuilder();
            s.append(name + "    " + key );
            return s.toString();
        }
    }
    public static void main(String[] args){
        String filename = args[0];
        String delim = args[1];
        In in = new In(filename);
        int N = in.readInt();
        StdOut.println("N: " + N);
        int R = in.readInt();
        StdOut.println("R: " + R);
        Item[] item = new Item[N];
        int index = 0;

        while (in.hasNextLine())
        {
            String Line = in.readLine();
            if (Line.isEmpty())
                continue;
            String[] a = Line.split(delim);
        //    StdOut.println(a[0]);
        //    StdOut.println(a[1]);
            String name = a[0];
            int key = Integer.parseInt(a[1]);
        //    StdOut.println("index: " + index);
            item[index++] = new Item(name, key);
        }

        Item[] aux = new Item[N];
        int[] count = new int[R+1];

        // Compute frequency counts
        for (int i = 0; i < N; i++)
            count[item[i].key()+1]++;
        // Transform counts to indices.
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];
        // Distribute the records
        for (int i = 0; i < N; i++)
            aux[count[item[i].key()]++] = item[i];
        // Copy back.
        for (int i = 0; i < N; i++)
        {
            item[i] = aux[i];

        }
        StdOut.println("sort: ");
        for (int i = 0; i < N; i++)
            StdOut.println(item[i]);
        StdOut.println();


    }
}
