import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Font;

public class SortTransactions {
    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new Queue<Transaction>();
        while (StdIn.hasNextLine()){
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            queue.enqueue(transaction);
        }

        int n = queue.size();
        Transaction[] transactions = new Transaction[n];
        for (int i = 0; i < n; i++)
            transactions[i] = queue.dequeue();
        return transactions;
    }
    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        Arrays.sort(transactions);
        for (int i = 0; i < transactions.length; i++)
            StdOut.println(transactions[i]);
    }
}
