package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(
            int empID,
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary() {
        return baseSalary + super.computeSalary();
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {

        displayEmployee();

        System.out.println(
                "Total Sale: ₱"
                        + String.format(
                        "%.2f",
                        getTotalSale()
                )
        );

        System.out.println(
                "Commission Rate: "
                        + String.format(
                        "%.0f%%",
                        getCommissionRate() * 100
                )
        );

        System.out.println(
                "Base Salary: ₱"
                        + String.format(
                        "%.2f",
                        baseSalary
                )
        );

        System.out.println(
                "Salary: ₱"
                        + String.format(
                        "%.2f",
                        computeSalary()
                )
        );
    }

    @Override
    public String toString() {

        return "BasePlusCommissionEmployee{" +
                "empID=" + getEmpID() +
                ", empName=" + getEmpName() +
                ", birthDate=" + getBirthDate() +
                ", dateHired=" + getDateHired() +
                ", totalSale=" + getTotalSale() +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return super.equals(other)
                && Double.compare(
                baseSalary,
                other.baseSalary
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                baseSalary
        );
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}