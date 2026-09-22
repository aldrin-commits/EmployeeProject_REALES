package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    // Default constructor
    public HourlyEmployee() {
        super();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Full constructor
    public HourlyEmployee(int empID,
                          Name empName,
                          MyDate birthDate,
                          MyDate dateHired,
                          float totalHoursWorked,
                          double ratePerHour) {

        super(empID, empName, birthDate, dateHired);

        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    // Getters
    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    // Setters
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    // Salary
    @Override
    public double computeSalary() {

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimeHours = totalHoursWorked - 40;
        double overtimePay = overtimeHours * ratePerHour * 1.5;

        return regularPay + overtimePay;
    }

    // Salary with birthday bonus
    @Override
    public double computeSalary(int currentMonth) {

        double basePay = computeSalary();

        return basePay + super.computeSalary(currentMonth);
    }

    // Display
    public void displayHourlyEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Hours: %.2f | Rate: ₱%.2f/hr%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalHoursWorked,
                ratePerHour
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, "
                        + "Hired: %s, Hours: %.2f, Rate: ₱%.2f, "
                        + "Total Salary: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalHoursWorked,
                ratePerHour,
                computeSalary()
        );
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other = (HourlyEmployee) obj;

        return Float.compare(
                totalHoursWorked,
                other.totalHoursWorked
        ) == 0
                && Double.compare(
                ratePerHour,
                other.ratePerHour
        ) == 0;
    }

    // hashCode
    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalHoursWorked,
                ratePerHour
        );
    }

    // clone
    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}