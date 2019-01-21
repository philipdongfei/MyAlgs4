

public class Max_MinPQ {
    private MaxPQ maxpq;
    private MinPQ minpq;

    public Max_MinPQ(int maxN) {
        maxpq = new MaxPQ(maxN);
        minpq = new MinPQ(maxN);
    }

}
