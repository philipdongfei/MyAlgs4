import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

public class Ex13_HybridTST {
    @SuppressWarnings("unchecked")
    public class HybridTernarySearchTrie<Value> {
        private static final int R = 256;
        private int size;
        private TST<Value>[][] TSTs;
        private static final int NULL_CHAR_INDEX = R;

        public HybridTernarySearchTrie(){
            // Columns have size R+1 because there may be keys of length 1, which are equivalent to 
            // row = character1, column = R
            TSTs = new TST[R][R+1];
            for (int tst1 = 0; tst1 < R; tst1++){
                for (int tst2 = 0; tst2 <= R; tst2++){
                    TSTs[tst1][tst2] = new TST<>();
                }
            }
        }
        private TST<Value> getTernarySearchTrie(String key){
            TST<Value> tst;
            char character1 = key.charAt(0);
            if (key.length() == 1){
                tst = TSTs[character1][NULL_CHAR_INDEX];
            } else {
                char character2 = key.charAt(1);
                tst = TSTs[character1][character2];
            }
            return tst;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size() == 0;
        }

        public boolean contains(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            return get(key) != null;
        }
        public Value get(String key){
            if (key == null){
                throw new IllegalArgumentException("Key cannot be null");
            }
            if (key.length() == 0){
                throw new IllegalArgumentException("Key must have a positive length");
            }
            TST<Value> tst = getTernarySearchTrie(key);
            return tst.get(key);
        }
        public void put(String key, Value value){
            if (key == null){
                throw new IllegalArgumentException("key cannot be null");
            }
            if (value == null){
                delete(key);
                return;
            }
            if (!contains(key)){
                size++;
            }
            TST<Value> tst = getTernarySearchTrie(key);
            tst.put(key, value);
        }
        public void delete(String key){
            if (key == null){
                throw new IllegalArgumentException("key cannot be null");

            }
            if (!contains(key)){
                return;
            }
            TST<Value> tst = getTernarySearchTrie(key);
            tst.delete(key);
            size--;
        }
        public Iterable<String> keys(){
            Queue<String> keys = new Queue<>();
            for (char tst1 = 0; tst1 < R; tst1++){
                // First add key of size 1
                getAllKeysInTST(tst1, NULL_CHAR_INDEX, keys);
                for (char tst2 = 0; tst2 < R; tst2++){
                    getAllKeysInTST(tst1, tst2, keys);
                }
            }
            return keys;
        }
        private void getAllKeysInTST(int index1, int index2, Queue<String> keys){
            if (TSTs[index1][index2].size() > 0){
                for (String key : TSTs[index1][index2].keys()){
                    keys.enqueue(key);
                }
            }
        }
    }
    public static void main(String[] args){
        HybridTernarySearchTrie<Integer> hybridTST = 
            new Ex13_HybridTST().new HybridTernarySearchTrie<>();

        StdOut.println("size: " + hybridTST.size());

        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            hybridTST.put(key, i);
        }
        StdOut.println("size: " + hybridTST.size());
        StdOut.println("\nGet Re: " + hybridTST.get("Re"));   
        StdOut.println("Expected: 10");
        StdOut.println("Get Algorithms: " + hybridTST.get("Algorithms"));
        StdOut.println("Expected: 2");
        StdOut.println("Get Trie123: " + hybridTST.get("Trie123"));
        StdOut.println("Expected: 8");
        StdOut.println("Get Algori: " + hybridTST.get("Algori"));
        StdOut.println("Expected: null");
        StdOut.println("Get Zooom: " + hybridTST.get("Zooom"));
        StdOut.println("Expected: null");


    }
}
