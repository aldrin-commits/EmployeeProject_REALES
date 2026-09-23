package version5;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate,
                          MyDate dateHired, float totalHoursWorked,
                          double ratePerHour) {

        super(empID, empName, birthDate, dateHired);

        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary() {

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;

        double overtimeHours = totalHoursWorked - 40;

        double overtimePay =
                overtimeHours * ratePerHour * 1.5;

        return regularPay + overtimePay;
    }

    @Override
    public double computeSalary(int currentMonth) {

        double salary = computeSalary();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {

        displayEmployee();

        System.out.println(
                "Total Hours Worked: "
                        + totalHoursWorked
        );

        System.out.println(
                "Rate Per Hour: ₱"
                        + String.format("%.2f", ratePerHour)
        );

        System.out.println(
                "Salary: ₱"
                        + String.format("%.2f", computeSalary())
        );
    }

    @Override
    public String toString() {

        return "HourlyEmployee{" +
                "empID=" + getEmpID() +
                ", empName=" + getEmpName() +
                ", birthDate=" + getBirthDate() +
                ", dateHired=" + getDateHired() +
                ", totalHoursWorked=" + totalHoursWorked +
                ", ratePerHour=" + ratePerHour +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other =
                (HourlyEmployee) obj;

        return super.equals(other)
                && Float.compare(
                totalHoursWorked,
                other.totalHoursWorked
        ) == 0
                && Double.compare(
                ratePerHour,
                other.ratePerHour
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalHoursWorked,
                ratePerHour
        );
    }

    @Override
    public HourlyEmployee clone() {

        return (HourlyEmployee) super.clone();
    }
}