

public class Ex2_4_18{

    public static void main(String[] args) {
        int n = 20;
        MaxPQ<Integer> pq = new MaxPQ<Integer>(n);
        for (int i = 16; i >= 0; i--)
            pq.insert(i);
        pq.show();
        pq.insert(17);
        pq.show();
        pq.delMax();
        pq.show();

        pq.insert(18);
        pq.insert(19);
        pq.show();
        pq.delMax();
        pq.delMax();
        pq.show();
    }
}
