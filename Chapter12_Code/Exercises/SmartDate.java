import java.util.Calendar;
import java.lang.Exception;

public class SmartDate
{
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int m, int d, int y)
    {
        if ((m<1 || m>12) || (d<1 || d>31))
            throw new RuntimeException("illegal date.");
        month = m;
        day = d;
        year = y;
    }
    public SmartDate(String date)
    {
        String[] fields = date.split("/");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
        if ((month<1 || month>12) || (day<1 || day>31))
            throw new RuntimeException("illegal date.");

    }

    public int month()
    { return month; }
    public int day()
    { return day; }
    public int year()
    {
        return year;
    }
    public boolean equals(Object x)
    {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate)x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }
    public String toString()
    {
        return month()+"/"+day()
            +"/"+year();
    }
    public String dayOfTheWeek()
    {
        String[] weekday = new String[]{
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thusday",
            "Friday",
            "Saturday"};
        Calendar cal = Calendar.getInstance();
        // Jan=0,Feb=1,Mar=2...
        cal.set(year,month-1,day);

        return weekday[cal.get(Calendar.DAY_OF_WEEK)-1];
        
    }
}
