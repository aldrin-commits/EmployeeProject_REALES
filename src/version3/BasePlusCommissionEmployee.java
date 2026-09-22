package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    // Default constructor
    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    // Full constructor
    public BasePlusCommissionEmployee(int empID,
                                      Name empName,
                                      MyDate birthDate,
                                      MyDate dateHired,
                                      double totalSale,
                                      double baseSalary) {

        super(
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );

        this.baseSalary = baseSalary;
    }

    // Getter
    public double getBaseSalary() {
        return baseSalary;
    }

    // Setter
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    // Salary
    @Override
    public double computeSalary() {

        return baseSalary + super.computeSalary();
    }

    // Salary with birthday bonus
    @Override
    public double computeSalary(int currentMonth) {

        return baseSalary + super.computeSalary(currentMonth);
    }

    // Display
    public void displayBasePlusCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                getTotalSale(),
                baseSalary
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, "
                        + "Name: %s, DOB: %s, Hired: %s, "
                        + "Total Sale: ₱%.2f, Base Salary: ₱%.2f, "
                        + "Total Salary: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                getTotalSale(),
                baseSalary,
                computeSalary()
        );
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return Double.compare(
                baseSalary,
                other.baseSalary
        ) == 0;
    }

    // hashCode
    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                baseSalary
        );
    }

    // clone
    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}