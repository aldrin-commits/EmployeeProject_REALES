package version1;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    // Default constructor
    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
        baseSalary = 0;
    }

    // Partial constructor
    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    // Full constructor
    public BasePlusCommissionEmployee(int empID, String empName,
                                      double totalSale,
                                      double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
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

    public void setEmpName(String empName) {
        if (empName != null && !empName.trim().isEmpty()) {
            this.empName = empName;
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

    // Computes salary
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

    // Displays employee information
    public void displayBasePlusCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Total Sale: ₱%.2f "
                        + "| Base Salary: ₱%.2f%n",
                empID,
                empName,
                totalSale,
                baseSalary
        );
    }

    // Returns employee information
    @Override
    public String toString() {

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

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, "
                        + "Sales: ₱%.2f, Base Salary: ₱%.2f, "
                        + "Commission Rate: %.0f%%, Total Salary: ₱%.2f]",
                empID,
                empName,
                totalSale,
                baseSalary,
                commissionRate * 100,
                computeSalary()
        );
    }
}