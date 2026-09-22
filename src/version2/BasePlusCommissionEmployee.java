package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    // Default constructor
    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
        totalSale = 0;
        baseSalary = 0;
    }

    // Partial constructor
    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        totalSale = 0;
        baseSalary = 0;
    }

    // Full constructor
    public BasePlusCommissionEmployee(int empID, Name empName,
                                      MyDate birthDate, MyDate dateHired,
                                      double totalSale,
                                      double baseSalary) {

        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getBaseSalary() {
        return baseSalary;
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

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
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

        return baseSalary + (totalSale * commissionRate);
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
    public void displayBasePlusCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s "
                        + "| Total Sale: ₱%.2f | Base Salary: ₱%.2f%n",
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale,
                baseSalary
        );
    }

    // String representation
    @Override
    public String toString() {

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, "
                        + "DOB: %s, Hired: %s, Total Sale: ₱%.2f, "
                        + "Base Salary: ₱%.2f, Total Salary: ₱%.2f]",
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale,
                baseSalary,
                computeSalary()
        );
    }
}