package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate,
                              MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        displayEmployee();
        System.out.println("Total Sale: ₱" + String.format("%.2f", totalSale));
        System.out.println("Commission Rate: "
                + String.format("%.0f%%", getCommissionRate() * 100));
        System.out.println("Salary: ₱"
                + String.format("%.2f", computeSalary()));
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "empID=" + getEmpID() +
                ", empName=" + getEmpName() +
                ", birthDate=" + getBirthDate() +
                ", dateHired=" + getDateHired() +
                ", totalSale=" + totalSale +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other = (CommissionEmployee) obj;

        return super.equals(other)
                && Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}
