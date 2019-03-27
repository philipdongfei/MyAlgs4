import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.LinearProbingHashST;


public class STWithRandomAccess<Key, Value>{
    private LinearProbingHashST<Key, Value> st;
    private RandomQueue<Key> rdmqueue;

    STWithRandomAccess(){
        st = new LinearProbingHashST<>();
        rdmqueue = new RandomQueue<>();
    }
    public void insert(Key key, Value val){
        st.put(key, val);
        rdmqueue.enqueue(key);
    }
    public Value get(Key key){
        return st.get(key);
    }
    public Key deleteRandomKey(){
        if (st.isEmpty())
            throw new RuntimeException("Empty st");
        Key random = rdmqueue.sample();
        st.delete(random);
        return random;
    }
    public static void main(String[] args){
        STWithRandomAccess<Integer, Integer> st = 
            new STWithRandomAccess<>();
        st.insert(1,1);
        st.insert(2,2);
        st.insert(3,3);
        st.insert(4,4);
        st.insert(7,7);
        st.insert(8,8);
        st.insert(5,5);

        StdOut.println("Get 4 " + st.get(4));
        StdOut.println("random key: " + st.deleteRandomKey());
        StdOut.println("random key: " + st.deleteRandomKey());
    }
}
