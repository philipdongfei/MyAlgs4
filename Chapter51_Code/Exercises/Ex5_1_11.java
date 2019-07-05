import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Arrays;
import java.util.StringJoiner;

public class Ex5_1_11 {
    // O(N^2), but runs in O(N) if items are uniformly distributed in the buckets

    public class BucketSort {
        private int alphabetSize = 256; // 
        private Queue<String>[] buckets;

        public void bucketSort(String[] strings){
            buckets = new Queue[alphabetSize+1];
            for (int b = 0; b < buckets.length; b++)
                buckets[b] = new Queue();

            // put strings in bins
            for (int i = 0; i < strings.length; i++){
                int leadingDigitIndex = strings[i].charAt(0);
                buckets[leadingDigitIndex].enqueue(strings[i]);
            }
            // sort the sublists
            for (int b = 0; b < buckets.length; b++){
                if (!buckets[b].isEmpty()){
                    sortBucket(buckets[b]);
                }
            }
            // stitch together all the buckets
            int arrayIndex = 0;

            for (int r = 0; r <= alphabetSize; r++){
                while (!buckets[r].isEmpty()){
                    String currentStr = buckets[r].dequeue();
                    strings[arrayIndex++] = currentStr;
                }
            }

        }
        private void sortBucket(Queue<String> bucket){
            String[] strings = new String[bucket.size()];
            int arrayIndex = 0;

            while (!bucket.isEmpty()){
                strings[arrayIndex++] = bucket.dequeue();

            }
            Insertion.sort(strings);
            for (String s : strings){
                bucket.enqueue(s);
            }
        }

    }
    public static void main(String[] args){
        BucketSort sort = new Ex5_1_11().new BucketSort();

        String[] a = StdIn.readAllStrings();
        StringJoiner sortedArray1 = new StringJoiner(" ");
        for (String s : a){
            sortedArray1.add(s);
        }
        StdOut.println(sortedArray1);
        StdOut.println();
        sort.bucketSort(a);
        StdOut.println("sort: ");
        StringJoiner sortedArray = new StringJoiner(" ");
        for (String s : a){
            sortedArray.add(s);
        }
        StdOut.println(sortedArray);
        StdOut.println();
    }

}
