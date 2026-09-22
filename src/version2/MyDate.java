package version2;

public class MyDate {

    private int day;
    private int month;
    private int year;

    // Default constructor
    public MyDate() {
        day = 1;
        month = 1;
        year = 2000;
    }

    // Full constructor
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        }
    }

    // Displays the formatted date
    public void displayDate() {
        System.out.println("Date: " + this);
    }

    // Returns the formatted date
    @Override
    public String toString() {

        String[] monthNames = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"
        };

        return String.format(
                "%02d %s %04d",
                day,
                monthNames[month - 1],
                year
        );
    }
}