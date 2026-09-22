package version3;

import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    // Default constructor
    public Employee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Full constructor
    public Employee(int empID,
                    Name empName,
                    MyDate birthDate,
                    MyDate dateHired) {

        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    // Setters
    public void setEmpID(int empID) {
        if (empID >= 0) {
            this.empID = empID;
        }
    }

    public void setEmpName(Name empName) {
        if (empName != null) {
            this.empName = empName;
        }
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate != null) {
            this.birthDate = birthDate;
        }
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired != null) {
            this.dateHired = dateHired;
        }
    }

    // Regular salary
    public double computeSalary() {
        return 0;
    }

    // Salary with birthday incentive
    public double computeSalary(int currentMonth) {

        double bonus = 0;

        if (birthDate.getMonth() == currentMonth) {
            bonus = 5000;
        }

        return bonus;
    }

    // Display employee
    public void displayEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID,
                empName,
                birthDate,
                dateHired
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID,
                empName,
                birthDate,
                dateHired
        );
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return empID == other.empID
                && Objects.equals(empName, other.empName)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dateHired, other.dateHired);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(
                empID,
                empName,
                birthDate,
                dateHired
        );
    }

    // Deep clone
    @Override
    public Employee clone() {

        try {

            Employee copy = (Employee) super.clone();

            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}