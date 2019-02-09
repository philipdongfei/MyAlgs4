import java.util.Arrays;
import java.util.Comparator;

public class Job implements Comparable<Job> {
    private final String name;
    private final double time;

    public Job(String name, double time) {
        if (Double.isNaN(time) || Double.isInfinite(time))
            throw new IllegalArgumentException("Time cannot be NaN or infinite");
        this.name = name;
        this.time = time;
    }
    public String Name() {
        return name;
    }
    public double Time() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%-10s     %8.2f", name, time);
    }

    public int compareTo(Job that) {
        return Double.compare(this.time, that.time);
    }
}
