import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;

public class Student {
    public static final Comparator<Student> NAME_ORDER = new NameOrder();

    public static final Comparator<Student> SECTION_ORDER = new SectionOrder();

    private final String name;
    private final int section;

    public Student(String name, int section) {
        this.name = name;
        this.section = section;
    }

    private static Comparator<Student> byNameOrder() {
        return new NameOrder();
    }

    private static Comparator<Student> bySectionOrder() {
        return new SectionOrder();
    }

    // compare students by name, starting at this student's name
    // and wrapping around alphabetically.
    private Comparator<Student> byRelativeNameOrder() {
        return new RelativeNameOrder();
    }
    // comparator to sort by name.
    private static class NameOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.name.compareTo(b.name);
        }
    }
    // comarator to sort by section.
    private static class SectionOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.section - b.section;
        }
    }
    // comparator to sort by name with this name first
    // illustrates the use of a non-static comparator.
    private class RelativeNameOrder implements Comparator<Student>{
        public int compare(Student a, Student b) {
            if (a.name.compareTo(b.name) == 0) return 0;
            if (a.name.compareTo(name) == 0) return -1;
            if (b.name.compareTo(name) == 0) return +1;
            if ((a.name.compareTo(name) < 0) && (b.name.compareTo(name) > 0))
                return +1;
            if ((a.name.compareTo(name) > 0) && (b.name.compareTo(name) < 0))
                return -1;
            return a.name.compareTo(b.name);
        }
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Student that = (Student) other;
        return (this.section == that.section) && (this.name.equals(that.name));
    }
    @Override
    public int hashCode() {
        return 31*section + name.hashCode();
    }
    @Override
    public String toString() {
        return section + " " + name;
    }
    
    public static void main(String[] args) {
        // create an array of students

        Student alice = new Student("Alice", 2);
        Student bob = new Student("Bob", 1);
        Student carol = new Student("Carol", 2);
        Student dave = new Student("Dave", 1);
        Student eve = new Student("Eve", 2);
        Student frank = new Student("Frank", 3);
        Student grant = new Student("Grant", 1);
        Student helia = new Student("Helia", 3);
        Student isaac = new Student("Isaac", 3);
        Student jen = new Student("Jen", 1);
        Student kevin = new Student("Kevin", 1);
        Student larry = new Student("Larry", 2);
        Student[] students = {
            larry, kevin, jen, isaac, grant, helia,
            frank, eve, dave, carol, bob, alice
        };

        // sort by name and print results
        StdOut.println("By name");
        StdOut.println("----------");
        Arrays.sort(students, Student.byNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        //now, sort by section and print results
        StdOut.println("By section");
        StdOut.println("----------");
        Arrays.sort(students, Student.bySectionOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        //now, sort by name relative to Kevin
        StdOut.println("By Kevin");
        StdOut.println("----------");
        Arrays.sort(students, kevin.byRelativeNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
    }

}
