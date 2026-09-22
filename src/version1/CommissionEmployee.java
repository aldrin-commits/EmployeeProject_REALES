package version1;

public class CommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;

    // Default constructor
    public CommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
    }

    // Partial constructor
    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    // Full constructor
    public CommissionEmployee(int empID, String empName,
                              double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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

    // Computes commission salary
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

    // Displays employee information
    public void displayCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Total Sale: ₱%.2f%n",
                empID,
                empName,
                totalSale
        );
    }

    // Returns employee information
    @Override
    public String toString() {

        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, "
                        + "Total Sale: ₱%.2f, Commission Salary: ₱%.2f]",
                empID,
                empName,
                totalSale,
                computeSalary()
        );
    }
}