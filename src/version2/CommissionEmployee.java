package version2;

public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    // Default constructor
    public CommissionEmployee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
        totalSale = 0;
    }

    // Partial constructor
    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        totalSale = 0;
    }

    // Full constructor
    public CommissionEmployee(int empID, Name empName,
                              MyDate birthDate, MyDate dateHired,
                              double totalSale) {

        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
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

    public double getTotalSale() {
        return totalSale;
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

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    // Regular salary without birthday bonus
    public double computeSalary() {

        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return totalSale * commissionRate;
    }

    // Salary with birthday incentive
    public double computeSalary(int currentMonth) {

        double salary = computeSalary();

        if (birthDate.getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    // Display employee information
    public void displayCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Total Sale: ₱%.2f%n",
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );
    }

    // String representation
    @Override
    public String toString() {

        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, "
                        + "Hired: %s, Total Sale: ₱%.2f, "
                        + "Total Salary: ₱%.2f]",
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale,
                computeSalary()
        );
    }
}