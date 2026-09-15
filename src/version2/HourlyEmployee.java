package version2;

import java.time.LocalDate;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate dates;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        empID = 0;
        empName = new Name();
        dates = new MyDate();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.dates = new MyDate();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate dates,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.dates = dates;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getDates() {
        return dates;
    }

    public void setDates(MyDate dates) {
        this.dates = dates;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {

        double salary;

        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimeHours = totalHoursWorked - 40;
            double overtimePay = overtimeHours * (ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }

        // Birthday month bonus: salary is raised to P5,000.
        int currentMonth = LocalDate.now().getMonthValue();
        int birthMonth = dates.getBirthDate().getMonthValue();

        if (currentMonth == birthMonth) {
            salary = 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Date Hired: %s | Birth Date: %s "
                + "| Hours: %.2f | Rate: P%.2f/hr%n",
                empID,
                empName,
                dates.getDateHired(),
                dates.getBirthDate(),
                totalHoursWorked,
                ratePerHour
        );
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, Dates: %s, "
                + "Hours: %.2f, Rate: P%.2f, Total Salary: P%.2f]",
                empID,
                empName,
                dates,
                totalHoursWorked,
                ratePerHour,
                computeSalary()
        );
    }
}
