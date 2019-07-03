import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

@SuppressWarnings("unchecked")
public class Ex5_1_7 {
    public void keyIndexedCountingWithQueue(String[] array, int len){
        StdOut.println("array len: " + array.length + ", len=" + len);
        int alphabetSize = 256;

        Queue<String> auxQueue = new Queue<>();
        Queue<String> count[] = new Queue[alphabetSize + 1];
        for (int r = 0; r < count.length; r++)
            count[r] = new Queue();
        for (int digit = len-1; digit >= 0; digit--){
            // compute frequency counts
            for (int i = 0; i < array.length; i++){
                int digitIndex = array[i].charAt(digit);
                count[digitIndex].enqueue(array[i]);
            }
            //Distribute
            for (int r = 0; r < count.length; r++){
                while (!count[r].isEmpty()){
                    String string = count[r].dequeue();
                    auxQueue.enqueue(string);
                }
            }
            // Copy back
            int indexArray = 0;
            while (!auxQueue.isEmpty()){
                array[indexArray++] = auxQueue.dequeue();
            }
        }
    }
    public static void main(String[] args){
        Ex5_1_7 ex7 = new Ex5_1_7();
        String[] a = StdIn.readAllStrings();

        ex7.keyIndexedCountingWithQueue(a, a[0].length());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        
    }
}
