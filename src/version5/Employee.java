package version5;

import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate,
                    MyDate dateHired) {

        this.empID = empID;
        this.empName = empName == null ? new Name() : empName;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
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

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    /*
     * V5 BASELINE PAYROLL METHOD
     *
     * This method exists so that every Employee reference
     * can call computeSalary().
     *
     * Subclasses override this method.
     */
    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    /*
     * Overloaded version.
     * Calls computeSalary(-1), which gives the regular/default
     * salary implementation.
     */
    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName.displayName());
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Date Hired: " + dateHired);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName=" + empName +
                ", birthDate=" + birthDate +
                ", dateHired=" + dateHired +
                '}';
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(
                empID,
                empName,
                birthDate,
                dateHired
        );
    }

    @Override
    public Employee clone() {

        try {

            Employee copy = (Employee) super.clone();

            copy.empName = this.empName.clone();
            copy.birthDate = this.birthDate.clone();
            copy.dateHired = this.dateHired.clone();

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}