import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Multiway {
    public static void merge(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        StdOut.println("N="+N);

        for (int i = 0; i < N; i++){
            if (!streams[i].isEmpty()){
                //StdOut.printf("i=%d,item=%s\n", i, streams[i].readString());
                pq.insert(i, streams[i].readString());
            }
        }
        StdOut.println();
        while (!pq.isEmpty()) {
            StdOut.println(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty()){
                //StdOut.printf("i=%d,item=%s\n", i, streams[i].readString());
                pq.insert(i, streams[i].readString());
            }
        }

    }
    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}
