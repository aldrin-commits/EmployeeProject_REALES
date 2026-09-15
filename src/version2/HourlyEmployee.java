package version2;

import java.time.LocalDate;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        empID = 0;
        empName = new Name();
        dateHired = new MyDate();
        birthDate = new MyDate();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = new MyDate();
        this.birthDate = new MyDate();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate dateHired,
                          MyDate birthDate, float totalHoursWorked,
                          double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }
    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName; }
    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }
    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }
    public float getTotalHoursWorked() { return totalHoursWorked; }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) this.ratePerHour = ratePerHour;
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

        // If the current month is the employee's birth month, salary is P5,000.
        if (LocalDate.now().getMonthValue() == birthDate.getMonth()) {
            salary = 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Date Hired: %s | Birth Date: %s "
                + "| Hours: %.2f | Rate: P%.2f/hr%n",
                empID, empName, dateHired, birthDate,
                totalHoursWorked, ratePerHour
        );
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, Date Hired: %s, Birth Date: %s, "
                + "Hours: %.2f, Rate: P%.2f, Total Salary: P%.2f]",
                empID, empName, dateHired, birthDate,
                totalHoursWorked, ratePerHour, computeSalary()
        );
    }
}