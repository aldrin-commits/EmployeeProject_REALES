package version1;

public class HourlyEmployee {

    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    // Default constructor
    public HourlyEmployee() {
        empID = 0;
        empName = "N/A";
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Partial constructor
    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    // Full constructor
    public HourlyEmployee(int empID, String empName,
                          float totalHoursWorked,
                          double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    // Getters
    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
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

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    // Computes salary including overtime
    public double computeSalary() {

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimeHours = totalHoursWorked - 40;
        double overtimePay = overtimeHours * (ratePerHour * 1.5);

        return regularPay + overtimePay;
    }

    // Displays employee information
    public void displayHourlyEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID,
                empName,
                totalHoursWorked,
                ratePerHour
        );
    }

    // Returns employee information
    @Override
    public String toString() {

        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, "
                        + "Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID,
                empName,
                totalHoursWorked,
                ratePerHour,
                computeSalary()
        );
    }
}