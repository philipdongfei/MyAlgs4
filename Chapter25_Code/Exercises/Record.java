import java.util.Arrays;
import java.util.Comparator;

public class Record implements Comparable<Record> {
    private final String word;
    private final Integer freq;

    public Record(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return String.format("%-10s %5d", word, freq);
    }

    public int compareTo(Record that) {
        return this.freq.compareTo(that.freq);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Record that = (Record) other;
        return (this.word.equals(that.word) && this.freq == that.freq);
    }

}

