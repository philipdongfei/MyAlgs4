import java.util.Arrays;
import java.util.Queue;
import java.util.Comparator;

public class Processor implements Comparable<Processor> {
    //private Queue<Job> jobs;
    private double totaltime;
    private String name;
    
    public Processor() {
        this.totaltime = 0.0;
        this.name = "";
    }
    public void add(Job j) {
        //jobs.enqueue(j);
        this.totaltime += j.Time();
        name += j.Name();
        name += ",";
    }
    public double getTime() {
        return totaltime;
    }
    public int compareTo(Processor that) {
        return Double.compare(this.totaltime, that.totaltime);
    }
    @Override
    public String toString() {
        return String.format("%s: %-8.2f", name, totaltime);
    }

}

